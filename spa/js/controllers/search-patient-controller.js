(function() {

  function SearchPatientController($scope, UserService, SearchPatientConstants) {

    init();

    function init() {
      $scope.loadUserPatients = loadUserPatients; 
      $scope.valueSearch = "";
      $scope.tryAgain =  tryAgain;
    }

    function successLoadUserPatients(response) {
      enableSucess();
      console.log(response);
      $scope.users = response;
    }

    function failLoadUserPatients(error) {
      enableError();
    }

    function tryAgain(){
      enableLoading();
      loadUserPatients();
    }

    function loadUserPatients() {
      enableLoading();
      UserService.getUserByCpfOrName($scope.valueSearch).then(successLoadUserPatients, failLoadUserPatients);
    }

    function enableLoading(){
      $scope.loadingMessage = SearchPatientConstants.LoadUserPatients;
      $scope.isError = false;
      $scope.isLoading = true;
      $scope.isSuccess = false;
    }

    function enableError(){
      $scope.errorMessage = SearchPatientConstants.FailLoadUserPatients;
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

  controllers.controller("SearchPatientController", SearchPatientController);

})();
