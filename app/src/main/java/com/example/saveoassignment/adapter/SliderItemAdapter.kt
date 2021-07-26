package com.example.saveoassignment.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import com.example.saveoassignment.R
import com.example.saveoassignment.data.model.MoviesResponseItem
import com.example.saveoassignment.utils.ItemClickListener
import com.example.saveoassignment.viewholder.SliderItemViewHolder

class SliderItemAdapter(
    val viewPagerList: MutableList<MoviesResponseItem?>?,
    val viewPager: ViewPager2,
    val itemClickListener: ItemClickListener,
) : RecyclerView.Adapter<SliderItemViewHolder>() {



    /*
    Inflates the layout and sends it to the view holders constructor.
     */

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SliderItemViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.movies_slide_item_layout, parent, false)
        return SliderItemViewHolder(view,itemClickListener)
    }


    /*

Binds the movies data with the view holder

 */
    override fun onBindViewHolder(holder: SliderItemViewHolder, position: Int) {
        var moviesResponseItem = viewPagerList?.get(position)
        if (moviesResponseItem != null) {
            holder.setData(moviesResponseItem)

        }
    }

    /*

   checks the list of data and returns the size
    */

    override fun getItemCount(): Int {
        return viewPagerList?.size!!
    }

}