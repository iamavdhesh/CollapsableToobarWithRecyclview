package app.com.myassignment

import android.content.Context
import android.os.Bundle
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.LinearLayoutManager
import app.com.myassignment.models.BottomItemModel
import kotlinx.android.synthetic.main.activity_main_recycleview.*
import kotlinx.android.synthetic.main.content_recycle.*
import android.nfc.tech.MifareUltralight.PAGE_SIZE
import androidx.recyclerview.widget.RecyclerView




class MainRecycleview : AppCompatActivity() {

    lateinit var mContext: Context;
      lateinit var  bottomLinearLayoutManager: LinearLayoutManager
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val window = window
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
        window.statusBarColor = ContextCompat.getColor(this, R.color.colorPrimary)
        mContext = this;
        bottomLinearLayoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        setContentView(R.layout.activity_main_recycleview)
        setTopAdapter()

        setBottomAdapter()
    }

    private val isLastPage = false
    private val isLoading = false



    private val recyclerViewOnScrollListener = object : RecyclerView.OnScrollListener() {
        override fun onScrollStateChanged(recyclerView: RecyclerView, newState: Int) {
            super.onScrollStateChanged(recyclerView, newState)
        }

        override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
            super.onScrolled(recyclerView, dx, dy)
            val visibleItemCount = bottomLinearLayoutManager.getChildCount()
            val totalItemCount = bottomLinearLayoutManager.getItemCount()
            val firstVisibleItemPosition = bottomLinearLayoutManager.findFirstVisibleItemPosition()

            if (!isLoading && !isLastPage) {
                if (visibleItemCount + firstVisibleItemPosition >= totalItemCount
                    && firstVisibleItemPosition >= 0
                    && totalItemCount >= PAGE_SIZE
                ) {

                    /*TODO actions*/
   // pagination bottom loads code
                }
            }
        }
    }

    private fun setTopAdapter() {
        with(rvTop) {
            var productInfoAdapter = TopAdapter()
            val linearLayoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
            layoutManager = linearLayoutManager
            adapter = productInfoAdapter

        }
    }

    private fun setBottomAdapter() {
        var firstVisibleInListview: Int

        with(rvbottom) {
            val productInfoAdapter = BottomAdapter(getItems(), mContext)
            layoutManager = bottomLinearLayoutManager
            adapter = productInfoAdapter
//            firstVisibleInListview = linearLayoutMager.findFirstVisibleItemPosition()


            productInfoAdapter.setOnClickListner(object :BottomAdapter.OnClickListener{
                override fun onItemClick(item: BottomItemModel, position: Int) {

                    item.itemCheck=!item.itemCheck
                    productInfoAdapter.notifyItemChanged(position)
                }
            })
        }






/*            rvbottom.addOnScrollListener(object : RecyclerView.OnScrollListener() {

                override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                    super.onScrolled(recyclerView, dx, dy)

                    Log.e("onScrolled", "scroll dx Postion DX:" + dx + ", DY:" + dy + "\n")


                    val currentFirstVisible = linearLayoutManager.findFirstVisibleItemPosition()

                   *//* if (currentFirstVisible > firstVisibleInListview) {
                        llTopView.animate().alpha(0f)
                        llTopView.animate().translationY(llTopView.getHeight().toFloat());
                        llTopView.visibility = View.GONE

                        Log.i("RecyclerView scrolled: ", "scroll up!")
                    }; else {
                        llTopView.animate().translationY(0f);
                        llTopView.animate().alpha(1.0f)
                        llTopView.visibility = View.VISIBLE

                        Log.i("RecyclerView scrolled: ", "scroll down!")
                    }*//*

                    firstVisibleInListview = currentFirstVisible

                    if (dy > 0) {

                        System.out.println("Scrolled Downwards");
                        llTopView.animate().alpha(0f)
//                        llTopView.animate().translationY(llTopView.getHeight().toFloat());
                        llTopView.visibility = View.GONE




                    } else if (dy < 0) {
                        System.out.println("Scrolled Upwards");
//                        llTopView.animate().translationY(0f);
                        llTopView.animate().alpha(1.0f)
                        llTopView.visibility = View.VISIBLE

                    } else {
                        System.out.println("No Vertical Scrolled");
                    }


                }

                override fun onScrollStateChanged(recyclerView: RecyclerView, newState: Int) {
                    super.onScrollStateChanged(recyclerView, newState)

                    Log.e("onScrollStateChanged", "scroll changeState, New state:" + newState + "\n")
                }
            })*/;





/*
        nsvVIew.setOnScrollChangeListener(object :NestedScrollView.OnScrollChangeListener{
            override fun onScrollChange(
                v: NestedScrollView?,
                scrollX: Int,
                scrollY: Int,
                oldScrollX: Int,
                oldScrollY: Int
            )
            {
*/
/*
                if (scrollY > 0) {

                    System.out.println("Scrolled Downwards");
                    llTopView.animate().alpha(0f)
//                        llTopView.animate().translationY(llTopView.getHeight().toFloat());
                    llTopView.visibility = View.GONE




                } else if (scrollY < 0) {
                    System.out.println("Scrolled Upwards");
//                        llTopView.animate().translationY(0f);
                    llTopView.animate().alpha(1.0f)
                    llTopView.visibility = View.VISIBLE

                } else {
                    System.out.println("No Vertical Scrolled");
                }
*//*



            }
        })
*/

    }

    private fun getItems(): List<BottomItemModel> {

        var items= arrayListOf<BottomItemModel>()
        for (i in 0..20){
           val model=BottomItemModel()
            items.add(model)

        }
        return  items

    }

}