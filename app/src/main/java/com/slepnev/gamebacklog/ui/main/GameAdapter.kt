package com.slepnev.gamebacklog.ui.main

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.slepnev.gamebacklog.R
import com.slepnev.gamebacklog.model.Game
import kotlinx.android.synthetic.main.item_game.view.*
import java.text.SimpleDateFormat
import java.util.*

class GameAdapter(private val games:List<Game>) : RecyclerView.Adapter<GameAdapter.ViewHolder>() {
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


    inner class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        fun bind(game: Game) {
            itemView.tvTitle.text = game.title
            itemView.tvPlatform.text = game.platform
            itemView.tvDate.text = getDateMonthYearString(game.releaseDate)
        }
    }

    private fun getDateMonthYearString(date: Date): String {
        val formatter = SimpleDateFormat("d MMMM yyyy", Locale.ENGLISH)
        return "Release: " + formatter.format(date)
    }
}