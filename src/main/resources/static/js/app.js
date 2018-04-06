var myApp = angular.module('myApp',['ngRoute']);

myApp.config(['$routeProvider','$locationProvider',
        function($routeProvider, $locationProvider) {
          $routeProvider
          	.when('/app', {
              templateUrl: 'templates/app.html',
              controller: 'TodoController'
          	})
            .otherwise({
            	redirectTo: 'app'
            });
          
}]);