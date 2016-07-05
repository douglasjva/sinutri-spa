(function () {

  function WebServiceService($http, WebServiceConstants) {

    var service = {};
    service.doHttpGet = doHttpGet;
    service.doHttpPost = doHttpPost;
    service.doHttpDelete = doHttpDelete
    service.doHttpPut = doHttpPut;

    function doHttpGet(path) {
      return $http.get(buildUrl(path));
    }

    function doHttpPost(path, data) {
      return $http.post(buildUrl(path), data);
    }

    function doHttpDelete(path) {
      return $http.delete(buildUrl(path));
    }

    function doHttpPut(path, data) {
      return $http.put(buildUrl(path), data);
    }

    /**
    * This function build a full URL to request and valid Plim WS adrress.
    * @param {String} path The suffix URL. Will be appended to base URL.
    * @return {String} a full URL to Plim WS (base URL + path).
    */
    function buildUrl(path) {
      var url;
      if (path.indexOf("http") != 0) {
        url = WebServiceConstants.WebServiceAddress + path;
      } else {
        url = path;
      }
      return url;
    }

    return service;

  }

  services.service("WebServiceService", WebServiceService);

})();
