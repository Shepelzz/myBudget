var app = angular.module("myBudget", []);

// Controller Part
app.controller("homeController", function($scope, $http) {


    $scope.incomingItems = [
        {
            category: {
                id: 1,
                name: "Зарплатка"
            },
            plSum: 2000,
            fcSum: 2000,
            diff: 0
        },
        {
            category: {
                id: 2,
                name: "Подарили"
            },
            plSum: 0,
            fcSum: 41000,
            diff: 41000
        }
    ];
    $scope.outgoingItems = [
        {
            category: {
                id: 3,
                name: "Коммуналка"
            },
            plSum: 2000,
            fcSum: 1600,
            diff: -400
        }
    ];
    $scope.incomingItem = {
        category: "",
        plSum: "",
        fcSum: "",
        diff: ""
    };
    $scope.outgoingItem = {
        category: "",
        plSum: "",
        fcSum: "",
        diff: ""
    };

    _refreshCategoryTypesData();

    $scope.submitCategoryType = function() {

        var method = "";
        var url = "";

        if ($scope.categoryTypeForm.id === "") {
            method = "POST";
            url = '/category-type';
        } else {
            method = "PUT";
            url = '/category-type';
        }


        $http({
            method: method,
            url: url,
            data: angular.toJson($scope.categoryTypeForm),
            headers: {
                'Content-Type': 'application/json'
            }
        }).then(_success, _error);
    };


    $scope.deleteCategoryType = function(categoryType) {
        $http({
            method: 'DELETE',
            url: '/category-type/' + categoryType.id
        }).then(_success, _error);
    };

    $scope.editCategoryType = function(categoryType) {
        $scope.categoryTypeForm.id = categoryType.id;
        $scope.categoryTypeForm.name = categoryType.name;
    };

    function _refreshCategoryTypesData() {
        $http({
            method: 'GET',
            url: '/category-types'
        }).then(
            function(res) { // success
                $scope.categoryTypes = res.data;
            },
            function(res) { // error
                console.log("Error: " + res.status + " : " + res.data);
            }
        );
    }

    function _success(res) {
        _refreshCategoryTypesData();
    }

    function _error(res) {
        var data = res.data;
        var status = res.status;
        var header = res.header;
        var config = res.config;
        alert("Error: " + status + ":" + data);
    }

});