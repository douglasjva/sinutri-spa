(function() {

  function PatternLoad() {

    var directive = {};
    directive.templateUrl = "templates/directives/pattern-load.html";
    directive.restrict = "E";
    directive.scope = {
    	message: "="
    };

    return directive;

  }

  directives.directive("patternLoad", PatternLoad);

})();