(function() {

  function LoginController($scope, $state, PersonService, LoginConstants) {

    init();

    function init() {
      $scope.cpf = "";
      $scope.password = "";
      $scope.requestAuthentication = requestAuthentication;
    }

    function successAuthentication(response) {
      $state.go("app");
    }

    function failAuthentication(error) {
      enableError(LoginConstants.FailAuthentication);
    }

    function requestAuthentication() {
      enableLoading();
      console.log("CPF "+$scope.cpf+" password "+$scope.password);
      PersonService.requestAuthentication($scope.cpf, $scope.password).then(successAuthentication, failAuthentication);
    }

    function enableLoading(){
      $scope.loadingMessage = LoginConstants.LoadAuthentication;
      $scope.isError = false;
      $scope.isLoading = true;
    }

    function enableError(message){
      $scope.errorMessage = message;
      $scope.isError = true;
      $scope.isLoading = false;
    }

  }

  controllers.controller("LoginController", LoginController);

})();
