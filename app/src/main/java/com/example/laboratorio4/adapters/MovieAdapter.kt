package com.example.laboratorio4.adapters

import android.support.design.internal.BottomNavigationItemView
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import com.example.laboratorio4.model.Movie
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.cardview_movie.view.*


class MovieAdapter(var movies :List<Movie>):RecyclerView.Adapter<MovieAdapter.ViewHolder> {

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): ViewHolder {
        val view=LayoutInflater.from(parent.context).inflate(R.layout.cardview_movie, parent,false)
    }

    override fun getItemCount(): Int =movies.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) =holder.bind(movies(position))
    fun changeList(movies:List<Movie>){
        this.movies=movies
        notifyDataSetChanged()
    }

    class ViewHolder (itemView:View):RecyclerView.ViewHolder(itemView){
        fun bind(movie: Movie) = with(itemView){
            Glide.with(itemView.context)
                    .load(movie.Poster)
                    .placeholder(R.drawable.ic_launcher_background)
                    .into(movie_image_cv)
            movie_title_cv.text= movie.Title
            movie_plot_cv.text=movie.Plot
            movie_rate_cv.text=movie.imdbRating
            movie_runtime_cv.text=movie.Runtime
        }

    }
}