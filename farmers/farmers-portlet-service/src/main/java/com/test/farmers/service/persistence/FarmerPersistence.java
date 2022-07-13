package com.test.farmers.service.persistence;

import com.liferay.portal.service.persistence.BasePersistence;

import com.test.farmers.model.Farmer;

/**
 * The persistence interface for the farmer service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see FarmerPersistenceImpl
 * @see FarmerUtil
 * @generated
 */
public interface FarmerPersistence extends BasePersistence<Farmer> {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this interface directly. Always use {@link FarmerUtil} to access the farmer persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
     */

    /**
    * Returns all the farmers where name = &#63;.
    *
    * @param name the name
    * @return the matching farmers
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.test.farmers.model.Farmer> findByName(
        java.lang.String name)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns a range of all the farmers where name = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.test.farmers.model.impl.FarmerModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param name the name
    * @param start the lower bound of the range of farmers
    * @param end the upper bound of the range of farmers (not inclusive)
    * @return the range of matching farmers
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.test.farmers.model.Farmer> findByName(
        java.lang.String name, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns an ordered range of all the farmers where name = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.test.farmers.model.impl.FarmerModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param name the name
    * @param start the lower bound of the range of farmers
    * @param end the upper bound of the range of farmers (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of matching farmers
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.test.farmers.model.Farmer> findByName(
        java.lang.String name, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the first farmer in the ordered set where name = &#63;.
    *
    * @param name the name
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching farmer
    * @throws com.test.farmers.NoSuchFarmerException if a matching farmer could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.test.farmers.model.Farmer findByName_First(
        java.lang.String name,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.test.farmers.NoSuchFarmerException;

    /**
    * Returns the first farmer in the ordered set where name = &#63;.
    *
    * @param name the name
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching farmer, or <code>null</code> if a matching farmer could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.test.farmers.model.Farmer fetchByName_First(
        java.lang.String name,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the last farmer in the ordered set where name = &#63;.
    *
    * @param name the name
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching farmer
    * @throws com.test.farmers.NoSuchFarmerException if a matching farmer could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.test.farmers.model.Farmer findByName_Last(
        java.lang.String name,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.test.farmers.NoSuchFarmerException;

    /**
    * Returns the last farmer in the ordered set where name = &#63;.
    *
    * @param name the name
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching farmer, or <code>null</code> if a matching farmer could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.test.farmers.model.Farmer fetchByName_Last(
        java.lang.String name,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the farmers before and after the current farmer in the ordered set where name = &#63;.
    *
    * @param farmerId the primary key of the current farmer
    * @param name the name
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the previous, current, and next farmer
    * @throws com.test.farmers.NoSuchFarmerException if a farmer with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.test.farmers.model.Farmer[] findByName_PrevAndNext(
        long farmerId, java.lang.String name,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.test.farmers.NoSuchFarmerException;

    /**
    * Removes all the farmers where name = &#63; from the database.
    *
    * @param name the name
    * @throws SystemException if a system exception occurred
    */
    public void removeByName(java.lang.String name)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of farmers where name = &#63;.
    *
    * @param name the name
    * @return the number of matching farmers
    * @throws SystemException if a system exception occurred
    */
    public int countByName(java.lang.String name)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns all the farmers where inn = &#63;.
    *
    * @param inn the inn
    * @return the matching farmers
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.test.farmers.model.Farmer> findByInn(long inn)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns a range of all the farmers where inn = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.test.farmers.model.impl.FarmerModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param inn the inn
    * @param start the lower bound of the range of farmers
    * @param end the upper bound of the range of farmers (not inclusive)
    * @return the range of matching farmers
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.test.farmers.model.Farmer> findByInn(long inn,
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns an ordered range of all the farmers where inn = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.test.farmers.model.impl.FarmerModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param inn the inn
    * @param start the lower bound of the range of farmers
    * @param end the upper bound of the range of farmers (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of matching farmers
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.test.farmers.model.Farmer> findByInn(long inn,
        int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the first farmer in the ordered set where inn = &#63;.
    *
    * @param inn the inn
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching farmer
    * @throws com.test.farmers.NoSuchFarmerException if a matching farmer could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.test.farmers.model.Farmer findByInn_First(long inn,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.test.farmers.NoSuchFarmerException;

    /**
    * Returns the first farmer in the ordered set where inn = &#63;.
    *
    * @param inn the inn
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching farmer, or <code>null</code> if a matching farmer could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.test.farmers.model.Farmer fetchByInn_First(long inn,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the last farmer in the ordered set where inn = &#63;.
    *
    * @param inn the inn
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching farmer
    * @throws com.test.farmers.NoSuchFarmerException if a matching farmer could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.test.farmers.model.Farmer findByInn_Last(long inn,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.test.farmers.NoSuchFarmerException;

    /**
    * Returns the last farmer in the ordered set where inn = &#63;.
    *
    * @param inn the inn
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching farmer, or <code>null</code> if a matching farmer could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.test.farmers.model.Farmer fetchByInn_Last(long inn,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the farmers before and after the current farmer in the ordered set where inn = &#63;.
    *
    * @param farmerId the primary key of the current farmer
    * @param inn the inn
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the previous, current, and next farmer
    * @throws com.test.farmers.NoSuchFarmerException if a farmer with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.test.farmers.model.Farmer[] findByInn_PrevAndNext(
        long farmerId, long inn,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.test.farmers.NoSuchFarmerException;

    /**
    * Removes all the farmers where inn = &#63; from the database.
    *
    * @param inn the inn
    * @throws SystemException if a system exception occurred
    */
    public void removeByInn(long inn)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of farmers where inn = &#63;.
    *
    * @param inn the inn
    * @return the number of matching farmers
    * @throws SystemException if a system exception occurred
    */
    public int countByInn(long inn)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns all the farmers where registrationDate = &#63;.
    *
    * @param registrationDate the registration date
    * @return the matching farmers
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.test.farmers.model.Farmer> findByRegistrationDate(
        java.util.Date registrationDate)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns a range of all the farmers where registrationDate = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.test.farmers.model.impl.FarmerModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param registrationDate the registration date
    * @param start the lower bound of the range of farmers
    * @param end the upper bound of the range of farmers (not inclusive)
    * @return the range of matching farmers
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.test.farmers.model.Farmer> findByRegistrationDate(
        java.util.Date registrationDate, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns an ordered range of all the farmers where registrationDate = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.test.farmers.model.impl.FarmerModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param registrationDate the registration date
    * @param start the lower bound of the range of farmers
    * @param end the upper bound of the range of farmers (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of matching farmers
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.test.farmers.model.Farmer> findByRegistrationDate(
        java.util.Date registrationDate, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the first farmer in the ordered set where registrationDate = &#63;.
    *
    * @param registrationDate the registration date
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching farmer
    * @throws com.test.farmers.NoSuchFarmerException if a matching farmer could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.test.farmers.model.Farmer findByRegistrationDate_First(
        java.util.Date registrationDate,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.test.farmers.NoSuchFarmerException;

    /**
    * Returns the first farmer in the ordered set where registrationDate = &#63;.
    *
    * @param registrationDate the registration date
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching farmer, or <code>null</code> if a matching farmer could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.test.farmers.model.Farmer fetchByRegistrationDate_First(
        java.util.Date registrationDate,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the last farmer in the ordered set where registrationDate = &#63;.
    *
    * @param registrationDate the registration date
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching farmer
    * @throws com.test.farmers.NoSuchFarmerException if a matching farmer could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.test.farmers.model.Farmer findByRegistrationDate_Last(
        java.util.Date registrationDate,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.test.farmers.NoSuchFarmerException;

    /**
    * Returns the last farmer in the ordered set where registrationDate = &#63;.
    *
    * @param registrationDate the registration date
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching farmer, or <code>null</code> if a matching farmer could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.test.farmers.model.Farmer fetchByRegistrationDate_Last(
        java.util.Date registrationDate,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the farmers before and after the current farmer in the ordered set where registrationDate = &#63;.
    *
    * @param farmerId the primary key of the current farmer
    * @param registrationDate the registration date
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the previous, current, and next farmer
    * @throws com.test.farmers.NoSuchFarmerException if a farmer with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.test.farmers.model.Farmer[] findByRegistrationDate_PrevAndNext(
        long farmerId, java.util.Date registrationDate,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.test.farmers.NoSuchFarmerException;

    /**
    * Removes all the farmers where registrationDate = &#63; from the database.
    *
    * @param registrationDate the registration date
    * @throws SystemException if a system exception occurred
    */
    public void removeByRegistrationDate(java.util.Date registrationDate)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of farmers where registrationDate = &#63;.
    *
    * @param registrationDate the registration date
    * @return the number of matching farmers
    * @throws SystemException if a system exception occurred
    */
    public int countByRegistrationDate(java.util.Date registrationDate)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns all the farmers where isArchive = &#63;.
    *
    * @param isArchive the is archive
    * @return the matching farmers
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.test.farmers.model.Farmer> findByIsArchive(
        boolean isArchive)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns a range of all the farmers where isArchive = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.test.farmers.model.impl.FarmerModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param isArchive the is archive
    * @param start the lower bound of the range of farmers
    * @param end the upper bound of the range of farmers (not inclusive)
    * @return the range of matching farmers
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.test.farmers.model.Farmer> findByIsArchive(
        boolean isArchive, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns an ordered range of all the farmers where isArchive = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.test.farmers.model.impl.FarmerModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param isArchive the is archive
    * @param start the lower bound of the range of farmers
    * @param end the upper bound of the range of farmers (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of matching farmers
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.test.farmers.model.Farmer> findByIsArchive(
        boolean isArchive, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the first farmer in the ordered set where isArchive = &#63;.
    *
    * @param isArchive the is archive
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching farmer
    * @throws com.test.farmers.NoSuchFarmerException if a matching farmer could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.test.farmers.model.Farmer findByIsArchive_First(
        boolean isArchive,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.test.farmers.NoSuchFarmerException;

    /**
    * Returns the first farmer in the ordered set where isArchive = &#63;.
    *
    * @param isArchive the is archive
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching farmer, or <code>null</code> if a matching farmer could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.test.farmers.model.Farmer fetchByIsArchive_First(
        boolean isArchive,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the last farmer in the ordered set where isArchive = &#63;.
    *
    * @param isArchive the is archive
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching farmer
    * @throws com.test.farmers.NoSuchFarmerException if a matching farmer could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.test.farmers.model.Farmer findByIsArchive_Last(
        boolean isArchive,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.test.farmers.NoSuchFarmerException;

    /**
    * Returns the last farmer in the ordered set where isArchive = &#63;.
    *
    * @param isArchive the is archive
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching farmer, or <code>null</code> if a matching farmer could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.test.farmers.model.Farmer fetchByIsArchive_Last(
        boolean isArchive,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the farmers before and after the current farmer in the ordered set where isArchive = &#63;.
    *
    * @param farmerId the primary key of the current farmer
    * @param isArchive the is archive
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the previous, current, and next farmer
    * @throws com.test.farmers.NoSuchFarmerException if a farmer with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.test.farmers.model.Farmer[] findByIsArchive_PrevAndNext(
        long farmerId, boolean isArchive,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.test.farmers.NoSuchFarmerException;

    /**
    * Removes all the farmers where isArchive = &#63; from the database.
    *
    * @param isArchive the is archive
    * @throws SystemException if a system exception occurred
    */
    public void removeByIsArchive(boolean isArchive)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of farmers where isArchive = &#63;.
    *
    * @param isArchive the is archive
    * @return the number of matching farmers
    * @throws SystemException if a system exception occurred
    */
    public int countByIsArchive(boolean isArchive)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Caches the farmer in the entity cache if it is enabled.
    *
    * @param farmer the farmer
    */
    public void cacheResult(com.test.farmers.model.Farmer farmer);

    /**
    * Caches the farmers in the entity cache if it is enabled.
    *
    * @param farmers the farmers
    */
    public void cacheResult(
        java.util.List<com.test.farmers.model.Farmer> farmers);

    /**
    * Creates a new farmer with the primary key. Does not add the farmer to the database.
    *
    * @param farmerId the primary key for the new farmer
    * @return the new farmer
    */
    public com.test.farmers.model.Farmer create(long farmerId);

    /**
    * Removes the farmer with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param farmerId the primary key of the farmer
    * @return the farmer that was removed
    * @throws com.test.farmers.NoSuchFarmerException if a farmer with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.test.farmers.model.Farmer remove(long farmerId)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.test.farmers.NoSuchFarmerException;

    public com.test.farmers.model.Farmer updateImpl(
        com.test.farmers.model.Farmer farmer)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the farmer with the primary key or throws a {@link com.test.farmers.NoSuchFarmerException} if it could not be found.
    *
    * @param farmerId the primary key of the farmer
    * @return the farmer
    * @throws com.test.farmers.NoSuchFarmerException if a farmer with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.test.farmers.model.Farmer findByPrimaryKey(long farmerId)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.test.farmers.NoSuchFarmerException;

    /**
    * Returns the farmer with the primary key or returns <code>null</code> if it could not be found.
    *
    * @param farmerId the primary key of the farmer
    * @return the farmer, or <code>null</code> if a farmer with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.test.farmers.model.Farmer fetchByPrimaryKey(long farmerId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns all the farmers.
    *
    * @return the farmers
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.test.farmers.model.Farmer> findAll()
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public java.util.List<com.test.farmers.model.Farmer> findAll(int start,
        int end) throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns an ordered range of all the farmers.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.test.farmers.model.impl.FarmerModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param start the lower bound of the range of farmers
    * @param end the upper bound of the range of farmers (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of farmers
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.test.farmers.model.Farmer> findAll(int start,
        int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Removes all the farmers from the database.
    *
    * @throws SystemException if a system exception occurred
    */
    public void removeAll()
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of farmers.
    *
    * @return the number of farmers
    * @throws SystemException if a system exception occurred
    */
    public int countAll()
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns all the districts associated with the farmer.
    *
    * @param pk the primary key of the farmer
    * @return the districts associated with the farmer
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.test.farmers.model.District> getDistricts(long pk)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns a range of all the districts associated with the farmer.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.test.farmers.model.impl.FarmerModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param pk the primary key of the farmer
    * @param start the lower bound of the range of farmers
    * @param end the upper bound of the range of farmers (not inclusive)
    * @return the range of districts associated with the farmer
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.test.farmers.model.District> getDistricts(
        long pk, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns an ordered range of all the districts associated with the farmer.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.test.farmers.model.impl.FarmerModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param pk the primary key of the farmer
    * @param start the lower bound of the range of farmers
    * @param end the upper bound of the range of farmers (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of districts associated with the farmer
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.test.farmers.model.District> getDistricts(
        long pk, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of districts associated with the farmer.
    *
    * @param pk the primary key of the farmer
    * @return the number of districts associated with the farmer
    * @throws SystemException if a system exception occurred
    */
    public int getDistrictsSize(long pk)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns <code>true</code> if the district is associated with the farmer.
    *
    * @param pk the primary key of the farmer
    * @param districtPK the primary key of the district
    * @return <code>true</code> if the district is associated with the farmer; <code>false</code> otherwise
    * @throws SystemException if a system exception occurred
    */
    public boolean containsDistrict(long pk, long districtPK)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns <code>true</code> if the farmer has any districts associated with it.
    *
    * @param pk the primary key of the farmer to check for associations with districts
    * @return <code>true</code> if the farmer has any districts associated with it; <code>false</code> otherwise
    * @throws SystemException if a system exception occurred
    */
    public boolean containsDistricts(long pk)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Adds an association between the farmer and the district. Also notifies the appropriate model listeners and clears the mapping table finder cache.
    *
    * @param pk the primary key of the farmer
    * @param districtPK the primary key of the district
    * @throws SystemException if a system exception occurred
    */
    public void addDistrict(long pk, long districtPK)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Adds an association between the farmer and the district. Also notifies the appropriate model listeners and clears the mapping table finder cache.
    *
    * @param pk the primary key of the farmer
    * @param district the district
    * @throws SystemException if a system exception occurred
    */
    public void addDistrict(long pk, com.test.farmers.model.District district)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Adds an association between the farmer and the districts. Also notifies the appropriate model listeners and clears the mapping table finder cache.
    *
    * @param pk the primary key of the farmer
    * @param districtPKs the primary keys of the districts
    * @throws SystemException if a system exception occurred
    */
    public void addDistricts(long pk, long[] districtPKs)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Adds an association between the farmer and the districts. Also notifies the appropriate model listeners and clears the mapping table finder cache.
    *
    * @param pk the primary key of the farmer
    * @param districts the districts
    * @throws SystemException if a system exception occurred
    */
    public void addDistricts(long pk,
        java.util.List<com.test.farmers.model.District> districts)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Clears all associations between the farmer and its districts. Also notifies the appropriate model listeners and clears the mapping table finder cache.
    *
    * @param pk the primary key of the farmer to clear the associated districts from
    * @throws SystemException if a system exception occurred
    */
    public void clearDistricts(long pk)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Removes the association between the farmer and the district. Also notifies the appropriate model listeners and clears the mapping table finder cache.
    *
    * @param pk the primary key of the farmer
    * @param districtPK the primary key of the district
    * @throws SystemException if a system exception occurred
    */
    public void removeDistrict(long pk, long districtPK)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Removes the association between the farmer and the district. Also notifies the appropriate model listeners and clears the mapping table finder cache.
    *
    * @param pk the primary key of the farmer
    * @param district the district
    * @throws SystemException if a system exception occurred
    */
    public void removeDistrict(long pk, com.test.farmers.model.District district)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Removes the association between the farmer and the districts. Also notifies the appropriate model listeners and clears the mapping table finder cache.
    *
    * @param pk the primary key of the farmer
    * @param districtPKs the primary keys of the districts
    * @throws SystemException if a system exception occurred
    */
    public void removeDistricts(long pk, long[] districtPKs)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Removes the association between the farmer and the districts. Also notifies the appropriate model listeners and clears the mapping table finder cache.
    *
    * @param pk the primary key of the farmer
    * @param districts the districts
    * @throws SystemException if a system exception occurred
    */
    public void removeDistricts(long pk,
        java.util.List<com.test.farmers.model.District> districts)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Sets the districts associated with the farmer, removing and adding associations as necessary. Also notifies the appropriate model listeners and clears the mapping table finder cache.
    *
    * @param pk the primary key of the farmer
    * @param districtPKs the primary keys of the districts to be associated with the farmer
    * @throws SystemException if a system exception occurred
    */
    public void setDistricts(long pk, long[] districtPKs)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Sets the districts associated with the farmer, removing and adding associations as necessary. Also notifies the appropriate model listeners and clears the mapping table finder cache.
    *
    * @param pk the primary key of the farmer
    * @param districts the districts to be associated with the farmer
    * @throws SystemException if a system exception occurred
    */
    public void setDistricts(long pk,
        java.util.List<com.test.farmers.model.District> districts)
        throws com.liferay.portal.kernel.exception.SystemException;
}
