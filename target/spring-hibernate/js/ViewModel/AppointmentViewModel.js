function AppointmentsViewModel() {
    this.initiateViewModel = function (dataSources) {
        var appointmentsViewModel = kendo.observable({
            //Scheduler
            isVisibleScheduler: true,
            onSaveScheduler: function (e) {
                kendoConsole.log("event :: save(" + kendo.stringify(e.event, null, 4) + ")");
            },
            tasks: dataSources.appointmentsDataSource,

            //Calendar
            isVisibleCalendar: true,
            selectedDateCalendar: null,
            onChangeCalendar: function () {
                kendoConsole.log("event :: change (" + kendo.toString(this.get("selectedDate"), "D") + ")");
                console.log("onChange");
            },

            //Dropdownlist
            AppointmentsProvidersDataSource: dataSources.serviceProviderTypeDataSource,
            AppointmentsPracticesDataSource: dataSources.practicesDataSource,
            AppointmentsActionsDataSource: dataSources.actionsDummyDataSource,
            AppointmentsReportsDataSource: dataSources.reportsDummyDataSource,
            FilterProviderDataSource: dataSources.filterProviderDataSource
        });
        return appointmentsViewModel;
    };
};