package com.pdi.jsonplaceholdermvp.presenter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.pdi.jsonplaceholdermvp.R
import com.pdi.jsonplaceholdermvp.model.local.Photo
import com.squareup.picasso.Picasso

class RecyclerPhotosAdapter(photoList: List<Photo>) : RecyclerView.Adapter<RecyclerPhotosAdapter.PhotosViewHolder>() {

    private var listPhotos = photoList.toMutableList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PhotosViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(
            R.layout.photo_item,
            parent,
            false
        )
        return PhotosViewHolder(view)
    }

    override fun onBindViewHolder(holder: PhotosViewHolder, position: Int) {
        val photo = listPhotos[position]
        holder.bind(photo)
    }

    override fun getItemCount(): Int = listPhotos.size

    fun updatePhotos(photoList: List<Photo>) {
        listPhotos = photoList.toMutableList()
        notifyDataSetChanged()
    }

    inner class PhotosViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        private var image = view.findViewById<ImageView>(R.id.imagePhoto)
        private var id = view.findViewById<TextView>(R.id.idPhoto)
        private var title = view.findViewById<TextView>(R.id.titlePhoto)

        fun bind(photo: Photo) {
            Picasso.get().load(photo.url).into(image)

            id.text = photo.id.toString()
            title.text = photo.title
        }
    }

}