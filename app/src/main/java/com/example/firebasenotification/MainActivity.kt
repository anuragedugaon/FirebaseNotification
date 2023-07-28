package com.example.firebasenotification

import android.annotation.SuppressLint
import android.content.ContentValues
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.ListView
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.messaging.FirebaseMessaging
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class MainActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



       var title=findViewById<EditText>(R.id.title)
       var descreiption=findViewById<EditText>(R.id.description)
      var  button=findViewById<Button>(R.id.sendNotification)



        FirebaseMessaging.getInstance().token.addOnSuccessListener {
            Log.d("Anurag", it.toString())

            val user = hashMapOf(
                "first" to "Ada",
                "last" to "Lovelace",
                "born" to toString()
            )

// Add a new document with a generated ID
            FirebaseFirestore.getInstance().collection("user")
                .add(user)
                .addOnSuccessListener { documentReference ->
                    Log.d(ContentValues.TAG, "DocumentSnapshot added with ID: ${documentReference.id}")
                }
                .addOnFailureListener { e ->
                    Log.w(ContentValues.TAG, "Error adding document", e)
                }
        }


//        val tokenList: List<String> =
//            mutableListOf("dE75ZiW-QVSrmDhdTTsviW:APA91bEY2jmdmoPUcAUHa0hTtsUOEySFc2h9EutHW-j1XWeUTw7WJtJMACFjlNW2fTWbxZmZBV56LqXEEzAQBTBt4gquj0G2lYNazGGvZX30xYdWm9qyh76KG7sjLiBq9MgPxHw4_68e"
//                )
//        val headerMap =
//            hashMapOf<String, String>("Authorization" to "key=AAAA1X66nTM:APA91bHYXWQWtxRQYZIw_1RztZqpMaHpbyvVul8PNRKrsuw_JkAGUP5H1NBuX9XxR8qoHnN0ggYZK9T7l2_A_J5C0OryXj-OmCMi6MRg20A_X6oE-7OiCFZVFN9eLmSa5TFfcysFvVBt")
//
//
//
//        button.setOnClickListener{
//
//            val notificationData = NotificationData(
//                Notification(
//                    "notofication",
//                    title.text.toString(),
//                    true,
//                    descreiption.text.toString()
//                ), tokenList
//            )
//            ApiCalling.Create().send(headerMap, notificationData)
//                .subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe {
//                    val notification = it
//                }
//
//        }


    }

}
