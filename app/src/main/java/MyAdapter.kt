import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.day24recyclerview.News
import com.example.day24recyclerview.R
import com.google.android.material.imageview.ShapeableImageView

class MyAdapter(var newsArrayList: ArrayList<News>, var context : Activity) :
    RecyclerView.Adapter<MyAdapter.MyViewHolder>() {

        lateinit var myListener: onItemClickListener

        interface onItemClickListener {
            fun onItemClick(position: Int)
        }

        fun setonItemClickListener(Listener: onItemClickListener){
            myListener = Listener
        }

    // to create new view instance
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyAdapter.MyViewHolder {
            val itemView = LayoutInflater.from(parent.context).inflate(R.layout.each_row, parent, false)
        return MyViewHolder(itemView, myListener)
    }

    override fun onBindViewHolder(holder: MyAdapter.MyViewHolder, position: Int) {
        var currentItem = newsArrayList[position]
        holder.headingTitle.text = currentItem.newsHeading
        holder.headingimage.setImageResource(currentItem.newsImage)

    }

    // how many list items are present in your Array
    override fun getItemCount(): Int {
        return newsArrayList.size

    }


    // it holds the view so views are not created everytime, so memory can be saved
    class MyViewHolder(itemView : View, Listener: onItemClickListener) : RecyclerView.ViewHolder(itemView){
        val headingTitle = itemView.findViewById<TextView>(R.id.tvheading)
        val headingimage = itemView.findViewById<ShapeableImageView>(R.id.Headingimg)

        init {
            itemView.setOnClickListener {
                Listener.onItemClick(adapterPosition)

            }
        }


    }




}




