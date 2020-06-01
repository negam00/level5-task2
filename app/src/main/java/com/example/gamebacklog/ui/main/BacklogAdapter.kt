package com.example.gamebacklog.ui.main

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.gamebacklog.R
import com.example.gamebacklog.model.Game
import kotlinx.android.synthetic.main.item_game.view.*
import java.text.SimpleDateFormat
import java.util.*

class BacklogAdapter(private val games: List<Game>) :
    RecyclerView.Adapter<BacklogAdapter.ViewHolder>() {

    private val cal by lazy { Calendar.getInstance() }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(game: Game) {

            val sdf = SimpleDateFormat("d MMMM yy", Locale.UK)
            val formattedDate =sdf.format(game.releaseDate)

            itemView.tvGameTitle.text = game.title
            itemView.tvGamePlatform.text = game.platform
            itemView.tvGameReleaseDate.text =
                itemView.context.getString(R.string.release_date, formattedDate)
        }
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_game, parent, false)
        )
    }

    override fun getItemCount(): Int {
        return games.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(games[position])
    }
}