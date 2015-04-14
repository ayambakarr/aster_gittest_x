var dataSource = new kendo.data.DataSource({
  autoSync: true,
  transport: {
    read:  {
      url: "http://localhost:8080/asterx/rest/patients/ping/",
      dataType: "jsonp" // "jsonp" is required for cross-domain requests; use "json" for same-domain requests
    }
  },
  schema: {
    model: { id: "patientGUID" }
  }
});
dataSource.fetch(function() {
  var product = dataSource.at(0);
  product.set("UnitPrice", 20); // auto-syncs and makes request to http://demos.telerik.com/kendo-ui/service/products/update
});