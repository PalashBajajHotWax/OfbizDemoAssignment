import org.apache.ofbiz.party.party.PartyHelper;
import org.apache.ofbiz.base.util.UtilValidate;
import org.apache.ofbiz.entity.util.EntityQuery;
import org.apache.ofbiz.entity.GenericValue;
import org.apache.ofbiz.entity.condition.EntityOperator
import org.apache.ofbiz.entity.condition.EntityCondition

keyword = parameters.keyword
conditionList = [];
conditions = [];
if (keyword){
        conditionList.add(EntityCondition.makeCondition("partyId", EntityOperator.LIKE, "%"+keyword+"%"));
        conditionList.add(EntityCondition.makeCondition("groupName", EntityOperator.LIKE, "%"+keyword+"%"));
}
EntityCondition condition = EntityCondition.makeCondition(conditionList, EntityOperator.OR);
conditions.add(condition);
conditions.add(EntityCondition.makeCondition("roleTypeIdTo", "SUPPLIER"));

supplierRelationships = from("PartyRelationshipAndDetail").where(conditions).filterByDate().queryList()
suppliers = []
supplierRelationships.each { supplierRelationship  ->
        supplierInfo = [:]
        supplierInfo.partyId = supplierRelationship.partyIdTo
        supplierInfo.supplierName = PartyHelper.getPartyName(delegator, supplierRelationship.partyIdTo, false)

        //Supplier's Primary Email
        primaryEmailPartyContactMechPurpose = from("PartyContactMechPurpose").where("partyId", supplierRelationship.partyIdTo, "contactMechPurposeTypeId", "PRIMARY_EMAIL").filterByDate().queryFirst();
        primaryEmailContactMech = from("ContactMech").where("contactMechId", primaryEmailPartyContactMechPurpose?.contactMechId).queryOne();
        supplierInfo.primaryEmailAddress = primaryEmailContactMech?.infoString;

        //Supplier's Primary Phone
        primaryPhonePartyContactMechPurpose = from("PartyContactMechPurpose").where("partyId", supplierRelationship.partyIdTo, "contactMechPurposeTypeId", "PRIMARY_PHONE").filterByDate().queryFirst();
        primaryPhoneContactMech = from("TelecomNumber").where("contactMechId", primaryPhonePartyContactMechPurpose?.contactMechId).queryOne();
        supplierInfo.primaryPhone = primaryPhoneContactMech?.contactNumber;

        //Supplier's Primary Address
        primaryAddressPartyContactMechPurpose = from("PartyContactMechPurpose").where("partyId", supplierRelationship.partyIdTo, "contactMechPurposeTypeId", "PRIMARY_LOCATION").filterByDate().queryFirst();
        primaryAddressContactMech = from("PostalAddress").where("contactMechId", primaryAddressPartyContactMechPurpose?.contactMechId).queryOne();
        supplierInfo.primaryAddress1 = primaryAddressContactMech?.address1;
        supplierInfo.primaryAddress2 = primaryAddressContactMech?.address2;
        supplierInfo.primaryAddressCity = primaryAddressContactMech?.city;
        supplierInfo.primaryAddressPostal = primaryAddressContactMech?.postalCode;
        suppliers.add(supplierInfo)
}


context.suppliers = suppliers;
