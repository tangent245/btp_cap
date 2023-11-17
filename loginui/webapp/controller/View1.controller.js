sap.ui.define([
    "sap/ui/core/mvc/Controller",
    "sap/m/MessageToast",
    "sap/ui/model/json/JSONModel",
    "sap/ui/core/BusyIndicator",
    "sap/ui/core/Fragment"
], function (Controller, MessageToast, JSONModel, BusyIndicator, Fragment) {
    "use strict";

    return Controller.extend("loginui.controller.View1", {
        onInit: function () {
            // Initialize your model
            var oModel = new JSONModel({
                username: "",
                password: ""
            });
            this.getView().setModel(oModel, "loginModel");
        },

        onLoginPress: function () {
            var username = this.getView().getModel("loginModel").getProperty("/username");
            var password = this.getView().getModel("loginModel").getProperty("/password");

            // Show BusyIndicator during authentication
            BusyIndicator.show();

            // Make AJAX request to CAP service endpoint
            $.ajax({
                url: "/your-cap-service/validate_user",
                method: "POST",
                contentType: "application/json",
                data: JSON.stringify({ IN_USERNAME: username, IN_PASSWORD: password }),
                success: function (data, textStatus, xhr) {
                    MessageToast.show(data.EX_MESSAGE);
                    // Redirect to the home page or perform other actions based on the response
                },
                error: function (xhr, textStatus, error) {
                    MessageToast.show("Login failed");
                },
                complete: function () {
                    BusyIndicator.hide();
                }
            });
        },

        // Additional functions...

    });
});

