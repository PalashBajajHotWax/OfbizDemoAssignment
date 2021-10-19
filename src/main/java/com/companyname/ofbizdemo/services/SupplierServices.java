package com.companyname.ofbizdemo.services;
import java.util.Map;
import java.util.HashMap;
import java.sql.Timestamp;

import org.apache.ofbiz.base.util.Debug;
import org.apache.ofbiz.base.util.UtilMisc;
import org.apache.ofbiz.base.util.UtilDateTime;
import org.apache.ofbiz.entity.Delegator;
import org.apache.ofbiz.entity.GenericEntityException;
import org.apache.ofbiz.entity.GenericValue;
import org.apache.ofbiz.service.DispatchContext;
import org.apache.ofbiz.service.ServiceUtil;
import org.apache.ofbiz.service.LocalDispatcher;
import org.apache.ofbiz.service.ModelService;
import org.apache.ofbiz.service.GenericServiceException;

public class SupplierServices {

    public static final String module = SupplierServices.class.getName();

    public static Map<String, Object> createSupplier(DispatchContext dctx, Map<String, ? extends Object> context) {
        Map<String, Object> result = ServiceUtil.returnSuccess();
        Map<String, Object> serviceCtx = new HashMap<>();
        Delegator delegator = dctx.getDelegator();
        LocalDispatcher dispatcher = dctx.getDispatcher();
        GenericValue userLogin = (GenericValue) context.get("userLogin");
        Map<String, Object> serviceResult = new HashMap();
        try {
            /* Create Party Group */
            serviceCtx = dctx.makeValidContext("createPartyGroup", ModelService.IN_PARAM, context);
            serviceResult = dispatcher.runSync("createPartyGroup", serviceCtx);
            if (ServiceUtil.isError(serviceResult)) {
                Debug.logError(ServiceUtil.getErrorMessage(serviceResult), module);
                return ServiceUtil.returnError(ServiceUtil.getErrorMessage(serviceResult));
            }
            String partyId = (String) serviceResult.get("partyId");
            serviceCtx.clear();

            /* Create Party Relationship */
            serviceCtx = dctx.makeValidContext("createPartyRelationship", ModelService.IN_PARAM, context);
            serviceCtx.put("partyIdFrom", "Company");
            serviceCtx.put("partyIdTo", partyId);
            serviceCtx.put("roleTypeIdFrom", "_NA_");
            serviceCtx.put("roleTypeIdTo", "SUPPLIER");
            dispatcher.runSync("ensurePartyRole", UtilMisc.toMap("partyId", partyId, "roleTypeId", "SUPPLIER", "userLogin", userLogin));
            serviceCtx.put("partyRelationshipTypeId", "SUPPLIER_REL");
            serviceResult = dispatcher.runSync("createPartyRelationship", serviceCtx);
            if (ServiceUtil.isError(serviceResult)) {
                Debug.logError(ServiceUtil.getErrorMessage(serviceResult), module);
                return ServiceUtil.returnError(ServiceUtil.getErrorMessage(serviceResult));
            }
            serviceCtx.clear();

            /* Create Party Email Address */
            serviceCtx = dctx.makeValidContext("createPartyEmailAddress", ModelService.IN_PARAM, context);
            serviceCtx.put("contactMechPurposeTypeId", "PRIMARY_EMAIL");
            serviceCtx.put("partyId", partyId);
            serviceResult = dispatcher.runSync("createPartyEmailAddress", serviceCtx);
            if (ServiceUtil.isError(serviceResult)) {
                Debug.logError(ServiceUtil.getErrorMessage(serviceResult), module);
                return ServiceUtil.returnError(ServiceUtil.getErrorMessage(serviceResult));
            }
            serviceCtx.clear();

            /* Create Party Contact Number */
            serviceCtx = dctx.makeValidContext("createPartyTelecomNumber", ModelService.IN_PARAM, context);
            serviceCtx.put("partyId", partyId);
            serviceCtx.put("contactMechPurposeTypeId", "PRIMARY_PHONE");
            serviceResult = dispatcher.runSync("createPartyTelecomNumber", serviceCtx);
            if (ServiceUtil.isError(serviceResult)) {
                Debug.logError(ServiceUtil.getErrorMessage(serviceResult), module);
                return ServiceUtil.returnError(ServiceUtil.getErrorMessage(serviceResult));
            }
            serviceCtx.clear();

            /* Create Party Postel Address */
            serviceCtx = dctx.makeValidContext("createPartyPostalAddress", ModelService.IN_PARAM, context);
            serviceCtx.put("partyId", partyId);
            serviceCtx.put("contactMechPurposeTypeId", "PRIMARY_LOCATION");
            serviceResult = dispatcher.runSync("createPartyPostalAddress", serviceCtx);
            if (ServiceUtil.isError(serviceResult)) {
                Debug.logError(ServiceUtil.getErrorMessage(serviceResult), module);
                return ServiceUtil.returnError(ServiceUtil.getErrorMessage(serviceResult));
            }
            serviceCtx.clear();
            result.put("partyId", partyId);
        } catch (GenericServiceException e) {
            Debug.logError(e, e.getMessage(), module);
            return ServiceUtil.returnError("Error in creating Supplier." +module);
        }
        return result;
    }

    public static Map<String, Object> updateSupplier(DispatchContext dctx, Map<String, ? extends Object> context) {
        Map<String, Object> result = ServiceUtil.returnSuccess();
        Map<String, Object> serviceCtx = new HashMap<>();
        Delegator delegator = dctx.getDelegator();
        LocalDispatcher dispatcher = dctx.getDispatcher();
        GenericValue userLogin = (GenericValue) context.get("userLogin");
        Map<String, Object> serviceResult = new HashMap();
        return result;
    }


}