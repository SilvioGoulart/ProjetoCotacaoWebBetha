angular.module("app").controller("produtosController", function($scope, produtosAPI) {

    $scope.tituloApp = "Lista de Produtos";
    $scope.produtos = [];

    var carregarProdutos = function() {
        produtosAPI.getProdutos()
        .then(function(response) {
            $scope.produtos = response.data;
        })
        .catch(function(response) {
            var mensagem = "Deu erro: " + response.status + " - " + response.statusText;
            $scope.mensagemDeErro = !!response.data.mensagem ? response.data.mensagem : mensagem;
        });
    };

    $scope.adicionarProduto = function(produto) {
        var novoProduto = angular.copy(produto);
        produtosAPI.saveProduto(novoProduto)
        .then(function(response) {
            delete $scope.produto;
            $scope.produtoForm.$setPristine();
            carregarProdutos();
        })
        .catch(function(response) {
            var mensagem = "Deu erro: " + response.status + " - " + response.statusText;
            $scope.mensagemDeErro = !!response.data.mensagem ? response.data.mensagem : mensagem;
        });
    };

    $scope.carregarDescricao = [];
    var carregarDescricao = function() {
        produtosAPI.getProdutos()
        .then(function(response) {
            $scope.descricao = response.data;
        })
        .catch(function(response) {
            var mensagem = "Deu erro: " + response.status + " - " + response.statusText;
            $scope.mensagemDeErro = !!response.data.mensagem ? response.data.mensagem : mensagem;
        });
    };

    $scope.carregarUnidade = [];
    var carregarUnidade = function() {
        produtosAPI.getProdutos()
        .then(function(response) {
            $scope.unidade = response.data;
        })
        .catch(function(response) {
            var mensagem = "Deu erro: " + response.status + " - " + response.statusText;
            $scope.mensagemDeErro = !!response.data.mensagem ? response.data.mensagem : mensagem;
        });
    };

    $scope.removerProduto = function(produtoParaRemover) {
        if(!confirm('Deseja realmente excluir?')) { 
            return; 
        };
        produtosAPI.removeProduto(produtoParaRemover)
        .then(function(response) {
            carregarProdutos();
        })
        .catch(function(response) {
            var mensagem = "Não é possível remover um item que está em cotação. " + response.status + " - " + response.statusText;
            $scope.mensagemDeErro = !!response.data.mensagem ? response.data.mensagem : mensagem;
        });
    };
    $scope.editarProduto = function(produtoParaEditar) {
        $scope.produto = angular.copy(produtoParaEditar);
    };
    $scope.temProdutoSelecionado = function(produtos) {
        return produtos.some(function(item) {
            return item.selecionado;
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
    carregarProdutos();
    carregarDescricao();
    carregarUnidade();
    
});