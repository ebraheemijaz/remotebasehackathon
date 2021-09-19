package com.hackathon.remotebase.challengeswvl.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.hackathon.remotebase.challengeswvl.R
import com.hackathon.remotebase.challengeswvl.models.InterestsDto

class AllInterestsAdapter(private val callback: (InterestsDto) -> Unit) :
    RecyclerView.Adapter<AllInterestsAdapter.ViewAllMoviesViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewAllMoviesViewHolder {

        return ViewAllMoviesViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_interests, parent, false)
        )
    }

    override fun onBindViewHolder(holder: ViewAllMoviesViewHolder, position: Int) {
        val currentItem = differ.currentList[position]

        holder.tvInterestName.text = currentItem.name

        Glide.with(holder.itemView)
            .load(currentItem.image)
            .error(R.drawable.square)
            .into(holder.ivInterest)

        holder.itemView.setOnClickListener {
            callback.invoke(currentItem)
        }
    }

    override fun getItemCount(): Int {
        return differ.currentList.size
    }

    private val differCallBack = object : DiffUtil.ItemCallback<InterestsDto>() {
        override fun areItemsTheSame(
            oldItem: InterestsDto,
            newItem: InterestsDto
        ): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(
            oldItem: InterestsDto,
            newItem: InterestsDto
        ): Boolean {
            return oldItem == newItem
        }
    }

    val differ = AsyncListDiffer(this, differCallBack)

    inner class ViewAllMoviesViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tvInterestName = itemView.findViewById<TextView>(R.id.tvInterestTitle)
        val ivInterest = itemView.findViewById<ImageView>(R.id.ivInterestThumb)

    }
}