package com.test.farmers.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link DistrictLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see DistrictLocalService
 * @generated
 */
public class DistrictLocalServiceWrapper implements DistrictLocalService,
    ServiceWrapper<DistrictLocalService> {
    private DistrictLocalService _districtLocalService;

    public DistrictLocalServiceWrapper(
        DistrictLocalService districtLocalService) {
        _districtLocalService = districtLocalService;
    }

    /**
    * Adds the district to the database. Also notifies the appropriate model listeners.
    *
    * @param district the district
    * @return the district that was added
    * @throws SystemException if a system exception occurred
    */
    @Override
    public com.test.farmers.model.District addDistrict(
        com.test.farmers.model.District district)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _districtLocalService.addDistrict(district);
    }

    /**
    * Creates a new district with the primary key. Does not add the district to the database.
    *
    * @param districtId the primary key for the new district
    * @return the new district
    */
    @Override
    public com.test.farmers.model.District createDistrict(long districtId) {
        return _districtLocalService.createDistrict(districtId);
    }

    /**
    * Deletes the district with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param districtId the primary key of the district
    * @return the district that was removed
    * @throws PortalException if a district with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    @Override
    public com.test.farmers.model.District deleteDistrict(long districtId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _districtLocalService.deleteDistrict(districtId);
    }

    /**
    * Deletes the district from the database. Also notifies the appropriate model listeners.
    *
    * @param district the district
    * @return the district that was removed
    * @throws SystemException if a system exception occurred
    */
    @Override
    public com.test.farmers.model.District deleteDistrict(
        com.test.farmers.model.District district)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _districtLocalService.deleteDistrict(district);
    }

    @Override
    public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
        return _districtLocalService.dynamicQuery();
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
        return _districtLocalService.dynamicQuery(dynamicQuery);
    }

    /**
    * Performs a dynamic query on the database and returns a range of the matching rows.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.test.farmers.model.impl.DistrictModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
        return _districtLocalService.dynamicQuery(dynamicQuery, start, end);
    }

    /**
    * Performs a dynamic query on the database and returns an ordered range of the matching rows.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.test.farmers.model.impl.DistrictModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
        return _districtLocalService.dynamicQuery(dynamicQuery, start, end,
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
        return _districtLocalService.dynamicQueryCount(dynamicQuery);
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
        return _districtLocalService.dynamicQueryCount(dynamicQuery, projection);
    }

    @Override
    public com.test.farmers.model.District fetchDistrict(long districtId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _districtLocalService.fetchDistrict(districtId);
    }

    /**
    * Returns the district with the primary key.
    *
    * @param districtId the primary key of the district
    * @return the district
    * @throws PortalException if a district with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    @Override
    public com.test.farmers.model.District getDistrict(long districtId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _districtLocalService.getDistrict(districtId);
    }

    @Override
    public com.liferay.portal.model.PersistedModel getPersistedModel(
        java.io.Serializable primaryKeyObj)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _districtLocalService.getPersistedModel(primaryKeyObj);
    }

    /**
    * Returns a range of all the districts.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.test.farmers.model.impl.DistrictModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param start the lower bound of the range of districts
    * @param end the upper bound of the range of districts (not inclusive)
    * @return the range of districts
    * @throws SystemException if a system exception occurred
    */
    @Override
    public java.util.List<com.test.farmers.model.District> getDistricts(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _districtLocalService.getDistricts(start, end);
    }

    /**
    * Returns the number of districts.
    *
    * @return the number of districts
    * @throws SystemException if a system exception occurred
    */
    @Override
    public int getDistrictsCount()
        throws com.liferay.portal.kernel.exception.SystemException {
        return _districtLocalService.getDistrictsCount();
    }

    /**
    * Updates the district in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
    *
    * @param district the district
    * @return the district that was updated
    * @throws SystemException if a system exception occurred
    */
    @Override
    public com.test.farmers.model.District updateDistrict(
        com.test.farmers.model.District district)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _districtLocalService.updateDistrict(district);
    }

    /**
    * @throws SystemException if a system exception occurred
    */
    @Override
    public void addFarmerDistrict(long farmerId, long districtId)
        throws com.liferay.portal.kernel.exception.SystemException {
        _districtLocalService.addFarmerDistrict(farmerId, districtId);
    }

    /**
    * @throws SystemException if a system exception occurred
    */
    @Override
    public void addFarmerDistrict(long farmerId,
        com.test.farmers.model.District district)
        throws com.liferay.portal.kernel.exception.SystemException {
        _districtLocalService.addFarmerDistrict(farmerId, district);
    }

    /**
    * @throws SystemException if a system exception occurred
    */
    @Override
    public void addFarmerDistricts(long farmerId, long[] districtIds)
        throws com.liferay.portal.kernel.exception.SystemException {
        _districtLocalService.addFarmerDistricts(farmerId, districtIds);
    }

    /**
    * @throws SystemException if a system exception occurred
    */
    @Override
    public void addFarmerDistricts(long farmerId,
        java.util.List<com.test.farmers.model.District> Districts)
        throws com.liferay.portal.kernel.exception.SystemException {
        _districtLocalService.addFarmerDistricts(farmerId, Districts);
    }

    /**
    * @throws SystemException if a system exception occurred
    */
    @Override
    public void clearFarmerDistricts(long farmerId)
        throws com.liferay.portal.kernel.exception.SystemException {
        _districtLocalService.clearFarmerDistricts(farmerId);
    }

    /**
    * @throws SystemException if a system exception occurred
    */
    @Override
    public void deleteFarmerDistrict(long farmerId, long districtId)
        throws com.liferay.portal.kernel.exception.SystemException {
        _districtLocalService.deleteFarmerDistrict(farmerId, districtId);
    }

    /**
    * @throws SystemException if a system exception occurred
    */
    @Override
    public void deleteFarmerDistrict(long farmerId,
        com.test.farmers.model.District district)
        throws com.liferay.portal.kernel.exception.SystemException {
        _districtLocalService.deleteFarmerDistrict(farmerId, district);
    }

    /**
    * @throws SystemException if a system exception occurred
    */
    @Override
    public void deleteFarmerDistricts(long farmerId, long[] districtIds)
        throws com.liferay.portal.kernel.exception.SystemException {
        _districtLocalService.deleteFarmerDistricts(farmerId, districtIds);
    }

    /**
    * @throws SystemException if a system exception occurred
    */
    @Override
    public void deleteFarmerDistricts(long farmerId,
        java.util.List<com.test.farmers.model.District> Districts)
        throws com.liferay.portal.kernel.exception.SystemException {
        _districtLocalService.deleteFarmerDistricts(farmerId, Districts);
    }

    /**
    * @throws SystemException if a system exception occurred
    */
    @Override
    public java.util.List<com.test.farmers.model.District> getFarmerDistricts(
        long farmerId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _districtLocalService.getFarmerDistricts(farmerId);
    }

    /**
    * @throws SystemException if a system exception occurred
    */
    @Override
    public java.util.List<com.test.farmers.model.District> getFarmerDistricts(
        long farmerId, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _districtLocalService.getFarmerDistricts(farmerId, start, end);
    }

    /**
    * @throws SystemException if a system exception occurred
    */
    @Override
    public java.util.List<com.test.farmers.model.District> getFarmerDistricts(
        long farmerId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _districtLocalService.getFarmerDistricts(farmerId, start, end,
            orderByComparator);
    }

    /**
    * @throws SystemException if a system exception occurred
    */
    @Override
    public int getFarmerDistrictsCount(long farmerId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _districtLocalService.getFarmerDistrictsCount(farmerId);
    }

    /**
    * @throws SystemException if a system exception occurred
    */
    @Override
    public boolean hasFarmerDistrict(long farmerId, long districtId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _districtLocalService.hasFarmerDistrict(farmerId, districtId);
    }

    /**
    * @throws SystemException if a system exception occurred
    */
    @Override
    public boolean hasFarmerDistricts(long farmerId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _districtLocalService.hasFarmerDistricts(farmerId);
    }

    /**
    * @throws SystemException if a system exception occurred
    */
    @Override
    public void setFarmerDistricts(long farmerId, long[] districtIds)
        throws com.liferay.portal.kernel.exception.SystemException {
        _districtLocalService.setFarmerDistricts(farmerId, districtIds);
    }

    /**
    * Returns the Spring bean ID for this bean.
    *
    * @return the Spring bean ID for this bean
    */
    @Override
    public java.lang.String getBeanIdentifier() {
        return _districtLocalService.getBeanIdentifier();
    }

    /**
    * Sets the Spring bean ID for this bean.
    *
    * @param beanIdentifier the Spring bean ID for this bean
    */
    @Override
    public void setBeanIdentifier(java.lang.String beanIdentifier) {
        _districtLocalService.setBeanIdentifier(beanIdentifier);
    }

    @Override
    public java.lang.Object invokeMethod(java.lang.String name,
        java.lang.String[] parameterTypes, java.lang.Object[] arguments)
        throws java.lang.Throwable {
        return _districtLocalService.invokeMethod(name, parameterTypes,
            arguments);
    }

    @Override
    public com.test.farmers.model.District addDistrict(java.lang.String name,
        int code)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _districtLocalService.addDistrict(name, code);
    }

    @Override
    public com.test.farmers.model.District archiveDistrict(long districtId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _districtLocalService.archiveDistrict(districtId);
    }

    @Override
    public java.util.List<com.test.farmers.model.District> getDistricts()
        throws com.liferay.portal.kernel.exception.SystemException {
        return _districtLocalService.getDistricts();
    }

    @Override
    public com.test.farmers.model.District updateDistrict(long districtId,
        java.lang.String name, int code)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _districtLocalService.updateDistrict(districtId, name, code);
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
     */
    public DistrictLocalService getWrappedDistrictLocalService() {
        return _districtLocalService;
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
     */
    public void setWrappedDistrictLocalService(
        DistrictLocalService districtLocalService) {
        _districtLocalService = districtLocalService;
    }

    @Override
    public DistrictLocalService getWrappedService() {
        return _districtLocalService;
    }

    @Override
    public void setWrappedService(DistrictLocalService districtLocalService) {
        _districtLocalService = districtLocalService;
    }
}
