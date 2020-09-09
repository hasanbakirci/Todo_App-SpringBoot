import 'dart:convert';
import 'package:http/http.dart' as http;
import 'package:todoapp/core/model/todo.dart';
import 'dart:async';

class ApiService {
  Future<List<Todo>> getTodo() async {
    var response = await http.get("http://192.168.0.104:8080/api/todolists/");
    if (response.statusCode == 200) {
      // return Todo.fromJson(json.decode(response.body));
      return (json.decode(response.body) as List)
          .map((e) => Todo.fromJson(e))
          .toList();
    } else {
      throw Exception("Bağlanamadık ${response.statusCode}");
    }
  }

  Future<Todo> addTodo(String todoJson) async {
    var response = await http.post("http://192.168.0.104:8080/api/add",
        headers: {'content-type': 'application/json'}, body: todoJson);
  }
}
