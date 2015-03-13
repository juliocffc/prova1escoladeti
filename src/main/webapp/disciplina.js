module = angular.module("Prova", []);
module.controller("DisciplinasController", ["$scope","$http", DisciplinasController]);

function DisciplinasController($scope,$http) {
    
    $scope.iniciar = funcaoIniciar;
    $scope.salvar = funcaoSalvar;
    $scope.excluir = funcaoExcluir;
    $scope.editar = funcaoEditar;
    
    $scope.disciplinas = [];
    $scope.disciplina = {};
    $scope.isNovo = true;
    
    funcaoIniciar();
    
    function funcaoEditar(vitima) {
        $scope.disciplina = angular.copy(vitima);
        $scope.isNovo = false;
    }

    
    function funcaoExcluir(vitima) {
        $http.delete("/disciplinas/"+vitima.id).success(onSuccess).error(onError);
        function onSuccess(status) {
            funcaoCarregar();
            $scope.disciplina = {};
            $scope.isNovo = true;
        }
        function onError(status) {
            alert("Deu erro: " + status);
        }
    }
    
    function funcaoSalvar() {
        if ($scope.isNovo){
            $http.post("/disciplinas",$scope.disciplina).success(onSuccess).error(onError);
            function onSuccess(status) {
                funcaoCarregar();
                $scope.disciplina = {};
                $scope.isNovo = true;
            }
            function onError(status) {
                alert("Deu erro: " + status);
            }
        }else{
            
            $http.put("/disciplinas/"+$scope.disciplina.id,$scope.disciplina).success(onSuccess).error(onError);
            function onSuccess() {
                funcaoCarregar();
                $scope.disciplina = {};
                $scope.isNovo = true;
            }
            function onError(status) {
                alert("Deu erro: " + status);
            }
        }
    }
    
    function funcaoCarregar() {
        $http.get("/disciplinas").success(onSuccess).error(onError);
        
        function onSuccess(data, status) {
            $scope.disciplinas = data;       
            console.log(data);
        }
        function onError(data, status) {
            alert("Deu erro: " + data);
        }
    }
    
    function funcaoIniciar() {
        funcaoCarregar();
        console.log(">>> disciplinas carregadas....");
    }
        
}


