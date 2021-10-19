<div class="panel panel-default">
  <div class="panel-heading">
    <h3 class="panel-title">${uiLabelMap.CreateSupplier}</h3>
  </div>
  <div class="panel-body">
    <form method="post" action="<@ofbizUrl>updateSupplier</@ofbizUrl>" name="createSupplier" class="form-vertical">
      <div class="row">
        <div class="col-sm-6 mx-auto">
          <div class="form-group">
            <label for="address1">${uiLabelMap.CommonAddress1}</label>
            <input type="text" class="form-control" id="address1" name="address1" required>
          </div>
          <div class="form-group">
            <label for="address2">${uiLabelMap.CommonAddress2}</label>
            <input type="text" class="form-control" id="address2" name="address2" required>
          </div>
          <div class="form-group">
            <label for="countryGeoId">${uiLabelMap.CommonCountry}</label>
            <select class="form-control" id="countryGeoId" name="countryGeoId" readonly>
              <#list countryGeoList as countryGeo>
                <option class="form-control" value="${(countryGeo.geoId)!}" <#if countryGeoId?has_content && countryGeoId == countryGeo.geoId>selected</#if>>${(countryGeo.geoName)!}</option>
              </#list>
            </select>
          </div>
          <div class="form-group">
            <label for="state">${uiLabelMap.CommonState}</label>
            <select class="form-control" id="state" name="stateProvinceGeoId">
            <#list stateGeoList as stateGeo>
              <option class="form-control" value="${(stateGeo.geoId)!}">${(stateGeo.geoName)!}</option>
            </#list>
            </select>
          </div>
          <div class="form-group">
            <label for="city">${uiLabelMap.CommonCity}</label>
            <input type="text" class="form-control" id="city" name="city" required>
          </div>
          <div class="form-group">
            <label for="postalCode">${uiLabelMap.SupplierPostalCode}</label>
            <input type="text" class="form-control" id="postalCode" name="postalCode" required>        </div>
          </div>
        </div>
        <div class="form-group">
            <button type="submit" class="btn btn-control btn-primary col-lg-6">${uiLabelMap.CreateSupplier}</button>
        </div>
      </div>
    </form>
  </div>
</div>

