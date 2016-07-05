(function() {

  function HistoryPatientController($scope, PersonService, HistoryPatientConstants) {

    init();

    function init() {
      enableLoading();
      loadHistory();
      $scope.tryAgain =  tryAgain;
    }

    function successLoadHistory(response) {
      enableSucess();
      $scope.person = response.data;
      $scope.person.sexo = ($scope.person.sexo == "M") ? "Masculino":"Feminino";
    }

    function failLoadHistory(error) {
      enableError();
    }

    function tryAgain(){
      enableLoading();
      loadHistory();
    }

    function loadHistory() {
      PersonService.getPersonByCpf("05786631397").then(successLoadHistory, failLoadHistory);
    }

    function enableLoading(){
      $scope.loadingMessage = HistoryPatientConstants.LoadHistory;
      $scope.isError = false;
      $scope.isLoading = true;
      $scope.isSuccess = false;
    }

    function enableError(){
      $scope.errorMessage = HistoryPatientConstants.FailLoadHistory;
      $scope.isError = true;
      $scope.isLoading = false;
      $scope.isSuccess = false;
    }

    function enableSucess(){
      $scope.isError = false;
      $scope.isLoading = false;
      $scope.isSuccess = true;
    }

  }

  controllers.controller("HistoryPatientController", HistoryPatientController);

})();
