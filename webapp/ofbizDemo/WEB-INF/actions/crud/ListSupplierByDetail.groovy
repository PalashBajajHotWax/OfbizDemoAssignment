import org.apache.ofbiz.party.party.PartyHelper;

supplierRelationships = from("PartyRelationship").where("roleTypeIdTo", "SUPPLIER").filterByDate().queryList()
suppliers = []
supplierRelationships.each { supplierRelationship ->
    supplierInfo = [:]
    supplierInfo.partyId = supplierRelationship.partyIdTo
    supplierInfo.supplierName = PartyHelper.getPartyName(delegator, supplierRelationship.partyIdTo, false)

    //Supplier's Primary Email
    primaryEmailContactMech = from("PartyContactDetailByPurpose").where("partyId", supplierRelationship.partyIdTo, "contactMechPurposeTypeId", "PRIMARY_EMAIL").filterByDate().queryFirst();
    supplierInfo.primaryEmail = primaryEmailContactMech?.infoString;

    //Supplier's Primary Phone
    primaryPhoneContactMech = from("PartyContactDetailByPurpose").where("partyId", supplierRelationship.partyIdTo, "contactMechPurposeTypeId", "PRIMARY_PHONE").filterByDate().queryFirst();
    supplierInfo.primaryPhone = primaryPhoneContactMech?.contactNumber;

    //Supplier's Primary Address
    primaryAddressContactMech = from("PartyContactDetailByPurpose").where("partyId", supplierRelationship.partyIdTo, "contactMechPurposeTypeId", "PRIMARY_LOCATION").filterByDate().queryFirst();
    supplierInfo.primaryAddress1 = primaryAddressContactMech?.address1;
    supplierInfo.primaryCity = primaryAddressContactMech?.city;
    supplierInfo.primaryPostal = primaryAddressContactMech?.postalCode;

    suppliers.add(supplierInfo)
}

context.suppliers = suppliers;