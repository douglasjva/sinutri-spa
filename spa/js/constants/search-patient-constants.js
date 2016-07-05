(function() {

  function SearchPatientConstants() {

    var constants = {};
	constants.LoadUserPatients = "Buscando por paciente(s)";
	constants.FailLoadUserPatients = "Ocorreu um problema ao buscar por paciente(s)";
    return constants;

  }

  constants.constant("SearchPatientConstants", SearchPatientConstants());

})();