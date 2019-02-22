angular.module("app").factory("produtosAPI", function($http, configAPI) {
    var _getProdutos = function() {
        return $http.get(configAPI.resourceProdutos);
    };

    var _getDescricao = function() {
        return $http.get(configAPI.resourceProdutos);
    };

    var _saveProduto = function(produto) {
        if (!!produto.idProduto) {
            return $http.put(configAPI.resourceProdutos,produto)
        }
        return $http.post(configAPI.resourceProdutos,produto);
    };

    var _saveDescricao = function(descricao) {
        if (!!produto.idProduto) {
            return $http.put(configAPI.resourceProdutos,descricao)
        }
        return $http.post(configAPI.resourceProdutos,descricao);
    };

    var _removeProduto = function(produtoParaRemover) {
        var url = configAPI.resourceProdutos + "/" + produtoParaRemover.idProduto;
        return $http.delete(url);
    }

    var _removeDescricao = function(descricaoParaRemover) {
        var url = configAPI.resourceProdutos + "/" + descricaoParaRemover.idProduto;
        return $http.delete(url);
    }

    return {
        getProdutos: _getProdutos,
        getDescricao: _getDescricao,
        saveProduto: _saveProduto,
        saveDescricao: _saveDescricao,
        removeProduto: _removeProduto,
        removeDescricao: _removeDescricao
    };
});