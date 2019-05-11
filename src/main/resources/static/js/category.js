var app = angular.module("myBudget", []);

// Controller Part
app.controller("CategoryController", function($scope, $http) {


    $scope.categories = [];
    $scope.categoryForm = {
        id: "",
        name: "",
        categoryType: ""
    };
    $scope.categoryTypesList = [];

    // Now load the data from server
    _refreshCategoriesData();
    _loadAllLists();

    // HTTP POST/PUT methods for add/edit categoryType
    $scope.submitCategory = function() {

        var method = "";
        var url = "";

        if ($scope.categoryForm.id === "") {
            method = "POST";
            url = '/category';
        } else {
            method = "PUT";
            url = '/category';
        }

        $http({
            method: method,
            url: url,
            data: angular.toJson($scope.categoryForm),
            headers: {
                'Content-Type': 'application/json'
            }
        }).then(_success, _error);
    };

    $scope.createCategory = function() {
        _clearFormData();
    };

    // HTTP DELETE- delete categoryType by Id
    $scope.deleteCategory = function(category) {
        $http({
            method: 'DELETE',
            url: '/category/' + category.id
        }).then(_success, _error);
    };

    // In case of edit
    $scope.editCategory = function(category) {
        $scope.categoryForm.id = category.id;
        $scope.categoryForm.name = category.name;
        $scope.categoryForm.categoryType = $scope.categoryTypesList[getArrIndexByName(category.categoryType.name, $scope.categoryTypesList)];
    };

    // Private Method
    // HTTP GET- get all categoryTypes collection
    function _refreshCategoriesData() {
        $http({
            method: 'GET',
            url: '/categories'
        }).then(
            function(res) { // success
                $scope.categories = res.data;
            },
            function(res) { // error
                console.log("Error: " + res.status + " : " + res.data);
            }
        );
    }

    function _loadAllLists() {
        $http({
            method: 'GET',
            url: '/category-types'
        }).then(
            function(res) { // success
                $scope.categoryTypesList = res.data;
            },
            function(res) { // error
                console.log("Error: " + res.status + " : " + res.data);
            }
        );
    }

    function _success(res) {
        _refreshCategoriesData();
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
        $scope.categoryForm.id = "";
        $scope.categoryForm.name = "";
        $scope.categoryForm.categoryType = "";
    }

    function getArrIndexByName(name, items) {
        for (var i = 0; i< items.length; i++){
            if (items[i].name === name) {
                return i;
            }
        }

        // for(let item in items){
        //     alert(item.name+'-'+index);
        //     // if(item.name === name)
        //     //     alert(item.name.equals(name));
        //     index++;
        //
        // }
    }
});