package com.example.intents



import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val button = findViewById<Button>(R.id.buttonintents)
        val button1 = findViewById<Button>(R.id.btnwhats)
        val button2 = findViewById<Button>(R.id.btntelefono)
        val button3 = findViewById<Button>(R.id.btnEmail)

        button.setOnClickListener { share() }
        button1.setOnClickListener { whatsapp() }
        button2.setOnClickListener { telefonollamada() }
        button3.setOnClickListener { intentEmail() }

    }

    private fun share() {
        val sendIntent = Intent()
        sendIntent.action = Intent.ACTION_SEND
        sendIntent.putExtra(Intent.EXTRA_TEXT, "This is my text to send.")
        sendIntent.type = "text/plain"
        startActivity(sendIntent)
    }

    private fun whatsapp(){
        val msj = "Mi mensaje es abcdef 1234567890"
        val numeroTel = "+524434749747"
        val intent = Intent(Intent.ACTION_VIEW)
        val uri = "whatsapp://send?phone=$numeroTel&text=$msj"
        intent.data = Uri.parse(uri)
        startActivity(intent)
    }

    private fun telefonollamada(){
        val phoneNumber = "4434749747"
        val call = Uri.parse("tel:$phoneNumber")
        val intent2 = Intent(Intent.ACTION_DIAL, call)
        startActivity(intent2)
    }

    private fun intentEmail(){
        val email = Intent(Intent.ACTION_VIEW)

            email.data=Uri.parse("mailto:your.email@gmail.com")
            email.setPackage("com.google.android.gm")
            email.putExtra(Intent.EXTRA_EMAIL, "your.email@gmail.com")
            email.putExtra(Intent.EXTRA_SUBJECT, "Subject")
            email.putExtra(Intent.EXTRA_TEXT, "My Email message")

        startActivity(email)

        //cualquier correo
//        val email = Intent(Intent.ACTION_SENDTO)
//        email.data = Uri.parse("mailto:your.eamil@gmail.com")
//        email.putExtra(Intent.EXTRA_SUBJECT, "Subject")
//        email.putExtra(Intent.EXTRA_TEXT, "My Email message")
//        startActivity(email)

    }


}