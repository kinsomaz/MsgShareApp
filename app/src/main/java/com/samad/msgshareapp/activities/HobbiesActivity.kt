package com.samad.msgshareapp.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.samad.msgshareapp.adapters.HobbiesAdapter
import com.samad.msgshareapp.databinding.ActivityHobbiesBinding
import com.samad.msgshareapp.models.Hobby

private lateinit var binding: ActivityHobbiesBinding

class HobbiesActivity: AppCompatActivity() {

    companion object{
        val TAG: String = HobbiesActivity::class.java.simpleName
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHobbiesBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        setupRecyclerView()

    }

    private fun setupRecyclerView() {
        val layoutManager = LinearLayoutManager(this)
        layoutManager.orientation = LinearLayoutManager.VERTICAL
        binding.txvTitle.layoutManager = layoutManager


        val adapter = HobbiesAdapter(this, Hobby.Supplier.hobbies)
        binding.txvTitle.adapter = adapter

    }
}