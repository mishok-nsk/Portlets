package com.test.farmers.model.impl;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import com.test.farmers.model.District;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing District in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see District
 * @generated
 */
public class DistrictCacheModel implements CacheModel<District>, Externalizable {
    public long districtId;
    public String name;
    public int code;
    public boolean isArchive;

    @Override
    public String toString() {
        StringBundler sb = new StringBundler(9);

        sb.append("{districtId=");
        sb.append(districtId);
        sb.append(", name=");
        sb.append(name);
        sb.append(", code=");
        sb.append(code);
        sb.append(", isArchive=");
        sb.append(isArchive);
        sb.append("}");

        return sb.toString();
    }

    @Override
    public District toEntityModel() {
        DistrictImpl districtImpl = new DistrictImpl();

        districtImpl.setDistrictId(districtId);

        if (name == null) {
            districtImpl.setName(StringPool.BLANK);
        } else {
            districtImpl.setName(name);
        }

        districtImpl.setCode(code);
        districtImpl.setIsArchive(isArchive);

        districtImpl.resetOriginalValues();

        return districtImpl;
    }

    @Override
    public void readExternal(ObjectInput objectInput) throws IOException {
        districtId = objectInput.readLong();
        name = objectInput.readUTF();
        code = objectInput.readInt();
        isArchive = objectInput.readBoolean();
    }

    @Override
    public void writeExternal(ObjectOutput objectOutput)
        throws IOException {
        objectOutput.writeLong(districtId);

        if (name == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(name);
        }

        objectOutput.writeInt(code);
        objectOutput.writeBoolean(isArchive);
    }
}
