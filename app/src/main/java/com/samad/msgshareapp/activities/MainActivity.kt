package com.samad.msgshareapp.activities

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.samad.msgshareapp.Constants
import com.samad.msgshareapp.R
import com.samad.msgshareapp.databinding.ActivityMainBinding
import com.samad.msgshareapp.showToast

private lateinit var binding: ActivityMainBinding

class MainActivity : AppCompatActivity(){

    companion object{
        val TAG: String = MainActivity::class.java.simpleName
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.btnShowToast.setOnClickListener {
            Log.i(TAG, "Button was clicked")
            showToast(getString(R.string.button_was_clicked), Toast.LENGTH_SHORT)
        }

        binding.btnSendMsgToNextActivity.setOnClickListener {
            val message: String = binding.etUserMessage.text.toString()
            val intent = Intent(this, SecondActivity::class.java)
            intent.putExtra(Constants.USER_MSG_KEY,message)
            startActivity(intent)
        }

        binding.btnShareToOtherApps.setOnClickListener {
            val message: String = binding.etUserMessage.text.toString()
            val intent = Intent()
            intent.action = Intent.ACTION_SEND
            intent.putExtra(Intent.EXTRA_TEXT, message)
            intent.type = "text/plain"

            startActivity(Intent.createChooser(intent, "Share to"))
        }

        binding.btnRecyclerViewDemo.setOnClickListener {
            val intent = Intent(this, HobbiesActivity::class.java)
            startActivity(intent)
        }



    }
}