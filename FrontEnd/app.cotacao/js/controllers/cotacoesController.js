angular.module("app").controller("cotacoesController", function($scope, cotacoesAPI, produtosAPI) {
   
    $scope.tituloApp = "Lista de Cotações";

    $scope.cotacoes = [];
    var carregaCotacoes = function() {
        cotacoesAPI.getCotacoes()
        .then(function(response) {
            $scope.cotacoes = response.data;
        })
        .catch(function(response) {
            var mensagem = "Deu erro: " + response.status + " - " + response.statusText;
            $scope.mensagemDeErro = mensagem;
        });
    };
   

    $scope.produtos = [];
    var carregaProdutos = function() {
        produtosAPI.getProdutos()
        .then(function(response) {
            $scope.produtos = response.data;
        })
        .catch(function(response) {
            var mensagem = "Deu erro: " + response.status + " - " + response.statusText;
            $scope.mensagemDeErro = mensagem;
        });
    }; 

    


    $scope.adicionarCotacao = function(cotacao) {
        var novoCotacao = angular.copy(cotacao);
        cotacoesAPI.saveCotacao(novoCotacao)
        .then(function(response) {
            delete $scope.cotacao;
            $scope.cotacaoForm.$setPristine();
            carregaCotacoes();
        })
        .catch(function(response) {
            var mensagem = "Deu erro: " + response.status + " - " + response.statusText;
            $scope.mensagemDeErro = !!response.data.mensagem ? response.data.mensagem : mensagem;
        });
    };



    var convertData = function(dataLong){
        if (!dataLong){
            return;
        }
        return new Date(dataLong);
    }

    $scope.ordenarPor = function(nomeDoCampo) {
        $scope.campoParaOrdenacao = nomeDoCampo;
        $scope.direcaoDaOrdenacao = !$scope.direcaoDaOrdenacao;
    };
    carregaCotacoes();
    carregaProdutos();

   
});