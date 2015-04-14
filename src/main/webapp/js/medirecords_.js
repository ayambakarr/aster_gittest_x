//Define constanta
var LOOKUPTEXT = "LookUpText";
var LOOKUPVALUE = "LookUpValue";
var COUTRYTEXT = "CountryName";
var COUNTRYVALUE = "CountryCode";
var COUNTRY_OPTION_LABEL = "Country*"
var COUNTRY_DEFAULT = "AU"
var LOOKUPGUID = "LookUpGUID";
var ID = "Id";
var LOOKUPVALUE1 = "LookupValue1";
var DOMAINNAME = "noosa";
var MAINAPPURL = 'http://' + DOMAINNAME + ':9292/index.html';

//Define ProgressModalDialog for loading
$("#ProgressModalDialog").dialog({
    dialogClass: "no-close",
    autoOpen: false,
    modal: true
});
//Define MessageModalDialog for Messages
$("#MessageModalDialog").dialog({
    autoOpen: false,
    modal: true,
    buttons: {
        Ok: function () {
            $(this).dialog("close");
        }
    }
});
//Define ProgressModalDialog for loading
$("#ProgressModalDialog").dialog({
    dialogClass: "no-close",
    autoOpen: false,
    modal: true
});
//Define MessageModalDialog for Messages
$("#MessageModalDialog").dialog({
    autoOpen: false,
    modal: true,
    buttons: {
        Ok: function () {
            $(this).dialog("close");
        }
    }
});

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

//set field limit
function SetFieldLimit(){
    $.ajax({
        url: "api/registration/getfieldlimit",
        contentType: "json",
        success: function (data) {
            $.cookie.json = true;
            $.cookie('listOfFieldLimit', data);
            //debugger;
        }
    });
};
SetFieldLimit();
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

function ChangeInvalidDropDownBorderColor() {
    $('.RegistrationCombobox').parent().find('.k-dropdown-wrap.k-state-default').css('border', "1px solid #dadada");
    $('.RegistrationCombobox.k-invalid').parent().find('.k-dropdown-wrap.k-state-default').css('border', "1px solid #f0898a");
};

function SetCheckboxValue(e, checkboxID) {
    if (e.which == 13 || e.which == 32) {
        if ($(checkboxID).is(":checked")) {
            $(checkboxID).prop("checked", false);
        }
        else {
            $(checkboxID).prop("checked", true);
        }
    }
};