<div class="panel panel-default">
  <div class="panel-heading">
    <h3 class="panel-title">${uiLabelMap.UpdateSupplier}</h3>
  </div>
  <div class="panel-body">
    <form method="post" action="<@ofbizUrl>updateAddressInformation</@ofbizUrl>" name="updateAddressInformation" class="form-vertical">
      <div class="row">
        <div class="col-sm-6 mx-auto">
        <div class="form-group">
                    <label for="countryGeoId">${uiLabelMap.CommonCountry}</label>
                    <select class="form-control" id="countryGeoId" name="countryGeoId" readonly>
                      <#list countryGeoList as countryGeo>
                        <option class="form-control" value="${(suppliers.primaryAddressCountry)!}" <#if countryGeoId?has_content && countryGeoId == countryGeo.geoId>selected</#if>>${(countryGeo.geoName)!}</option>
                      </#list>
                    </select>
                  </div>
                  <div class="form-group">
                    <label for="state">${uiLabelMap.CommonState}</label>
                    <select class="form-control" id="state" name="stateProvinceGeoId">
                    <#list stateGeoList as stateGeo>
                      <option class="form-control" value="${(stateGeo.geoId)!}" <#if (suppliers.primaryAddressState)?has_content && suppliers.primaryAddressState == stateGeo.geoId>selected</#if>>${(stateGeo.geoName)!}</option>
                    </#list>
                    </select>
                  </div>
          <div class="form-group">
            <label for="address1">${uiLabelMap.CommonAddress1}</label>
            <input type="hidden" value="${(suppliers.partyId)!}" id="partyId" name="partyId">
            <input type="hidden" value="${(suppliers.primaryAddressContactMechId)!}" id="primaryAddressContactMechId" name="primaryAddressContactMechId">
            <input type="text" value="${(suppliers.primaryAddress1)!}" class="form-control" id="address1" name="address1" required>
          </div>
          <div class="form-group">
            <label for="address2">${uiLabelMap.CommonAddress2}</label>
            <input type="text" value="${(suppliers.primaryAddress2)!}" class="form-control" id="address2" name="address2" required>
          </div>
          <div class="form-group">
            <label for="city">${uiLabelMap.CommonCity}</label>
            <input type="text" value="${(suppliers.primaryAddressCity)!}" class="form-control" id="city" name="city" required>
          </div>
          <div class="form-group">
            <label for="postalCode">${uiLabelMap.SupplierPostalCode}</label>
            <input type="text" value="${(suppliers.primaryAddressPostal)!}" class="form-control" id="postalCode" name="postalCode" required>        </div>
          </div>
        </div>
        <div class="form-group">
            <button type="submit" class="btn btn-control btn-primary">${uiLabelMap.CommonUpdate}</button>
        </div>
      </div>
    </form>
  </div>
</div>

