var myApp = angular.module('myApp');

myApp.factory('TodoService', function($http){
	return {
		loadTodos : function(){
			return $http.get('todos');
		},
		loadPendingTodos : function(){
			return $http.get('todos/pending');
		},
		loadCompletedTodos : function(){
			return $http.get('todos/completed');
		},
		createTodo: function(todo){
			return $http.post('todos',todo);
		},		
		deleteTodo: function(id){
			return $http.delete('todos/'+id);
		}
	}
});