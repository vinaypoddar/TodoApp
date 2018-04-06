angular.module('myApp')
.controller('TodoController', [ '$scope', 'TodoService', function ($scope, TodoService) {
	
	$scope.newTodo = {};
	$scope.statuses = ["All", "Completed", "Pending"];
	$scope.status = "All";
	
	$scope.updateTodoList = function(){
		if($scope.status == "Completed")
			$scope.loadCompletedTodos();
		else if ($scope.status == "Pending")
			$scope.loadPendingTodos();
		else
			$scope.loadTodos();
	}
	
	$scope.loadTodos = function(){
		TodoService.loadTodos().
		success(function(data, status, headers, config) {
			$scope.todos = data;
		 })
		.error(function(data, status, headers, config) {
		      alert('Error loading Todos');
		});
	};
	
	$scope.loadPendingTodos = function(){
		TodoService.loadPendingTodos()
		.success(function(data, status, headers, config) {
			$scope.todos = data;
		 })
		.error(function(data, status, headers, config) {
		      alert('Error loading Todos');
		});
	};
	
	$scope.loadCompletedTodos = function(){
		TodoService.loadCompletedTodos()
		.success(function(data, status, headers, config) {
			$scope.todos = data;
		 })
		.error(function(data, status, headers, config) {
		      alert('Error loading Todos');
		});
	};
	
	$scope.addTodo = function(){
		TodoService.createTodo($scope.newTodo).
		success(function(data, status, headers, config) {
			$scope.newTodo = {};
			$scope.updateTodoList();
		 })
		.error(function(data, status, headers, config) {
		      alert('Error saving Todo');
		});
	};
	
	$scope.deleteTodo = function(todo){
		TodoService.deleteTodo(todo.id).
		success(function(data, status, headers, config) {
			$scope.updateTodoList();
		 })
		.error(function(data, status, headers, config) {
		      alert('Error deleting Todo');
		});
	};
	
	$scope.updateTodoList();
}]);