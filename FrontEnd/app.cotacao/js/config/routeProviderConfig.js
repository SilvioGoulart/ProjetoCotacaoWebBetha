angular.module("app").config(AppConfig);

AppConfig.$inject = ['$routeProvider'];
function AppConfig($routeProvider) {
$routeProvider
    .when('/', {
        templateUrl: 'home.html',
        controller: 'homeController'
    })
    .when('/produtos', {
        templateUrl: 'views/produtos.html',
        controller: 'produtosController'
    })
    
    .when('/cotacoes', {
        templateUrl: 'views/cotacoes.html',
        controller: 'cotacoesController'
    })
    .otherwise({redirectTo: "/"});
}

