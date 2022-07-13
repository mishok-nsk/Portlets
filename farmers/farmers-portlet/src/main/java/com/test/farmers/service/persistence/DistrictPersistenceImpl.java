package com.test.farmers.service.persistence;

import com.liferay.portal.kernel.bean.BeanReference;
import com.liferay.portal.kernel.cache.CacheRegistryUtil;
import com.liferay.portal.kernel.dao.orm.EntityCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.InstanceFactory;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.SetUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.UnmodifiableList;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.ModelListener;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;
import com.liferay.portal.service.persistence.impl.TableMapper;
import com.liferay.portal.service.persistence.impl.TableMapperFactory;

import com.test.farmers.NoSuchDistrictException;
import com.test.farmers.model.District;
import com.test.farmers.model.impl.DistrictImpl;
import com.test.farmers.model.impl.DistrictModelImpl;
import com.test.farmers.service.persistence.DistrictPersistence;
import com.test.farmers.service.persistence.FarmerPersistence;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * The persistence implementation for the district service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see DistrictPersistence
 * @see DistrictUtil
 * @generated
 */
public class DistrictPersistenceImpl extends BasePersistenceImpl<District>
    implements DistrictPersistence {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this class directly. Always use {@link DistrictUtil} to access the district persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
     */
    public static final String FINDER_CLASS_NAME_ENTITY = DistrictImpl.class.getName();
    public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
        ".List1";
    public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
        ".List2";
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(DistrictModelImpl.ENTITY_CACHE_ENABLED,
            DistrictModelImpl.FINDER_CACHE_ENABLED, DistrictImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(DistrictModelImpl.ENTITY_CACHE_ENABLED,
            DistrictModelImpl.FINDER_CACHE_ENABLED, DistrictImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
    public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(DistrictModelImpl.ENTITY_CACHE_ENABLED,
            DistrictModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_ISARCHIVE =
        new FinderPath(DistrictModelImpl.ENTITY_CACHE_ENABLED,
            DistrictModelImpl.FINDER_CACHE_ENABLED, DistrictImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByIsArchive",
            new String[] {
                Boolean.class.getName(),
                
            Integer.class.getName(), Integer.class.getName(),
                OrderByComparator.class.getName()
            });
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ISARCHIVE =
        new FinderPath(DistrictModelImpl.ENTITY_CACHE_ENABLED,
            DistrictModelImpl.FINDER_CACHE_ENABLED, DistrictImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByIsArchive",
            new String[] { Boolean.class.getName() },
            DistrictModelImpl.ISARCHIVE_COLUMN_BITMASK |
            DistrictModelImpl.NAME_COLUMN_BITMASK);
    public static final FinderPath FINDER_PATH_COUNT_BY_ISARCHIVE = new FinderPath(DistrictModelImpl.ENTITY_CACHE_ENABLED,
            DistrictModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByIsArchive",
            new String[] { Boolean.class.getName() });
    private static final String _FINDER_COLUMN_ISARCHIVE_ISARCHIVE_2 = "district.isArchive = ?";
    private static final String _SQL_SELECT_DISTRICT = "SELECT district FROM District district";
    private static final String _SQL_SELECT_DISTRICT_WHERE = "SELECT district FROM District district WHERE ";
    private static final String _SQL_COUNT_DISTRICT = "SELECT COUNT(district) FROM District district";
    private static final String _SQL_COUNT_DISTRICT_WHERE = "SELECT COUNT(district) FROM District district WHERE ";
    private static final String _ORDER_BY_ENTITY_ALIAS = "district.";
    private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No District exists with the primary key ";
    private static final String _NO_SUCH_ENTITY_WITH_KEY = "No District exists with the key {";
    private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
                PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
    private static Log _log = LogFactoryUtil.getLog(DistrictPersistenceImpl.class);
    private static Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
                "code"
            });
    private static District _nullDistrict = new DistrictImpl() {
            @Override
            public Object clone() {
                return this;
            }

            @Override
            public CacheModel<District> toCacheModel() {
                return _nullDistrictCacheModel;
            }
        };

    private static CacheModel<District> _nullDistrictCacheModel = new CacheModel<District>() {
            @Override
            public District toEntityModel() {
                return _nullDistrict;
            }
        };

    @BeanReference(type = FarmerPersistence.class)
    protected FarmerPersistence farmerPersistence;
    protected TableMapper<District, com.test.farmers.model.Farmer> districtToFarmerTableMapper;

    public DistrictPersistenceImpl() {
        setModelClass(District.class);
    }

    /**
     * Returns all the districts where isArchive = &#63;.
     *
     * @param isArchive the is archive
     * @return the matching districts
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<District> findByIsArchive(boolean isArchive)
        throws SystemException {
        return findByIsArchive(isArchive, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
            null);
    }

    /**
     * Returns a range of all the districts where isArchive = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.test.farmers.model.impl.DistrictModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param isArchive the is archive
     * @param start the lower bound of the range of districts
     * @param end the upper bound of the range of districts (not inclusive)
     * @return the range of matching districts
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<District> findByIsArchive(boolean isArchive, int start, int end)
        throws SystemException {
        return findByIsArchive(isArchive, start, end, null);
    }

    /**
     * Returns an ordered range of all the districts where isArchive = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.test.farmers.model.impl.DistrictModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param isArchive the is archive
     * @param start the lower bound of the range of districts
     * @param end the upper bound of the range of districts (not inclusive)
     * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
     * @return the ordered range of matching districts
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<District> findByIsArchive(boolean isArchive, int start,
        int end, OrderByComparator orderByComparator) throws SystemException {
        boolean pagination = true;
        FinderPath finderPath = null;
        Object[] finderArgs = null;

        if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
                (orderByComparator == null)) {
            pagination = false;
            finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ISARCHIVE;
            finderArgs = new Object[] { isArchive };
        } else {
            finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_ISARCHIVE;
            finderArgs = new Object[] { isArchive, start, end, orderByComparator };
        }

        List<District> list = (List<District>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if ((list != null) && !list.isEmpty()) {
            for (District district : list) {
                if ((isArchive != district.getIsArchive())) {
                    list = null;

                    break;
                }
            }
        }

        if (list == null) {
            StringBundler query = null;

            if (orderByComparator != null) {
                query = new StringBundler(3 +
                        (orderByComparator.getOrderByFields().length * 3));
            } else {
                query = new StringBundler(3);
            }

            query.append(_SQL_SELECT_DISTRICT_WHERE);

            query.append(_FINDER_COLUMN_ISARCHIVE_ISARCHIVE_2);

            if (orderByComparator != null) {
                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator);
            } else
             if (pagination) {
                query.append(DistrictModelImpl.ORDER_BY_JPQL);
            }

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(isArchive);

                if (!pagination) {
                    list = (List<District>) QueryUtil.list(q, getDialect(),
                            start, end, false);

                    Collections.sort(list);

                    list = new UnmodifiableList<District>(list);
                } else {
                    list = (List<District>) QueryUtil.list(q, getDialect(),
                            start, end);
                }

                cacheResult(list);

                FinderCacheUtil.putResult(finderPath, finderArgs, list);
            } catch (Exception e) {
                FinderCacheUtil.removeResult(finderPath, finderArgs);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        return list;
    }

    /**
     * Returns the first district in the ordered set where isArchive = &#63;.
     *
     * @param isArchive the is archive
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching district
     * @throws com.test.farmers.NoSuchDistrictException if a matching district could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public District findByIsArchive_First(boolean isArchive,
        OrderByComparator orderByComparator)
        throws NoSuchDistrictException, SystemException {
        District district = fetchByIsArchive_First(isArchive, orderByComparator);

        if (district != null) {
            return district;
        }

        StringBundler msg = new StringBundler(4);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("isArchive=");
        msg.append(isArchive);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchDistrictException(msg.toString());
    }

    /**
     * Returns the first district in the ordered set where isArchive = &#63;.
     *
     * @param isArchive the is archive
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching district, or <code>null</code> if a matching district could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public District fetchByIsArchive_First(boolean isArchive,
        OrderByComparator orderByComparator) throws SystemException {
        List<District> list = findByIsArchive(isArchive, 0, 1, orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the last district in the ordered set where isArchive = &#63;.
     *
     * @param isArchive the is archive
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching district
     * @throws com.test.farmers.NoSuchDistrictException if a matching district could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public District findByIsArchive_Last(boolean isArchive,
        OrderByComparator orderByComparator)
        throws NoSuchDistrictException, SystemException {
        District district = fetchByIsArchive_Last(isArchive, orderByComparator);

        if (district != null) {
            return district;
        }

        StringBundler msg = new StringBundler(4);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("isArchive=");
        msg.append(isArchive);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchDistrictException(msg.toString());
    }

    /**
     * Returns the last district in the ordered set where isArchive = &#63;.
     *
     * @param isArchive the is archive
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching district, or <code>null</code> if a matching district could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public District fetchByIsArchive_Last(boolean isArchive,
        OrderByComparator orderByComparator) throws SystemException {
        int count = countByIsArchive(isArchive);

        if (count == 0) {
            return null;
        }

        List<District> list = findByIsArchive(isArchive, count - 1, count,
                orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the districts before and after the current district in the ordered set where isArchive = &#63;.
     *
     * @param districtId the primary key of the current district
     * @param isArchive the is archive
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the previous, current, and next district
     * @throws com.test.farmers.NoSuchDistrictException if a district with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public District[] findByIsArchive_PrevAndNext(long districtId,
        boolean isArchive, OrderByComparator orderByComparator)
        throws NoSuchDistrictException, SystemException {
        District district = findByPrimaryKey(districtId);

        Session session = null;

        try {
            session = openSession();

            District[] array = new DistrictImpl[3];

            array[0] = getByIsArchive_PrevAndNext(session, district, isArchive,
                    orderByComparator, true);

            array[1] = district;

            array[2] = getByIsArchive_PrevAndNext(session, district, isArchive,
                    orderByComparator, false);

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    protected District getByIsArchive_PrevAndNext(Session session,
        District district, boolean isArchive,
        OrderByComparator orderByComparator, boolean previous) {
        StringBundler query = null;

        if (orderByComparator != null) {
            query = new StringBundler(6 +
                    (orderByComparator.getOrderByFields().length * 6));
        } else {
            query = new StringBundler(3);
        }

        query.append(_SQL_SELECT_DISTRICT_WHERE);

        query.append(_FINDER_COLUMN_ISARCHIVE_ISARCHIVE_2);

        if (orderByComparator != null) {
            String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

            if (orderByConditionFields.length > 0) {
                query.append(WHERE_AND);
            }

            for (int i = 0; i < orderByConditionFields.length; i++) {
                query.append(_ORDER_BY_ENTITY_ALIAS);
                query.append(orderByConditionFields[i]);

                if ((i + 1) < orderByConditionFields.length) {
                    if (orderByComparator.isAscending() ^ previous) {
                        query.append(WHERE_GREATER_THAN_HAS_NEXT);
                    } else {
                        query.append(WHERE_LESSER_THAN_HAS_NEXT);
                    }
                } else {
                    if (orderByComparator.isAscending() ^ previous) {
                        query.append(WHERE_GREATER_THAN);
                    } else {
                        query.append(WHERE_LESSER_THAN);
                    }
                }
            }

            query.append(ORDER_BY_CLAUSE);

            String[] orderByFields = orderByComparator.getOrderByFields();

            for (int i = 0; i < orderByFields.length; i++) {
                query.append(_ORDER_BY_ENTITY_ALIAS);
                query.append(orderByFields[i]);

                if ((i + 1) < orderByFields.length) {
                    if (orderByComparator.isAscending() ^ previous) {
                        query.append(ORDER_BY_ASC_HAS_NEXT);
                    } else {
                        query.append(ORDER_BY_DESC_HAS_NEXT);
                    }
                } else {
                    if (orderByComparator.isAscending() ^ previous) {
                        query.append(ORDER_BY_ASC);
                    } else {
                        query.append(ORDER_BY_DESC);
                    }
                }
            }
        } else {
            query.append(DistrictModelImpl.ORDER_BY_JPQL);
        }

        String sql = query.toString();

        Query q = session.createQuery(sql);

        q.setFirstResult(0);
        q.setMaxResults(2);

        QueryPos qPos = QueryPos.getInstance(q);

        qPos.add(isArchive);

        if (orderByComparator != null) {
            Object[] values = orderByComparator.getOrderByConditionValues(district);

            for (Object value : values) {
                qPos.add(value);
            }
        }

        List<District> list = q.list();

        if (list.size() == 2) {
            return list.get(1);
        } else {
            return null;
        }
    }

    /**
     * Removes all the districts where isArchive = &#63; from the database.
     *
     * @param isArchive the is archive
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void removeByIsArchive(boolean isArchive) throws SystemException {
        for (District district : findByIsArchive(isArchive, QueryUtil.ALL_POS,
                QueryUtil.ALL_POS, null)) {
            remove(district);
        }
    }

    /**
     * Returns the number of districts where isArchive = &#63;.
     *
     * @param isArchive the is archive
     * @return the number of matching districts
     * @throws SystemException if a system exception occurred
     */
    @Override
    public int countByIsArchive(boolean isArchive) throws SystemException {
        FinderPath finderPath = FINDER_PATH_COUNT_BY_ISARCHIVE;

        Object[] finderArgs = new Object[] { isArchive };

        Long count = (Long) FinderCacheUtil.getResult(finderPath, finderArgs,
                this);

        if (count == null) {
            StringBundler query = new StringBundler(2);

            query.append(_SQL_COUNT_DISTRICT_WHERE);

            query.append(_FINDER_COLUMN_ISARCHIVE_ISARCHIVE_2);

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(isArchive);

                count = (Long) q.uniqueResult();

                FinderCacheUtil.putResult(finderPath, finderArgs, count);
            } catch (Exception e) {
                FinderCacheUtil.removeResult(finderPath, finderArgs);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        return count.intValue();
    }

    /**
     * Caches the district in the entity cache if it is enabled.
     *
     * @param district the district
     */
    @Override
    public void cacheResult(District district) {
        EntityCacheUtil.putResult(DistrictModelImpl.ENTITY_CACHE_ENABLED,
            DistrictImpl.class, district.getPrimaryKey(), district);

        district.resetOriginalValues();
    }

    /**
     * Caches the districts in the entity cache if it is enabled.
     *
     * @param districts the districts
     */
    @Override
    public void cacheResult(List<District> districts) {
        for (District district : districts) {
            if (EntityCacheUtil.getResult(
                        DistrictModelImpl.ENTITY_CACHE_ENABLED,
                        DistrictImpl.class, district.getPrimaryKey()) == null) {
                cacheResult(district);
            } else {
                district.resetOriginalValues();
            }
        }
    }

    /**
     * Clears the cache for all districts.
     *
     * <p>
     * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
     * </p>
     */
    @Override
    public void clearCache() {
        if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
            CacheRegistryUtil.clear(DistrictImpl.class.getName());
        }

        EntityCacheUtil.clearCache(DistrictImpl.class.getName());

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }

    /**
     * Clears the cache for the district.
     *
     * <p>
     * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
     * </p>
     */
    @Override
    public void clearCache(District district) {
        EntityCacheUtil.removeResult(DistrictModelImpl.ENTITY_CACHE_ENABLED,
            DistrictImpl.class, district.getPrimaryKey());

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }

    @Override
    public void clearCache(List<District> districts) {
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

        for (District district : districts) {
            EntityCacheUtil.removeResult(DistrictModelImpl.ENTITY_CACHE_ENABLED,
                DistrictImpl.class, district.getPrimaryKey());
        }
    }

    /**
     * Creates a new district with the primary key. Does not add the district to the database.
     *
     * @param districtId the primary key for the new district
     * @return the new district
     */
    @Override
    public District create(long districtId) {
        District district = new DistrictImpl();

        district.setNew(true);
        district.setPrimaryKey(districtId);

        return district;
    }

    /**
     * Removes the district with the primary key from the database. Also notifies the appropriate model listeners.
     *
     * @param districtId the primary key of the district
     * @return the district that was removed
     * @throws com.test.farmers.NoSuchDistrictException if a district with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public District remove(long districtId)
        throws NoSuchDistrictException, SystemException {
        return remove((Serializable) districtId);
    }

    /**
     * Removes the district with the primary key from the database. Also notifies the appropriate model listeners.
     *
     * @param primaryKey the primary key of the district
     * @return the district that was removed
     * @throws com.test.farmers.NoSuchDistrictException if a district with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public District remove(Serializable primaryKey)
        throws NoSuchDistrictException, SystemException {
        Session session = null;

        try {
            session = openSession();

            District district = (District) session.get(DistrictImpl.class,
                    primaryKey);

            if (district == null) {
                if (_log.isWarnEnabled()) {
                    _log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
                }

                throw new NoSuchDistrictException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
                    primaryKey);
            }

            return remove(district);
        } catch (NoSuchDistrictException nsee) {
            throw nsee;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    @Override
    protected District removeImpl(District district) throws SystemException {
        district = toUnwrappedModel(district);

        districtToFarmerTableMapper.deleteLeftPrimaryKeyTableMappings(district.getPrimaryKey());

        Session session = null;

        try {
            session = openSession();

            if (!session.contains(district)) {
                district = (District) session.get(DistrictImpl.class,
                        district.getPrimaryKeyObj());
            }

            if (district != null) {
                session.delete(district);
            }
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        if (district != null) {
            clearCache(district);
        }

        return district;
    }

    @Override
    public District updateImpl(com.test.farmers.model.District district)
        throws SystemException {
        district = toUnwrappedModel(district);

        boolean isNew = district.isNew();

        DistrictModelImpl districtModelImpl = (DistrictModelImpl) district;

        Session session = null;

        try {
            session = openSession();

            if (district.isNew()) {
                session.save(district);

                district.setNew(false);
            } else {
                session.merge(district);
            }
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

        if (isNew || !DistrictModelImpl.COLUMN_BITMASK_ENABLED) {
            FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
        }
        else {
            if ((districtModelImpl.getColumnBitmask() &
                    FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ISARCHIVE.getColumnBitmask()) != 0) {
                Object[] args = new Object[] {
                        districtModelImpl.getOriginalIsArchive()
                    };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_ISARCHIVE,
                    args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ISARCHIVE,
                    args);

                args = new Object[] { districtModelImpl.getIsArchive() };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_ISARCHIVE,
                    args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ISARCHIVE,
                    args);
            }
        }

        EntityCacheUtil.putResult(DistrictModelImpl.ENTITY_CACHE_ENABLED,
            DistrictImpl.class, district.getPrimaryKey(), district);

        return district;
    }

    protected District toUnwrappedModel(District district) {
        if (district instanceof DistrictImpl) {
            return district;
        }

        DistrictImpl districtImpl = new DistrictImpl();

        districtImpl.setNew(district.isNew());
        districtImpl.setPrimaryKey(district.getPrimaryKey());

        districtImpl.setDistrictId(district.getDistrictId());
        districtImpl.setName(district.getName());
        districtImpl.setCode(district.getCode());
        districtImpl.setIsArchive(district.isIsArchive());

        return districtImpl;
    }

    /**
     * Returns the district with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
     *
     * @param primaryKey the primary key of the district
     * @return the district
     * @throws com.test.farmers.NoSuchDistrictException if a district with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public District findByPrimaryKey(Serializable primaryKey)
        throws NoSuchDistrictException, SystemException {
        District district = fetchByPrimaryKey(primaryKey);

        if (district == null) {
            if (_log.isWarnEnabled()) {
                _log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
            }

            throw new NoSuchDistrictException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
                primaryKey);
        }

        return district;
    }

    /**
     * Returns the district with the primary key or throws a {@link com.test.farmers.NoSuchDistrictException} if it could not be found.
     *
     * @param districtId the primary key of the district
     * @return the district
     * @throws com.test.farmers.NoSuchDistrictException if a district with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public District findByPrimaryKey(long districtId)
        throws NoSuchDistrictException, SystemException {
        return findByPrimaryKey((Serializable) districtId);
    }

    /**
     * Returns the district with the primary key or returns <code>null</code> if it could not be found.
     *
     * @param primaryKey the primary key of the district
     * @return the district, or <code>null</code> if a district with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public District fetchByPrimaryKey(Serializable primaryKey)
        throws SystemException {
        District district = (District) EntityCacheUtil.getResult(DistrictModelImpl.ENTITY_CACHE_ENABLED,
                DistrictImpl.class, primaryKey);

        if (district == _nullDistrict) {
            return null;
        }

        if (district == null) {
            Session session = null;

            try {
                session = openSession();

                district = (District) session.get(DistrictImpl.class, primaryKey);

                if (district != null) {
                    cacheResult(district);
                } else {
                    EntityCacheUtil.putResult(DistrictModelImpl.ENTITY_CACHE_ENABLED,
                        DistrictImpl.class, primaryKey, _nullDistrict);
                }
            } catch (Exception e) {
                EntityCacheUtil.removeResult(DistrictModelImpl.ENTITY_CACHE_ENABLED,
                    DistrictImpl.class, primaryKey);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        return district;
    }

    /**
     * Returns the district with the primary key or returns <code>null</code> if it could not be found.
     *
     * @param districtId the primary key of the district
     * @return the district, or <code>null</code> if a district with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public District fetchByPrimaryKey(long districtId)
        throws SystemException {
        return fetchByPrimaryKey((Serializable) districtId);
    }

    /**
     * Returns all the districts.
     *
     * @return the districts
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<District> findAll() throws SystemException {
        return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
    public List<District> findAll(int start, int end) throws SystemException {
        return findAll(start, end, null);
    }

    /**
     * Returns an ordered range of all the districts.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.test.farmers.model.impl.DistrictModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param start the lower bound of the range of districts
     * @param end the upper bound of the range of districts (not inclusive)
     * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
     * @return the ordered range of districts
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<District> findAll(int start, int end,
        OrderByComparator orderByComparator) throws SystemException {
        boolean pagination = true;
        FinderPath finderPath = null;
        Object[] finderArgs = null;

        if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
                (orderByComparator == null)) {
            pagination = false;
            finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL;
            finderArgs = FINDER_ARGS_EMPTY;
        } else {
            finderPath = FINDER_PATH_WITH_PAGINATION_FIND_ALL;
            finderArgs = new Object[] { start, end, orderByComparator };
        }

        List<District> list = (List<District>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if (list == null) {
            StringBundler query = null;
            String sql = null;

            if (orderByComparator != null) {
                query = new StringBundler(2 +
                        (orderByComparator.getOrderByFields().length * 3));

                query.append(_SQL_SELECT_DISTRICT);

                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator);

                sql = query.toString();
            } else {
                sql = _SQL_SELECT_DISTRICT;

                if (pagination) {
                    sql = sql.concat(DistrictModelImpl.ORDER_BY_JPQL);
                }
            }

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                if (!pagination) {
                    list = (List<District>) QueryUtil.list(q, getDialect(),
                            start, end, false);

                    Collections.sort(list);

                    list = new UnmodifiableList<District>(list);
                } else {
                    list = (List<District>) QueryUtil.list(q, getDialect(),
                            start, end);
                }

                cacheResult(list);

                FinderCacheUtil.putResult(finderPath, finderArgs, list);
            } catch (Exception e) {
                FinderCacheUtil.removeResult(finderPath, finderArgs);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        return list;
    }

    /**
     * Removes all the districts from the database.
     *
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void removeAll() throws SystemException {
        for (District district : findAll()) {
            remove(district);
        }
    }

    /**
     * Returns the number of districts.
     *
     * @return the number of districts
     * @throws SystemException if a system exception occurred
     */
    @Override
    public int countAll() throws SystemException {
        Long count = (Long) FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
                FINDER_ARGS_EMPTY, this);

        if (count == null) {
            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(_SQL_COUNT_DISTRICT);

                count = (Long) q.uniqueResult();

                FinderCacheUtil.putResult(FINDER_PATH_COUNT_ALL,
                    FINDER_ARGS_EMPTY, count);
            } catch (Exception e) {
                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_ALL,
                    FINDER_ARGS_EMPTY);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        return count.intValue();
    }

    /**
     * Returns all the farmers associated with the district.
     *
     * @param pk the primary key of the district
     * @return the farmers associated with the district
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<com.test.farmers.model.Farmer> getFarmers(long pk)
        throws SystemException {
        return getFarmers(pk, QueryUtil.ALL_POS, QueryUtil.ALL_POS);
    }

    /**
     * Returns a range of all the farmers associated with the district.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.test.farmers.model.impl.DistrictModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param pk the primary key of the district
     * @param start the lower bound of the range of districts
     * @param end the upper bound of the range of districts (not inclusive)
     * @return the range of farmers associated with the district
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<com.test.farmers.model.Farmer> getFarmers(long pk, int start,
        int end) throws SystemException {
        return getFarmers(pk, start, end, null);
    }

    /**
     * Returns an ordered range of all the farmers associated with the district.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.test.farmers.model.impl.DistrictModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param pk the primary key of the district
     * @param start the lower bound of the range of districts
     * @param end the upper bound of the range of districts (not inclusive)
     * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
     * @return the ordered range of farmers associated with the district
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<com.test.farmers.model.Farmer> getFarmers(long pk, int start,
        int end, OrderByComparator orderByComparator) throws SystemException {
        return districtToFarmerTableMapper.getRightBaseModels(pk, start, end,
            orderByComparator);
    }

    /**
     * Returns the number of farmers associated with the district.
     *
     * @param pk the primary key of the district
     * @return the number of farmers associated with the district
     * @throws SystemException if a system exception occurred
     */
    @Override
    public int getFarmersSize(long pk) throws SystemException {
        long[] pks = districtToFarmerTableMapper.getRightPrimaryKeys(pk);

        return pks.length;
    }

    /**
     * Returns <code>true</code> if the farmer is associated with the district.
     *
     * @param pk the primary key of the district
     * @param farmerPK the primary key of the farmer
     * @return <code>true</code> if the farmer is associated with the district; <code>false</code> otherwise
     * @throws SystemException if a system exception occurred
     */
    @Override
    public boolean containsFarmer(long pk, long farmerPK)
        throws SystemException {
        return districtToFarmerTableMapper.containsTableMapping(pk, farmerPK);
    }

    /**
     * Returns <code>true</code> if the district has any farmers associated with it.
     *
     * @param pk the primary key of the district to check for associations with farmers
     * @return <code>true</code> if the district has any farmers associated with it; <code>false</code> otherwise
     * @throws SystemException if a system exception occurred
     */
    @Override
    public boolean containsFarmers(long pk) throws SystemException {
        if (getFarmersSize(pk) > 0) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Adds an association between the district and the farmer. Also notifies the appropriate model listeners and clears the mapping table finder cache.
     *
     * @param pk the primary key of the district
     * @param farmerPK the primary key of the farmer
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void addFarmer(long pk, long farmerPK) throws SystemException {
        districtToFarmerTableMapper.addTableMapping(pk, farmerPK);
    }

    /**
     * Adds an association between the district and the farmer. Also notifies the appropriate model listeners and clears the mapping table finder cache.
     *
     * @param pk the primary key of the district
     * @param farmer the farmer
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void addFarmer(long pk, com.test.farmers.model.Farmer farmer)
        throws SystemException {
        districtToFarmerTableMapper.addTableMapping(pk, farmer.getPrimaryKey());
    }

    /**
     * Adds an association between the district and the farmers. Also notifies the appropriate model listeners and clears the mapping table finder cache.
     *
     * @param pk the primary key of the district
     * @param farmerPKs the primary keys of the farmers
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void addFarmers(long pk, long[] farmerPKs) throws SystemException {
        for (long farmerPK : farmerPKs) {
            districtToFarmerTableMapper.addTableMapping(pk, farmerPK);
        }
    }

    /**
     * Adds an association between the district and the farmers. Also notifies the appropriate model listeners and clears the mapping table finder cache.
     *
     * @param pk the primary key of the district
     * @param farmers the farmers
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void addFarmers(long pk, List<com.test.farmers.model.Farmer> farmers)
        throws SystemException {
        for (com.test.farmers.model.Farmer farmer : farmers) {
            districtToFarmerTableMapper.addTableMapping(pk,
                farmer.getPrimaryKey());
        }
    }

    /**
     * Clears all associations between the district and its farmers. Also notifies the appropriate model listeners and clears the mapping table finder cache.
     *
     * @param pk the primary key of the district to clear the associated farmers from
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void clearFarmers(long pk) throws SystemException {
        districtToFarmerTableMapper.deleteLeftPrimaryKeyTableMappings(pk);
    }

    /**
     * Removes the association between the district and the farmer. Also notifies the appropriate model listeners and clears the mapping table finder cache.
     *
     * @param pk the primary key of the district
     * @param farmerPK the primary key of the farmer
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void removeFarmer(long pk, long farmerPK) throws SystemException {
        districtToFarmerTableMapper.deleteTableMapping(pk, farmerPK);
    }

    /**
     * Removes the association between the district and the farmer. Also notifies the appropriate model listeners and clears the mapping table finder cache.
     *
     * @param pk the primary key of the district
     * @param farmer the farmer
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void removeFarmer(long pk, com.test.farmers.model.Farmer farmer)
        throws SystemException {
        districtToFarmerTableMapper.deleteTableMapping(pk,
            farmer.getPrimaryKey());
    }

    /**
     * Removes the association between the district and the farmers. Also notifies the appropriate model listeners and clears the mapping table finder cache.
     *
     * @param pk the primary key of the district
     * @param farmerPKs the primary keys of the farmers
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void removeFarmers(long pk, long[] farmerPKs)
        throws SystemException {
        for (long farmerPK : farmerPKs) {
            districtToFarmerTableMapper.deleteTableMapping(pk, farmerPK);
        }
    }

    /**
     * Removes the association between the district and the farmers. Also notifies the appropriate model listeners and clears the mapping table finder cache.
     *
     * @param pk the primary key of the district
     * @param farmers the farmers
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void removeFarmers(long pk,
        List<com.test.farmers.model.Farmer> farmers) throws SystemException {
        for (com.test.farmers.model.Farmer farmer : farmers) {
            districtToFarmerTableMapper.deleteTableMapping(pk,
                farmer.getPrimaryKey());
        }
    }

    /**
     * Sets the farmers associated with the district, removing and adding associations as necessary. Also notifies the appropriate model listeners and clears the mapping table finder cache.
     *
     * @param pk the primary key of the district
     * @param farmerPKs the primary keys of the farmers to be associated with the district
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void setFarmers(long pk, long[] farmerPKs) throws SystemException {
        Set<Long> newFarmerPKsSet = SetUtil.fromArray(farmerPKs);
        Set<Long> oldFarmerPKsSet = SetUtil.fromArray(districtToFarmerTableMapper.getRightPrimaryKeys(
                    pk));

        Set<Long> removeFarmerPKsSet = new HashSet<Long>(oldFarmerPKsSet);

        removeFarmerPKsSet.removeAll(newFarmerPKsSet);

        for (long removeFarmerPK : removeFarmerPKsSet) {
            districtToFarmerTableMapper.deleteTableMapping(pk, removeFarmerPK);
        }

        newFarmerPKsSet.removeAll(oldFarmerPKsSet);

        for (long newFarmerPK : newFarmerPKsSet) {
            districtToFarmerTableMapper.addTableMapping(pk, newFarmerPK);
        }
    }

    /**
     * Sets the farmers associated with the district, removing and adding associations as necessary. Also notifies the appropriate model listeners and clears the mapping table finder cache.
     *
     * @param pk the primary key of the district
     * @param farmers the farmers to be associated with the district
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void setFarmers(long pk, List<com.test.farmers.model.Farmer> farmers)
        throws SystemException {
        try {
            long[] farmerPKs = new long[farmers.size()];

            for (int i = 0; i < farmers.size(); i++) {
                com.test.farmers.model.Farmer farmer = farmers.get(i);

                farmerPKs[i] = farmer.getPrimaryKey();
            }

            setFarmers(pk, farmerPKs);
        } catch (Exception e) {
            throw processException(e);
        } finally {
            FinderCacheUtil.clearCache(DistrictModelImpl.MAPPING_TABLE_LR_FARMERS_DISTRICTS_NAME);
        }
    }

    @Override
    protected Set<String> getBadColumnNames() {
        return _badColumnNames;
    }

    /**
     * Initializes the district persistence.
     */
    public void afterPropertiesSet() {
        String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
                    com.liferay.util.service.ServiceProps.get(
                        "value.object.listener.com.test.farmers.model.District")));

        if (listenerClassNames.length > 0) {
            try {
                List<ModelListener<District>> listenersList = new ArrayList<ModelListener<District>>();

                for (String listenerClassName : listenerClassNames) {
                    listenersList.add((ModelListener<District>) InstanceFactory.newInstance(
                            getClassLoader(), listenerClassName));
                }

                listeners = listenersList.toArray(new ModelListener[listenersList.size()]);
            } catch (Exception e) {
                _log.error(e);
            }
        }

        districtToFarmerTableMapper = TableMapperFactory.getTableMapper("lr_Farmers_Districts",
                "districtId", "farmerId", this, farmerPersistence);
    }

    public void destroy() {
        EntityCacheUtil.removeCache(DistrictImpl.class.getName());
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

        TableMapperFactory.removeTableMapper("lr_Farmers_Districts");
    }
}
