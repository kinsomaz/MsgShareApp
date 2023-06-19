package com.samad.msgshareapp.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.samad.msgshareapp.Constants
import com.samad.msgshareapp.databinding.ActivitySecondBinding
import com.samad.msgshareapp.showToast

private lateinit var binding: ActivitySecondBinding

class SecondActivity : AppCompatActivity() {

    companion object{
        val TAG: String = SecondActivity::class.java.simpleName
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySecondBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        val bundle: Bundle? = intent.extras

        bundle?.let {
            val msg = bundle.getString(Constants.USER_MSG_KEY).toString()

            showToast(msg)

            binding.txvUserMessage.text = msg
        }
    }
}