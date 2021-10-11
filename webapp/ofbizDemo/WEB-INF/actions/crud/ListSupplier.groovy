import org.apache.ofbiz.party.party.PartyHelper;

supplierRelationships = from("PartyRelationship").where("roleTypeIdTo", "SUPPLIER").filterByDate().queryList()
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
        supplierInfo.primaryAddressCity = primaryAddressContactMech?.city;
        supplierInfo.primaryAddressPostal = primaryAddressContactMech?.postalCode;
        suppliers.add(supplierInfo)
}

context.suppliers = suppliers;
