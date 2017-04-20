/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

angular.module('monApp', ['ngRoute', 'ngResource']);

angular.module('monApp').config(['$routeProvider', function routeConfig($routeProvider) {
        $routeProvider
                .when('/admissions', {
                    controller: "AdmissionsController as ctrl",
                    templateUrl: 'listeAdmissions.html'
                })
                .when('/admission/:iep', {
                    controller: "AdmissionController as ctrl",
                    templateUrl: 'admission.html'
                })
                .when('/home', {
                    controller: "HomeController as ctrl",
                    templateUrl: 'home.html'
                })
                .when('/newActe', {
                    controller: "NewActeController as ctrl",
                    templateUrl: 'newActe.html'
                })
                .otherwise({redirectTo: '/home'});
    }]);

