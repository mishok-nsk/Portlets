package com.test.farmers.service.persistence;

import com.liferay.portal.kernel.dao.orm.BaseActionableDynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;

import com.test.farmers.model.District;
import com.test.farmers.service.DistrictLocalServiceUtil;

/**
 * @author Brian Wing Shun Chan
 * @generated
 */
public abstract class DistrictActionableDynamicQuery
    extends BaseActionableDynamicQuery {
    public DistrictActionableDynamicQuery() throws SystemException {
        setBaseLocalService(DistrictLocalServiceUtil.getService());
        setClass(District.class);

        setClassLoader(com.test.farmers.service.ClpSerializer.class.getClassLoader());

        setPrimaryKeyPropertyName("districtId");
    }
}
