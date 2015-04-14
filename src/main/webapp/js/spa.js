﻿var templateLoader = (function ($, host) {
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

    //addRoute("/(home)", "home", "content/home/home.html");
    //addRoute("/home", "home", "content/home/audit.html");
    //addRoute("/(appointments)", "appointments", "content/appointments/appointments.html");
    //addRoute("/activationinfo", "activationinfo", "content/registration/activationinfo.html");
    addRoute("/patient", "patient", "content/patient.html");

    router.start();
});