function PracticesDataSource(){
    this.initiateDataSource = function(model){
    	var practicesDummy = [{
    		"practiceId": 111,
    		"practiceName": "Moseman Medical Practice",
    		"address1" : "10 Test Street",
    		"address2" : "",
    		"citySuburb" : "Mosman",
    		"postCode" : 2088,
    		"phone" : "02 9999 8888",
    		"email" : "mosman@medical.com.au",
    		"type" : "Primary",
    		"accountGUID": 2
    	},
    	{
    		"practiceId": 112,
    		"practiceName": "Cremorne Medical Practice",
    		"address1" : "Unit 6",
    		"address2" : "98 Johns Street",
    		"citySuburb" : "Cremorne",
    		"postCode" : 2087,
    		"phone" : "02 9988 4455",
    		"email" : "cremorne@medical.com.au",
    		"type" : "Secondary",
    		"accountGUID": 3
    	}];
    	
        var practicesDatasource = new kendo.data.DataSource({
            data: practicesDummy,
        });

        return practicesDatasource;
    };
};


