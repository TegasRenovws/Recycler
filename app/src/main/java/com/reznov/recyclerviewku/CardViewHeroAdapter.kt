package com.reznov.recyclerviewku

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import kotlinx.android.synthetic.main.item_cardview_hero.view.*
import kotlinx.android.synthetic.main.item_row_hero.view.*
import kotlinx.android.synthetic.main.item_row_hero.view.img_item_photo
import kotlinx.android.synthetic.main.item_row_hero.view.tv_item_description
import kotlinx.android.synthetic.main.item_row_hero.view.tv_item_name

class CardViewHeroAdapter(private val listHero: ArrayList<Hero>) : RecyclerView.Adapter<CardViewHeroAdapter.CardViewHolder>() {
    inner class CardViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        fun bind(hero: Hero){
            with(itemView){
                Glide.with(itemView.context)
                    .load(hero.photo)
                    .apply(RequestOptions().override(350,550))
                    .into(img_item_photo)

                tv_item_name.text = hero.name
                tv_item_description.text = hero.description

                btn_set_suka.setOnClickListener{Toast.makeText(itemView.context, "Disukai ${hero.name}",Toast.LENGTH_SHORT).show()}

                btn_set_bagikan.setOnClickListener{Toast.makeText(itemView.context, "Bagikan ${hero.name}", Toast.LENGTH_SHORT).show()}

                itemView.setOnClickListener{Toast.makeText(itemView.context, "Pick ${hero.name}", Toast.LENGTH_SHORT).show()}
            }
        }
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): CardViewHolder {
        val view = LayoutInflater.from(viewGroup.context).inflate(R.layout.item_cardview_hero, viewGroup, false)
        return CardViewHolder(view)
    }

    override fun getItemCount(): Int = listHero.size

    override fun onBindViewHolder(holder: CardViewHolder, position: Int) {
        holder.bind(listHero[position])
    }
}