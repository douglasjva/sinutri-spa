(function() {

  function PatternError() {

    var directive = {};
    directive.templateUrl = "templates/directives/pattern-error.html";
    directive.restrict = "E";
    directive.scope = {
    	message: "=",
      action: "="
    };

    return directive;

  }

  directives.directive("patternError", PatternError);

})();