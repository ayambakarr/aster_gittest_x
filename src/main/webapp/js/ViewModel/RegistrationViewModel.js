function RegistrationViewModel() {
	this.initiateViewModel = function(validator) {
		var registrationViewModel = kendo.observable({
			clinicalDataSource:[{LOOKUPTEXT : "Medical Director", LOOKUPVALUE: "315890000"},
			                    {LOOKUPTEXT : "ZedMed", LOOKUPVALUE: "315890002"},
			                    {LOOKUPTEXT : "Best Practice", LOOKUPVALUE: "315890001"},
			                    {LOOKUPTEXT : "Shexie", LOOKUPVALUE: "315890004"},
			                    {LOOKUPTEXT : "Genie", LOOKUPVALUE: "315890003"}],
			                    
			userCategoryDataSource:[{LOOKUPTEXT : "Aboriginal Health Worker", LOOKUPVALUE: "10BA2794-EA40-E311-93F5-005056813643"},
			                        {LOOKUPTEXT : "Audiologist", LOOKUPVALUE: "369A06D7-EA40-E311-93F5-005056813643"},
			                        {LOOKUPTEXT : "Chiropractor", LOOKUPVALUE: "234851AD-EA40-E311-93F5-005056813643"},
			                        {LOOKUPTEXT : "Dental prosthetist", LOOKUPVALUE: "224515C9-EA40-E311-93F5-005056813643"},
			                        {LOOKUPTEXT : "Dentist", LOOKUPVALUE: "5A121383-EA40-E311-93F5-005056813643"},
			                        {LOOKUPTEXT : "Diabetes Educator", LOOKUPVALUE: "7AEEB85A-EA40-E311-93F5-005056813643"},
									{LOOKUPTEXT : "Dietitian", LOOKUPVALUE: "79EEB85A-EA40-E311-93F5-005056813643"},
									{LOOKUPTEXT : "Employee Doctor", LOOKUPVALUE: "E0BD8803-EA40-E311-93F5-005056813643"},
									{LOOKUPTEXT : "Excercise Physiologist", LOOKUPVALUE: "CDED589F-EA40-E311-93F5-005056813643"},
									{LOOKUPTEXT : "General Practitioner", LOOKUPVALUE: "51F65378-9842-E311-93F5-005056813643"},
									{LOOKUPTEXT : "Guest", LOOKUPVALUE: "333594F3-E940-E311-93F5-005056813643"},
									{LOOKUPTEXT : "Massage therapist", LOOKUPVALUE: "285864B7-EA40-E311-93F5-005056813643"},
									{LOOKUPTEXT : "Medical Student", LOOKUPVALUE: "7EFDB28D-EA40-E311-93F5-005056813643"},
									{LOOKUPTEXT : "Midwife", LOOKUPVALUE: "FC3E064C-EA40-E311-93F5-005056813643"},
									{LOOKUPTEXT : "Nurse Practitioner", LOOKUPVALUE: "178836CF-EA40-E311-93F5-005056813643"},
									{LOOKUPTEXT : "Occupational Therapist", LOOKUPVALUE: "59121383-EA40-E311-93F5-005056813643"},
									{LOOKUPTEXT : "Office Manager", LOOKUPVALUE: "343594F3-E940-E311-93F5-005056813643"},
									{LOOKUPTEXT : "Orthoptist", LOOKUPVALUE: "528726C1-EA40-E311-93F5-005056813643"},
									{LOOKUPTEXT : "Osteopath", LOOKUPVALUE: "244851AD-EA40-E311-93F5-005056813643"},
									{LOOKUPTEXT : "Patient", LOOKUPVALUE: "0BF0B7E9-A13B-E311-93F5-005056813643"},
									{LOOKUPTEXT : "Physiotherapist", LOOKUPVALUE: "5144EC67-EA40-E311-93F5-005056813643"},
									{LOOKUPTEXT : "Podiatrist", LOOKUPVALUE: "5244EC67-EA40-E311-93F5-005056813643"},
									{LOOKUPTEXT : "Practice Nurse", LOOKUPVALUE: "E2958613-EA40-E311-93F5-005056813643"},
									{LOOKUPTEXT : "Practice Owner", LOOKUPVALUE: "F0CE59E8-A73A-E311-93F5-005056813643"},
									{LOOKUPTEXT : "Principal Doctor", LOOKUPVALUE: "DFBD8803-EA40-E311-93F5-005056813643"},
									{LOOKUPTEXT : "Psychologist", LOOKUPVALUE: "B0A24654-EA40-E311-93F5-005056813643"},
									{LOOKUPTEXT : "Radiographer", LOOKUPVALUE: "25C1FBA5-EA40-E311-93F5-005056813643"},
									{LOOKUPTEXT : "Receptionist", LOOKUPVALUE: "28E16345-EA40-E311-93F5-005056813643"},
									{LOOKUPTEXT : "Social Worker", LOOKUPVALUE: "6921F270-EA40-E311-93F5-005056813643"},
									{LOOKUPTEXT : "Speech Pathologist", LOOKUPVALUE: "0612607C-EA40-E311-93F5-005056813643"}],
			                    
			trueVisible: true,
			trueEnable: true,
			                    
			saveRegistration: function(e) {
				
				if (validator.validate()) {
					
					// If the form is valid, the Validator will return true
			        var registration = {
			            practiceName: $('#PracticeName').val(),
			            title: $('#Title').val(),
			            firstName: $('#FirstName').val(),
			            lastName: $('#LastName').val(),
			            userId: $('#UserID').val(),
			            email: $('#Email').val(),
			            phone: $('#Phone').val(),
			            promotionCode: $('#PromoCode').val(),
			            currentClinicalSystem: $('#CurrentSystem').val(),
			        	userCategoryId: $('#MRUserCategory').val(),
			            doNotSendMM: $('#sendStatus').val()
			        };

			        $.ajax({
			            url: '/mrapp/rest/registration/create',
			            type: 'POST',
			            data: JSON.stringify(registration),
			            contentType: "application/json;charset=utf-8",
			            dataType: 'json',
			            success: function (data) {
			            	$.cookie('email', data.email);
			        		window.location.href = '#/activationinfo';
			            },
			            error: function (x, y, z) {
			                alert(x + '\n' + y + '\n' + z);
			            }
			        }); 
				}
			}
		
		});
		
		return registrationViewModel;
	};
};