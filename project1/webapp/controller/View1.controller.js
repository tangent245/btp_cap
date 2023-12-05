sap.ui.define([
    "sap/ui/core/mvc/Controller",
    "project1/model/URLConstants",
    "sap/ui/model/json/JSONModel"
], function (Controller, URLConstants, JSONModel) {
    "use strict";
 
    return Controller.extend("project1.controller.View1", {
        onInit: function () {
            this.getAll();
            // this.byid();
           
        },
 
       
       
        getAll: async function () {
            try {
                // Update the data path based on your requirement
                var path = URLConstants.URL.UserData; // Use the desired data path
                let obj = await this.restMethodGet(path);
                this.getView().setModel(new JSONModel(obj), "userDataMdl");
            } catch (e) {
                console.error("Error getting UserData:", e);
            }
        },
        // byid: async function () {
        //     try {
        //         // Update the data path based on your requirement
        //         var path = URLConstants.URL.getbyid; // Use the desired data path
        //         let obj = await this.restMethodGet(path);
        //         this.getView().setModel(new JSONModel(obj), "userDataMdl");
        //     } catch (e) {
        //         console.error("Error getting UserData:", e);
        //     }
       
        restMethodGet: function (url) {
            url = URLConstants.URL.app_endPoint + url;
            var deferred = $.Deferred();
 
            $.ajax({
                type: "GET",
                url: url,
                contentType: "application/json",
                success: function (response) {
                    deferred.resolve(response);
                },
                error: function (xhr) {
                    deferred.reject(xhr);
                }
            });
            return deferred.promise();
        }
       
    });
});
 
