function ActionsDummyDataSource(){
    this.initiateDataSource = function(){
        var actionsDummy = [{
            LookUpValue: 1,
            LookUpText: "SMS Reminder"
        },
        {
            LookUpValue: 2,
            LookUpText: "MR App Reminder"
        },
        {
            LookUpValue: 3,
            LookUpText: "Add to Waiting Room"
        },
        {
            LookUpValue: 4,
            LookUpText: "MR App Questionaire"
        },
        {
            LookUpValue: 5,
            LookUpText: "Block"
        },
        {
            LookUpValue: 6,
            LookUpText: "Follow Up"
        },
        {
            LookUpValue: 7,
            LookUpText: "New Patient"
        }];
        var actionsDummyDatasource = new kendo.data.DataSource({
            data: actionsDummy,
        });

        return actionsDummyDatasource;
    };
};


