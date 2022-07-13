package com.test.farmers.model;

import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link District}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see District
 * @generated
 */
public class DistrictWrapper implements District, ModelWrapper<District> {
    private District _district;

    public DistrictWrapper(District district) {
        _district = district;
    }

    @Override
    public Class<?> getModelClass() {
        return District.class;
    }

    @Override
    public String getModelClassName() {
        return District.class.getName();
    }

    @Override
    public Map<String, Object> getModelAttributes() {
        Map<String, Object> attributes = new HashMap<String, Object>();

        attributes.put("districtId", getDistrictId());
        attributes.put("name", getName());
        attributes.put("code", getCode());
        attributes.put("isArchive", getIsArchive());

        return attributes;
    }

    @Override
    public void setModelAttributes(Map<String, Object> attributes) {
        Long districtId = (Long) attributes.get("districtId");

        if (districtId != null) {
            setDistrictId(districtId);
        }

        String name = (String) attributes.get("name");

        if (name != null) {
            setName(name);
        }

        Integer code = (Integer) attributes.get("code");

        if (code != null) {
            setCode(code);
        }

        Boolean isArchive = (Boolean) attributes.get("isArchive");

        if (isArchive != null) {
            setIsArchive(isArchive);
        }
    }

    /**
    * Returns the primary key of this district.
    *
    * @return the primary key of this district
    */
    @Override
    public long getPrimaryKey() {
        return _district.getPrimaryKey();
    }

    /**
    * Sets the primary key of this district.
    *
    * @param primaryKey the primary key of this district
    */
    @Override
    public void setPrimaryKey(long primaryKey) {
        _district.setPrimaryKey(primaryKey);
    }

    /**
    * Returns the district ID of this district.
    *
    * @return the district ID of this district
    */
    @Override
    public long getDistrictId() {
        return _district.getDistrictId();
    }

    /**
    * Sets the district ID of this district.
    *
    * @param districtId the district ID of this district
    */
    @Override
    public void setDistrictId(long districtId) {
        _district.setDistrictId(districtId);
    }

    /**
    * Returns the name of this district.
    *
    * @return the name of this district
    */
    @Override
    public java.lang.String getName() {
        return _district.getName();
    }

    /**
    * Sets the name of this district.
    *
    * @param name the name of this district
    */
    @Override
    public void setName(java.lang.String name) {
        _district.setName(name);
    }

    /**
    * Returns the code of this district.
    *
    * @return the code of this district
    */
    @Override
    public int getCode() {
        return _district.getCode();
    }

    /**
    * Sets the code of this district.
    *
    * @param code the code of this district
    */
    @Override
    public void setCode(int code) {
        _district.setCode(code);
    }

    /**
    * Returns the is archive of this district.
    *
    * @return the is archive of this district
    */
    @Override
    public boolean getIsArchive() {
        return _district.getIsArchive();
    }

    /**
    * Returns <code>true</code> if this district is is archive.
    *
    * @return <code>true</code> if this district is is archive; <code>false</code> otherwise
    */
    @Override
    public boolean isIsArchive() {
        return _district.isIsArchive();
    }

    /**
    * Sets whether this district is is archive.
    *
    * @param isArchive the is archive of this district
    */
    @Override
    public void setIsArchive(boolean isArchive) {
        _district.setIsArchive(isArchive);
    }

    @Override
    public boolean isNew() {
        return _district.isNew();
    }

    @Override
    public void setNew(boolean n) {
        _district.setNew(n);
    }

    @Override
    public boolean isCachedModel() {
        return _district.isCachedModel();
    }

    @Override
    public void setCachedModel(boolean cachedModel) {
        _district.setCachedModel(cachedModel);
    }

    @Override
    public boolean isEscapedModel() {
        return _district.isEscapedModel();
    }

    @Override
    public java.io.Serializable getPrimaryKeyObj() {
        return _district.getPrimaryKeyObj();
    }

    @Override
    public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
        _district.setPrimaryKeyObj(primaryKeyObj);
    }

    @Override
    public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
        return _district.getExpandoBridge();
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portal.model.BaseModel<?> baseModel) {
        _district.setExpandoBridgeAttributes(baseModel);
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
        _district.setExpandoBridgeAttributes(expandoBridge);
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portal.service.ServiceContext serviceContext) {
        _district.setExpandoBridgeAttributes(serviceContext);
    }

    @Override
    public java.lang.Object clone() {
        return new DistrictWrapper((District) _district.clone());
    }

    @Override
    public int compareTo(com.test.farmers.model.District district) {
        return _district.compareTo(district);
    }

    @Override
    public int hashCode() {
        return _district.hashCode();
    }

    @Override
    public com.liferay.portal.model.CacheModel<com.test.farmers.model.District> toCacheModel() {
        return _district.toCacheModel();
    }

    @Override
    public com.test.farmers.model.District toEscapedModel() {
        return new DistrictWrapper(_district.toEscapedModel());
    }

    @Override
    public com.test.farmers.model.District toUnescapedModel() {
        return new DistrictWrapper(_district.toUnescapedModel());
    }

    @Override
    public java.lang.String toString() {
        return _district.toString();
    }

    @Override
    public java.lang.String toXmlString() {
        return _district.toXmlString();
    }

    @Override
    public void persist()
        throws com.liferay.portal.kernel.exception.SystemException {
        _district.persist();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (!(obj instanceof DistrictWrapper)) {
            return false;
        }

        DistrictWrapper districtWrapper = (DistrictWrapper) obj;

        if (Validator.equals(_district, districtWrapper._district)) {
            return true;
        }

        return false;
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
     */
    public District getWrappedDistrict() {
        return _district;
    }

    @Override
    public District getWrappedModel() {
        return _district;
    }

    @Override
    public void resetOriginalValues() {
        _district.resetOriginalValues();
    }
}
