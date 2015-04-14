function RegistrationDataSource() {
	this.initiateDataSource = function() {
		var registrationDataSource = new kendo.data.DataSource({
			transport: {
                read: {
                    url: "api/registration/GetCurrentClinicalSystem",
                    dataType: "json"
                }
            },
            error: function(e) {
            	var msg = e.xhr.responseText;
            	alert(msg);
            }
		});
		
		return registrationDataSource;
	};
};