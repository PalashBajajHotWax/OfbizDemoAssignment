<div class="panel panel-default">
    <div class="panel-heading">
        <div class="row">
            <div class="col-sm-6"><h3 class="panel-title">Supplier Basic Information</h3></div>
            <div class="col-sm-6"><a class="btn btn-default btn-sm pull-right" href="<@ofbizUrl>UpdateBasicInformation</@ofbizUrl>?partyId=${(supplier.partyId)!}" role="button">${uiLabelMap.CommonUpdate}</a></div>
        </div>
    </div>
    <div class="panel-body">
        <dl class="dl-horizontal">
            <dt>${uiLabelMap.SupplierGroupName}</dt>
            <dd>${(supplier.supplierName)!}</dd>
            <dt>${uiLabelMap.SupplierPhoneNumber}</dt>
            <dd>${(supplier.primaryPhone.contactNumber)!}</dd>
            <dt>${uiLabelMap.CommonEmail}</dt>
            <dd>${(supplier.primaryEmail.infoString)!}</dd>
        </dl>
    </div>
</div>
<div class="panel panel-default">
<div class="panel-heading">
    <div class="row">
        <div class="col-sm-6"><h3 class="panel-title">Supplier Address Information</h3></div>
        <div class="col-sm-6"><a class="btn btn-default btn-sm pull-right" href="<@ofbizUrl>UpdateAddressInformation</@ofbizUrl>?partyId=${(supplier.partyId)!}" role="button">${uiLabelMap.CommonUpdate}</a></div>
    </div>
</div>
<div class="panel-body">
    <dl class="dl-horizontal">
        <dt>${uiLabelMap.CommonCountry}</dt>
        <#list stateGeoList as stateGeo>
        <#if supplier.primaryAddress.stateGeoId == stateGeo.geoId>
        <dd>${(stateGeo.geoName)!}</dd>
        </#if>
        </#list>
        <dt>${uiLabelMap.CommonState}</dt>
        <#list countryGeoList as countryGeo>
        <#if supplier.primaryAddress.countryGeoId == countryGeo.geoId>
        <dd>${(countryGeo.geoName)!}</dd>
        </#if>
        </#list>
        <dt>${uiLabelMap.CommonAddress1}</dt>
        <dd>${(supplier.primaryAddress.address1)!}</dd>
        <dt>${uiLabelMap.CommonAddress2}</dt>
        <dd>${(supplier.primaryAddress.address2)!}</dd>
        <dt>${uiLabelMap.CommonCity}</dt>
        <dd>${(supplier.primaryAddress.city)!}</dd>
        <dt>${uiLabelMap.SupplierPostalCode}</dt>
        <dd>${(supplier.primaryAddress.postalCode)!}</dd>
    </dl>
</div>
</div>