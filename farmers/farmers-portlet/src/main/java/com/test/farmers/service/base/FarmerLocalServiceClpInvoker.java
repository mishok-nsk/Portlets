package com.test.farmers.service.base;

import com.test.farmers.service.FarmerLocalServiceUtil;

import java.util.Arrays;

/**
 * @author Brian Wing Shun Chan
 * @generated
 */
public class FarmerLocalServiceClpInvoker {
    private String _methodName0;
    private String[] _methodParameterTypes0;
    private String _methodName1;
    private String[] _methodParameterTypes1;
    private String _methodName2;
    private String[] _methodParameterTypes2;
    private String _methodName3;
    private String[] _methodParameterTypes3;
    private String _methodName4;
    private String[] _methodParameterTypes4;
    private String _methodName5;
    private String[] _methodParameterTypes5;
    private String _methodName6;
    private String[] _methodParameterTypes6;
    private String _methodName7;
    private String[] _methodParameterTypes7;
    private String _methodName8;
    private String[] _methodParameterTypes8;
    private String _methodName9;
    private String[] _methodParameterTypes9;
    private String _methodName10;
    private String[] _methodParameterTypes10;
    private String _methodName11;
    private String[] _methodParameterTypes11;
    private String _methodName12;
    private String[] _methodParameterTypes12;
    private String _methodName13;
    private String[] _methodParameterTypes13;
    private String _methodName14;
    private String[] _methodParameterTypes14;
    private String _methodName15;
    private String[] _methodParameterTypes15;
    private String _methodName16;
    private String[] _methodParameterTypes16;
    private String _methodName17;
    private String[] _methodParameterTypes17;
    private String _methodName18;
    private String[] _methodParameterTypes18;
    private String _methodName19;
    private String[] _methodParameterTypes19;
    private String _methodName20;
    private String[] _methodParameterTypes20;
    private String _methodName21;
    private String[] _methodParameterTypes21;
    private String _methodName22;
    private String[] _methodParameterTypes22;
    private String _methodName23;
    private String[] _methodParameterTypes23;
    private String _methodName24;
    private String[] _methodParameterTypes24;
    private String _methodName25;
    private String[] _methodParameterTypes25;
    private String _methodName26;
    private String[] _methodParameterTypes26;
    private String _methodName27;
    private String[] _methodParameterTypes27;
    private String _methodName28;
    private String[] _methodParameterTypes28;
    private String _methodName29;
    private String[] _methodParameterTypes29;
    private String _methodName30;
    private String[] _methodParameterTypes30;
    private String _methodName31;
    private String[] _methodParameterTypes31;
    private String _methodName68;
    private String[] _methodParameterTypes68;
    private String _methodName69;
    private String[] _methodParameterTypes69;
    private String _methodName74;
    private String[] _methodParameterTypes74;
    private String _methodName75;
    private String[] _methodParameterTypes75;
    private String _methodName76;
    private String[] _methodParameterTypes76;
    private String _methodName78;
    private String[] _methodParameterTypes78;

    public FarmerLocalServiceClpInvoker() {
        _methodName0 = "addFarmer";

        _methodParameterTypes0 = new String[] { "com.test.farmers.model.Farmer" };

        _methodName1 = "createFarmer";

        _methodParameterTypes1 = new String[] { "long" };

        _methodName2 = "deleteFarmer";

        _methodParameterTypes2 = new String[] { "long" };

        _methodName3 = "deleteFarmer";

        _methodParameterTypes3 = new String[] { "com.test.farmers.model.Farmer" };

        _methodName4 = "dynamicQuery";

        _methodParameterTypes4 = new String[] {  };

        _methodName5 = "dynamicQuery";

        _methodParameterTypes5 = new String[] {
                "com.liferay.portal.kernel.dao.orm.DynamicQuery"
            };

        _methodName6 = "dynamicQuery";

        _methodParameterTypes6 = new String[] {
                "com.liferay.portal.kernel.dao.orm.DynamicQuery", "int", "int"
            };

        _methodName7 = "dynamicQuery";

        _methodParameterTypes7 = new String[] {
                "com.liferay.portal.kernel.dao.orm.DynamicQuery", "int", "int",
                "com.liferay.portal.kernel.util.OrderByComparator"
            };

        _methodName8 = "dynamicQueryCount";

        _methodParameterTypes8 = new String[] {
                "com.liferay.portal.kernel.dao.orm.DynamicQuery"
            };

        _methodName9 = "dynamicQueryCount";

        _methodParameterTypes9 = new String[] {
                "com.liferay.portal.kernel.dao.orm.DynamicQuery",
                "com.liferay.portal.kernel.dao.orm.Projection"
            };

        _methodName10 = "fetchFarmer";

        _methodParameterTypes10 = new String[] { "long" };

        _methodName11 = "getFarmer";

        _methodParameterTypes11 = new String[] { "long" };

        _methodName12 = "getPersistedModel";

        _methodParameterTypes12 = new String[] { "java.io.Serializable" };

        _methodName13 = "getFarmers";

        _methodParameterTypes13 = new String[] { "int", "int" };

        _methodName14 = "getFarmersCount";

        _methodParameterTypes14 = new String[] {  };

        _methodName15 = "updateFarmer";

        _methodParameterTypes15 = new String[] { "com.test.farmers.model.Farmer" };

        _methodName16 = "addDistrictFarmer";

        _methodParameterTypes16 = new String[] { "long", "long" };

        _methodName17 = "addDistrictFarmer";

        _methodParameterTypes17 = new String[] {
                "long", "com.test.farmers.model.Farmer"
            };

        _methodName18 = "addDistrictFarmers";

        _methodParameterTypes18 = new String[] { "long", "long[][]" };

        _methodName19 = "addDistrictFarmers";

        _methodParameterTypes19 = new String[] { "long", "java.util.List" };

        _methodName20 = "clearDistrictFarmers";

        _methodParameterTypes20 = new String[] { "long" };

        _methodName21 = "deleteDistrictFarmer";

        _methodParameterTypes21 = new String[] { "long", "long" };

        _methodName22 = "deleteDistrictFarmer";

        _methodParameterTypes22 = new String[] {
                "long", "com.test.farmers.model.Farmer"
            };

        _methodName23 = "deleteDistrictFarmers";

        _methodParameterTypes23 = new String[] { "long", "long[][]" };

        _methodName24 = "deleteDistrictFarmers";

        _methodParameterTypes24 = new String[] { "long", "java.util.List" };

        _methodName25 = "getDistrictFarmers";

        _methodParameterTypes25 = new String[] { "long" };

        _methodName26 = "getDistrictFarmers";

        _methodParameterTypes26 = new String[] { "long", "int", "int" };

        _methodName27 = "getDistrictFarmers";

        _methodParameterTypes27 = new String[] {
                "long", "int", "int",
                "com.liferay.portal.kernel.util.OrderByComparator"
            };

        _methodName28 = "getDistrictFarmersCount";

        _methodParameterTypes28 = new String[] { "long" };

        _methodName29 = "hasDistrictFarmer";

        _methodParameterTypes29 = new String[] { "long", "long" };

        _methodName30 = "hasDistrictFarmers";

        _methodParameterTypes30 = new String[] { "long" };

        _methodName31 = "setDistrictFarmers";

        _methodParameterTypes31 = new String[] { "long", "long[][]" };

        _methodName68 = "getBeanIdentifier";

        _methodParameterTypes68 = new String[] {  };

        _methodName69 = "setBeanIdentifier";

        _methodParameterTypes69 = new String[] { "java.lang.String" };

        _methodName74 = "changeFarmerArchiveStatus";

        _methodParameterTypes74 = new String[] { "long" };

        _methodName75 = "getSearchFarmers";

        _methodParameterTypes75 = new String[] {
                "java.lang.String", "long", "java.lang.String", "int",
                "java.lang.String", "java.lang.String", "boolean", "int", "int",
                "com.liferay.portal.kernel.util.OrderByComparator"
            };

        _methodName76 = "getSearchFarmersCount";

        _methodParameterTypes76 = new String[] {
                "java.lang.String", "long", "java.lang.String", "int",
                "java.lang.String", "java.lang.String", "boolean"
            };

        _methodName78 = "updateFarmerData";

        _methodParameterTypes78 = new String[] { "com.test.farmers.model.Farmer" };
    }

    public Object invokeMethod(String name, String[] parameterTypes,
        Object[] arguments) throws Throwable {
        if (_methodName0.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes0, parameterTypes)) {
            return FarmerLocalServiceUtil.addFarmer((com.test.farmers.model.Farmer) arguments[0]);
        }

        if (_methodName1.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes1, parameterTypes)) {
            return FarmerLocalServiceUtil.createFarmer(((Long) arguments[0]).longValue());
        }

        if (_methodName2.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes2, parameterTypes)) {
            return FarmerLocalServiceUtil.deleteFarmer(((Long) arguments[0]).longValue());
        }

        if (_methodName3.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes3, parameterTypes)) {
            return FarmerLocalServiceUtil.deleteFarmer((com.test.farmers.model.Farmer) arguments[0]);
        }

        if (_methodName4.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes4, parameterTypes)) {
            return FarmerLocalServiceUtil.dynamicQuery();
        }

        if (_methodName5.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes5, parameterTypes)) {
            return FarmerLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery) arguments[0]);
        }

        if (_methodName6.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes6, parameterTypes)) {
            return FarmerLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery) arguments[0],
                ((Integer) arguments[1]).intValue(),
                ((Integer) arguments[2]).intValue());
        }

        if (_methodName7.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes7, parameterTypes)) {
            return FarmerLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery) arguments[0],
                ((Integer) arguments[1]).intValue(),
                ((Integer) arguments[2]).intValue(),
                (com.liferay.portal.kernel.util.OrderByComparator) arguments[3]);
        }

        if (_methodName8.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes8, parameterTypes)) {
            return FarmerLocalServiceUtil.dynamicQueryCount((com.liferay.portal.kernel.dao.orm.DynamicQuery) arguments[0]);
        }

        if (_methodName9.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes9, parameterTypes)) {
            return FarmerLocalServiceUtil.dynamicQueryCount((com.liferay.portal.kernel.dao.orm.DynamicQuery) arguments[0],
                (com.liferay.portal.kernel.dao.orm.Projection) arguments[1]);
        }

        if (_methodName10.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes10, parameterTypes)) {
            return FarmerLocalServiceUtil.fetchFarmer(((Long) arguments[0]).longValue());
        }

        if (_methodName11.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes11, parameterTypes)) {
            return FarmerLocalServiceUtil.getFarmer(((Long) arguments[0]).longValue());
        }

        if (_methodName12.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes12, parameterTypes)) {
            return FarmerLocalServiceUtil.getPersistedModel((java.io.Serializable) arguments[0]);
        }

        if (_methodName13.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes13, parameterTypes)) {
            return FarmerLocalServiceUtil.getFarmers(((Integer) arguments[0]).intValue(),
                ((Integer) arguments[1]).intValue());
        }

        if (_methodName14.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes14, parameterTypes)) {
            return FarmerLocalServiceUtil.getFarmersCount();
        }

        if (_methodName15.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes15, parameterTypes)) {
            return FarmerLocalServiceUtil.updateFarmer((com.test.farmers.model.Farmer) arguments[0]);
        }

        if (_methodName16.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes16, parameterTypes)) {
            FarmerLocalServiceUtil.addDistrictFarmer(((Long) arguments[0]).longValue(),
                ((Long) arguments[1]).longValue());

            return null;
        }

        if (_methodName17.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes17, parameterTypes)) {
            FarmerLocalServiceUtil.addDistrictFarmer(((Long) arguments[0]).longValue(),
                (com.test.farmers.model.Farmer) arguments[1]);

            return null;
        }

        if (_methodName18.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes18, parameterTypes)) {
            FarmerLocalServiceUtil.addDistrictFarmers(((Long) arguments[0]).longValue(),
                (long[]) arguments[1]);

            return null;
        }

        if (_methodName19.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes19, parameterTypes)) {
            FarmerLocalServiceUtil.addDistrictFarmers(((Long) arguments[0]).longValue(),
                (java.util.List<com.test.farmers.model.Farmer>) arguments[1]);

            return null;
        }

        if (_methodName20.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes20, parameterTypes)) {
            FarmerLocalServiceUtil.clearDistrictFarmers(((Long) arguments[0]).longValue());

            return null;
        }

        if (_methodName21.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes21, parameterTypes)) {
            FarmerLocalServiceUtil.deleteDistrictFarmer(((Long) arguments[0]).longValue(),
                ((Long) arguments[1]).longValue());

            return null;
        }

        if (_methodName22.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes22, parameterTypes)) {
            FarmerLocalServiceUtil.deleteDistrictFarmer(((Long) arguments[0]).longValue(),
                (com.test.farmers.model.Farmer) arguments[1]);

            return null;
        }

        if (_methodName23.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes23, parameterTypes)) {
            FarmerLocalServiceUtil.deleteDistrictFarmers(((Long) arguments[0]).longValue(),
                (long[]) arguments[1]);

            return null;
        }

        if (_methodName24.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes24, parameterTypes)) {
            FarmerLocalServiceUtil.deleteDistrictFarmers(((Long) arguments[0]).longValue(),
                (java.util.List<com.test.farmers.model.Farmer>) arguments[1]);

            return null;
        }

        if (_methodName25.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes25, parameterTypes)) {
            return FarmerLocalServiceUtil.getDistrictFarmers(((Long) arguments[0]).longValue());
        }

        if (_methodName26.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes26, parameterTypes)) {
            return FarmerLocalServiceUtil.getDistrictFarmers(((Long) arguments[0]).longValue(),
                ((Integer) arguments[1]).intValue(),
                ((Integer) arguments[2]).intValue());
        }

        if (_methodName27.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes27, parameterTypes)) {
            return FarmerLocalServiceUtil.getDistrictFarmers(((Long) arguments[0]).longValue(),
                ((Integer) arguments[1]).intValue(),
                ((Integer) arguments[2]).intValue(),
                (com.liferay.portal.kernel.util.OrderByComparator) arguments[3]);
        }

        if (_methodName28.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes28, parameterTypes)) {
            return FarmerLocalServiceUtil.getDistrictFarmersCount(((Long) arguments[0]).longValue());
        }

        if (_methodName29.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes29, parameterTypes)) {
            return FarmerLocalServiceUtil.hasDistrictFarmer(((Long) arguments[0]).longValue(),
                ((Long) arguments[1]).longValue());
        }

        if (_methodName30.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes30, parameterTypes)) {
            return FarmerLocalServiceUtil.hasDistrictFarmers(((Long) arguments[0]).longValue());
        }

        if (_methodName31.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes31, parameterTypes)) {
            FarmerLocalServiceUtil.setDistrictFarmers(((Long) arguments[0]).longValue(),
                (long[]) arguments[1]);

            return null;
        }

        if (_methodName68.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes68, parameterTypes)) {
            return FarmerLocalServiceUtil.getBeanIdentifier();
        }

        if (_methodName69.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes69, parameterTypes)) {
            FarmerLocalServiceUtil.setBeanIdentifier((java.lang.String) arguments[0]);

            return null;
        }

        if (_methodName74.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes74, parameterTypes)) {
            return FarmerLocalServiceUtil.changeFarmerArchiveStatus(((Long) arguments[0]).longValue());
        }

        if (_methodName75.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes75, parameterTypes)) {
            return FarmerLocalServiceUtil.getSearchFarmers((java.lang.String) arguments[0],
                ((Long) arguments[1]).longValue(),
                (java.lang.String) arguments[2],
                ((Integer) arguments[3]).intValue(),
                (java.lang.String) arguments[4],
                (java.lang.String) arguments[5],
                ((Boolean) arguments[6]).booleanValue(),
                ((Integer) arguments[7]).intValue(),
                ((Integer) arguments[8]).intValue(),
                (com.liferay.portal.kernel.util.OrderByComparator) arguments[9]);
        }

        if (_methodName76.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes76, parameterTypes)) {
            return FarmerLocalServiceUtil.getSearchFarmersCount((java.lang.String) arguments[0],
                ((Long) arguments[1]).longValue(),
                (java.lang.String) arguments[2],
                ((Integer) arguments[3]).intValue(),
                (java.lang.String) arguments[4],
                (java.lang.String) arguments[5],
                ((Boolean) arguments[6]).booleanValue());
        }

        if (_methodName78.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes78, parameterTypes)) {
            return FarmerLocalServiceUtil.updateFarmerData((com.test.farmers.model.Farmer) arguments[0]);
        }

        throw new UnsupportedOperationException();
    }
}
