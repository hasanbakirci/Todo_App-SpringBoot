import 'dart:convert';

class Todo {
  int id;
  String message;

  Todo({this.id, this.message});

  Todo.fromJson(Map<String, dynamic> json) {
    id = json['id'];
    message = json['message'];
  }

  String toJson() {
    final Map<String, dynamic> data = new Map<String, dynamic>();
    data['id'] = this.id;
    data['message'] = this.message;
    return json.encode(data);
  }
}
