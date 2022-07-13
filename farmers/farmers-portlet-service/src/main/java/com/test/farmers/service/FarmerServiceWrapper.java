package com.test.farmers.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link FarmerService}.
 *
 * @author Brian Wing Shun Chan
 * @see FarmerService
 * @generated
 */
public class FarmerServiceWrapper implements FarmerService,
    ServiceWrapper<FarmerService> {
    private FarmerService _farmerService;

    public FarmerServiceWrapper(FarmerService farmerService) {
        _farmerService = farmerService;
    }

    /**
    * Returns the Spring bean ID for this bean.
    *
    * @return the Spring bean ID for this bean
    */
    @Override
    public java.lang.String getBeanIdentifier() {
        return _farmerService.getBeanIdentifier();
    }

    /**
    * Sets the Spring bean ID for this bean.
    *
    * @param beanIdentifier the Spring bean ID for this bean
    */
    @Override
    public void setBeanIdentifier(java.lang.String beanIdentifier) {
        _farmerService.setBeanIdentifier(beanIdentifier);
    }

    @Override
    public java.lang.Object invokeMethod(java.lang.String name,
        java.lang.String[] parameterTypes, java.lang.Object[] arguments)
        throws java.lang.Throwable {
        return _farmerService.invokeMethod(name, parameterTypes, arguments);
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
     */
    public FarmerService getWrappedFarmerService() {
        return _farmerService;
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
     */
    public void setWrappedFarmerService(FarmerService farmerService) {
        _farmerService = farmerService;
    }

    @Override
    public FarmerService getWrappedService() {
        return _farmerService;
    }

    @Override
    public void setWrappedService(FarmerService farmerService) {
        _farmerService = farmerService;
    }
}
