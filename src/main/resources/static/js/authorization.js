var app = angular.module("myBudget", []);

// Controller Part
app.controller("authController", function($scope, $http) {

    $scope.authForm = {
        login: "",
        password: ""
    };

    $scope.submitAuth = function() {

        let method = "POST";
        let url = "/login";

        if ($scope.authForm.login === "") {
            alert("error");
        } else {
            $http({
                method: method,
                url: url,
                data: angular.toJson($scope.authForm),
                headers: {
                    'Content-Type': 'application/json'
                }
            }).then(_success, _error);
        }
    };

    function _success(res) {
        window.location.reload(true);
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