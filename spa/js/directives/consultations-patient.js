(function() {

  function ConsultationsPatient() {

    var directive = {};
    directive.templateUrl = "templates/directives/consultations-patient.html";
    directive.restrict = "E";
    directive.scope = {
    	consultations: "="
    };

    return directive;
  }

  directives.directive("consultationsPatient", ConsultationsPatient);

})();