package com.test.farmers.service.persistence;

import com.liferay.portal.kernel.dao.orm.BaseActionableDynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;

import com.test.farmers.model.Farmer;
import com.test.farmers.service.FarmerLocalServiceUtil;

/**
 * @author Brian Wing Shun Chan
 * @generated
 */
public abstract class FarmerActionableDynamicQuery
    extends BaseActionableDynamicQuery {
    public FarmerActionableDynamicQuery() throws SystemException {
        setBaseLocalService(FarmerLocalServiceUtil.getService());
        setClass(Farmer.class);

        setClassLoader(com.test.farmers.service.ClpSerializer.class.getClassLoader());

        setPrimaryKeyPropertyName("farmerId");
    }
}
