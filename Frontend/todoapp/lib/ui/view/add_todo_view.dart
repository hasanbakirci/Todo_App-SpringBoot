import 'package:flutter/material.dart';
import 'package:todoapp/core/api_service.dart';
import 'package:todoapp/core/model/todo.dart';
import 'dart:async';

class AddTodoView extends StatefulWidget {
  AddTodoView({Key key}) : super(key: key);

  @override
  _AddTodoViewState createState() => _AddTodoViewState();
}

class _AddTodoViewState extends State<AddTodoView> {
  ApiService apiService = new ApiService();
  GlobalKey<FormState> formKey = GlobalKey(debugLabel: "formKey");
  TextEditingController controller = TextEditingController();
  @override
  Widget build(BuildContext context) {
    return Scaffold(
      body: Form(
        autovalidate: true,
        key: formKey,
        child: Center(
          child: Padding(
            padding: const EdgeInsets.all(10.0),
            child: Column(
              mainAxisAlignment: MainAxisAlignment.center,
              children: <Widget>[
                TextFormField(
                  controller: controller,
                  decoration: InputDecoration(
                      border: OutlineInputBorder(),
                      labelText: "Todo Name",
                      hasFloatingPlaceholder: true),
                  validator: (value) {
                    if (value.isEmpty) {
                      return "Boş değer kabul edilemez";
                    }
                    return null;
                  },
                ),
                RaisedButton.icon(
                  icon: Icon(Icons.send),
                  label: Text("Add"),
                  onPressed: () {
                    var todo = Todo(message: controller.text.toString());
                    apiService.addTodo(todo.toJson());
                    Navigator.pop(context);
                  },
                  shape: StadiumBorder(),
                )
              ],
            ),
          ),
        ),
      ),
    );
  }
}
