package com.test.farmers;

import com.liferay.portal.kernel.exception.PortalException;

public class DistrictNameException extends PortalException {
    public DistrictNameException() {
        super("District name is empty");
    }
}
