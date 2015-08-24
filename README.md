# firebase-recycleview

A generic way of backing an Android RecyclerView with a Firebase location.
- It handles all of the child events at the given Firebase location.
- It marshals received data into the given class type.
- Simplifies the management of configuration change (e.g.: device rotation) allowing the restore of the list.
- Extend [this](https://github.com/mmazzarolo/firebase-recycleview/blob/master/app/src/main/java/com/example/matteo/firebase_recycleview/FirebaseRecyclerAdapter.java) class and provide an implementation of the abstract methods, which will notify you when the adapter list changes.

##### Usage
To-do

Thanks to [FirebaseListAdapter](https://github.com/firebase/AndroidChat/blob/master/app/src/main/java/com/firebase/androidchat/FirebaseListAdapter.java) for the base of development.
