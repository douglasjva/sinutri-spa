
/**
* The above global variables are visibale to each component (controllers, services...)
* adds it self to them. E.g: controllers.controller('ExController', ExControllerDef)
*/
var constants = angular.module("constants", []);
var controllers = angular.module("controllers", []);
var directives = angular.module("directives", []);
var factories = angular.module("factories", []);
var services = angular.module("services", []);

angular.module("sinutri-spa", [
  /**
  * Libraries modules dependencies
  */
  "ui.router",

  /**
  * Our modules  dependencies
  */
  "constants", "controllers", "directives", "factories", "services"
])

/**
* Main function
*/
.run(function() {

})

/**
* States configuration
*/
.config(function($stateProvider, $urlRouterProvider) {

  /**
  * The above code shows how to add an state and state part.
  *
  * $stateProvider
  *  .state("stateName", {
  *    url: "stateUrl/"
  *    templateUrl: "templates/state.html",
  *    controller: "ControllerName"
  *  })
  *  .state("stateName.part", {
  *    url: "statePartUrl/"
  *    views: {
  *       "content": {
  *         templateUrl: "templates/state/part.html",
  *         controller: "ControllerPartName"
  *       }
  *     }
  *  })
  */

  $stateProvider

    .state("login", {
      url: "/login",
      templateUrl: "templates/login.html",
      controller: "LoginController"
    })

    .state("app", {
      url: "/app",
      templateUrl: "templates/app.html",
      controller: "AppController"
    })

    .state("app.searchPatient", {
      url: "^/search",
      views: {
        "main": {
          templateUrl: "templates/search-patient.html",
          controller: "SearchPatientController"
        }
      }
      
    })

    .state("app.history", {
      url: "^/history",
      views: {
        "main": {
          templateUrl: "templates/history-patient.html",
          controller: "HistoryPatientController"
        }
      }
    });

  $urlRouterProvider.otherwise("/login");

});

/**
Criar uma directiva para ultimas consultas e informações do paciente.

No controller de histórico por exemplo, eu chamo a diretiva consulta e passo para o scopo dela a 
lista de ultimas consultas, então o controller da diretiva pode trabalhar em cima dessa lista de consultas
 passa para o escopo da diretiva
*/