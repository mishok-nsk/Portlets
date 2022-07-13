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
import com.liferay.portal.kernel.util.CalendarUtil;
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
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.ModelListener;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;
import com.liferay.portal.service.persistence.impl.TableMapper;
import com.liferay.portal.service.persistence.impl.TableMapperFactory;

import com.test.farmers.NoSuchFarmerException;
import com.test.farmers.model.Farmer;
import com.test.farmers.model.impl.FarmerImpl;
import com.test.farmers.model.impl.FarmerModelImpl;
import com.test.farmers.service.persistence.DistrictPersistence;
import com.test.farmers.service.persistence.FarmerPersistence;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * The persistence implementation for the farmer service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see FarmerPersistence
 * @see FarmerUtil
 * @generated
 */
public class FarmerPersistenceImpl extends BasePersistenceImpl<Farmer>
    implements FarmerPersistence {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this class directly. Always use {@link FarmerUtil} to access the farmer persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
     */
    public static final String FINDER_CLASS_NAME_ENTITY = FarmerImpl.class.getName();
    public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
        ".List1";
    public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
        ".List2";
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(FarmerModelImpl.ENTITY_CACHE_ENABLED,
            FarmerModelImpl.FINDER_CACHE_ENABLED, FarmerImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(FarmerModelImpl.ENTITY_CACHE_ENABLED,
            FarmerModelImpl.FINDER_CACHE_ENABLED, FarmerImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
    public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(FarmerModelImpl.ENTITY_CACHE_ENABLED,
            FarmerModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_NAME = new FinderPath(FarmerModelImpl.ENTITY_CACHE_ENABLED,
            FarmerModelImpl.FINDER_CACHE_ENABLED, FarmerImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByName",
            new String[] {
                String.class.getName(),
                
            Integer.class.getName(), Integer.class.getName(),
                OrderByComparator.class.getName()
            });
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_NAME = new FinderPath(FarmerModelImpl.ENTITY_CACHE_ENABLED,
            FarmerModelImpl.FINDER_CACHE_ENABLED, FarmerImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByName",
            new String[] { String.class.getName() },
            FarmerModelImpl.NAME_COLUMN_BITMASK);
    public static final FinderPath FINDER_PATH_COUNT_BY_NAME = new FinderPath(FarmerModelImpl.ENTITY_CACHE_ENABLED,
            FarmerModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByName",
            new String[] { String.class.getName() });
    private static final String _FINDER_COLUMN_NAME_NAME_1 = "farmer.name IS NULL";
    private static final String _FINDER_COLUMN_NAME_NAME_2 = "farmer.name = ?";
    private static final String _FINDER_COLUMN_NAME_NAME_3 = "(farmer.name IS NULL OR farmer.name = '')";
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_INN = new FinderPath(FarmerModelImpl.ENTITY_CACHE_ENABLED,
            FarmerModelImpl.FINDER_CACHE_ENABLED, FarmerImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByInn",
            new String[] {
                Long.class.getName(),
                
            Integer.class.getName(), Integer.class.getName(),
                OrderByComparator.class.getName()
            });
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_INN = new FinderPath(FarmerModelImpl.ENTITY_CACHE_ENABLED,
            FarmerModelImpl.FINDER_CACHE_ENABLED, FarmerImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByInn",
            new String[] { Long.class.getName() },
            FarmerModelImpl.INN_COLUMN_BITMASK |
            FarmerModelImpl.NAME_COLUMN_BITMASK);
    public static final FinderPath FINDER_PATH_COUNT_BY_INN = new FinderPath(FarmerModelImpl.ENTITY_CACHE_ENABLED,
            FarmerModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByInn",
            new String[] { Long.class.getName() });
    private static final String _FINDER_COLUMN_INN_INN_2 = "farmer.inn = ?";
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_REGISTRATIONDATE =
        new FinderPath(FarmerModelImpl.ENTITY_CACHE_ENABLED,
            FarmerModelImpl.FINDER_CACHE_ENABLED, FarmerImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByRegistrationDate",
            new String[] {
                Date.class.getName(),
                
            Integer.class.getName(), Integer.class.getName(),
                OrderByComparator.class.getName()
            });
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_REGISTRATIONDATE =
        new FinderPath(FarmerModelImpl.ENTITY_CACHE_ENABLED,
            FarmerModelImpl.FINDER_CACHE_ENABLED, FarmerImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
            "findByRegistrationDate", new String[] { Date.class.getName() },
            FarmerModelImpl.REGISTRATIONDATE_COLUMN_BITMASK |
            FarmerModelImpl.NAME_COLUMN_BITMASK);
    public static final FinderPath FINDER_PATH_COUNT_BY_REGISTRATIONDATE = new FinderPath(FarmerModelImpl.ENTITY_CACHE_ENABLED,
            FarmerModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
            "countByRegistrationDate", new String[] { Date.class.getName() });
    private static final String _FINDER_COLUMN_REGISTRATIONDATE_REGISTRATIONDATE_1 =
        "farmer.registrationDate IS NULL";
    private static final String _FINDER_COLUMN_REGISTRATIONDATE_REGISTRATIONDATE_2 =
        "farmer.registrationDate = ?";
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_ISARCHIVE =
        new FinderPath(FarmerModelImpl.ENTITY_CACHE_ENABLED,
            FarmerModelImpl.FINDER_CACHE_ENABLED, FarmerImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByIsArchive",
            new String[] {
                Boolean.class.getName(),
                
            Integer.class.getName(), Integer.class.getName(),
                OrderByComparator.class.getName()
            });
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ISARCHIVE =
        new FinderPath(FarmerModelImpl.ENTITY_CACHE_ENABLED,
            FarmerModelImpl.FINDER_CACHE_ENABLED, FarmerImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByIsArchive",
            new String[] { Boolean.class.getName() },
            FarmerModelImpl.ISARCHIVE_COLUMN_BITMASK |
            FarmerModelImpl.NAME_COLUMN_BITMASK);
    public static final FinderPath FINDER_PATH_COUNT_BY_ISARCHIVE = new FinderPath(FarmerModelImpl.ENTITY_CACHE_ENABLED,
            FarmerModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByIsArchive",
            new String[] { Boolean.class.getName() });
    private static final String _FINDER_COLUMN_ISARCHIVE_ISARCHIVE_2 = "farmer.isArchive = ?";
    private static final String _SQL_SELECT_FARMER = "SELECT farmer FROM Farmer farmer";
    private static final String _SQL_SELECT_FARMER_WHERE = "SELECT farmer FROM Farmer farmer WHERE ";
    private static final String _SQL_COUNT_FARMER = "SELECT COUNT(farmer) FROM Farmer farmer";
    private static final String _SQL_COUNT_FARMER_WHERE = "SELECT COUNT(farmer) FROM Farmer farmer WHERE ";
    private static final String _ORDER_BY_ENTITY_ALIAS = "farmer.";
    private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No Farmer exists with the primary key ";
    private static final String _NO_SUCH_ENTITY_WITH_KEY = "No Farmer exists with the key {";
    private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
                PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
    private static Log _log = LogFactoryUtil.getLog(FarmerPersistenceImpl.class);
    private static Farmer _nullFarmer = new FarmerImpl() {
            @Override
            public Object clone() {
                return this;
            }

            @Override
            public CacheModel<Farmer> toCacheModel() {
                return _nullFarmerCacheModel;
            }
        };

    private static CacheModel<Farmer> _nullFarmerCacheModel = new CacheModel<Farmer>() {
            @Override
            public Farmer toEntityModel() {
                return _nullFarmer;
            }
        };

    @BeanReference(type = DistrictPersistence.class)
    protected DistrictPersistence districtPersistence;
    protected TableMapper<Farmer, com.test.farmers.model.District> farmerToDistrictTableMapper;

    public FarmerPersistenceImpl() {
        setModelClass(Farmer.class);
    }

    /**
     * Returns all the farmers where name = &#63;.
     *
     * @param name the name
     * @return the matching farmers
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<Farmer> findByName(String name) throws SystemException {
        return findByName(name, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
    }

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
    @Override
    public List<Farmer> findByName(String name, int start, int end)
        throws SystemException {
        return findByName(name, start, end, null);
    }

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
    @Override
    public List<Farmer> findByName(String name, int start, int end,
        OrderByComparator orderByComparator) throws SystemException {
        boolean pagination = true;
        FinderPath finderPath = null;
        Object[] finderArgs = null;

        if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
                (orderByComparator == null)) {
            pagination = false;
            finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_NAME;
            finderArgs = new Object[] { name };
        } else {
            finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_NAME;
            finderArgs = new Object[] { name, start, end, orderByComparator };
        }

        List<Farmer> list = (List<Farmer>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if ((list != null) && !list.isEmpty()) {
            for (Farmer farmer : list) {
                if (!Validator.equals(name, farmer.getName())) {
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

            query.append(_SQL_SELECT_FARMER_WHERE);

            boolean bindName = false;

            if (name == null) {
                query.append(_FINDER_COLUMN_NAME_NAME_1);
            } else if (name.equals(StringPool.BLANK)) {
                query.append(_FINDER_COLUMN_NAME_NAME_3);
            } else {
                bindName = true;

                query.append(_FINDER_COLUMN_NAME_NAME_2);
            }

            if (orderByComparator != null) {
                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator);
            } else
             if (pagination) {
                query.append(FarmerModelImpl.ORDER_BY_JPQL);
            }

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                if (bindName) {
                    qPos.add(name);
                }

                if (!pagination) {
                    list = (List<Farmer>) QueryUtil.list(q, getDialect(),
                            start, end, false);

                    Collections.sort(list);

                    list = new UnmodifiableList<Farmer>(list);
                } else {
                    list = (List<Farmer>) QueryUtil.list(q, getDialect(),
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
     * Returns the first farmer in the ordered set where name = &#63;.
     *
     * @param name the name
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching farmer
     * @throws com.test.farmers.NoSuchFarmerException if a matching farmer could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Farmer findByName_First(String name,
        OrderByComparator orderByComparator)
        throws NoSuchFarmerException, SystemException {
        Farmer farmer = fetchByName_First(name, orderByComparator);

        if (farmer != null) {
            return farmer;
        }

        StringBundler msg = new StringBundler(4);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("name=");
        msg.append(name);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchFarmerException(msg.toString());
    }

    /**
     * Returns the first farmer in the ordered set where name = &#63;.
     *
     * @param name the name
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching farmer, or <code>null</code> if a matching farmer could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Farmer fetchByName_First(String name,
        OrderByComparator orderByComparator) throws SystemException {
        List<Farmer> list = findByName(name, 0, 1, orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the last farmer in the ordered set where name = &#63;.
     *
     * @param name the name
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching farmer
     * @throws com.test.farmers.NoSuchFarmerException if a matching farmer could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Farmer findByName_Last(String name,
        OrderByComparator orderByComparator)
        throws NoSuchFarmerException, SystemException {
        Farmer farmer = fetchByName_Last(name, orderByComparator);

        if (farmer != null) {
            return farmer;
        }

        StringBundler msg = new StringBundler(4);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("name=");
        msg.append(name);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchFarmerException(msg.toString());
    }

    /**
     * Returns the last farmer in the ordered set where name = &#63;.
     *
     * @param name the name
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching farmer, or <code>null</code> if a matching farmer could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Farmer fetchByName_Last(String name,
        OrderByComparator orderByComparator) throws SystemException {
        int count = countByName(name);

        if (count == 0) {
            return null;
        }

        List<Farmer> list = findByName(name, count - 1, count, orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

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
    @Override
    public Farmer[] findByName_PrevAndNext(long farmerId, String name,
        OrderByComparator orderByComparator)
        throws NoSuchFarmerException, SystemException {
        Farmer farmer = findByPrimaryKey(farmerId);

        Session session = null;

        try {
            session = openSession();

            Farmer[] array = new FarmerImpl[3];

            array[0] = getByName_PrevAndNext(session, farmer, name,
                    orderByComparator, true);

            array[1] = farmer;

            array[2] = getByName_PrevAndNext(session, farmer, name,
                    orderByComparator, false);

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    protected Farmer getByName_PrevAndNext(Session session, Farmer farmer,
        String name, OrderByComparator orderByComparator, boolean previous) {
        StringBundler query = null;

        if (orderByComparator != null) {
            query = new StringBundler(6 +
                    (orderByComparator.getOrderByFields().length * 6));
        } else {
            query = new StringBundler(3);
        }

        query.append(_SQL_SELECT_FARMER_WHERE);

        boolean bindName = false;

        if (name == null) {
            query.append(_FINDER_COLUMN_NAME_NAME_1);
        } else if (name.equals(StringPool.BLANK)) {
            query.append(_FINDER_COLUMN_NAME_NAME_3);
        } else {
            bindName = true;

            query.append(_FINDER_COLUMN_NAME_NAME_2);
        }

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
            query.append(FarmerModelImpl.ORDER_BY_JPQL);
        }

        String sql = query.toString();

        Query q = session.createQuery(sql);

        q.setFirstResult(0);
        q.setMaxResults(2);

        QueryPos qPos = QueryPos.getInstance(q);

        if (bindName) {
            qPos.add(name);
        }

        if (orderByComparator != null) {
            Object[] values = orderByComparator.getOrderByConditionValues(farmer);

            for (Object value : values) {
                qPos.add(value);
            }
        }

        List<Farmer> list = q.list();

        if (list.size() == 2) {
            return list.get(1);
        } else {
            return null;
        }
    }

    /**
     * Removes all the farmers where name = &#63; from the database.
     *
     * @param name the name
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void removeByName(String name) throws SystemException {
        for (Farmer farmer : findByName(name, QueryUtil.ALL_POS,
                QueryUtil.ALL_POS, null)) {
            remove(farmer);
        }
    }

    /**
     * Returns the number of farmers where name = &#63;.
     *
     * @param name the name
     * @return the number of matching farmers
     * @throws SystemException if a system exception occurred
     */
    @Override
    public int countByName(String name) throws SystemException {
        FinderPath finderPath = FINDER_PATH_COUNT_BY_NAME;

        Object[] finderArgs = new Object[] { name };

        Long count = (Long) FinderCacheUtil.getResult(finderPath, finderArgs,
                this);

        if (count == null) {
            StringBundler query = new StringBundler(2);

            query.append(_SQL_COUNT_FARMER_WHERE);

            boolean bindName = false;

            if (name == null) {
                query.append(_FINDER_COLUMN_NAME_NAME_1);
            } else if (name.equals(StringPool.BLANK)) {
                query.append(_FINDER_COLUMN_NAME_NAME_3);
            } else {
                bindName = true;

                query.append(_FINDER_COLUMN_NAME_NAME_2);
            }

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                if (bindName) {
                    qPos.add(name);
                }

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
     * Returns all the farmers where inn = &#63;.
     *
     * @param inn the inn
     * @return the matching farmers
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<Farmer> findByInn(long inn) throws SystemException {
        return findByInn(inn, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
    }

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
    @Override
    public List<Farmer> findByInn(long inn, int start, int end)
        throws SystemException {
        return findByInn(inn, start, end, null);
    }

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
    @Override
    public List<Farmer> findByInn(long inn, int start, int end,
        OrderByComparator orderByComparator) throws SystemException {
        boolean pagination = true;
        FinderPath finderPath = null;
        Object[] finderArgs = null;

        if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
                (orderByComparator == null)) {
            pagination = false;
            finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_INN;
            finderArgs = new Object[] { inn };
        } else {
            finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_INN;
            finderArgs = new Object[] { inn, start, end, orderByComparator };
        }

        List<Farmer> list = (List<Farmer>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if ((list != null) && !list.isEmpty()) {
            for (Farmer farmer : list) {
                if ((inn != farmer.getInn())) {
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

            query.append(_SQL_SELECT_FARMER_WHERE);

            query.append(_FINDER_COLUMN_INN_INN_2);

            if (orderByComparator != null) {
                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator);
            } else
             if (pagination) {
                query.append(FarmerModelImpl.ORDER_BY_JPQL);
            }

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(inn);

                if (!pagination) {
                    list = (List<Farmer>) QueryUtil.list(q, getDialect(),
                            start, end, false);

                    Collections.sort(list);

                    list = new UnmodifiableList<Farmer>(list);
                } else {
                    list = (List<Farmer>) QueryUtil.list(q, getDialect(),
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
     * Returns the first farmer in the ordered set where inn = &#63;.
     *
     * @param inn the inn
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching farmer
     * @throws com.test.farmers.NoSuchFarmerException if a matching farmer could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Farmer findByInn_First(long inn, OrderByComparator orderByComparator)
        throws NoSuchFarmerException, SystemException {
        Farmer farmer = fetchByInn_First(inn, orderByComparator);

        if (farmer != null) {
            return farmer;
        }

        StringBundler msg = new StringBundler(4);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("inn=");
        msg.append(inn);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchFarmerException(msg.toString());
    }

    /**
     * Returns the first farmer in the ordered set where inn = &#63;.
     *
     * @param inn the inn
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching farmer, or <code>null</code> if a matching farmer could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Farmer fetchByInn_First(long inn, OrderByComparator orderByComparator)
        throws SystemException {
        List<Farmer> list = findByInn(inn, 0, 1, orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the last farmer in the ordered set where inn = &#63;.
     *
     * @param inn the inn
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching farmer
     * @throws com.test.farmers.NoSuchFarmerException if a matching farmer could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Farmer findByInn_Last(long inn, OrderByComparator orderByComparator)
        throws NoSuchFarmerException, SystemException {
        Farmer farmer = fetchByInn_Last(inn, orderByComparator);

        if (farmer != null) {
            return farmer;
        }

        StringBundler msg = new StringBundler(4);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("inn=");
        msg.append(inn);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchFarmerException(msg.toString());
    }

    /**
     * Returns the last farmer in the ordered set where inn = &#63;.
     *
     * @param inn the inn
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching farmer, or <code>null</code> if a matching farmer could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Farmer fetchByInn_Last(long inn, OrderByComparator orderByComparator)
        throws SystemException {
        int count = countByInn(inn);

        if (count == 0) {
            return null;
        }

        List<Farmer> list = findByInn(inn, count - 1, count, orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

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
    @Override
    public Farmer[] findByInn_PrevAndNext(long farmerId, long inn,
        OrderByComparator orderByComparator)
        throws NoSuchFarmerException, SystemException {
        Farmer farmer = findByPrimaryKey(farmerId);

        Session session = null;

        try {
            session = openSession();

            Farmer[] array = new FarmerImpl[3];

            array[0] = getByInn_PrevAndNext(session, farmer, inn,
                    orderByComparator, true);

            array[1] = farmer;

            array[2] = getByInn_PrevAndNext(session, farmer, inn,
                    orderByComparator, false);

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    protected Farmer getByInn_PrevAndNext(Session session, Farmer farmer,
        long inn, OrderByComparator orderByComparator, boolean previous) {
        StringBundler query = null;

        if (orderByComparator != null) {
            query = new StringBundler(6 +
                    (orderByComparator.getOrderByFields().length * 6));
        } else {
            query = new StringBundler(3);
        }

        query.append(_SQL_SELECT_FARMER_WHERE);

        query.append(_FINDER_COLUMN_INN_INN_2);

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
            query.append(FarmerModelImpl.ORDER_BY_JPQL);
        }

        String sql = query.toString();

        Query q = session.createQuery(sql);

        q.setFirstResult(0);
        q.setMaxResults(2);

        QueryPos qPos = QueryPos.getInstance(q);

        qPos.add(inn);

        if (orderByComparator != null) {
            Object[] values = orderByComparator.getOrderByConditionValues(farmer);

            for (Object value : values) {
                qPos.add(value);
            }
        }

        List<Farmer> list = q.list();

        if (list.size() == 2) {
            return list.get(1);
        } else {
            return null;
        }
    }

    /**
     * Removes all the farmers where inn = &#63; from the database.
     *
     * @param inn the inn
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void removeByInn(long inn) throws SystemException {
        for (Farmer farmer : findByInn(inn, QueryUtil.ALL_POS,
                QueryUtil.ALL_POS, null)) {
            remove(farmer);
        }
    }

    /**
     * Returns the number of farmers where inn = &#63;.
     *
     * @param inn the inn
     * @return the number of matching farmers
     * @throws SystemException if a system exception occurred
     */
    @Override
    public int countByInn(long inn) throws SystemException {
        FinderPath finderPath = FINDER_PATH_COUNT_BY_INN;

        Object[] finderArgs = new Object[] { inn };

        Long count = (Long) FinderCacheUtil.getResult(finderPath, finderArgs,
                this);

        if (count == null) {
            StringBundler query = new StringBundler(2);

            query.append(_SQL_COUNT_FARMER_WHERE);

            query.append(_FINDER_COLUMN_INN_INN_2);

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(inn);

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
     * Returns all the farmers where registrationDate = &#63;.
     *
     * @param registrationDate the registration date
     * @return the matching farmers
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<Farmer> findByRegistrationDate(Date registrationDate)
        throws SystemException {
        return findByRegistrationDate(registrationDate, QueryUtil.ALL_POS,
            QueryUtil.ALL_POS, null);
    }

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
    @Override
    public List<Farmer> findByRegistrationDate(Date registrationDate,
        int start, int end) throws SystemException {
        return findByRegistrationDate(registrationDate, start, end, null);
    }

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
    @Override
    public List<Farmer> findByRegistrationDate(Date registrationDate,
        int start, int end, OrderByComparator orderByComparator)
        throws SystemException {
        boolean pagination = true;
        FinderPath finderPath = null;
        Object[] finderArgs = null;

        if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
                (orderByComparator == null)) {
            pagination = false;
            finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_REGISTRATIONDATE;
            finderArgs = new Object[] { registrationDate };
        } else {
            finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_REGISTRATIONDATE;
            finderArgs = new Object[] {
                    registrationDate,
                    
                    start, end, orderByComparator
                };
        }

        List<Farmer> list = (List<Farmer>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if ((list != null) && !list.isEmpty()) {
            for (Farmer farmer : list) {
                if (!Validator.equals(registrationDate,
                            farmer.getRegistrationDate())) {
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

            query.append(_SQL_SELECT_FARMER_WHERE);

            boolean bindRegistrationDate = false;

            if (registrationDate == null) {
                query.append(_FINDER_COLUMN_REGISTRATIONDATE_REGISTRATIONDATE_1);
            } else {
                bindRegistrationDate = true;

                query.append(_FINDER_COLUMN_REGISTRATIONDATE_REGISTRATIONDATE_2);
            }

            if (orderByComparator != null) {
                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator);
            } else
             if (pagination) {
                query.append(FarmerModelImpl.ORDER_BY_JPQL);
            }

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                if (bindRegistrationDate) {
                    qPos.add(CalendarUtil.getTimestamp(registrationDate));
                }

                if (!pagination) {
                    list = (List<Farmer>) QueryUtil.list(q, getDialect(),
                            start, end, false);

                    Collections.sort(list);

                    list = new UnmodifiableList<Farmer>(list);
                } else {
                    list = (List<Farmer>) QueryUtil.list(q, getDialect(),
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
     * Returns the first farmer in the ordered set where registrationDate = &#63;.
     *
     * @param registrationDate the registration date
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching farmer
     * @throws com.test.farmers.NoSuchFarmerException if a matching farmer could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Farmer findByRegistrationDate_First(Date registrationDate,
        OrderByComparator orderByComparator)
        throws NoSuchFarmerException, SystemException {
        Farmer farmer = fetchByRegistrationDate_First(registrationDate,
                orderByComparator);

        if (farmer != null) {
            return farmer;
        }

        StringBundler msg = new StringBundler(4);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("registrationDate=");
        msg.append(registrationDate);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchFarmerException(msg.toString());
    }

    /**
     * Returns the first farmer in the ordered set where registrationDate = &#63;.
     *
     * @param registrationDate the registration date
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching farmer, or <code>null</code> if a matching farmer could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Farmer fetchByRegistrationDate_First(Date registrationDate,
        OrderByComparator orderByComparator) throws SystemException {
        List<Farmer> list = findByRegistrationDate(registrationDate, 0, 1,
                orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the last farmer in the ordered set where registrationDate = &#63;.
     *
     * @param registrationDate the registration date
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching farmer
     * @throws com.test.farmers.NoSuchFarmerException if a matching farmer could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Farmer findByRegistrationDate_Last(Date registrationDate,
        OrderByComparator orderByComparator)
        throws NoSuchFarmerException, SystemException {
        Farmer farmer = fetchByRegistrationDate_Last(registrationDate,
                orderByComparator);

        if (farmer != null) {
            return farmer;
        }

        StringBundler msg = new StringBundler(4);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("registrationDate=");
        msg.append(registrationDate);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchFarmerException(msg.toString());
    }

    /**
     * Returns the last farmer in the ordered set where registrationDate = &#63;.
     *
     * @param registrationDate the registration date
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching farmer, or <code>null</code> if a matching farmer could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Farmer fetchByRegistrationDate_Last(Date registrationDate,
        OrderByComparator orderByComparator) throws SystemException {
        int count = countByRegistrationDate(registrationDate);

        if (count == 0) {
            return null;
        }

        List<Farmer> list = findByRegistrationDate(registrationDate, count - 1,
                count, orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

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
    @Override
    public Farmer[] findByRegistrationDate_PrevAndNext(long farmerId,
        Date registrationDate, OrderByComparator orderByComparator)
        throws NoSuchFarmerException, SystemException {
        Farmer farmer = findByPrimaryKey(farmerId);

        Session session = null;

        try {
            session = openSession();

            Farmer[] array = new FarmerImpl[3];

            array[0] = getByRegistrationDate_PrevAndNext(session, farmer,
                    registrationDate, orderByComparator, true);

            array[1] = farmer;

            array[2] = getByRegistrationDate_PrevAndNext(session, farmer,
                    registrationDate, orderByComparator, false);

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    protected Farmer getByRegistrationDate_PrevAndNext(Session session,
        Farmer farmer, Date registrationDate,
        OrderByComparator orderByComparator, boolean previous) {
        StringBundler query = null;

        if (orderByComparator != null) {
            query = new StringBundler(6 +
                    (orderByComparator.getOrderByFields().length * 6));
        } else {
            query = new StringBundler(3);
        }

        query.append(_SQL_SELECT_FARMER_WHERE);

        boolean bindRegistrationDate = false;

        if (registrationDate == null) {
            query.append(_FINDER_COLUMN_REGISTRATIONDATE_REGISTRATIONDATE_1);
        } else {
            bindRegistrationDate = true;

            query.append(_FINDER_COLUMN_REGISTRATIONDATE_REGISTRATIONDATE_2);
        }

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
            query.append(FarmerModelImpl.ORDER_BY_JPQL);
        }

        String sql = query.toString();

        Query q = session.createQuery(sql);

        q.setFirstResult(0);
        q.setMaxResults(2);

        QueryPos qPos = QueryPos.getInstance(q);

        if (bindRegistrationDate) {
            qPos.add(CalendarUtil.getTimestamp(registrationDate));
        }

        if (orderByComparator != null) {
            Object[] values = orderByComparator.getOrderByConditionValues(farmer);

            for (Object value : values) {
                qPos.add(value);
            }
        }

        List<Farmer> list = q.list();

        if (list.size() == 2) {
            return list.get(1);
        } else {
            return null;
        }
    }

    /**
     * Removes all the farmers where registrationDate = &#63; from the database.
     *
     * @param registrationDate the registration date
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void removeByRegistrationDate(Date registrationDate)
        throws SystemException {
        for (Farmer farmer : findByRegistrationDate(registrationDate,
                QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
            remove(farmer);
        }
    }

    /**
     * Returns the number of farmers where registrationDate = &#63;.
     *
     * @param registrationDate the registration date
     * @return the number of matching farmers
     * @throws SystemException if a system exception occurred
     */
    @Override
    public int countByRegistrationDate(Date registrationDate)
        throws SystemException {
        FinderPath finderPath = FINDER_PATH_COUNT_BY_REGISTRATIONDATE;

        Object[] finderArgs = new Object[] { registrationDate };

        Long count = (Long) FinderCacheUtil.getResult(finderPath, finderArgs,
                this);

        if (count == null) {
            StringBundler query = new StringBundler(2);

            query.append(_SQL_COUNT_FARMER_WHERE);

            boolean bindRegistrationDate = false;

            if (registrationDate == null) {
                query.append(_FINDER_COLUMN_REGISTRATIONDATE_REGISTRATIONDATE_1);
            } else {
                bindRegistrationDate = true;

                query.append(_FINDER_COLUMN_REGISTRATIONDATE_REGISTRATIONDATE_2);
            }

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                if (bindRegistrationDate) {
                    qPos.add(CalendarUtil.getTimestamp(registrationDate));
                }

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
     * Returns all the farmers where isArchive = &#63;.
     *
     * @param isArchive the is archive
     * @return the matching farmers
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<Farmer> findByIsArchive(boolean isArchive)
        throws SystemException {
        return findByIsArchive(isArchive, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
            null);
    }

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
    @Override
    public List<Farmer> findByIsArchive(boolean isArchive, int start, int end)
        throws SystemException {
        return findByIsArchive(isArchive, start, end, null);
    }

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
    @Override
    public List<Farmer> findByIsArchive(boolean isArchive, int start, int end,
        OrderByComparator orderByComparator) throws SystemException {
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

        List<Farmer> list = (List<Farmer>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if ((list != null) && !list.isEmpty()) {
            for (Farmer farmer : list) {
                if ((isArchive != farmer.getIsArchive())) {
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

            query.append(_SQL_SELECT_FARMER_WHERE);

            query.append(_FINDER_COLUMN_ISARCHIVE_ISARCHIVE_2);

            if (orderByComparator != null) {
                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator);
            } else
             if (pagination) {
                query.append(FarmerModelImpl.ORDER_BY_JPQL);
            }

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(isArchive);

                if (!pagination) {
                    list = (List<Farmer>) QueryUtil.list(q, getDialect(),
                            start, end, false);

                    Collections.sort(list);

                    list = new UnmodifiableList<Farmer>(list);
                } else {
                    list = (List<Farmer>) QueryUtil.list(q, getDialect(),
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
     * Returns the first farmer in the ordered set where isArchive = &#63;.
     *
     * @param isArchive the is archive
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching farmer
     * @throws com.test.farmers.NoSuchFarmerException if a matching farmer could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Farmer findByIsArchive_First(boolean isArchive,
        OrderByComparator orderByComparator)
        throws NoSuchFarmerException, SystemException {
        Farmer farmer = fetchByIsArchive_First(isArchive, orderByComparator);

        if (farmer != null) {
            return farmer;
        }

        StringBundler msg = new StringBundler(4);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("isArchive=");
        msg.append(isArchive);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchFarmerException(msg.toString());
    }

    /**
     * Returns the first farmer in the ordered set where isArchive = &#63;.
     *
     * @param isArchive the is archive
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching farmer, or <code>null</code> if a matching farmer could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Farmer fetchByIsArchive_First(boolean isArchive,
        OrderByComparator orderByComparator) throws SystemException {
        List<Farmer> list = findByIsArchive(isArchive, 0, 1, orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the last farmer in the ordered set where isArchive = &#63;.
     *
     * @param isArchive the is archive
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching farmer
     * @throws com.test.farmers.NoSuchFarmerException if a matching farmer could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Farmer findByIsArchive_Last(boolean isArchive,
        OrderByComparator orderByComparator)
        throws NoSuchFarmerException, SystemException {
        Farmer farmer = fetchByIsArchive_Last(isArchive, orderByComparator);

        if (farmer != null) {
            return farmer;
        }

        StringBundler msg = new StringBundler(4);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("isArchive=");
        msg.append(isArchive);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchFarmerException(msg.toString());
    }

    /**
     * Returns the last farmer in the ordered set where isArchive = &#63;.
     *
     * @param isArchive the is archive
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching farmer, or <code>null</code> if a matching farmer could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Farmer fetchByIsArchive_Last(boolean isArchive,
        OrderByComparator orderByComparator) throws SystemException {
        int count = countByIsArchive(isArchive);

        if (count == 0) {
            return null;
        }

        List<Farmer> list = findByIsArchive(isArchive, count - 1, count,
                orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

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
    @Override
    public Farmer[] findByIsArchive_PrevAndNext(long farmerId,
        boolean isArchive, OrderByComparator orderByComparator)
        throws NoSuchFarmerException, SystemException {
        Farmer farmer = findByPrimaryKey(farmerId);

        Session session = null;

        try {
            session = openSession();

            Farmer[] array = new FarmerImpl[3];

            array[0] = getByIsArchive_PrevAndNext(session, farmer, isArchive,
                    orderByComparator, true);

            array[1] = farmer;

            array[2] = getByIsArchive_PrevAndNext(session, farmer, isArchive,
                    orderByComparator, false);

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    protected Farmer getByIsArchive_PrevAndNext(Session session, Farmer farmer,
        boolean isArchive, OrderByComparator orderByComparator, boolean previous) {
        StringBundler query = null;

        if (orderByComparator != null) {
            query = new StringBundler(6 +
                    (orderByComparator.getOrderByFields().length * 6));
        } else {
            query = new StringBundler(3);
        }

        query.append(_SQL_SELECT_FARMER_WHERE);

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
            query.append(FarmerModelImpl.ORDER_BY_JPQL);
        }

        String sql = query.toString();

        Query q = session.createQuery(sql);

        q.setFirstResult(0);
        q.setMaxResults(2);

        QueryPos qPos = QueryPos.getInstance(q);

        qPos.add(isArchive);

        if (orderByComparator != null) {
            Object[] values = orderByComparator.getOrderByConditionValues(farmer);

            for (Object value : values) {
                qPos.add(value);
            }
        }

        List<Farmer> list = q.list();

        if (list.size() == 2) {
            return list.get(1);
        } else {
            return null;
        }
    }

    /**
     * Removes all the farmers where isArchive = &#63; from the database.
     *
     * @param isArchive the is archive
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void removeByIsArchive(boolean isArchive) throws SystemException {
        for (Farmer farmer : findByIsArchive(isArchive, QueryUtil.ALL_POS,
                QueryUtil.ALL_POS, null)) {
            remove(farmer);
        }
    }

    /**
     * Returns the number of farmers where isArchive = &#63;.
     *
     * @param isArchive the is archive
     * @return the number of matching farmers
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

            query.append(_SQL_COUNT_FARMER_WHERE);

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
     * Caches the farmer in the entity cache if it is enabled.
     *
     * @param farmer the farmer
     */
    @Override
    public void cacheResult(Farmer farmer) {
        EntityCacheUtil.putResult(FarmerModelImpl.ENTITY_CACHE_ENABLED,
            FarmerImpl.class, farmer.getPrimaryKey(), farmer);

        farmer.resetOriginalValues();
    }

    /**
     * Caches the farmers in the entity cache if it is enabled.
     *
     * @param farmers the farmers
     */
    @Override
    public void cacheResult(List<Farmer> farmers) {
        for (Farmer farmer : farmers) {
            if (EntityCacheUtil.getResult(
                        FarmerModelImpl.ENTITY_CACHE_ENABLED, FarmerImpl.class,
                        farmer.getPrimaryKey()) == null) {
                cacheResult(farmer);
            } else {
                farmer.resetOriginalValues();
            }
        }
    }

    /**
     * Clears the cache for all farmers.
     *
     * <p>
     * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
     * </p>
     */
    @Override
    public void clearCache() {
        if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
            CacheRegistryUtil.clear(FarmerImpl.class.getName());
        }

        EntityCacheUtil.clearCache(FarmerImpl.class.getName());

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }

    /**
     * Clears the cache for the farmer.
     *
     * <p>
     * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
     * </p>
     */
    @Override
    public void clearCache(Farmer farmer) {
        EntityCacheUtil.removeResult(FarmerModelImpl.ENTITY_CACHE_ENABLED,
            FarmerImpl.class, farmer.getPrimaryKey());

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }

    @Override
    public void clearCache(List<Farmer> farmers) {
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

        for (Farmer farmer : farmers) {
            EntityCacheUtil.removeResult(FarmerModelImpl.ENTITY_CACHE_ENABLED,
                FarmerImpl.class, farmer.getPrimaryKey());
        }
    }

    /**
     * Creates a new farmer with the primary key. Does not add the farmer to the database.
     *
     * @param farmerId the primary key for the new farmer
     * @return the new farmer
     */
    @Override
    public Farmer create(long farmerId) {
        Farmer farmer = new FarmerImpl();

        farmer.setNew(true);
        farmer.setPrimaryKey(farmerId);

        return farmer;
    }

    /**
     * Removes the farmer with the primary key from the database. Also notifies the appropriate model listeners.
     *
     * @param farmerId the primary key of the farmer
     * @return the farmer that was removed
     * @throws com.test.farmers.NoSuchFarmerException if a farmer with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Farmer remove(long farmerId)
        throws NoSuchFarmerException, SystemException {
        return remove((Serializable) farmerId);
    }

    /**
     * Removes the farmer with the primary key from the database. Also notifies the appropriate model listeners.
     *
     * @param primaryKey the primary key of the farmer
     * @return the farmer that was removed
     * @throws com.test.farmers.NoSuchFarmerException if a farmer with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Farmer remove(Serializable primaryKey)
        throws NoSuchFarmerException, SystemException {
        Session session = null;

        try {
            session = openSession();

            Farmer farmer = (Farmer) session.get(FarmerImpl.class, primaryKey);

            if (farmer == null) {
                if (_log.isWarnEnabled()) {
                    _log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
                }

                throw new NoSuchFarmerException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
                    primaryKey);
            }

            return remove(farmer);
        } catch (NoSuchFarmerException nsee) {
            throw nsee;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    @Override
    protected Farmer removeImpl(Farmer farmer) throws SystemException {
        farmer = toUnwrappedModel(farmer);

        farmerToDistrictTableMapper.deleteLeftPrimaryKeyTableMappings(farmer.getPrimaryKey());

        Session session = null;

        try {
            session = openSession();

            if (!session.contains(farmer)) {
                farmer = (Farmer) session.get(FarmerImpl.class,
                        farmer.getPrimaryKeyObj());
            }

            if (farmer != null) {
                session.delete(farmer);
            }
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        if (farmer != null) {
            clearCache(farmer);
        }

        return farmer;
    }

    @Override
    public Farmer updateImpl(com.test.farmers.model.Farmer farmer)
        throws SystemException {
        farmer = toUnwrappedModel(farmer);

        boolean isNew = farmer.isNew();

        FarmerModelImpl farmerModelImpl = (FarmerModelImpl) farmer;

        Session session = null;

        try {
            session = openSession();

            if (farmer.isNew()) {
                session.save(farmer);

                farmer.setNew(false);
            } else {
                session.merge(farmer);
            }
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

        if (isNew || !FarmerModelImpl.COLUMN_BITMASK_ENABLED) {
            FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
        }
        else {
            if ((farmerModelImpl.getColumnBitmask() &
                    FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_NAME.getColumnBitmask()) != 0) {
                Object[] args = new Object[] { farmerModelImpl.getOriginalName() };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_NAME, args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_NAME,
                    args);

                args = new Object[] { farmerModelImpl.getName() };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_NAME, args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_NAME,
                    args);
            }

            if ((farmerModelImpl.getColumnBitmask() &
                    FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_INN.getColumnBitmask()) != 0) {
                Object[] args = new Object[] { farmerModelImpl.getOriginalInn() };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_INN, args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_INN,
                    args);

                args = new Object[] { farmerModelImpl.getInn() };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_INN, args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_INN,
                    args);
            }

            if ((farmerModelImpl.getColumnBitmask() &
                    FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_REGISTRATIONDATE.getColumnBitmask()) != 0) {
                Object[] args = new Object[] {
                        farmerModelImpl.getOriginalRegistrationDate()
                    };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_REGISTRATIONDATE,
                    args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_REGISTRATIONDATE,
                    args);

                args = new Object[] { farmerModelImpl.getRegistrationDate() };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_REGISTRATIONDATE,
                    args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_REGISTRATIONDATE,
                    args);
            }

            if ((farmerModelImpl.getColumnBitmask() &
                    FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ISARCHIVE.getColumnBitmask()) != 0) {
                Object[] args = new Object[] {
                        farmerModelImpl.getOriginalIsArchive()
                    };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_ISARCHIVE,
                    args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ISARCHIVE,
                    args);

                args = new Object[] { farmerModelImpl.getIsArchive() };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_ISARCHIVE,
                    args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ISARCHIVE,
                    args);
            }
        }

        EntityCacheUtil.putResult(FarmerModelImpl.ENTITY_CACHE_ENABLED,
            FarmerImpl.class, farmer.getPrimaryKey(), farmer);

        return farmer;
    }

    protected Farmer toUnwrappedModel(Farmer farmer) {
        if (farmer instanceof FarmerImpl) {
            return farmer;
        }

        FarmerImpl farmerImpl = new FarmerImpl();

        farmerImpl.setNew(farmer.isNew());
        farmerImpl.setPrimaryKey(farmer.getPrimaryKey());

        farmerImpl.setFarmerId(farmer.getFarmerId());
        farmerImpl.setName(farmer.getName());
        farmerImpl.setLegalForm(farmer.getLegalForm());
        farmerImpl.setInn(farmer.getInn());
        farmerImpl.setKpp(farmer.getKpp());
        farmerImpl.setOgrn(farmer.getOgrn());
        farmerImpl.setDistrictId(farmer.getDistrictId());
        farmerImpl.setRegistrationDate(farmer.getRegistrationDate());
        farmerImpl.setIsArchive(farmer.isIsArchive());

        return farmerImpl;
    }

    /**
     * Returns the farmer with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
     *
     * @param primaryKey the primary key of the farmer
     * @return the farmer
     * @throws com.test.farmers.NoSuchFarmerException if a farmer with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Farmer findByPrimaryKey(Serializable primaryKey)
        throws NoSuchFarmerException, SystemException {
        Farmer farmer = fetchByPrimaryKey(primaryKey);

        if (farmer == null) {
            if (_log.isWarnEnabled()) {
                _log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
            }

            throw new NoSuchFarmerException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
                primaryKey);
        }

        return farmer;
    }

    /**
     * Returns the farmer with the primary key or throws a {@link com.test.farmers.NoSuchFarmerException} if it could not be found.
     *
     * @param farmerId the primary key of the farmer
     * @return the farmer
     * @throws com.test.farmers.NoSuchFarmerException if a farmer with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Farmer findByPrimaryKey(long farmerId)
        throws NoSuchFarmerException, SystemException {
        return findByPrimaryKey((Serializable) farmerId);
    }

    /**
     * Returns the farmer with the primary key or returns <code>null</code> if it could not be found.
     *
     * @param primaryKey the primary key of the farmer
     * @return the farmer, or <code>null</code> if a farmer with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Farmer fetchByPrimaryKey(Serializable primaryKey)
        throws SystemException {
        Farmer farmer = (Farmer) EntityCacheUtil.getResult(FarmerModelImpl.ENTITY_CACHE_ENABLED,
                FarmerImpl.class, primaryKey);

        if (farmer == _nullFarmer) {
            return null;
        }

        if (farmer == null) {
            Session session = null;

            try {
                session = openSession();

                farmer = (Farmer) session.get(FarmerImpl.class, primaryKey);

                if (farmer != null) {
                    cacheResult(farmer);
                } else {
                    EntityCacheUtil.putResult(FarmerModelImpl.ENTITY_CACHE_ENABLED,
                        FarmerImpl.class, primaryKey, _nullFarmer);
                }
            } catch (Exception e) {
                EntityCacheUtil.removeResult(FarmerModelImpl.ENTITY_CACHE_ENABLED,
                    FarmerImpl.class, primaryKey);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        return farmer;
    }

    /**
     * Returns the farmer with the primary key or returns <code>null</code> if it could not be found.
     *
     * @param farmerId the primary key of the farmer
     * @return the farmer, or <code>null</code> if a farmer with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Farmer fetchByPrimaryKey(long farmerId) throws SystemException {
        return fetchByPrimaryKey((Serializable) farmerId);
    }

    /**
     * Returns all the farmers.
     *
     * @return the farmers
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<Farmer> findAll() throws SystemException {
        return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
    public List<Farmer> findAll(int start, int end) throws SystemException {
        return findAll(start, end, null);
    }

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
    @Override
    public List<Farmer> findAll(int start, int end,
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

        List<Farmer> list = (List<Farmer>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if (list == null) {
            StringBundler query = null;
            String sql = null;

            if (orderByComparator != null) {
                query = new StringBundler(2 +
                        (orderByComparator.getOrderByFields().length * 3));

                query.append(_SQL_SELECT_FARMER);

                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator);

                sql = query.toString();
            } else {
                sql = _SQL_SELECT_FARMER;

                if (pagination) {
                    sql = sql.concat(FarmerModelImpl.ORDER_BY_JPQL);
                }
            }

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                if (!pagination) {
                    list = (List<Farmer>) QueryUtil.list(q, getDialect(),
                            start, end, false);

                    Collections.sort(list);

                    list = new UnmodifiableList<Farmer>(list);
                } else {
                    list = (List<Farmer>) QueryUtil.list(q, getDialect(),
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
     * Removes all the farmers from the database.
     *
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void removeAll() throws SystemException {
        for (Farmer farmer : findAll()) {
            remove(farmer);
        }
    }

    /**
     * Returns the number of farmers.
     *
     * @return the number of farmers
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

                Query q = session.createQuery(_SQL_COUNT_FARMER);

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
     * Returns all the districts associated with the farmer.
     *
     * @param pk the primary key of the farmer
     * @return the districts associated with the farmer
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<com.test.farmers.model.District> getDistricts(long pk)
        throws SystemException {
        return getDistricts(pk, QueryUtil.ALL_POS, QueryUtil.ALL_POS);
    }

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
    @Override
    public List<com.test.farmers.model.District> getDistricts(long pk,
        int start, int end) throws SystemException {
        return getDistricts(pk, start, end, null);
    }

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
    @Override
    public List<com.test.farmers.model.District> getDistricts(long pk,
        int start, int end, OrderByComparator orderByComparator)
        throws SystemException {
        return farmerToDistrictTableMapper.getRightBaseModels(pk, start, end,
            orderByComparator);
    }

    /**
     * Returns the number of districts associated with the farmer.
     *
     * @param pk the primary key of the farmer
     * @return the number of districts associated with the farmer
     * @throws SystemException if a system exception occurred
     */
    @Override
    public int getDistrictsSize(long pk) throws SystemException {
        long[] pks = farmerToDistrictTableMapper.getRightPrimaryKeys(pk);

        return pks.length;
    }

    /**
     * Returns <code>true</code> if the district is associated with the farmer.
     *
     * @param pk the primary key of the farmer
     * @param districtPK the primary key of the district
     * @return <code>true</code> if the district is associated with the farmer; <code>false</code> otherwise
     * @throws SystemException if a system exception occurred
     */
    @Override
    public boolean containsDistrict(long pk, long districtPK)
        throws SystemException {
        return farmerToDistrictTableMapper.containsTableMapping(pk, districtPK);
    }

    /**
     * Returns <code>true</code> if the farmer has any districts associated with it.
     *
     * @param pk the primary key of the farmer to check for associations with districts
     * @return <code>true</code> if the farmer has any districts associated with it; <code>false</code> otherwise
     * @throws SystemException if a system exception occurred
     */
    @Override
    public boolean containsDistricts(long pk) throws SystemException {
        if (getDistrictsSize(pk) > 0) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Adds an association between the farmer and the district. Also notifies the appropriate model listeners and clears the mapping table finder cache.
     *
     * @param pk the primary key of the farmer
     * @param districtPK the primary key of the district
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void addDistrict(long pk, long districtPK) throws SystemException {
        farmerToDistrictTableMapper.addTableMapping(pk, districtPK);
    }

    /**
     * Adds an association between the farmer and the district. Also notifies the appropriate model listeners and clears the mapping table finder cache.
     *
     * @param pk the primary key of the farmer
     * @param district the district
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void addDistrict(long pk, com.test.farmers.model.District district)
        throws SystemException {
        farmerToDistrictTableMapper.addTableMapping(pk, district.getPrimaryKey());
    }

    /**
     * Adds an association between the farmer and the districts. Also notifies the appropriate model listeners and clears the mapping table finder cache.
     *
     * @param pk the primary key of the farmer
     * @param districtPKs the primary keys of the districts
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void addDistricts(long pk, long[] districtPKs)
        throws SystemException {
        for (long districtPK : districtPKs) {
            farmerToDistrictTableMapper.addTableMapping(pk, districtPK);
        }
    }

    /**
     * Adds an association between the farmer and the districts. Also notifies the appropriate model listeners and clears the mapping table finder cache.
     *
     * @param pk the primary key of the farmer
     * @param districts the districts
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void addDistricts(long pk,
        List<com.test.farmers.model.District> districts)
        throws SystemException {
        for (com.test.farmers.model.District district : districts) {
            farmerToDistrictTableMapper.addTableMapping(pk,
                district.getPrimaryKey());
        }
    }

    /**
     * Clears all associations between the farmer and its districts. Also notifies the appropriate model listeners and clears the mapping table finder cache.
     *
     * @param pk the primary key of the farmer to clear the associated districts from
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void clearDistricts(long pk) throws SystemException {
        farmerToDistrictTableMapper.deleteLeftPrimaryKeyTableMappings(pk);
    }

    /**
     * Removes the association between the farmer and the district. Also notifies the appropriate model listeners and clears the mapping table finder cache.
     *
     * @param pk the primary key of the farmer
     * @param districtPK the primary key of the district
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void removeDistrict(long pk, long districtPK)
        throws SystemException {
        farmerToDistrictTableMapper.deleteTableMapping(pk, districtPK);
    }

    /**
     * Removes the association between the farmer and the district. Also notifies the appropriate model listeners and clears the mapping table finder cache.
     *
     * @param pk the primary key of the farmer
     * @param district the district
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void removeDistrict(long pk, com.test.farmers.model.District district)
        throws SystemException {
        farmerToDistrictTableMapper.deleteTableMapping(pk,
            district.getPrimaryKey());
    }

    /**
     * Removes the association between the farmer and the districts. Also notifies the appropriate model listeners and clears the mapping table finder cache.
     *
     * @param pk the primary key of the farmer
     * @param districtPKs the primary keys of the districts
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void removeDistricts(long pk, long[] districtPKs)
        throws SystemException {
        for (long districtPK : districtPKs) {
            farmerToDistrictTableMapper.deleteTableMapping(pk, districtPK);
        }
    }

    /**
     * Removes the association between the farmer and the districts. Also notifies the appropriate model listeners and clears the mapping table finder cache.
     *
     * @param pk the primary key of the farmer
     * @param districts the districts
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void removeDistricts(long pk,
        List<com.test.farmers.model.District> districts)
        throws SystemException {
        for (com.test.farmers.model.District district : districts) {
            farmerToDistrictTableMapper.deleteTableMapping(pk,
                district.getPrimaryKey());
        }
    }

    /**
     * Sets the districts associated with the farmer, removing and adding associations as necessary. Also notifies the appropriate model listeners and clears the mapping table finder cache.
     *
     * @param pk the primary key of the farmer
     * @param districtPKs the primary keys of the districts to be associated with the farmer
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void setDistricts(long pk, long[] districtPKs)
        throws SystemException {
        Set<Long> newDistrictPKsSet = SetUtil.fromArray(districtPKs);
        Set<Long> oldDistrictPKsSet = SetUtil.fromArray(farmerToDistrictTableMapper.getRightPrimaryKeys(
                    pk));

        Set<Long> removeDistrictPKsSet = new HashSet<Long>(oldDistrictPKsSet);

        removeDistrictPKsSet.removeAll(newDistrictPKsSet);

        for (long removeDistrictPK : removeDistrictPKsSet) {
            farmerToDistrictTableMapper.deleteTableMapping(pk, removeDistrictPK);
        }

        newDistrictPKsSet.removeAll(oldDistrictPKsSet);

        for (long newDistrictPK : newDistrictPKsSet) {
            farmerToDistrictTableMapper.addTableMapping(pk, newDistrictPK);
        }
    }

    /**
     * Sets the districts associated with the farmer, removing and adding associations as necessary. Also notifies the appropriate model listeners and clears the mapping table finder cache.
     *
     * @param pk the primary key of the farmer
     * @param districts the districts to be associated with the farmer
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void setDistricts(long pk,
        List<com.test.farmers.model.District> districts)
        throws SystemException {
        try {
            long[] districtPKs = new long[districts.size()];

            for (int i = 0; i < districts.size(); i++) {
                com.test.farmers.model.District district = districts.get(i);

                districtPKs[i] = district.getPrimaryKey();
            }

            setDistricts(pk, districtPKs);
        } catch (Exception e) {
            throw processException(e);
        } finally {
            FinderCacheUtil.clearCache(FarmerModelImpl.MAPPING_TABLE_LR_FARMERS_DISTRICTS_NAME);
        }
    }

    /**
     * Initializes the farmer persistence.
     */
    public void afterPropertiesSet() {
        String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
                    com.liferay.util.service.ServiceProps.get(
                        "value.object.listener.com.test.farmers.model.Farmer")));

        if (listenerClassNames.length > 0) {
            try {
                List<ModelListener<Farmer>> listenersList = new ArrayList<ModelListener<Farmer>>();

                for (String listenerClassName : listenerClassNames) {
                    listenersList.add((ModelListener<Farmer>) InstanceFactory.newInstance(
                            getClassLoader(), listenerClassName));
                }

                listeners = listenersList.toArray(new ModelListener[listenersList.size()]);
            } catch (Exception e) {
                _log.error(e);
            }
        }

        farmerToDistrictTableMapper = TableMapperFactory.getTableMapper("lr_Farmers_Districts",
                "farmerId", "districtId", this, districtPersistence);
    }

    public void destroy() {
        EntityCacheUtil.removeCache(FarmerImpl.class.getName());
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

        TableMapperFactory.removeTableMapper("lr_Farmers_Districts");
    }
}
