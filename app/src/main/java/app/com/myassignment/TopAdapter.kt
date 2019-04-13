package app.com.myassignment

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class TopAdapter() : RecyclerView.Adapter<TopAdapter.MyViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {

        val view = LayoutInflater.from(parent?.context).inflate(R.layout.row_top_item, parent, false)

        return MyViewHolder(view)

    }


    class MyViewHolder(mview: View?) : RecyclerView.ViewHolder(mview!!)

    override fun getItemCount(): Int {
        return 20
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {

    }


}
