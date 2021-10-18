import org.apache.ofbiz.entity.util.EntityUtilProperties;

countryGeoId = parameters.countryGeoId
if(!countryGeoId){
    defaultCountryGeoId = EntityUtilProperties.getPropertyValue("general", "country.geo.id.default", "USA", delegator);
    countryGeoId = defaultCountryGeoId
}
context.countryGeoId = countryGeoId

countryGeoList = from("Geo").where("geoTypeId", "COUNTRY").queryList()
context.countryGeoList = countryGeoList

stateGeoList = from("GeoAssocAndGeoTo").where("geoIdFrom", countryGeoId).queryList()
context.stateGeoList = stateGeoList


