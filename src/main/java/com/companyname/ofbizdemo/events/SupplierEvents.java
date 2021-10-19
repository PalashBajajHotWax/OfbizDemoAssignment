package com.companyname.ofbizdemo.events;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

import org.apache.ofbiz.base.util.Debug;
import org.apache.ofbiz.base.util.UtilMisc;
import org.apache.ofbiz.base.util.UtilValidate;
import org.apache.ofbiz.entity.Delegator;
import org.apache.ofbiz.entity.GenericValue;
import org.apache.ofbiz.service.GenericServiceException;
import org.apache.ofbiz.service.LocalDispatcher;
import org.apache.ofbiz.service.ServiceUtil;

public class SupplierEvents{
    public static final String module = SupplierEvents.class.getName();

    public static String createSupplierEvent(HttpServletRequest request, HttpServletResponse response) {
        Delegator delegator = (Delegator) request.getAttribute("delegator");
        LocalDispatcher dispatcher = (LocalDispatcher) request.getAttribute("dispatcher");
        GenericValue userLogin = (GenericValue) request.getSession().getAttribute("userLogin");

        String groupName = request.getParameter("groupName");
        String contactNumber = request.getParameter("contactNumber");
        String emailAddress = request.getParameter("emailAddress");
        String address1 = request.getParameter("address1");
        String address2 = request.getParameter("address2");
        String countryGeoId = request.getParameter("countryGeoId");
        String stateProvinceGeoId = request.getParameter("stateProvinceGeoId");
        String city = request.getParameter("city");
        String postalCode = request.getParameter("postalCode");

        List<String> errorMessageList = new ArrayList<>();

        if (UtilValidate.isEmpty(groupName)) {
            String errMsg = "Supplier Name are required fields on the form and can't be empty.";
            errorMessageList.add(errMsg);
        }
        if (UtilValidate.isEmpty(contactNumber)) {
            String errMsg = "Contact Number are required fields on the form and can't be empty.";
            errorMessageList.add(errMsg);
        }
        if (UtilValidate.isEmpty(emailAddress)) {
            String errMsg = "Email Address are required fields on the form and can't be empty.";
            errorMessageList.add(errMsg);
        }
        if (UtilValidate.isNotEmpty(address1)) {
            if (UtilValidate.isEmpty(city)) {
                String errMsg = "If Postal Address can't be empty City Will be required.";
                errorMessageList.add(errMsg);
            }
            if (UtilValidate.isEmpty(postalCode)) {
                String errMsg = "If Postal Address can't be empty Postal Code Will be required.";
                errorMessageList.add(errMsg);
            }
        }
        if (UtilValidate.isNotEmpty(errorMessageList)) {
            request.setAttribute("errorMessageList", errorMessageList);
            Debug.log("+++++++++++++++++++++++++" + errorMessageList);
            return "error";
        }

        Map<String, Object> result = new HashMap<>();
        Map<String, Object> serviceContext = new HashMap<>();
        serviceContext.put("userLogin", userLogin);
        serviceContext.put("groupName", groupName);
        serviceContext.put("contactNumber", contactNumber);
        serviceContext.put("emailAddress", emailAddress);
        serviceContext.put("address1", address1);
        serviceContext.put("address2", address2);
        serviceContext.put("countryGeoId", countryGeoId);
        serviceContext.put("stateProvinceGeoId", stateProvinceGeoId);
        serviceContext.put("city", city);
        serviceContext.put("postalCode", postalCode);

        try {
            result = dispatcher.runSync("createSupplier", serviceContext);
        } catch (GenericServiceException e) {
            String errMsg = "Unable to create new records in Supplier entity: " + e.toString();
            request.setAttribute("_ERROR_MESSAGE_", errMsg);
            return "error";
        }
        request.setAttribute("_EVENT_MESSAGE_", "Supplier created succesfully.");
        return "success";
    }
}