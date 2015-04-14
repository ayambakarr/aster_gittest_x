var templateLoader = (function ($, host) {
    return {
        loadExtTemplate: function (path) {
            $.ajax({
                async: false,
                url: path,
                cache: false,
                success: function (result) {
                    $("body").append(result);
                },
                error: function (result) {
                    alert("Error Loading View/Template");
                }
            });
        }
    };
})(jQuery, document);

$(function () {
    var views = {};
    templateLoader.loadExtTemplate("layout.html");
    var layout = new kendo.Layout($('#layout').html());
    layout.render($("#app"));

    var router = new kendo.Router();

    //==Fade animation==
    var addRoute = function (route, name, path, forceRemoteLoad) {
        forceRemoteLoad = typeof forceRemoteLoad !== "undefined" ? forceRemoteLoad : false;
        router.route(route, function () {
            kendo.fx($("#body")).fadeOut().play().then(function () { // transition, slide view left
                var isRemotelyLoaded = false;
                if (views[name] == null || forceRemoteLoad) {   // check if we have already loaded in cache, could store this in browser local storage for larger apps
                    isRemotelyLoaded = true;
                    templateLoader.loadExtTemplate(path); // load the view
                    views[name] = new kendo.View(('#' + name)); // add the view to cache
                }
                layout.showIn("#body", views[name]); // switch view
                $(document).trigger("viewSwtichedEvent", { route: route, name: name, path: path, isRemotelyLoaded: isRemotelyLoaded }); // publish event view has been loaded (EventAggregator pattern)
                kendo.fx($("#body")).fadeIn().play(); // transition, slide view back to the right (center)
            });
        });
    };

    
    addRoute("/(registrationinterest)", "registration", "content/registration/registration.html");
    addRoute("/activationinfo", "activationinfo", "content/registration/activationinfo.html");
    addRoute("/registration2/:id", "registration2", "content/registration/registration2.html");
    addRoute("/registration3", "registration3", "content/registration/registration3.html");
    addRoute("/subscriptionplan", "subscriptionplan", "content/registration/subscriptionplan.html");
    addRoute("/createpassword", "createpassword", "content/registration/createpassword.html");
    addRoute("/creditcard", "creditcard", "content/registration/creditcard.html");
    addRoute("/patient", "patient", "content/patient.html");

    router.start();
});