package com.test.farmers.service.impl;

import com.liferay.portal.kernel.dao.orm.*;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.test.farmers.FarmerCreateException;
import com.test.farmers.FarmersPortletAction;
import com.test.farmers.model.District;
import com.test.farmers.model.Farmer;
import com.test.farmers.service.FarmerLocalServiceUtil;
import com.test.farmers.service.base.FarmerLocalServiceBaseImpl;

import javax.portlet.ActionRequest;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * The implementation of the farmer local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.test.farmers.service.FarmerLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.test.farmers.service.base.FarmerLocalServiceBaseImpl
 * @see com.test.farmers.service.FarmerLocalServiceUtil
 */
public class FarmerLocalServiceImpl extends FarmerLocalServiceBaseImpl {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never reference this interface directly. Always use {@link com.test.farmers.service.FarmerLocalServiceUtil} to access the farmer local service.
     */
    public static final Log logger = LogFactoryUtil.getLog(FarmerLocalServiceImpl.class);

    public Farmer changeFarmerArchiveStatus(long farmerId) throws SystemException, PortalException{
        Farmer farmer = getFarmer(farmerId);
        farmer.setIsArchive(!farmer.getIsArchive());
        farmerPersistence.update(farmer);
        return farmer;
    }

    public List getSearchFarmers(String name, long inn, String districtName, int status, String startDate, String endDate, boolean andSearch, int start, int end, OrderByComparator orderByComparator)
            throws SystemException
    {
        DynamicQuery dynamicQuery = buildFarmerDynamicQuery(name, inn, districtName, status, startDate, endDate, andSearch);
        return FarmerLocalServiceUtil.dynamicQuery(dynamicQuery, start, end, orderByComparator);
    }

    public int getSearchFarmersCount(String name, long inn, String districtName, int status, String startDate, String endDate, boolean andSearch)
            throws SystemException
    {
        DynamicQuery dynamicQuery = buildFarmerDynamicQuery(name, inn, districtName, status, startDate, endDate, andSearch);
        return (int)FarmerLocalServiceUtil.dynamicQueryCount(dynamicQuery);
    }

    protected DynamicQuery buildFarmerDynamicQuery(String name, long inn, String districtName, int status, String startDate, String endDate, boolean andSearch)
    {
        Junction junction = null;
        if (andSearch)
            junction = RestrictionsFactoryUtil.conjunction();
        else
            junction = RestrictionsFactoryUtil.disjunction();

        if (Validator.isNotNull(name))
        {
            Property property = PropertyFactoryUtil.forName("name");
            String value = (new StringBuilder("%")).append(name).append("%").toString();
            junction.add(property.like(value));
        }
        if (Validator.isNotNull(inn))
        {
            Property property = PropertyFactoryUtil.forName("inn");
            junction.add(property.eq(Long.valueOf(inn)));
        }
        if (status > 0) {
            Property property = PropertyFactoryUtil.forName("isArchive");
            if (status == 1) {
                junction.add(property.eq(Boolean.valueOf(false)));
            } else {
                junction.add(property.eq(Boolean.valueOf(true)));
            }
        }
        if (Validator.isNotNull(districtName)) {
            DynamicQuery districtQuery = DynamicQueryFactoryUtil.forClass(District.class, getClassLoader());
            String value = (new StringBuilder("%")).append(districtName).append("%").toString();
            districtQuery.add(RestrictionsFactoryUtil.like("name", value)).setProjection(ProjectionFactoryUtil.property("districtId"));
            junction.add(PropertyFactoryUtil.forName("districtId").in(districtQuery));
        }
        try {
            if (Validator.isNotNull(startDate) && Validator.isNotNull(endDate)) {
                DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
                Date startDateValue = dateFormat.parse(startDate);
                Date endDateValue = dateFormat.parse(endDate);
                if (startDateValue.compareTo(endDateValue) < 0) {
                    Property property = PropertyFactoryUtil.forName("registrationDate");
                    junction.add(property.between(startDateValue, endDateValue));
                }
            }
        } catch (ParseException e) {
            logger.warn("Parse date error");
        } finally {
            DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(Farmer.class, getClassLoader());
            return dynamicQuery.add(junction);
        }
    }

    public Farmer updateFarmerData(Farmer farmer) throws SystemException, PortalException {
        validate(farmer);
        farmerPersistence.update(farmer);
        return farmer;
    }

    protected void validate(Farmer farmer) throws FarmerCreateException {
        if (Validator.isNull(farmer.getName())) {
            throw new FarmerCreateException("There is an Error in adding Farmer: farmer name is empty");
        }
        if (Validator.isNull(farmer.getInn())) {
            throw new FarmerCreateException("There is an Error in adding Farmer: farmer inn is empty");
        }
    }
}
