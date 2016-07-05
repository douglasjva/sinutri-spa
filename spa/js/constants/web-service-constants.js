(function() {

  function WebServiceConstants() {
    var constants = {};
    constants.WebServiceAddress = "http://localhost:8080/sinutri-ws/"; //empty address forces use proxy

    return constants;
  }

  constants.constant("WebServiceConstants", WebServiceConstants());

})();
