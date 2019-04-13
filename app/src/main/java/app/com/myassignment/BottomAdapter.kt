package app.com.myassignment

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import app.com.myassignment.models.BottomItemModel

class BottomAdapter(
    val items: List<BottomItemModel>,
    val mContext: Context
) : RecyclerView.Adapter<BottomAdapter.MyViewHolder>() {

    var nClickListener: OnClickListener? = null

    fun setOnClickListner(listner: OnClickListener) {
        nClickListener = listner
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {

        val view = LayoutInflater.from(parent?.context).inflate(R.layout.row_bottom_item, parent, false)

        return MyViewHolder(view)

    }


    interface OnClickListener {
        fun onItemClick(item: BottomItemModel, position: Int);
    }

    inner class MyViewHolder(mview: View?) : RecyclerView.ViewHolder(mview!!), View.OnClickListener {
        override fun onClick(p0: View?) {

            if (nClickListener != null) {
                nClickListener?.onItemClick(items.get(adapterPosition), adapterPosition)
            }

        }

        var imageTick = mview?.findViewById<ImageView>(R.id.imageTick)

        init {
            imageTick?.setOnClickListener(this)
        }
    }

    override fun getItemCount(): Int {
        return items?.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {


        holder.imageTick?.setImageDrawable(
            ContextCompat.getDrawable(
                mContext,
                if (items.get(position).itemCheck) R.drawable.tick_icon else R.drawable.ic_circle
            )
        )


    }


}
