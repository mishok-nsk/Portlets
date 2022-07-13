package com.test.farmers;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;
import com.test.farmers.model.District;
import com.test.farmers.service.DistrictLocalServiceUtil;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import java.io.IOException;

public class DistrictPortletAction extends MVCPortlet {
    public static Log logger = LogFactoryUtil.getLog(DistrictPortletAction.class);

    public void editDistrict(ActionRequest actionRequest, ActionResponse actionResponse) {
        long districtId = ParamUtil.getLong(actionRequest, "districtId");
        String name = ParamUtil.getString(actionRequest, "name");
        int code = ParamUtil.getInteger(actionRequest, "code");

        if (districtId > 0) {
            try {
                DistrictLocalServiceUtil.updateDistrict(districtId, name, code);
                SessionMessages.add(actionRequest.getPortletSession(),"district-update-success");
                logger.info("District have been updated successfylly");
            } catch (Exception e) {
                SessionErrors.add(actionRequest.getPortletSession(), "district-update-error");
                logger.error("There is an Error in update District");
            } finally {
                actionResponse.setRenderParameter("mvcPath","/jsp/districts/view_districts.jsp");
            }

        } else {
            try {
                DistrictLocalServiceUtil.addDistrict(name, code);
                SessionMessages.add(actionRequest.getPortletSession(), "district-add-success");
                logger.info("District have been added successfylly");
            } catch (Exception e) {
                SessionErrors.add(actionRequest.getPortletSession(), "district-add-error");
                logger.error("There is an Error in adding District");
            } finally {
                actionResponse.setRenderParameter("mvcPath","/jsp/districts/view_districts.jsp");
            }
        }
    }

    public void deleteDistrict(ActionRequest actionRequest, ActionResponse actionResponse) {
        try {
            long districtId = ParamUtil.getLong(actionRequest, "districtId");
            District district = DistrictLocalServiceUtil.deleteDistrict(districtId);
            if (district != null) {
                SessionMessages.add(actionRequest.getPortletSession(),"district-delete-success");
                logger.info("District have been deleted successfylly");
            } else {
                SessionErrors.add(actionRequest.getPortletSession(),"district-delete-error");
                logger.error("There is an Erron in delete District");
            }
            // actionResponse.setRenderParameter("mvcPath", "delete_district.jsp");
        } catch (Exception e) {
            SessionErrors.add(actionRequest.getPortletSession(),"district-delete-error");
        } finally {
            actionResponse.setRenderParameter("mvcPath","/jsp/districts/view_districts.jsp");
        }
    }

    public void archiveDistrict(ActionRequest actionRequest, ActionResponse actionResponse) {
        long districtId = ParamUtil.getLong(actionRequest, "districtId");
        try {
            DistrictLocalServiceUtil.archiveDistrict(districtId);
            SessionMessages.add(actionRequest.getPortletSession(), "district-archive-success");
            logger.info("District have been archived successfylly");
        } catch (Exception e) {
            SessionErrors.add(actionRequest.getPortletSession(), "district-archive-error");
            logger.error("There is an Error in archive District");
        } finally {
            actionResponse.setRenderParameter("mvcPath","/jsp/districts/view_districts.jsp");
        }
    }

}
