package com.test.farmers;

import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;
import com.test.farmers.model.Farmer;
import com.test.farmers.service.DistrictLocalServiceUtil;
import com.test.farmers.service.FarmerLocalServiceUtil;

import javax.portlet.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;


public class FarmersPortletAction extends MVCPortlet {
    public static final Log logger = LogFactoryUtil.getLog(FarmersPortletAction.class);

    public void editFarmer(ActionRequest actionRequest, ActionResponse actionResponse) throws SystemException {
        long farmerId = ParamUtil.getLong(actionRequest, "farmerId");
        String name = ParamUtil.getString(actionRequest, "name");
        long inn = ParamUtil.getLong(actionRequest, "inn");
        String legalForm = ParamUtil.getString(actionRequest, "legalForm");
        int kpp = ParamUtil.getInteger(actionRequest, "kpp");
        long ogrn = ParamUtil.getLong(actionRequest, "ogrn");
        long districtId = ParamUtil.getLong(actionRequest, "districtId");
        DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        Date date = ParamUtil.getDate(actionRequest, "registrationDate", dateFormat);
        String[] districtFields = ParamUtil.getParameterValues(actionRequest, "districtField");

        try {
            Farmer farmer;
            if (farmerId <= 0) {
                farmerId = CounterLocalServiceUtil.increment();
                farmer = FarmerLocalServiceUtil.createFarmer(farmerId);
            } else {
                farmer = FarmerLocalServiceUtil.getFarmer(farmerId);
            }

            long[] districtFieldsId = convertToLong(districtFields);
            DistrictLocalServiceUtil.setFarmerDistricts(farmerId, districtFieldsId);

            farmer.setName(name);
            farmer.setLegalForm(legalForm);
            farmer.setInn(inn);
            farmer.setKpp(kpp);
            farmer.setOgrn(ogrn);
            farmer.setDistrictId(districtId);
            farmer.setRegistrationDate(date);

            FarmerLocalServiceUtil.updateFarmerData(farmer);
            SessionMessages.add(actionRequest.getPortletSession(),"farmer-update-success");
            logger.info("Farmer have been updated successfylly");
        } catch (Exception e) {
            SessionErrors.add(actionRequest.getPortletSession(), "farmer-update-error");
            logger.error("There is an Error in update Farmer");
        } finally {
            actionResponse.setRenderParameter("mvcPath","/jsp/farmers/view_farmers.jsp");
        }
    }

    public void changeArchiveStatus(ActionRequest actionRequest, ActionResponse actionResponse) {
        long farmerId = ParamUtil.getLong(actionRequest, "farmerId");
        try {
            Farmer farmer = FarmerLocalServiceUtil.changeFarmerArchiveStatus(farmerId);

            if (farmer != null) {
                SessionMessages.add(actionRequest.getPortletSession(),"farmer-update-success");
                logger.info("Farmer have been update successfylly");
            } else {
                SessionErrors.add(actionRequest.getPortletSession(),"farmer-update-error");
                logger.error("There is an Error in update Farmer");
            }

        } catch (Exception e) {
            SessionErrors.add(actionRequest.getPortletSession(),"farmer-update-error");
            logger.error("There is an Error in update Farmer");
        } finally {
            actionResponse.setRenderParameter("mvcPath","/jsp/farmers/view_farmers.jsp");
        }

    }

    public void deleteFarmer(ActionRequest actionRequest, ActionResponse actionResponse) {
        long farmerId = ParamUtil.getLong(actionRequest, "farmerId");
        try {
            Farmer farmer = FarmerLocalServiceUtil.deleteFarmer(farmerId);

            if (farmer != null) {
                SessionMessages.add(actionRequest.getPortletSession(),"farmer-delete-success");
                logger.info("Farmer have been delete successfylly");
            } else {
                SessionErrors.add(actionRequest.getPortletSession(),"farmer-delete-error");
                logger.error("There is an Error in delete Farmer");
            }

        } catch (Exception e) {
            SessionErrors.add(actionRequest.getPortletSession(),"farmer-delete-error");
            logger.error("There is an Error in delete Farmer");
        } finally {
            actionResponse.setRenderParameter("mvcPath","/jsp/farmers/view_farmers.jsp");
        }
    }

    protected long[] convertToLong(String[] districtFields) {
        long[] value = new long[districtFields.length];
        for (int i = 0; i < districtFields.length; i++) {
            value[i] = Long.parseLong(districtFields[i]);
        }
        return value;
    }
}

