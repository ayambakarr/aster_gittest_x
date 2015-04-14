function FilterProviderDataSource(){
    this.initiateDataSource = function(){
        var filterProviderDataSource = new kendo.data.DataSource({
            data: [
				{ text: "All Providers", value: 1 },
				{ text: "Dr Maatthew Gelato", value: 2 },
				{ text: "Dr Jon Marshal", value: 3 },
				{ text: "Practice Nurse", value: 4 },
				{ text: "Physioteraphist", value: 5 }
			]
        });
        return filterProviderDataSource;
    };
};