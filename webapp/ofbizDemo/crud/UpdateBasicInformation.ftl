<div class="panel panel-default">
    <div class="panel-heading">
        <h3 class="panel-title">${uiLabelMap.UpdateSupplier}</h3>
    </div>
    <div class="panel-body">
        <form method="post" action="<@ofbizUrl>updateBasicInformation</@ofbizUrl>" name="updateBasicInformation" class="form-vertical">
        <div class="row">
            <div class="col-sm-6">
                <div class="form-group">
                    <label for="groupName">${uiLabelMap.SupplierGroupName}</label>
                    <input type="hidden" value="${(supplier.partyId)!}" id="partyId" name="partyId">
                    <input type="text" value="${(supplier.supplierName)!}" class="form-control" id="groupName" name="groupName">
                </div>
                <div class="form-group">
                    <label for="contactNumber">${uiLabelMap.SupplierPhoneNumber}</label>
                    <input type="hidden" value="${(supplier.primaryPhone.contactMechId)!}" id="primaryPhoneContactMechId" name="primaryPhoneContactMechId">
                    <input type="text" value="${(supplier.primaryPhone.contactNumber)!}" class="form-control" id="contactNumber" name="contactNumber" required>
                </div>
                <div class="form-group">
                    <label for="emailAddress">${uiLabelMap.CommonEmail}</label>
                    <input type="hidden" value="${(supplier.primaryEmail.contactMechId)!}" id="primaryEmailContactMechId" name="primaryEmailContactMechId">
                    <input type="text" value="${(supplier.primaryEmail.infoString)!}" class="form-control" id="emailAddress" name="emailAddress" required>
                </div>
                <div class="form-group">
                </div><button type="submit" class="btn btn-control btn-primary">${uiLabelMap.CommonUpdate}</button></div>
                </div>
            </div>
        </div>
        </form>
    </div>
</div>

