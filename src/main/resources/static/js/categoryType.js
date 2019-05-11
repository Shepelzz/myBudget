var app = angular.module("myBudget", []);

// Controller Part
app.controller("CategoryTypeController", function($scope, $http) {


    $scope.categoryTypes = [];
    $scope.categoryTypeForm = {
        id: "",
        name: ""
    };

    // Now load the data from server
    _refreshCategoryTypesData();

    // HTTP POST/PUT methods for add/edit categoryType
    // Call: http://localhost:8080/category-type
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

    $scope.createCategoryType = function() {
        _clearFormData();
    };

    // HTTP DELETE- delete categoryType by Id
    // Call: http://localhost:8080/category-type/{categoryTypeId}
    $scope.deleteCategoryType = function(categoryType) {
        $http({
            method: 'DELETE',
            url: '/category-type/' + categoryType.id
        }).then(_success, _error);
    };

    // In case of edit
    $scope.editCategoryType = function(categoryType) {
        $scope.categoryTypeForm.id = categoryType.id;
        $scope.categoryTypeForm.name = categoryType.name;
    };

    // Private Method
    // HTTP GET- get all categoryTypes collection
    // Call: http://localhost:8080/category-types
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
        _clearFormData();
    }

    function _error(res) {
        var data = res.data;
        var status = res.status;
        var header = res.header;
        var config = res.config;
        alert("Error: " + status + ":" + data);
    }

    // Clear the form
    function _clearFormData() {
        $scope.categoryTypeForm.id = "";
        $scope.categoryTypeForm.name = ""
    }
});