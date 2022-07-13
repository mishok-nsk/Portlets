package com.test.farmers.service.impl;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.Validator;
import com.test.farmers.DistrictNameException;
import com.test.farmers.model.District;
import com.test.farmers.service.base.DistrictLocalServiceBaseImpl;

import java.util.List;


/**
 * The implementation of the district local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.test.farmers.service.DistrictLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.test.farmers.service.base.DistrictLocalServiceBaseImpl
 * @see com.test.farmers.service.DistrictLocalServiceUtil
 */
public class DistrictLocalServiceImpl extends DistrictLocalServiceBaseImpl {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never reference this interface directly. Always use {@link com.test.farmers.service.DistrictLocalServiceUtil} to access the district local service.
     */
    public District addDistrict(String name, int code) throws SystemException, PortalException {
        validate(name);
        long districtId = counterLocalService.increment();
        District district = districtPersistence.create(districtId);
        district.setName(name);
        district.setCode(code);
        districtPersistence.update(district);
        return district;
    }

    public District archiveDistrict(long districtId) throws SystemException, PortalException {
        District district = getDistrict(districtId);
        district.setIsArchive(true);
        districtPersistence.update(district);
        return district;
    }

    public List<District> getDistricts() throws SystemException {
        return districtPersistence.findByIsArchive(false);
    }

    public List<District> getDistricts(int start, int end) throws SystemException {
        return districtPersistence.findByIsArchive(false, start, end);
    }

    public int getDistrictsCount() throws SystemException {
        return districtPersistence.countByIsArchive(false);
    }

    public District updateDistrict(long districtId, String name, int code) throws SystemException, PortalException {
        validate(name);
        District district = getDistrict(districtId);
        district.setName(name);
        district.setCode(code);
        districtPersistence.update(district);
        return district;
    }

    protected void validate(String name) throws PortalException {
        if (Validator.isNull(name)) {
            throw new DistrictNameException();
        }
    }
}
