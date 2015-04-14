function AppointmentsModel() {
    this.initiateModel = function () {
        var appointmentsModel = {
            id: "meetingID",
            fields: {
				patientID: { from: "PatientID", type: "number" },
                apptTimeStart: { from: "ApptTimeStart"},
				apptTimeEnd: { from: "ApptTimeEnd" },
				arrived: {from: "Arrived" },
				lateBy: {from: "LateBy" },
				practice: {from: "Practice" },
				visiting: {from: "Visiting" },
				timeOfVisit: {from: "TimeOfVisit" },
				location: {from: "Location" },
				lastVisit: {from: "LastVisit", type: "date" },
				details: {from: "Details" },
				actions: {from: "Actions" }
				
                //meetingID: { from: "MeetingID", type: "number" },
                //title: { from: "Title", defaultValue: "No title", validation: { required: true } },
                //start: { type: "date", from: "Start" },
                //end: { type: "date", from: "End" },
                //startTimezone: { from: "StartTimezone" },
                //endTimezone: { from: "EndTimezone" },
                //description: { from: "Description" },
                //recurrenceId: { from: "RecurrenceID" },
                //recurrenceRule: { from: "RecurrenceRule" },
                //recurrenceException: { from: "RecurrenceException" },
                //roomId: { from: "RoomID", nullable: true },
                //attendees: { from: "Attendees", nullable: true },
                //isAllDay: { type: "boolean", from: "IsAllDay" }
            }
        };
        return appointmentsModel;
    }
};