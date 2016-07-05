(function () {

  function PersonService(WebServiceService) {

    var PERSON_CPF = function (cpfPerson) { return "pessoa/" + cpfPerson; };
    var AUTHENTICATION_PERSON = "pessoa/login";

    var service = {};
    service.getPersonByCpf = getPersonByCpf;
    service.requestAuthentication = requestAuthentication;

    function getPersonByCpf(cpfPerson){
      return WebServiceService.doHttpGet(PERSON_CPF(cpfPerson));
    }

    function requestAuthentication(cpfPerson, passwordPerson){
        return WebServiceService.doHttpPost(AUTHENTICATION_PERSON, {cpf: cpfPerson, password: passwordPerson});
    }

    return service;
  }

  services.service("PersonService", PersonService);

})();