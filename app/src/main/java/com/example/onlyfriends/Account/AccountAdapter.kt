package com.example.onlyfriends.Account

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.example.onlyfriends.R
import com.example.onlyfriends.databinding.CellAccountBinding
import com.squareup.picasso.Picasso

class AccountAdapter(): RecyclerView.Adapter<AccountAdapter.AccountViewHolder>() {
    class AccountViewHolder(binding: CellAccountBinding): RecyclerView.ViewHolder(binding.root) {
        val imgLeft: ImageView = binding.letftPicture
        val imgCenter: ImageView = binding.centerPicture
        val imgRight: ImageView = binding.rightPicture
        val layout: CardView = binding.root
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AccountViewHolder {
        val binding = CellAccountBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return AccountViewHolder(binding)
    }

    override fun onBindViewHolder(holder: AccountViewHolder, position: Int) {

    }

    override fun getItemCount(): Int {
        TODO("Not yet implemented")
    }
}