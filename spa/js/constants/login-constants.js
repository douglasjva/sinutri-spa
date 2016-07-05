(function() {

  function LoginConstants() {

    var constants = {};
    constants.LoadAuthentication = "Verificando Informações";
    constants.FailAuthentication = "CPF ou Senha incorretos";

    return constants;

  }

  constants.constant("LoginConstants", LoginConstants());

})();