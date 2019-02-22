angular.module("app").factory("cotacoesAPI", function($http, configAPI) {

    var _getCotacoes = function(cotacao) {
        return $http.get(configAPI.resourceCotacoes);
    };

    var _saveCotacao = function(cotacao) {
        return $http.post(configAPI.resourceCotacoes,cotacao);
    };

   

    return {
        getCotacoes: _getCotacoes,
        saveCotacao: _saveCotacao,
        
    };
});