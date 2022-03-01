package com.example.onlyfriends.Account

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.example.onlyfriends.Network.Image
import com.example.onlyfriends.R
import com.example.onlyfriends.databinding.CellAccountBinding
import com.squareup.picasso.Picasso

class AccountAdapter(val items: List<Image>): RecyclerView.Adapter<AccountAdapter.AccountViewHolder>() {
    class AccountViewHolder(binding: CellAccountBinding): RecyclerView.ViewHolder(binding.root) {
        val imgLeft: ImageView = binding.letftPicture
        val layout: CardView = binding.root
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AccountViewHolder {
        val binding = CellAccountBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return AccountViewHolder(binding)
    }

    override fun onBindViewHolder(holder: AccountViewHolder, position: Int) {
        val item = items[position]
        Picasso.get()
            .load(item.getUrl())
            .placeholder(R.drawable.logo)
            .into(holder.imgLeft)



    }

    override fun getItemCount(): Int {
        return items.size
    }
}