(function() {

  function InformationPatient() {

    var directive = {};
    directive.templateUrl = "templates/directives/information-patient.html";
    directive.restrict = "E";
    directive.scope = {
    	person: "="
    };

    return directive;
  }

  directives.directive("informationPatient", InformationPatient);

})();