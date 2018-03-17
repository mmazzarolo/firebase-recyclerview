
## Disclaimer: This repo is not mainained anymore  

# Firebase Recyclerview <img src="https://github.com/mmazzarolo/firebase-recyclerview/blob/master/extras/firebase-recyclerview-logo.png" width="90" align="left"> 
##### *Easily link your RecyclerView to a Firebase location.*
&nbsp;  
&nbsp;  
A generic way of backing an Android RecyclerView with a Firebase location.
- It handles all of the child events at the given Firebase location.
- It marshals received data into the given class type.
- Simplifies the management of configuration change (e.g.: device rotation) allowing the restoring of the list.
  
#### Installation
No modules, just copy [FirebaseRecyclerAdapter](https://github.com/mmazzarolo/firebase-recycleview/blob/master/app/src/main/java/com/example/matteo/firebase_recycleview/FirebaseRecyclerAdapter.java) in your project and extend it.
  
#### Usage
Create an adapter class extending FirebaseRecyclerAdapter and exposing a Viewholder and the Model of the Firebase childs:
`public class MyAdapter extends FirebaseRecyclerAdapter<MyAdapter.ViewHolder, MyItem>` (example [here](https://github.com/mmazzarolo/firebase-recycleview/blob/master/app/src/main/java/com/example/matteo/firebase_recycleview/MyAdapter.java)).
  
FirebaseRecyclerAdapter constructor takes two parameters:
- `query`: The Firebase location to watch for data changes
- `itemClass `: The class of the items (childs)
  
FirebaseRecyclerAdapter will handle the item list (listening from a Firebase location) and you can handle the view logic in your new adapter where you must:
- Declare a constructor that calls `super(params...)` with the default FirebaseRecyclerAdapter constructor parameters.
- Override `onCreateViewHolder` and `onBindViewHolder` and handle your viewholder logic here like a classic adapter (in `onBindViewHolder` you can get the item with the `getItem(int position)` method of FirebaseRecyclerAdapter, e.g.:`MyItem item = getItem(position)`.
- Implement the abstract methods `itemAdded`, `itemChanged`, `itemRemoved`, `itemMoved` that will notify you when the list changes.
  
Create your adapter just like you always do and pass the interested parameter to its constructor:
`mMyAdapter = new MyAdapter(mQuery, MyItem.class);`
  
You're done!
  
> Remember to call `MyAdapter.destroy` before destroying the adapter to remove the Firebase location listener!
  
#### Handling configurations changes
If you're interested in device rotation handling you should:
- Save FirebaseRecyclerAdapter `mItems` and `mKeys` before destroying the adapter: just put them in a onSavedInstance Bundle (be careful, your must declare the item/child class model as `Parcelable`). You can get them with `getItems()` and `getKeys()`.
- Call `MyAdapter.destroy` before destroying the adapter.
- Re-create the adapter (after the device rotation) passing the saved `mItems` and `mKeys` to the second constructor: `mMyAdapter = new MyAdapter(mQuery, MyItem.class, mAdapterItems, mAdapterKeys);`.
  
#### Example
[Here](https://github.com/mmazzarolo/firebase-recycleview/tree/master/app/src/main/java/com/example/matteo/firebase_recycleview) is a working example where I handled device rotation (I used [Parceler](https://github.com/johncarl81/parceler) to make myItem parcelable).

#### Thanks to...
Thanks to [FirebaseListAdapter](https://github.com/firebase/AndroidChat/blob/master/app/src/main/java/com/firebase/androidchat/FirebaseListAdapter.java) for the starting idea.
