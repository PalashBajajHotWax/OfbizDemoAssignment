package com.companyname.ofbizdemo.services;

import org.apache.ofbiz.entity.model.DynamicViewEntity;
import org.apache.ofbiz.entity.model.ModelKeyMap;

public class SupplierDynamicViews {
    public static DynamicViewEntity getSupplierDynamicView() {
        DynamicViewEntity supplierDynamicView = new DynamicViewEntity();
        supplierDynamicView.addMemberEntity("PT", "Party");
        supplierDynamicView.addMemberEntity("PE", "Person");
        supplierDynamicView.addMemberEntity("PG", "PartyGroup");
        supplierDynamicView.addMemberEntity("PR", "PartyRole");
        supplierDynamicView.addMemberEntity("PREL", "PartyRelationship");
        supplierDynamicView.addMemberEntity("SI", "StatusItem");


        supplierDynamicView.addAliasAll("PT", null, null);
        supplierDynamicView.addAlias("PR", "roleTypeId");
        supplierDynamicView.addAlias("PE", "firstName");
        supplierDynamicView.addAlias("PE", "middleName");
        supplierDynamicView.addAlias("PE", "lastName");
        supplierDynamicView.addAlias("PG", "groupName");
        supplierDynamicView.addAlias("PREL", "relationshipStatusId", "statusId", null, null, null,null);
        supplierDynamicView.addAlias("SI", "relationshipStatusDesc","description", null, null, null,null);

        supplierDynamicView.addViewLink("PT", "PE", Boolean.TRUE, ModelKeyMap.makeKeyMapList("partyId","partyId"));
        supplierDynamicView.addViewLink("PT", "PG", Boolean.TRUE, ModelKeyMap.makeKeyMapList("partyId","partyId"));
        supplierDynamicView.addViewLink("PT", "PR", Boolean.TRUE, ModelKeyMap.makeKeyMapList("partyId","partyId"));
        supplierDynamicView.addViewLink("PT", "PREL", Boolean.TRUE, ModelKeyMap.makeKeyMapList("partyId","partyIdTo"));
        supplierDynamicView.addViewLink("PREL", "SI", Boolean.TRUE, ModelKeyMap.makeKeyMapList("statusId","statusId"));

        return supplierDynamicView;
    }

}
