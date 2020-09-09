import 'package:flutter/material.dart';

class CustomCard extends StatelessWidget {
  final int id;
  final String message;

  const CustomCard({Key key, this.id, this.message}) : super(key: key);
  @override
  Widget build(BuildContext context) {
    return dismiss(Card(
      elevation: 20,
      child: Container(
        width: double.infinity,
        height: 75,
        child: Text(
          this.message,
          textAlign: TextAlign.center,
        ),
      ),
    ));
  }

  Widget dismiss(Widget child) {
    return Dismissible(
      key: UniqueKey(),
      child: child,
      background: Container(
        color: Colors.grey[300],
      ),
      secondaryBackground: Center(
        child: Text("Delete"),
      ),
      onDismissed: (direction) {},
    );
  }
}
