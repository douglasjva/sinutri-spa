(function() {

  function HistoryPatientConstants() {

    var constants = {};
    constants.LoadHistory = "Carregando histórico do paciente";
    constants.FailLoadHistory = "Ocorreu um problema ao carregar o histórico do paciente";

    return constants;

  }

  constants.constant("HistoryPatientConstants", HistoryPatientConstants());

})();