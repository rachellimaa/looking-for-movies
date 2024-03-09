package com.rachellima.movies.adapter

import android.text.Html
import android.text.Spanned
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.text.HtmlCompat
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.rachellima.listmovies.R
import com.rachellima.listmovies.databinding.MoviesCatalogItemBinding
import com.rachellima.models.Search

class MoviesAdapter(
    private val searchList: List<Search>
) : RecyclerView.Adapter<RecyclerView.ViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return MoviesCatalogHolder(
            MoviesCatalogItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int = searchList.size

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (holder is MoviesCatalogHolder) {
            holder.bind(searchList[position])
        }
    }

    inner class MoviesCatalogHolder(private val binding: MoviesCatalogItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind (item: Search) = with(binding) {
            val context = binding.root.context
            titleItem.text = context.getString(R.string.id_title_movies_catalog_item, item.imdbID, item.Title).parseAsHtml()
            subtitleItem.text = context.getString(R.string.type_year_movies_catalog_item, item.Type, item.Year).parseAsHtml()
            imgItem.load(item.Poster){
                crossfade(true)
                placeholder(R.drawable.baseline_image_search_24)
            }
        }
    }

     private fun String.parseAsHtml(
        flags: Int = HtmlCompat.FROM_HTML_MODE_LEGACY,
        imageGetter: Html.ImageGetter? = null,
        tagHandler: Html.TagHandler? = null
    ): Spanned = HtmlCompat.fromHtml(this, flags, imageGetter, tagHandler)
}