package com.test.farmers.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link FarmerLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see FarmerLocalService
 * @generated
 */
public class FarmerLocalServiceWrapper implements FarmerLocalService,
    ServiceWrapper<FarmerLocalService> {
    private FarmerLocalService _farmerLocalService;

    public FarmerLocalServiceWrapper(FarmerLocalService farmerLocalService) {
        _farmerLocalService = farmerLocalService;
    }

    /**
    * Adds the farmer to the database. Also notifies the appropriate model listeners.
    *
    * @param farmer the farmer
    * @return the farmer that was added
    * @throws SystemException if a system exception occurred
    */
    @Override
    public com.test.farmers.model.Farmer addFarmer(
        com.test.farmers.model.Farmer farmer)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _farmerLocalService.addFarmer(farmer);
    }

    /**
    * Creates a new farmer with the primary key. Does not add the farmer to the database.
    *
    * @param farmerId the primary key for the new farmer
    * @return the new farmer
    */
    @Override
    public com.test.farmers.model.Farmer createFarmer(long farmerId) {
        return _farmerLocalService.createFarmer(farmerId);
    }

    /**
    * Deletes the farmer with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param farmerId the primary key of the farmer
    * @return the farmer that was removed
    * @throws PortalException if a farmer with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    @Override
    public com.test.farmers.model.Farmer deleteFarmer(long farmerId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _farmerLocalService.deleteFarmer(farmerId);
    }

    /**
    * Deletes the farmer from the database. Also notifies the appropriate model listeners.
    *
    * @param farmer the farmer
    * @return the farmer that was removed
    * @throws SystemException if a system exception occurred
    */
    @Override
    public com.test.farmers.model.Farmer deleteFarmer(
        com.test.farmers.model.Farmer farmer)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _farmerLocalService.deleteFarmer(farmer);
    }

    @Override
    public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
        return _farmerLocalService.dynamicQuery();
    }

    /**
    * Performs a dynamic query on the database and returns the matching rows.
    *
    * @param dynamicQuery the dynamic query
    * @return the matching rows
    * @throws SystemException if a system exception occurred
    */
    @Override
    @SuppressWarnings("rawtypes")
    public java.util.List dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _farmerLocalService.dynamicQuery(dynamicQuery);
    }

    /**
    * Performs a dynamic query on the database and returns a range of the matching rows.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.test.farmers.model.impl.FarmerModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param dynamicQuery the dynamic query
    * @param start the lower bound of the range of model instances
    * @param end the upper bound of the range of model instances (not inclusive)
    * @return the range of matching rows
    * @throws SystemException if a system exception occurred
    */
    @Override
    @SuppressWarnings("rawtypes")
    public java.util.List dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
        int end) throws com.liferay.portal.kernel.exception.SystemException {
        return _farmerLocalService.dynamicQuery(dynamicQuery, start, end);
    }

    /**
    * Performs a dynamic query on the database and returns an ordered range of the matching rows.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.test.farmers.model.impl.FarmerModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param dynamicQuery the dynamic query
    * @param start the lower bound of the range of model instances
    * @param end the upper bound of the range of model instances (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of matching rows
    * @throws SystemException if a system exception occurred
    */
    @Override
    @SuppressWarnings("rawtypes")
    public java.util.List dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
        int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _farmerLocalService.dynamicQuery(dynamicQuery, start, end,
            orderByComparator);
    }

    /**
    * Returns the number of rows that match the dynamic query.
    *
    * @param dynamicQuery the dynamic query
    * @return the number of rows that match the dynamic query
    * @throws SystemException if a system exception occurred
    */
    @Override
    public long dynamicQueryCount(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _farmerLocalService.dynamicQueryCount(dynamicQuery);
    }

    /**
    * Returns the number of rows that match the dynamic query.
    *
    * @param dynamicQuery the dynamic query
    * @param projection the projection to apply to the query
    * @return the number of rows that match the dynamic query
    * @throws SystemException if a system exception occurred
    */
    @Override
    public long dynamicQueryCount(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
        com.liferay.portal.kernel.dao.orm.Projection projection)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _farmerLocalService.dynamicQueryCount(dynamicQuery, projection);
    }

    @Override
    public com.test.farmers.model.Farmer fetchFarmer(long farmerId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _farmerLocalService.fetchFarmer(farmerId);
    }

    /**
    * Returns the farmer with the primary key.
    *
    * @param farmerId the primary key of the farmer
    * @return the farmer
    * @throws PortalException if a farmer with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    @Override
    public com.test.farmers.model.Farmer getFarmer(long farmerId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _farmerLocalService.getFarmer(farmerId);
    }

    @Override
    public com.liferay.portal.model.PersistedModel getPersistedModel(
        java.io.Serializable primaryKeyObj)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _farmerLocalService.getPersistedModel(primaryKeyObj);
    }

    /**
    * Returns a range of all the farmers.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.test.farmers.model.impl.FarmerModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param start the lower bound of the range of farmers
    * @param end the upper bound of the range of farmers (not inclusive)
    * @return the range of farmers
    * @throws SystemException if a system exception occurred
    */
    @Override
    public java.util.List<com.test.farmers.model.Farmer> getFarmers(int start,
        int end) throws com.liferay.portal.kernel.exception.SystemException {
        return _farmerLocalService.getFarmers(start, end);
    }

    /**
    * Returns the number of farmers.
    *
    * @return the number of farmers
    * @throws SystemException if a system exception occurred
    */
    @Override
    public int getFarmersCount()
        throws com.liferay.portal.kernel.exception.SystemException {
        return _farmerLocalService.getFarmersCount();
    }

    /**
    * Updates the farmer in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
    *
    * @param farmer the farmer
    * @return the farmer that was updated
    * @throws SystemException if a system exception occurred
    */
    @Override
    public com.test.farmers.model.Farmer updateFarmer(
        com.test.farmers.model.Farmer farmer)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _farmerLocalService.updateFarmer(farmer);
    }

    /**
    * @throws SystemException if a system exception occurred
    */
    @Override
    public void addDistrictFarmer(long districtId, long farmerId)
        throws com.liferay.portal.kernel.exception.SystemException {
        _farmerLocalService.addDistrictFarmer(districtId, farmerId);
    }

    /**
    * @throws SystemException if a system exception occurred
    */
    @Override
    public void addDistrictFarmer(long districtId,
        com.test.farmers.model.Farmer farmer)
        throws com.liferay.portal.kernel.exception.SystemException {
        _farmerLocalService.addDistrictFarmer(districtId, farmer);
    }

    /**
    * @throws SystemException if a system exception occurred
    */
    @Override
    public void addDistrictFarmers(long districtId, long[] farmerIds)
        throws com.liferay.portal.kernel.exception.SystemException {
        _farmerLocalService.addDistrictFarmers(districtId, farmerIds);
    }

    /**
    * @throws SystemException if a system exception occurred
    */
    @Override
    public void addDistrictFarmers(long districtId,
        java.util.List<com.test.farmers.model.Farmer> Farmers)
        throws com.liferay.portal.kernel.exception.SystemException {
        _farmerLocalService.addDistrictFarmers(districtId, Farmers);
    }

    /**
    * @throws SystemException if a system exception occurred
    */
    @Override
    public void clearDistrictFarmers(long districtId)
        throws com.liferay.portal.kernel.exception.SystemException {
        _farmerLocalService.clearDistrictFarmers(districtId);
    }

    /**
    * @throws SystemException if a system exception occurred
    */
    @Override
    public void deleteDistrictFarmer(long districtId, long farmerId)
        throws com.liferay.portal.kernel.exception.SystemException {
        _farmerLocalService.deleteDistrictFarmer(districtId, farmerId);
    }

    /**
    * @throws SystemException if a system exception occurred
    */
    @Override
    public void deleteDistrictFarmer(long districtId,
        com.test.farmers.model.Farmer farmer)
        throws com.liferay.portal.kernel.exception.SystemException {
        _farmerLocalService.deleteDistrictFarmer(districtId, farmer);
    }

    /**
    * @throws SystemException if a system exception occurred
    */
    @Override
    public void deleteDistrictFarmers(long districtId, long[] farmerIds)
        throws com.liferay.portal.kernel.exception.SystemException {
        _farmerLocalService.deleteDistrictFarmers(districtId, farmerIds);
    }

    /**
    * @throws SystemException if a system exception occurred
    */
    @Override
    public void deleteDistrictFarmers(long districtId,
        java.util.List<com.test.farmers.model.Farmer> Farmers)
        throws com.liferay.portal.kernel.exception.SystemException {
        _farmerLocalService.deleteDistrictFarmers(districtId, Farmers);
    }

    /**
    * @throws SystemException if a system exception occurred
    */
    @Override
    public java.util.List<com.test.farmers.model.Farmer> getDistrictFarmers(
        long districtId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _farmerLocalService.getDistrictFarmers(districtId);
    }

    /**
    * @throws SystemException if a system exception occurred
    */
    @Override
    public java.util.List<com.test.farmers.model.Farmer> getDistrictFarmers(
        long districtId, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _farmerLocalService.getDistrictFarmers(districtId, start, end);
    }

    /**
    * @throws SystemException if a system exception occurred
    */
    @Override
    public java.util.List<com.test.farmers.model.Farmer> getDistrictFarmers(
        long districtId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _farmerLocalService.getDistrictFarmers(districtId, start, end,
            orderByComparator);
    }

    /**
    * @throws SystemException if a system exception occurred
    */
    @Override
    public int getDistrictFarmersCount(long districtId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _farmerLocalService.getDistrictFarmersCount(districtId);
    }

    /**
    * @throws SystemException if a system exception occurred
    */
    @Override
    public boolean hasDistrictFarmer(long districtId, long farmerId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _farmerLocalService.hasDistrictFarmer(districtId, farmerId);
    }

    /**
    * @throws SystemException if a system exception occurred
    */
    @Override
    public boolean hasDistrictFarmers(long districtId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _farmerLocalService.hasDistrictFarmers(districtId);
    }

    /**
    * @throws SystemException if a system exception occurred
    */
    @Override
    public void setDistrictFarmers(long districtId, long[] farmerIds)
        throws com.liferay.portal.kernel.exception.SystemException {
        _farmerLocalService.setDistrictFarmers(districtId, farmerIds);
    }

    /**
    * Returns the Spring bean ID for this bean.
    *
    * @return the Spring bean ID for this bean
    */
    @Override
    public java.lang.String getBeanIdentifier() {
        return _farmerLocalService.getBeanIdentifier();
    }

    /**
    * Sets the Spring bean ID for this bean.
    *
    * @param beanIdentifier the Spring bean ID for this bean
    */
    @Override
    public void setBeanIdentifier(java.lang.String beanIdentifier) {
        _farmerLocalService.setBeanIdentifier(beanIdentifier);
    }

    @Override
    public java.lang.Object invokeMethod(java.lang.String name,
        java.lang.String[] parameterTypes, java.lang.Object[] arguments)
        throws java.lang.Throwable {
        return _farmerLocalService.invokeMethod(name, parameterTypes, arguments);
    }

    @Override
    public com.test.farmers.model.Farmer changeFarmerArchiveStatus(
        long farmerId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _farmerLocalService.changeFarmerArchiveStatus(farmerId);
    }

    @Override
    public java.util.List getSearchFarmers(java.lang.String name, long inn,
        java.lang.String districtName, int status, java.lang.String startDate,
        java.lang.String endDate, boolean andSearch, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _farmerLocalService.getSearchFarmers(name, inn, districtName,
            status, startDate, endDate, andSearch, start, end, orderByComparator);
    }

    @Override
    public int getSearchFarmersCount(java.lang.String name, long inn,
        java.lang.String districtName, int status, java.lang.String startDate,
        java.lang.String endDate, boolean andSearch)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _farmerLocalService.getSearchFarmersCount(name, inn,
            districtName, status, startDate, endDate, andSearch);
    }

    @Override
    public com.test.farmers.model.Farmer updateFarmerData(
        com.test.farmers.model.Farmer farmer)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _farmerLocalService.updateFarmerData(farmer);
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
     */
    public FarmerLocalService getWrappedFarmerLocalService() {
        return _farmerLocalService;
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
     */
    public void setWrappedFarmerLocalService(
        FarmerLocalService farmerLocalService) {
        _farmerLocalService = farmerLocalService;
    }

    @Override
    public FarmerLocalService getWrappedService() {
        return _farmerLocalService;
    }

    @Override
    public void setWrappedService(FarmerLocalService farmerLocalService) {
        _farmerLocalService = farmerLocalService;
    }
}
