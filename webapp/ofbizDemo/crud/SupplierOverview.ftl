<div class="panel panel-default">
    <div class="panel-heading">
        <div class="row">
            <div class="col-sm-6"><h3 class="panel-title">Supplier Basic Information</h3></div>
            <div class="col-sm-6"><a class="btn btn-default btn-sm pull-right" href="<@ofbizUrl>UpdateBasicInformation</@ofbizUrl>?partyId=${(suppliers.partyId)!}" role="button">${uiLabelMap.CommonUpdate}</a></div>
        </div>
    </div>
    <div class="panel-body">
        <dl class="dl-horizontal">
            <dt>${uiLabelMap.SupplierGroupName}</dt>
            <dd>${(suppliers.supplierName)!}</dd>
            <dt>${uiLabelMap.SupplierPhoneNumber}</dt>
            <dd>${(suppliers.primaryPhone)!}</dd>
            <dt>${uiLabelMap.CommonEmail}</dt>
            <dd>${(suppliers.primaryEmailAddress)!}</dd>
        </dl>
    </div>
</div>
<div class="panel panel-default">
<div class="panel-heading">
    <div class="row">
        <div class="col-sm-6"><h3 class="panel-title">Supplier Address Information</h3></div>
        <div class="col-sm-6"><a class="btn btn-default btn-sm pull-right" href="<@ofbizUrl>UpdateAddressInformation</@ofbizUrl>?partyId=${(suppliers.partyId)!}" role="button">${uiLabelMap.CommonUpdate}</a></div>
    </div>
</div>
<div class="panel-body">
    <dl class="dl-horizontal">
        <dt>${uiLabelMap.CommonCountry}</dt>
        <#list stateGeoList as stateGeo>
        <#if suppliers.primaryAddressState == stateGeo.geoId>
        <dd>${(stateGeo.geoName)!}</dd>
        </#if>
        </#list>
        <dt>${uiLabelMap.CommonState}</dt>
        <#list countryGeoList as countryGeo>
        <#if suppliers.primaryAddressCountry == countryGeo.geoId>
        <dd>${(countryGeo.geoName)!}</dd>
        </#if>
        </#list>
        <dt>${uiLabelMap.CommonAddress1}</dt>
        <dd>${(suppliers.primaryAddress1)!}</dd>
        <dt>${uiLabelMap.CommonAddress2}</dt>
        <dd>${(suppliers.primaryAddress2)!}</dd>
        <dt>${uiLabelMap.CommonCity}</dt>
        <dd>${(suppliers.primaryAddressCity)!}</dd>
        <dt>${uiLabelMap.SupplierPostalCode}</dt>
        <dd>${(suppliers.primaryAddressPostal)!}</dd>
    </dl>
</div>
</div>