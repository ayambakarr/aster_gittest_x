function ServiceProviderTypeDataSource() {
    this.initiateDataSource = function (accountGuid) {
        var serviceProviderTypeDataSource = new kendo.data.DataSource({
            transport: {
                read: {
                    url: BASE_API_URL_MAIN + "GetServiceProviderType/" + accountGuid,
                    dataType: 'json'
                }
            },
            error: function (e) {
                var msg = e.xhr.responseText;
                alert(msg);
            }
        });

        return serviceProviderTypeDataSource;
    };
};