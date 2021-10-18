<div class="panel panel-default">
  <div class="panel-heading">
  <div class="row">
    <div class="col-sm-6"><h3 class="panel-title">${uiLabelMap.FindSupplier}</h3></div>
    <div class="col-sm-6"><a class="btn btn-default btn-sm pull-right" href="<@ofbizUrl>CreateSupplier</@ofbizUrl>" role="button">${uiLabelMap.CreateSupplier}</a></div>
  </div>

  </div>
  <div class="panel-body">
   <#include "FindSupplierQuery.ftl" />
    <#if suppliers?has_content>
          <table class="table table-bordered table-striped table-hover">
            <thead>
              <tr>
                <th>${uiLabelMap.CommonPartyId}</th>
                <th>${uiLabelMap.CommonGeoName}</th>
                <th>${uiLabelMap.CommonEmail}</th>
                <th>${uiLabelMap.CommonTelephoneAbbr}</th>
                <th>${uiLabelMap.SupplierPostalAddress}</th>
              </tr>
            </thead>
            <tbody>
            <#list suppliers as supplierInfo>
              <tr>
                <td><a href="<@ofbizUrl>SupplierOverview</@ofbizUrl>?partyId=${(supplierInfo.partyId)!}">${(supplierInfo.partyId)!}</a></td>
                <td>${(supplierInfo.supplierName)!}</td>
                <td>${(supplierInfo.primaryEmailAddress)!}</td>
                <td>${(supplierInfo.primaryPhone)!}</td>
                <td>${(supplierInfo.primaryAddress1)!}, ${(supplierInfo.primaryAddress2)!}, ${(supplierInfo.primaryAddressCity)!}, ${(supplierInfo.primaryAddressPostal)!}</td>
              </tr>
            </#list>
          </tbody>
        </table>
        <#else>
         <h5>No Suppliers Found.</h5>
        </#if>
  </div>
</div>