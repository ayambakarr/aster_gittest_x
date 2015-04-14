//Define constants
var LOOKUPTEXT = "LookUpText";
var LOOKUPVALUE = "LookUpValue";
var LOOKUPGUID = "LookUpGUID";
var SELECTED_GRID_ITEMS = "selectedGridItems";
var ID = "Id";
var LOOKUPVALUE1 = "LookupValue1";
var LOGINAPPURL = 'index.html';
var CLINICALGUID = 'd5ea848c-a23a-e311-93f5-005056813643';
var PRACTICECLINICALGUID = 'ae54039e-a23a-e311-93f5-005056813643';
var PRACTICEGUID = 'e0c2b9a7-a23a-e311-93f5-005056813643';
var TRANSPARENTBUTTON = 'TransparentButton';
var SELECTEDTRANSPARENTBUTTON = 'SelectedTransparentButton';
var YYYYMMDD = "yyyy-MM-dd";
var DDMMYYYY = "dd-MM-yyyy";
var BASE_API_URL_LETTER = "api/Letter/";
var BASE_API_URL_LOOKUP = "api/lookup/";
var BASE_API_URL_PATIENT = "api/patient/";
var BASE_API_URL_MAIN = "api/main/";
var BASE_API_URL_CLINICAL_TEMPLATE = "api/clinicaltemplate/";

//Define Kendo's MessageModalDialog for Messages
var messageModalDialog = $('#MessageModalDialog').kendoWindow({
	    title: 'Message',
	    width: "350px",
	    height: "110px",
	    draggable: true,
	    actions: ["Close"],
	    resizable: false,
	    visible: false,
	    modal: true
	}).data('kendoWindow');
$("#MessageButtonOK").click(function (e) {
    messageModalDialog.close();
});
var messageModalDialogContent = $("#Message");

//validation that allow alphanumeric and space
//parameter : formObj, e.g. #RegistrationForm
//            classDefinition, e.g.  "[class=RegInputWithValidation]"
function validateCommonField(formObj, classDefinition) {
    //= $("#RegistrationForm");
    var result = formObj.kendoValidator({
        validateOnBlur: false,
        rules: {
            customRule1: function (input) {
                if (input.is(classDefinition)) {
                    if (input.val() != "") {
                        var stringvalue = input.val();
                        var regex = /^[a-zA-Z0-9-_\s]+$/; //allow alphabet, numeric and space
                        if (stringvalue.search(regex) == -1) {
                            return false;
                        } else {
                            return true;
                        }
                    }
                }
                return true;
            }
        },
        messages: {
            customRule1: "Use alphabet, numeric or space"
        }
    }).data("kendoValidator");
    return result;
};

//validation that allow alphanumeric and space
//parameter : formObj, e.g. #RegistrationForm
//            classDefinition, e.g.  "[class=RegInputWithValidation]"
function validateListView(formObj, classDefinition) {
    
    //= $("#RegistrationForm");
    var result = formObj.kendoValidator({
        validateOnBlur: false,
        rules: {
            customRule1: function (input) {
                if (input.val() == "") {
                    return false;
                }
                else {
                    return true;
                }
            }
        },
        messages: {
            customRule1: "This list view is required"
        }
    }).data("kendoValidator");
    return result;
};

//Initiate Registration data
function GetUserData() {
    var userData;
    $.cookie.json = true;
    if ($.cookie('userInfo') == null) {
        alert('Your session was timeout. Please login again!');
        window.location.href = LOGINAPPURL;
    };
    $.cookie.json = false;
    $.ajax({
        url: 'api/main/GetUserData/' + $.cookie('userGuid') + '/' + $.cookie('accountGuid'),
        type: 'GET',
        contentType: "application/json;charset=utf-8",
        success: function (data) {
            userData = {
                FirstName: data.FirstName,
                LastName: data.LastName,
                TitleID: data.TitleID
            };
            $.cookie.json = true;
            $.cookie('userData', userData);
            GetTitleById($.cookie('userData').TitleID);
        },
        error: function (x, y, z) {
            alert('There is an error happened! \nTechnical error: ' + x.responseText);
            window.location.href = LOGINAPPURL;
        }
    });
};

function GetTitleById(id) {
    var userData;
    $.ajax({
        url: 'api/main/GetTitleById/' + id,
        type: 'GET',
        contentType: "application/json;charset=utf-8",
        success: function (data) {
            $.cookie.json = false;
            var practiceName = $.cookie('practiceName');
            titleText = data;
            $.cookie.json = true;
            userData = {
                FirstName: $.cookie('userData').FirstName,
                LastName: $.cookie('userData').LastName,
                TitleID: $.cookie('userData').TitleID,
                TitleName: data
            };
            $.cookie('userData', userData);
            if ($.cookie('userData') != null) {
                SetHeaderData(practiceName, $.cookie('userData').TitleName, $.cookie('userData').FirstName, $.cookie('userData').LastName);
            };
        },
        error: function (x, y, z) {
        	messageModalDialogContent.text('There is an error happened! Technical error: ' + x.responseText);
            messageModalDialog.title("Error");
            messageModalDialog.center();
            messageModalDialog.open();
        }
    });
};

function deleteAllCookies() {
    var cookies = document.cookie.split(";");
    for (var i = 0; i < cookies.length; i++) {
        var cookie = cookies[i];
        var eqPos = cookie.indexOf("=");
        var name = eqPos > -1 ? cookie.substr(0, eqPos) : cookie;
        //Delete all cookies except 'userInfo'
        if (name != ' userInfo') {
            document.cookie = name + "=;expires=Thu, 01 Jan 1970 00:00:00 GMT";
        }
    }
};

function CheckUserLockStatus(status) {
    if (status == 'false') {
        $("#header").hide();
        $("#HeaderPractice").hide();
        $("#HeaderClinical").hide();
        $("#HeaderClinicalPractice").hide();
        $("#BreadCrumbs").hide();
        $("#HeaderLocked").show();
        $('#BodyForm').css({ "width": "400px", "border-radius": "10px", "padding": "20px", "height": "auto", "min-height": "50px", "border": "2px solid #dddcdc", "margin":"55px auto 0px" });

        messageModalDialogContent.text("Your account has been locked. Please unlock your account by entering your password");
        messageModalDialog.center();
        messageModalDialog.open();
        window.location.href = 'application.html#/Locked';
    };
};

function SetHeaderData(practiceName, title, firstName, lastName) {
    var layoutPracticeSelectorDropDown = $("#LayoutPracticeSelector").data("kendoDropDownList");

    $.cookie.json = false;
    layoutPracticeSelectorDropDown.select(function (dataItem) {
        return dataItem.PracticeName === $.cookie('practiceName');
    });

    var username = "Welcome " + title + " " + firstName + " " + lastName;
    $("#HeaderUsername").text(username);
};

function LookupDataSource() {
    $.cookie.json = false;
    this.accountGuid = $.cookie('accountGuid');
    this.dataType = 'json';
    this.completeUrl;
    this.url = BASE_API_URL_MAIN;
    this.stateSubUrl = 'GetState/';
    this.stateByPostalCodeSubUrl = 'GetStateByPostalCode/';
    this.countrySubUrl = "GetCountry/";
    this.serviceProviderSubUrl = "GetServiceProviderType/";
    this.errorMessage = 'There is an error happened! Technical error: ';
    this.initiateDataSource = function (lookupType, id) {
        var lookupDataSource;
        if (lookupType == 'state') {
            this.completeUrl = this.url + this.stateSubUrl + this.accountGuid;
        } else if (lookupType == 'country') {
            this.completeUrl = this.url + this.countrySubUrl + this.accountGuid;
        } else if (lookupType == 'serviceprovider') {
            this.completeUrl = this.url + this.serviceProviderSubUrl + this.accountGuid;
        } else if (lookupType == 'statebypostalcode') {
            this.completeUrl = this.url + this.stateByPostalCodeSubUrl + id;
        }
        lookupDataSource = new kendo.data.DataSource({
            transport: {
                read: {
                    url: this.completeUrl,
                    dataType: this.dataType
                }
            },
            error: function (e) {
                var msg = this.errorMessage + e.xhr.responseText; // responseText is the custom error message which is being sent from the server side code
                // Show the message to user
                messageModalDialogContent.text(msg);
                messageModalDialog.title("Error");
                messageModalDialog.center();
                messageModalDialogw.open();
            }
        });
        return lookupDataSource;
    };
};

function ChangeInvalidDropDownBorderColor() {
    $('.RegistrationCombobox').parent().find('.k-dropdown-wrap.k-state-default').css('border', "1px solid #dadada");
    $('.RegistrationCombobox.k-invalid').parent().find('.k-dropdown-wrap.k-state-default').css('border', "1px solid #f0898a");
};

function ChangeInvalidListViewBorderColor() {
    $('.ListView.k-widget.k-listview.k-selectable').css('border', "1px solid #dadada");
    
};

function NavModuleClickedStyle(clickedSelectorName) {
    $(clickedSelectorName).click(function (event) {
        var divId = "#" + event.currentTarget.id;
        $(".MenuSelected").attr("class", "Menu");
        $(divId).attr("class", "MenuSelected");
    });
};

//Detect browser
//Browser name: BrowserDetect.browser
//Browser version: BrowserDetect.version
//OS name: BrowserDetect.OS
var BrowserDetect = {
    init: function () {
        this.browser = this.searchString(this.dataBrowser) || "An unknown browser";
        this.version = this.searchVersion(navigator.userAgent)
			|| this.searchVersion(navigator.appVersion)
			|| "an unknown version";
        this.OS = this.searchString(this.dataOS) || "an unknown OS";
    },
    searchString: function (data) {
        for (var i = 0; i < data.length; i++) {
            var dataString = data[i].string;
            var dataProp = data[i].prop;
            this.versionSearchString = data[i].versionSearch || data[i].identity;
            if (dataString) {
                if (dataString.indexOf(data[i].subString) != -1)
                    return data[i].identity;
            }
            else if (dataProp)
                return data[i].identity;
        }
    },
    searchVersion: function (dataString) {
        var index = dataString.indexOf(this.versionSearchString);
        if (index == -1) return;
        return parseFloat(dataString.substring(index + this.versionSearchString.length + 1));
    },
    dataBrowser: [
		{
		    string: navigator.userAgent,
		    subString: "Chrome",
		    identity: "Chrome"
		},
		{
		    string: navigator.userAgent,
		    subString: "OmniWeb",
		    versionSearch: "OmniWeb/",
		    identity: "OmniWeb"
		},
		{
		    string: navigator.vendor,
		    subString: "Apple",
		    identity: "Safari",
		    versionSearch: "Version"
		},
		{
		    prop: window.opera,
		    identity: "Opera",
		    versionSearch: "Version"
		},
		{
		    string: navigator.vendor,
		    subString: "iCab",
		    identity: "iCab"
		},
		{
		    string: navigator.vendor,
		    subString: "KDE",
		    identity: "Konqueror"
		},
		{
		    string: navigator.userAgent,
		    subString: "Firefox",
		    identity: "Firefox"
		},
		{
		    string: navigator.vendor,
		    subString: "Camino",
		    identity: "Camino"
		},
		{		// for newer Netscapes (6+)
		    string: navigator.userAgent,
		    subString: "Netscape",
		    identity: "Netscape"
		},
		{
		    string: navigator.userAgent,
		    subString: "MSIE",
		    identity: "Explorer",
		    versionSearch: "MSIE"
		},
		{
		    string: navigator.userAgent,
		    subString: "Gecko",
		    identity: "Mozilla",
		    versionSearch: "rv"
		},
		{ 		// for older Netscapes (4-)
		    string: navigator.userAgent,
		    subString: "Mozilla",
		    identity: "Netscape",
		    versionSearch: "Mozilla"
		}
    ],
    dataOS: [
		{
		    string: navigator.platform,
		    subString: "Win",
		    identity: "Windows"
		},
		{
		    string: navigator.platform,
		    subString: "Mac",
		    identity: "Mac"
		},
		{
		    string: navigator.userAgent,
		    subString: "iPhone",
		    identity: "iPhone/iPod"
		},
		{
		    string: navigator.platform,
		    subString: "Linux",
		    identity: "Linux"
		}
    ]

};
BrowserDetect.init();

function SetPageDescription(pageDescription) {
    $("#PageDesc").text(pageDescription);
};

function GenerateBreadcrumb(breadCrumbID) {
    $(".BreadCrumbNode").remove();
    $(breadCrumbID).text("");
    //Set default breadcrumb
    var bcStartIdx = window.location.href.indexOf("#", 0) + 1;
    var fullPath = [];

    if (bcStartIdx > 0) {
    	fullPath = window.location.href.substring(bcStartIdx).split('/');
    }

    if (fullPath.length <= 1) {
        $(breadCrumbID).append("<a href='" + window.location.href + "' class='BreadCrumbNode'>Home</a>");
    }
    for (var i = 1; i <= fullPath.length - 1; i++) {
        if (i == fullPath.length - 1) {
            var myString = fullPath[i];
            myString = myString.replace(/([a-z])([A-Z])/g, '$1 $2');
            $(breadCrumbID).append("<a href='" + window.location.href + "' class='BreadCrumbNode'>" + myString + "</a>");
        }
        else {
            var nodePath = "";
            for (var x = 0; x <= i; x++) {
                if (x == i) {
                    nodePath += fullPath[x];
                }
                else {
                    nodePath += fullPath[x] + '/';
                }
            }
            var myString = fullPath[i];
            myString = myString.replace(/([a-z])([A-Z])/g, '$1 $2');
            $(breadCrumbID).append("<a href='#" + nodePath + "' class='BreadCrumbNode'>" + myString + " > </a>");
        }
    }
}

//validation that allow alphanumeric and space
//parameter : formObj, e.g. #RegistrationForm
//            classDefinition, e.g.  "[class=RegInputWithValidation]"
function validateCommonField(formObj, classDefinition) {
    //= $("#RegistrationForm");
    var result = formObj.kendoValidator({
        validateOnBlur: false,
        rules: {
            customRule1: function (input) {
                if (input.is(classDefinition)) {
                    if (input.val() != "") {
                        var stringvalue = input.val();
                        var regex = /^[a-zA-Z0-9'-_\s]+$/; //allow alphabet, numeric and space
                        if (stringvalue.search(regex) == -1) {
                            return false;
                        } else {
                            return true;
                        }
                    }
                }
                return true;
            }
        },
        messages: {
            customRule1: "Use alphabet, numeric or space"
        }
    }).data("kendoValidator");
    return result;
};

function LoadMetaFields(accountGuid, entityName, callback) {
    $.cookie.json = false;
    $.ajax({
        url: 'api/main/GetFieldByEntityID/' + $.cookie('accountGuid') + '/' + entityName,
        type: 'GET',
        contentType: "application/json;charset=utf-8",
        success: callback,
        error: function (x, y, z) {
        	messageModalDialogContent.text('There is an error happened! Technical error: ' + x.responseText);
            messageModalDialog.title("Error");
            messageModalDialog.center();
            messageModalDialog.open();
        }
    });
}

function LoadConfigurationFields(callback) {
    $.cookie.json = false;
    $.ajax({
        url: '/api/configuration/GetConfigurationList',
        type: 'GET',
        contentType: "application/json;charset=utf-8",
        success: callback,
        error: function (x, y, z) {
        	messageModalDialogContent.text('There is an error happened! Technical error: ' + x.responseText);
            messageModalDialog.title("Error");
            messageModalDialog.center();
            messageModalDialog.open();
        }
    });
}

function ChangeGridPopUpButtonText(e, buttonText) {
    //Change the button text from "update" into "save"
    var update = $(e.container).parent().find(".k-grid-update");
    $(update).html('<span class="k-icon k-update"></span>' + buttonText);
};

function SwitchIconsStripOnOff(elementID) {
    var refIndex = window.location.href.indexOf("#");
    if (refIndex <= 0 || window.location.href.indexOf("#/Home") > 0) {
        $(elementID).show();
        var iconStripSplitter = $("#IconsStrip").data("kendoSplitter");
        iconStripSplitter.expand(".k-pane:first");
        var width = $(window).width();
        if (width < 1025) {
            $('#BodyForm').css({ "margin": "225px auto 0px" });
        } else {
            $('#BodyForm').css({ "margin": "330px auto 0px" });
        }
        
    }
    else {
        $(elementID).hide();
        var width = $(window).width();
        if (width < 1025) {
            $('#BodyForm').css({ "margin": "90px 10px 0px" });
        } else {
            $('#BodyForm').css({ "margin": "190px 10px 0px" });
        }
    }
};

String.prototype.replaceAll = function (find, replace) {
    var str = this;
    return str.replace(new RegExp(find.replace(/[-\/\\^$*+?.()|[\]{}]/g, '\\$&'), 'g'), replace);
};

function ApplyPreferencesOnPage(pageName) {
    if(pageName == "Audit"){
        LoadConfigurationFields(function (result) {
            var preferencesData = result;
            for (var i = 0; i < preferencesData.length; i++) {
                if (preferencesData[i].ConfigGroupName == 'General' && preferencesData[i].ConfigName == 'GridRecordCount') {
                    var gridPageSize = preferencesData[i].ConfigValue;
                    gridPageSize = parseInt(gridPageSize, 10);
                    
                    if (document.getElementById("UserAuditGrid") != null) {
                        var userAuditGrid = $("#UserAuditGrid").data("kendoGrid");
                        if (!isNaN(gridPageSize)) {
                            userAuditGrid.dataSource.pageSize(gridPageSize);
                        }
                    }
                    if (document.getElementById("AccountAuditGrid") != null) {
                        var accountAuditGrid = $("#AccountAuditGrid").data("kendoGrid");
                        if (!isNaN(gridPageSize)) {
                            accountAuditGrid.dataSource.pageSize(gridPageSize);
                        }
                    }
                    if (document.getElementById("PatientAuditGrid") != null) {
                        var patientAuditGrid = $("#PatientAuditGrid").data("kendoGrid");
                        if (!isNaN(gridPageSize)) {
                            patientAuditGrid.dataSource.pageSize(gridPageSize);
                        }
                    }
                }
            }
        });
    }
};

function SortGrid(gridId, dsSort) {
    var kendoGrid = $("#" + gridId).data('kendoGrid');
    kendoGrid.dataSource.sort(dsSort);
};

function ChangeInvalidEditorBorderColor() {
    $('.k-content.k-raw-content').parent().find('.k-content').css('border', "1px solid #dadada");
    $('.k-content.k-raw-content.k-invalid').parent().find('.k-content').css('border', "1px solid #f0898a");
};

function ShowPopUpMessage(errorMessageText, errorMessageTitle) {
	messageModalDialogContent.html(errorMessageText);
    messageModalDialog.title(errorMessageTitle);
    messageModalDialog.center();
    messageModalDialog.open();
};

function GetCurrentTime() {
    var currentTime;
    var d = new Date(); // for now
    return currentTime = d.getHours() + ":" + d.getMinutes() + ":" + d.getSeconds();
};

function GetCurrentDate() {
    var currentDate;
    var today = new Date();
    var month = today.getMonth() + 1; //January is 0!
    return currentDate = today.getDate() + "-" + month + "-" + today.getFullYear();
};

function BoundMetadataToGrid(metadata, arrayGridColName) {
    for (var i = 0; i < arrayGridColName.length; i++) {
        for (var x = 0; x < metadata.length; x++) {
            if (arrayGridColName[i].field == metadata[x].FieldName) {
                arrayGridColName[i].title = metadata[x].FieldLabel;
                arrayGridColName[i].headerTemplate = "<span title='" + metadata[x].FieldToolTip + "'>" + metadata[x].FieldLabel + "</span>";
            }
        }
    }
    return arrayGridColName;
};

var templateLoaderByNameAndPath = function (name, path) {
    $.ajax({
        async: false,
        url: path,
        cache: false,
        success: function (result) {
            var vw = new kendo.View(result);
            $("#" + name).append(vw.render());
        },
        error: function (result) {
            alert("Error Loading View/Template");
        }
    });
};

function ApplyGridsRowCheckBox(gridName) {
    ////on dataBound event restore previous selected rows:
    //var view = patientsDummyDataSource.view();
    //for (var i = 0; i < view.length; i++) {
    //    if (checkedIds[view[i].id]) {
    //        this.tbody.find("tr[data-uid='" + view[i].uid + "']")
    //            .addClass("k-state-selected")
    //            .find(".GridRowCheckBox")
    //            .attr("checked", "checked");
    //    }
    //}

    var grid = $("#" + gridName).data("kendoGrid");

    grid.table.on("click", ".GridRowCheckBox", selectRow);
    grid.thead.on("click", ".GridRowHeaderCheckBox", selectHeaderRow);

    function selectRow() {
        var checked = this.checked,
            row = $(this).closest("tr"),
            dataItem = grid.dataItem(row);
        if (checked) {
            //-select the row
            row.addClass("k-state-selected");
        } else {
            //-remove selection
            row.removeClass("k-state-selected");
        }
    };

    function selectHeaderRow() {
        var checked = this.checked;
        grid.tbody.find(".GridRowCheckBox").each(function () {
            var row = $(this).closest("tr");
            var dataItem = grid.dataItem(row);
            if (checked) {
                //-select the row
                row.addClass("k-state-selected");
                $(this).attr("checked", "checked");
            } else {
                //-remove selection
                row.removeClass("k-state-selected");
                $(this).removeAttr('checked');
            }
        });
    };
};

//Below codes for load kendo's Remote Template feature
//Creates a gloabl object called templateLoader with a single method "loadExtTemplate"
var remoteTemplateLoader = (function ($, host) {
    //Loads external templates from path and injects in to page DOM
    return {
        //Method: loadExtTemplate
        //Params: (string) path: the relative path to a file that contains template definition(s)
        loadExtTemplate: function (path, loadedEventName) {
            //Use jQuery Ajax to fetch the template file
            var tmplLoader = $.get(path)
                .success(function (result) {
                    //On success, Add templates to DOM (assumes file only has template definitions)
                    $("body").append(result);
                })
                .error(function (result) {
                    alert("Error Loading Templates -- TODO: Better Error Handling");
                });

            tmplLoader.complete(function () {
                //Publish an event that indicates when a template is done loading
                $(host).trigger(loadedEventName, [path]);
            });
        }
    };
})(jQuery, document);

function LoadTemplateWithCallback(data, filePath, templateId, elementIdTarget, loadedEventName, callback) {
    //Load the template definition from an external file
    remoteTemplateLoader.loadExtTemplate(filePath, loadedEventName);
    //Subscribe to event triggered when templates loaded
    //(Don't load use templates before they are available)
    $(document).bind(loadedEventName, function (e, path) {
        //Compile and cache templates
    	var _itemTemplate = kendo.template($("#" + templateId).html(), { useWithBlock: true });
        //Using the template (assuming "data" is collection loaded elsewhere)
        $("#" + elementIdTarget).html(_itemTemplate(data));
        callback();
    });
};

function LoadTemplate(data, filePath, templateId, loadedEventName, callback) {
    //Load the template definition from an external file
    remoteTemplateLoader.loadExtTemplate(filePath, loadedEventName);
    //Subscribe to event triggered when templates loaded
    //(Don't load use templates before they are available)
    $(document).bind(loadedEventName, function (e, path) {
        //Compile and cache templates
        var _itemTemplate = kendo.template($("#" + templateId).html(), { useWithBlock: true });
        callback(_itemTemplate);
    });
};

function loadScripts(scripts, callback) {
    for (var i = 0; i < scripts.length; i++) {
        var scriptPath = scripts[i];
        var x = 0;
        $.getScript(scriptPath, function (data, textStatus, jqxhr) {
            x = x + 1;
            if(x == scripts.length){
                callback();
            }
        });
    }
};

function loadWindowTemplate(options) {
    var option_template = {
            windowId: null,
            templateId: null,
            viewModel: null
    };
    var opt = $.extend({}, option_template, options);
    var $popup = $("#" + opt.windowId);
    var content = $("#"+ opt.templateId).html();
    var layout = new kendo.Layout(content);
    layout.render($popup);
    kendo.bind($popup, opt.viewModel);
}