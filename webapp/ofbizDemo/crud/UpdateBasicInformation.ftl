<div class="panel panel-default">
    <div class="panel-heading">
        <h3 class="panel-title">${uiLabelMap.UpdateSupplier}</h3>
    </div>
    <div class="panel-body">
        <form method="post" action="<@ofbizUrl>updateSupplier</@ofbizUrl>" name="updateSupplier" class="form-vertical">
        <div class="row">
            <div class="col-sm-6">
                <div class="form-group">
                    <label for="groupName">${uiLabelMap.SupplierGroupName}</label>
                    <input type="text" class="form-control" id="groupName" name="groupName">
                </div>
                <div class="form-group">
                    <label for="contactNumber">${uiLabelMap.SupplierPhoneNumber}</label>
                    <input type="text" class="form-control" id="contactNumber" name="contactNumber" required>
                </div>
                <div class="form-group">
                    <label for="emailAddress">${uiLabelMap.CommonEmail}</label>
                    <input type="text" class="form-control" id="emailAddress" name="emailAddress" required>
                </div>
                <div class="form-group">
                </div><button type="submit" class="btn btn-control btn-primary">${uiLabelMap.CommonUpdate}</button></div>
                </div>
            </div>
        </div>
        </form>
    </div>
</div>

