var app = angular.module('app', []);

app.factory('StreetService', ['$http', '$location', function ($http, $location) {
        var StreetService = {};
        function getAbsUrl(relativepath) {
            return $location.protocol() + '://' + $location.host() + ':' + $location.port() + relativepath;
        }

        StreetService.getStreetSpec = function (data) {
            var url = getAbsUrl("/streetspecification");
            var config = {
                headers: {
                    'Content-Type': undefined
                }
            };
            var ret = $http.post(url, data, config);
            return ret;
        }

        StreetService.getDeliveryApproach = function (deliveryapprach, data) {
            var url = getAbsUrl('/' + deliveryapprach);
            var config = {
                headers: {
                    'Content-Type': undefined
                }
            };
            return $http.post(url, data, config);
        }

        return StreetService;
    }]);


app.controller('StreetController', function ($scope, $http, $location, StreetService) {
    $scope.getDeliveryApproach = function () {
        if($scope.streetspec.length > 0) {
            var data = new FormData();
            data.append("streetSpec", $scope.streetspec);
            StreetService.getDeliveryApproach($scope.deliveryapproach, data)
                    .then(function (response) {
                        var deliveryApproach = response.data;
                        $scope.printDeliveryApproachResults(deliveryApproach);
                    }, function error(response) {
                        $scope.deliveryApproachResult = "Error calling service " + response.config.url + ": " + response.statusText;
                    })
        }
    }

    $scope.printDeliveryApproachResults = function (deliveryApproach) {
        var result = deliveryApproach.approachName + '\n';
        result = result + 'Delivery order is ' + deliveryApproach.deliveryOrder + '\n';
        result = result + 'Delivery person wil cross the street ' + deliveryApproach.numberOfStreetCrossings + ' times.\n';
        $scope.deliveryApproachResult = result;
    }

    $scope.printStreetResults = function (street) {
        var result;
        if(street.valid) {
            result = 'Street specification is valid.\n';
            result = result + 'There are ' + street.houseNumbers.length.toString() + ' houses on the street.\n';
            result = result + 'There are ' + street.northHouseNumbers.length.toString() + ' houses in the north.\n';
            result = result + 'There are ' + street.southHouseNumbers.length.toString() + ' houses in the south.\n';
        } else {
            result = 'Street specification is not valid.\n';
        }
        $scope.streetSpecResult = result;
    }
    
    $scope.submitForm = function () {
        $scope.streetSpecResult = "";
        $scope.deliveryApproachResult = "";
        var data = new FormData();
        data.append("streetSpec", $scope.streetspec);
        StreetService.getStreetSpec(data)
                .then(function (response) {
                    var street = response.data;
                    $scope.printStreetResults(street);
                    if (street.valid) {
                        $scope.getDeliveryApproach();
                    }
                }, function error(response) {
                    $scope.streetSpecResult = "Error calling service " + response.config.url + ": " + response.statusText;
                })
    }
    
    $scope.uploadFile = function(element) {
        var fileToLoad = element.files[0];
        if(fileToLoad) {
            $scope.fileName = fileToLoad.name;
            $scope.$apply();
            var reader = new FileReader();
            reader.onload = function (fileLoadedEvent) {
                //var lines = fileLoadedEvent.target.result.split("\n");
                const file = fileLoadedEvent.target.result;
                const lines = file.split(/\r\n|\n/);
                if(lines.length > 0) {
                    $scope.streetspec = lines[0];
                    $scope.submitForm();
                }
            };
            reader.readAsText(fileToLoad, 'UTF-8');
        }
    }
});
