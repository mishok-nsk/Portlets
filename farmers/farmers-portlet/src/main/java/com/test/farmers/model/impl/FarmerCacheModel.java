package com.test.farmers.model.impl;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import com.test.farmers.model.Farmer;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing Farmer in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see Farmer
 * @generated
 */
public class FarmerCacheModel implements CacheModel<Farmer>, Externalizable {
    public long farmerId;
    public String name;
    public String legalForm;
    public long inn;
    public int kpp;
    public long ogrn;
    public long districtId;
    public long registrationDate;
    public boolean isArchive;

    @Override
    public String toString() {
        StringBundler sb = new StringBundler(19);

        sb.append("{farmerId=");
        sb.append(farmerId);
        sb.append(", name=");
        sb.append(name);
        sb.append(", legalForm=");
        sb.append(legalForm);
        sb.append(", inn=");
        sb.append(inn);
        sb.append(", kpp=");
        sb.append(kpp);
        sb.append(", ogrn=");
        sb.append(ogrn);
        sb.append(", districtId=");
        sb.append(districtId);
        sb.append(", registrationDate=");
        sb.append(registrationDate);
        sb.append(", isArchive=");
        sb.append(isArchive);
        sb.append("}");

        return sb.toString();
    }

    @Override
    public Farmer toEntityModel() {
        FarmerImpl farmerImpl = new FarmerImpl();

        farmerImpl.setFarmerId(farmerId);

        if (name == null) {
            farmerImpl.setName(StringPool.BLANK);
        } else {
            farmerImpl.setName(name);
        }

        if (legalForm == null) {
            farmerImpl.setLegalForm(StringPool.BLANK);
        } else {
            farmerImpl.setLegalForm(legalForm);
        }

        farmerImpl.setInn(inn);
        farmerImpl.setKpp(kpp);
        farmerImpl.setOgrn(ogrn);
        farmerImpl.setDistrictId(districtId);

        if (registrationDate == Long.MIN_VALUE) {
            farmerImpl.setRegistrationDate(null);
        } else {
            farmerImpl.setRegistrationDate(new Date(registrationDate));
        }

        farmerImpl.setIsArchive(isArchive);

        farmerImpl.resetOriginalValues();

        return farmerImpl;
    }

    @Override
    public void readExternal(ObjectInput objectInput) throws IOException {
        farmerId = objectInput.readLong();
        name = objectInput.readUTF();
        legalForm = objectInput.readUTF();
        inn = objectInput.readLong();
        kpp = objectInput.readInt();
        ogrn = objectInput.readLong();
        districtId = objectInput.readLong();
        registrationDate = objectInput.readLong();
        isArchive = objectInput.readBoolean();
    }

    @Override
    public void writeExternal(ObjectOutput objectOutput)
        throws IOException {
        objectOutput.writeLong(farmerId);

        if (name == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(name);
        }

        if (legalForm == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(legalForm);
        }

        objectOutput.writeLong(inn);
        objectOutput.writeInt(kpp);
        objectOutput.writeLong(ogrn);
        objectOutput.writeLong(districtId);
        objectOutput.writeLong(registrationDate);
        objectOutput.writeBoolean(isArchive);
    }
}
