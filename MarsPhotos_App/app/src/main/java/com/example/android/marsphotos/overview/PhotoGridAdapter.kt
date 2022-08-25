package com.example.android.marsphotos.overview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.android.marsphotos.R
import com.example.android.marsphotos.databinding.GridViewItemBinding
import com.example.android.marsphotos.network.MarsPhoto


class PhotoGridAdapter :
    ListAdapter<MarsPhoto, PhotoGridAdapter.MarsPhotoViewHolder>(DiffCallBack) {

    inner class MarsPhotoViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val binding = GridViewItemBinding.bind(view)
        fun bind(photos: MarsPhoto) {
            binding.photos = photos
            binding.executePendingBindings()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MarsPhotoViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.grid_view_item, parent, false)
        return MarsPhotoViewHolder(view)
    }

    override fun onBindViewHolder(holder: MarsPhotoViewHolder, position: Int) {
        val pos = getItem(position)
        holder.bind(pos)
    }

    companion object DiffCallBack : DiffUtil.ItemCallback<MarsPhoto>() {
        override fun areItemsTheSame(oldItem: MarsPhoto, newItem: MarsPhoto): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: MarsPhoto, newItem: MarsPhoto): Boolean {
            return oldItem.img_src == newItem.img_src
        }

    }
}
