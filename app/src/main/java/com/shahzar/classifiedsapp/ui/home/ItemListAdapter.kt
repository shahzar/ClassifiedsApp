package com.shahzar.classifiedsapp.ui.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.RequestManager
import com.shahzar.classifiedsapp.data.model.response.Product
import com.shahzar.classifiedsapp.databinding.RowItemClassifiedsBinding
import javax.inject.Inject

class ItemListAdapter @Inject constructor(
    private val imageLoader: RequestManager
): RecyclerView.Adapter<ItemListAdapter.ItemViewHolder>() {

    var clicklistener: ((Product) -> Unit)? = null

    var items: List<Product> = arrayListOf()
        set(value) {
            notifyDataSetChanged()
            field = value
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val binding = RowItemClassifiedsBinding.inflate(LayoutInflater.from(parent.context))
        return ItemViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val item = items[position]
        holder.binding.tvProductName.text = item.name
        holder.binding.tvProductPrice.text = item.price
        imageLoader
            .load(item.imageUrls.firstOrNull())
            .into(holder.binding.imgProduct)

        holder.binding.root.setOnClickListener {
            clicklistener?.invoke(item)
        }
    }

    override fun getItemCount() = items.size

    class ItemViewHolder(val binding: RowItemClassifiedsBinding): RecyclerView.ViewHolder(binding.root)

}