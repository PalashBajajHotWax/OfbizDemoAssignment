import org.apache.ofbiz.party.party.PartyHelper;
import org.apache.ofbiz.entity.condition.EntityCondition;
import org.apache.ofbiz.entity.condition.EntityOperator;
import org.apache.ofbiz.entity.util.EntityUtil;
import com.companyname.ofbizdemo.services.SupplierDynamicViews;

partyId = parameters.get("partyId")
supplierInfo = [:]
supplierInfo.partyId = partyId
supplierInfo.supplierName = PartyHelper.getPartyName(delegator, partyId, false)

condList = [
        EntityCondition.makeCondition("partyId", partyId),
        EntityCondition.makeCondition("contactMechPurposeTypeId", EntityOperator.IN, ["PRIMARY_EMAIL", "PRIMARY_PHONE", "PRIMARY_LOCATION"])
]
primaryContactMechs = from("PartyContactDetailByPurpose").where(condList).filterByDate().queryList();
supplierInfo.primaryEmail = EntityUtil.getFirst(EntityUtil.filterByAnd(primaryContactMechs, ["contactMechPurposeTypeId" : "PRIMARY_EMAIL"]));
supplierInfo.primaryPhone = EntityUtil.getFirst(EntityUtil.filterByAnd(primaryContactMechs, ["contactMechPurposeTypeId" : "PRIMARY_PHONE"]));
supplierInfo.primaryAddress = EntityUtil.getFirst(EntityUtil.filterByAnd(primaryContactMechs, ["contactMechPurposeTypeId" : "PRIMARY_LOCATION"]));

supplerDynamicView = SupplierDynamicViews.getSupplierDynamicView();
supplerDynamicViewList = from(supplerDynamicView).where("roleTypeId", "SUPPLIER").queryList();
supplerDynamicViewList.each{ supplierDynamicView ->
    supplerDynamic = from(supplerDynamicView).queryFirst();
    println(supplerDynamic)
    print(supplerDynamic.groupName+",")
    print(supplerDynamic.partyId+",")
    print(supplerDynamic.roleTypeId+",")
    println(supplerDynamic.partyTypeId)


}

context.supplier = supplierInfo;