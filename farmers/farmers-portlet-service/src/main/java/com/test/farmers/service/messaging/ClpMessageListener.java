package com.test.farmers.service.messaging;

import com.liferay.portal.kernel.messaging.BaseMessageListener;
import com.liferay.portal.kernel.messaging.Message;

import com.test.farmers.service.ClpSerializer;
import com.test.farmers.service.DistrictLocalServiceUtil;
import com.test.farmers.service.DistrictServiceUtil;
import com.test.farmers.service.FarmerLocalServiceUtil;
import com.test.farmers.service.FarmerServiceUtil;


public class ClpMessageListener extends BaseMessageListener {
    public static String getServletContextName() {
        return ClpSerializer.getServletContextName();
    }

    @Override
    protected void doReceive(Message message) throws Exception {
        String command = message.getString("command");
        String servletContextName = message.getString("servletContextName");

        if (command.equals("undeploy") &&
                servletContextName.equals(getServletContextName())) {
            DistrictLocalServiceUtil.clearService();

            DistrictServiceUtil.clearService();
            FarmerLocalServiceUtil.clearService();

            FarmerServiceUtil.clearService();
        }
    }
}
