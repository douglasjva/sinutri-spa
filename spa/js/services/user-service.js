(function () {

  function UserService(WebServiceService) {

    var USER_CPF_NAME = function (cpfOrName) { return "usuario/" + cpfOrName; };

    var service = {};
    service.getUserByCpfOrName = getUserByCpfOrName;
    

    function getUserByCpfOrName(cpfOrName){
      return WebServiceService.doHttpGet(USER_CPF_NAME(cpfOrName));
    }

    return service;
  }

  services.service("UserService", UserService);

})();