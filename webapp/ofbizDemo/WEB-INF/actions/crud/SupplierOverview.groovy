import org.apache.ofbiz.party.party.PartyHelper;
import org.apache.ofbiz.entity.condition.EntityCondition;
import org.apache.ofbiz.entity.condition.EntityOperator;
import org.apache.ofbiz.entity.util.EntityUtil

partyId = parameters.get("partyId")
supplierInfo = [:]
supplierInfo.partyId = partyId
supplierInfo.supplierName = PartyHelper.getPartyName(delegator, partyId, false)

def condList = [
        EntityCondition.makeCondition("partyId", partyId),
        EntityCondition.makeCondition("contactMechPurposeTypeId", EntityOperator.IN, ["PRIMARY_EMAIL", "PRIMARY_PHONE", "PRIMARY_LOCATION"])
]
def primaryContactMech = from("PartyContactDetailByPurpose").where(condList).filterByDate().queryList();
supplierInfo.primaryEmail = EntityUtil.getFirst(EntityUtil.filterByAnd(primaryContactMech, ["contactMechPurposeTypeId" : "PRIMARY_EMAIL"]));
supplierInfo.primaryPhone = EntityUtil.getFirst(EntityUtil.filterByAnd(primaryContactMech, ["contactMechPurposeTypeId" : "PRIMARY_PHONE"]));
supplierInfo.primaryAddress = EntityUtil.getFirst(EntityUtil.filterByAnd(primaryContactMech, ["contactMechPurposeTypeId" : "PRIMARY_LOCATION"]));


context.supplier = supplierInfo;