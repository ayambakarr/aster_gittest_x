function ReportsDummyDataSource(){
    this.initiateDataSource = function(){
        var reportsDummy = [{
            LookUpValue: 1,
            LookUpText: "Today's Appointments"
        },
        {
            LookUpValue: 2,
            LookUpText: "This Week"
        },
        {
            LookUpValue: 3,
            LookUpText: "This Month"
        },
        {
            LookUpValue: 4,
            LookUpText: "This Quarter"
        },
        {
            LookUpValue: 5,
            LookUpText: "This Year"
        },
        {
            LookUpValue: 6,
            LookUpText: "Last Week"
        },
        {
            LookUpValue: 7,
            LookUpText: "Last Month"
        },
        {
            LookUpValue: 8,
            LookUpText: "Last Quarter"
        },
        {
            LookUpValue: 8,
            LookUpText: "Last Year"
        }
        ];
        var actionsDummyDatasource = new kendo.data.DataSource({
            data: reportsDummy,
        });

        return reportsDummy;
    };
};


