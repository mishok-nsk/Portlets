package com.test.farmers.model;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;

import com.test.farmers.service.ClpSerializer;
import com.test.farmers.service.FarmerLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;


public class FarmerClp extends BaseModelImpl<Farmer> implements Farmer {
    private long _farmerId;
    private String _name;
    private String _legalForm;
    private long _inn;
    private int _kpp;
    private long _ogrn;
    private long _districtId;
    private Date _registrationDate;
    private boolean _isArchive;
    private BaseModel<?> _farmerRemoteModel;
    private Class<?> _clpSerializerClass = com.test.farmers.service.ClpSerializer.class;

    public FarmerClp() {
    }

    @Override
    public Class<?> getModelClass() {
        return Farmer.class;
    }

    @Override
    public String getModelClassName() {
        return Farmer.class.getName();
    }

    @Override
    public long getPrimaryKey() {
        return _farmerId;
    }

    @Override
    public void setPrimaryKey(long primaryKey) {
        setFarmerId(primaryKey);
    }

    @Override
    public Serializable getPrimaryKeyObj() {
        return _farmerId;
    }

    @Override
    public void setPrimaryKeyObj(Serializable primaryKeyObj) {
        setPrimaryKey(((Long) primaryKeyObj).longValue());
    }

    @Override
    public Map<String, Object> getModelAttributes() {
        Map<String, Object> attributes = new HashMap<String, Object>();

        attributes.put("farmerId", getFarmerId());
        attributes.put("name", getName());
        attributes.put("legalForm", getLegalForm());
        attributes.put("inn", getInn());
        attributes.put("kpp", getKpp());
        attributes.put("ogrn", getOgrn());
        attributes.put("districtId", getDistrictId());
        attributes.put("registrationDate", getRegistrationDate());
        attributes.put("isArchive", getIsArchive());

        return attributes;
    }

    @Override
    public void setModelAttributes(Map<String, Object> attributes) {
        Long farmerId = (Long) attributes.get("farmerId");

        if (farmerId != null) {
            setFarmerId(farmerId);
        }

        String name = (String) attributes.get("name");

        if (name != null) {
            setName(name);
        }

        String legalForm = (String) attributes.get("legalForm");

        if (legalForm != null) {
            setLegalForm(legalForm);
        }

        Long inn = (Long) attributes.get("inn");

        if (inn != null) {
            setInn(inn);
        }

        Integer kpp = (Integer) attributes.get("kpp");

        if (kpp != null) {
            setKpp(kpp);
        }

        Long ogrn = (Long) attributes.get("ogrn");

        if (ogrn != null) {
            setOgrn(ogrn);
        }

        Long districtId = (Long) attributes.get("districtId");

        if (districtId != null) {
            setDistrictId(districtId);
        }

        Date registrationDate = (Date) attributes.get("registrationDate");

        if (registrationDate != null) {
            setRegistrationDate(registrationDate);
        }

        Boolean isArchive = (Boolean) attributes.get("isArchive");

        if (isArchive != null) {
            setIsArchive(isArchive);
        }
    }

    @Override
    public long getFarmerId() {
        return _farmerId;
    }

    @Override
    public void setFarmerId(long farmerId) {
        _farmerId = farmerId;

        if (_farmerRemoteModel != null) {
            try {
                Class<?> clazz = _farmerRemoteModel.getClass();

                Method method = clazz.getMethod("setFarmerId", long.class);

                method.invoke(_farmerRemoteModel, farmerId);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getName() {
        return _name;
    }

    @Override
    public void setName(String name) {
        _name = name;

        if (_farmerRemoteModel != null) {
            try {
                Class<?> clazz = _farmerRemoteModel.getClass();

                Method method = clazz.getMethod("setName", String.class);

                method.invoke(_farmerRemoteModel, name);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getLegalForm() {
        return _legalForm;
    }

    @Override
    public void setLegalForm(String legalForm) {
        _legalForm = legalForm;

        if (_farmerRemoteModel != null) {
            try {
                Class<?> clazz = _farmerRemoteModel.getClass();

                Method method = clazz.getMethod("setLegalForm", String.class);

                method.invoke(_farmerRemoteModel, legalForm);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public long getInn() {
        return _inn;
    }

    @Override
    public void setInn(long inn) {
        _inn = inn;

        if (_farmerRemoteModel != null) {
            try {
                Class<?> clazz = _farmerRemoteModel.getClass();

                Method method = clazz.getMethod("setInn", long.class);

                method.invoke(_farmerRemoteModel, inn);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public int getKpp() {
        return _kpp;
    }

    @Override
    public void setKpp(int kpp) {
        _kpp = kpp;

        if (_farmerRemoteModel != null) {
            try {
                Class<?> clazz = _farmerRemoteModel.getClass();

                Method method = clazz.getMethod("setKpp", int.class);

                method.invoke(_farmerRemoteModel, kpp);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public long getOgrn() {
        return _ogrn;
    }

    @Override
    public void setOgrn(long ogrn) {
        _ogrn = ogrn;

        if (_farmerRemoteModel != null) {
            try {
                Class<?> clazz = _farmerRemoteModel.getClass();

                Method method = clazz.getMethod("setOgrn", long.class);

                method.invoke(_farmerRemoteModel, ogrn);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public long getDistrictId() {
        return _districtId;
    }

    @Override
    public void setDistrictId(long districtId) {
        _districtId = districtId;

        if (_farmerRemoteModel != null) {
            try {
                Class<?> clazz = _farmerRemoteModel.getClass();

                Method method = clazz.getMethod("setDistrictId", long.class);

                method.invoke(_farmerRemoteModel, districtId);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public Date getRegistrationDate() {
        return _registrationDate;
    }

    @Override
    public void setRegistrationDate(Date registrationDate) {
        _registrationDate = registrationDate;

        if (_farmerRemoteModel != null) {
            try {
                Class<?> clazz = _farmerRemoteModel.getClass();

                Method method = clazz.getMethod("setRegistrationDate",
                        Date.class);

                method.invoke(_farmerRemoteModel, registrationDate);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public boolean getIsArchive() {
        return _isArchive;
    }

    @Override
    public boolean isIsArchive() {
        return _isArchive;
    }

    @Override
    public void setIsArchive(boolean isArchive) {
        _isArchive = isArchive;

        if (_farmerRemoteModel != null) {
            try {
                Class<?> clazz = _farmerRemoteModel.getClass();

                Method method = clazz.getMethod("setIsArchive", boolean.class);

                method.invoke(_farmerRemoteModel, isArchive);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    public BaseModel<?> getFarmerRemoteModel() {
        return _farmerRemoteModel;
    }

    public void setFarmerRemoteModel(BaseModel<?> farmerRemoteModel) {
        _farmerRemoteModel = farmerRemoteModel;
    }

    public Object invokeOnRemoteModel(String methodName,
        Class<?>[] parameterTypes, Object[] parameterValues)
        throws Exception {
        Object[] remoteParameterValues = new Object[parameterValues.length];

        for (int i = 0; i < parameterValues.length; i++) {
            if (parameterValues[i] != null) {
                remoteParameterValues[i] = ClpSerializer.translateInput(parameterValues[i]);
            }
        }

        Class<?> remoteModelClass = _farmerRemoteModel.getClass();

        ClassLoader remoteModelClassLoader = remoteModelClass.getClassLoader();

        Class<?>[] remoteParameterTypes = new Class[parameterTypes.length];

        for (int i = 0; i < parameterTypes.length; i++) {
            if (parameterTypes[i].isPrimitive()) {
                remoteParameterTypes[i] = parameterTypes[i];
            } else {
                String parameterTypeName = parameterTypes[i].getName();

                remoteParameterTypes[i] = remoteModelClassLoader.loadClass(parameterTypeName);
            }
        }

        Method method = remoteModelClass.getMethod(methodName,
                remoteParameterTypes);

        Object returnValue = method.invoke(_farmerRemoteModel,
                remoteParameterValues);

        if (returnValue != null) {
            returnValue = ClpSerializer.translateOutput(returnValue);
        }

        return returnValue;
    }

    @Override
    public void persist() throws SystemException {
        if (this.isNew()) {
            FarmerLocalServiceUtil.addFarmer(this);
        } else {
            FarmerLocalServiceUtil.updateFarmer(this);
        }
    }

    @Override
    public Farmer toEscapedModel() {
        return (Farmer) ProxyUtil.newProxyInstance(Farmer.class.getClassLoader(),
            new Class[] { Farmer.class }, new AutoEscapeBeanHandler(this));
    }

    @Override
    public Object clone() {
        FarmerClp clone = new FarmerClp();

        clone.setFarmerId(getFarmerId());
        clone.setName(getName());
        clone.setLegalForm(getLegalForm());
        clone.setInn(getInn());
        clone.setKpp(getKpp());
        clone.setOgrn(getOgrn());
        clone.setDistrictId(getDistrictId());
        clone.setRegistrationDate(getRegistrationDate());
        clone.setIsArchive(getIsArchive());

        return clone;
    }

    @Override
    public int compareTo(Farmer farmer) {
        int value = 0;

        value = getName().compareTo(farmer.getName());

        if (value != 0) {
            return value;
        }

        return 0;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (!(obj instanceof FarmerClp)) {
            return false;
        }

        FarmerClp farmer = (FarmerClp) obj;

        long primaryKey = farmer.getPrimaryKey();

        if (getPrimaryKey() == primaryKey) {
            return true;
        } else {
            return false;
        }
    }

    public Class<?> getClpSerializerClass() {
        return _clpSerializerClass;
    }

    @Override
    public int hashCode() {
        return (int) getPrimaryKey();
    }

    @Override
    public String toString() {
        StringBundler sb = new StringBundler(19);

        sb.append("{farmerId=");
        sb.append(getFarmerId());
        sb.append(", name=");
        sb.append(getName());
        sb.append(", legalForm=");
        sb.append(getLegalForm());
        sb.append(", inn=");
        sb.append(getInn());
        sb.append(", kpp=");
        sb.append(getKpp());
        sb.append(", ogrn=");
        sb.append(getOgrn());
        sb.append(", districtId=");
        sb.append(getDistrictId());
        sb.append(", registrationDate=");
        sb.append(getRegistrationDate());
        sb.append(", isArchive=");
        sb.append(getIsArchive());
        sb.append("}");

        return sb.toString();
    }

    @Override
    public String toXmlString() {
        StringBundler sb = new StringBundler(31);

        sb.append("<model><model-name>");
        sb.append("com.test.farmers.model.Farmer");
        sb.append("</model-name>");

        sb.append(
            "<column><column-name>farmerId</column-name><column-value><![CDATA[");
        sb.append(getFarmerId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>name</column-name><column-value><![CDATA[");
        sb.append(getName());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>legalForm</column-name><column-value><![CDATA[");
        sb.append(getLegalForm());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>inn</column-name><column-value><![CDATA[");
        sb.append(getInn());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>kpp</column-name><column-value><![CDATA[");
        sb.append(getKpp());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>ogrn</column-name><column-value><![CDATA[");
        sb.append(getOgrn());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>districtId</column-name><column-value><![CDATA[");
        sb.append(getDistrictId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>registrationDate</column-name><column-value><![CDATA[");
        sb.append(getRegistrationDate());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>isArchive</column-name><column-value><![CDATA[");
        sb.append(getIsArchive());
        sb.append("]]></column-value></column>");

        sb.append("</model>");

        return sb.toString();
    }
}
