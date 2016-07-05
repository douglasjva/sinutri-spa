(function() {

  function AppController($scope) {

    init();

    function init() {
    	initMenuConfig();
    }

    function initMenuConfig(){
    	$(document).ready(function(){
            $('.dropdown-button').dropdown({
			      constrain_width: false
			    }
			  );
        });
    }

  }

  controllers.controller("AppController", AppController);

})();
