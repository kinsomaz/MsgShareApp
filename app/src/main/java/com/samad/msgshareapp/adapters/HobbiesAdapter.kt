package com.samad.msgshareapp.adapters

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.samad.msgshareapp.activities.MainActivity
import com.samad.msgshareapp.databinding.ListItemBinding
import com.samad.msgshareapp.models.Hobby
import com.samad.msgshareapp.showToast

private lateinit var binding: ListItemBinding

class HobbiesAdapter(val context: Context, private val hobbies: List<Hobby>) : RecyclerView.Adapter<HobbiesAdapter.MyViewHolder>() {

    companion object{
        val TAG: String = MainActivity::class.java.simpleName
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
      binding = ListItemBinding.inflate(LayoutInflater.from(context), parent,false)
        val view = binding.root
        return MyViewHolder(view)
    }

    override fun getItemCount(): Int {
        return hobbies.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val hobby = hobbies[position]
        holder.setData(hobby, position)
    }

    inner class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var currentHobby: Hobby? = null
        var currentPosition: Int = 0

        init {
            binding.root.setOnClickListener {
                currentHobby?.let {
                    context.showToast(currentHobby!!.title + " Clicked !")
                }
            }
            binding.imgShare.setOnClickListener {

                currentHobby?.let {
                    val message: String = "My hobby is: " + currentHobby!!.title
                    val intent = Intent()
                    intent.action = Intent.ACTION_SEND
                    intent.putExtra(Intent.EXTRA_TEXT, message)
                    intent.type = "text/plain"

                    context.startActivity(Intent.createChooser(intent,"Share to"))

                }
            }
        }

        fun setData(hobby: Hobby?, pos: Int){
            hobby?.let {
                binding.txtTitle.text = hobby.title
            }

            this.currentHobby = hobby
            this.currentPosition = pos
        }
    }
}