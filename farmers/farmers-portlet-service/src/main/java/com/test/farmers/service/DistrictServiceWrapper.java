package com.test.farmers.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link DistrictService}.
 *
 * @author Brian Wing Shun Chan
 * @see DistrictService
 * @generated
 */
public class DistrictServiceWrapper implements DistrictService,
    ServiceWrapper<DistrictService> {
    private DistrictService _districtService;

    public DistrictServiceWrapper(DistrictService districtService) {
        _districtService = districtService;
    }

    /**
    * Returns the Spring bean ID for this bean.
    *
    * @return the Spring bean ID for this bean
    */
    @Override
    public java.lang.String getBeanIdentifier() {
        return _districtService.getBeanIdentifier();
    }

    /**
    * Sets the Spring bean ID for this bean.
    *
    * @param beanIdentifier the Spring bean ID for this bean
    */
    @Override
    public void setBeanIdentifier(java.lang.String beanIdentifier) {
        _districtService.setBeanIdentifier(beanIdentifier);
    }

    @Override
    public java.lang.Object invokeMethod(java.lang.String name,
        java.lang.String[] parameterTypes, java.lang.Object[] arguments)
        throws java.lang.Throwable {
        return _districtService.invokeMethod(name, parameterTypes, arguments);
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
     */
    public DistrictService getWrappedDistrictService() {
        return _districtService;
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
     */
    public void setWrappedDistrictService(DistrictService districtService) {
        _districtService = districtService;
    }

    @Override
    public DistrictService getWrappedService() {
        return _districtService;
    }

    @Override
    public void setWrappedService(DistrictService districtService) {
        _districtService = districtService;
    }
}
