<div class="screenlet-body">
    <h5>${uiLabelMap.FindSupplierByDetail}</h5>
    <#if suppliers?has_content>
      <table class="table table-bordered table-striped table-hover">
        <thead>
          <tr>
            <th>${uiLabelMap.CommonPartyId}</th>
            <th>${uiLabelMap.CommonGeoName}</th>
            <th>${uiLabelMap.CommonEmail}</th>
            <th>${uiLabelMap.CommonTelephoneAbbr}</th>
            <th>${uiLabelMap.CommonAddress1}</th>
          </tr>
        </thead>
        <tbody>
        <#list suppliers as supplierInfo>
        <tr>
          <td>${(supplierInfo.partyId)!}</td>
          <td>${(supplierInfo.supplierName)!}</td>
          <td>${(supplierInfo.primaryEmail)!}</td>
          <td>${(supplierInfo.primaryPhone)!}</td>
          <td>${(supplierInfo.primaryAddress1)!}, ${(supplierInfo.primaryCity)!}, ${(supplierInfo.primaryPostal)!}</td>
        </tr>
        </#list>
        </tbody>
     </table>
    <#else>
      <h5>No Suppliers Found.</h5>
    </#if>
</div>