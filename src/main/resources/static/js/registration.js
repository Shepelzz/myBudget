var app = angular.module("myBudget", []);

// Controller Part
app.controller("registerController", function($scope, $http) {

    $scope.registerForm = {
        lastName: "",
        firstName: "",
        email: "",
        password: "",
        confirmPassword: ""
    };

    $scope.submitRegister = function() {

        let method = "POST";
        let url = "/register";

        debugger;
        $http({
            method: method,
            url: url,
            data: angular.toJson($scope.registerForm),
            headers: {
                'Content-Type': 'application/json'
            }
        }).then(_success, _error);

    };

    function _success(res) {
        window.location.href(window.location.hostname+"/index");
    }

    function _error(res) {
        alert("oshibka blet");

        // let data = res.data;
        // let status = res.status;
        // let header = res.header;
        // let config = res.config;
        // alert("Error: " + status + ":" + data);
    }


});