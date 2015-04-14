var patientModel = {
            id: "PatientGUID",
            fields: {
                "patientGUID": {from: "patientGUID", type: "string", editable: false, nullable: true},
                "firstName": {from: "firstName", type: "string", editable: true, nullable: false},
                "lastName": {from: "lastName", type: "string", editable: true, nullable: false},
                "dOB": {from: "dOB", type: "string", editable: true},
                "genderCode": {from: "genderCode", type: "string", editable: true},                
                "homePhone": {from: "homePhone", type: "string", editable: true},                
            }
        };

var dataSource = new kendo.data.DataSource({
  autoSync: true,
  transport: {
    read:  {
      url: "/asterx/rest/patients/ping/",
      dataType: "json" // "jsonp" is required for cross-domain requests; use "json" for same-domain requests
    }
  },
  schema: {
    model: patientModel
  }
});

function onSearch()
{
  var q = $("#txtSearchString").val();
      var grid = $("#Grid").data("kendoGrid");
      grid.dataSource.query({
        page:1,
        pageSize:20,
        filter:{
          logic:"or",
          filters:[
            {field:"name", operator:"contains",value:q}
            ]
         }
      });
}

var template = '<input type="checkbox" id="SelectedCB" #= Selected ? checked="checked" : "" # />'