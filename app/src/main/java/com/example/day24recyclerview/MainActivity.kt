package com.example.day24recyclerview

import MyAdapter
import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.day24recyclerview.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var myRecyclerView : RecyclerView
    lateinit var binding : ActivityMainBinding
    lateinit var newsArrayList: ArrayList<News>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(binding.main) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        supportActionBar?.hide()
        myRecyclerView = findViewById(R.id.recyclerView)




        var newsImageArray = arrayOf(
            R.drawable.img1,
            R.drawable.img2,
            R.drawable.img3,
            R.drawable.img44,
            R.drawable.img55,
            R.drawable.img66,
            R.drawable.img77,
            R.drawable.img88,
            R.drawable.img999,
            R.drawable.img100
        )

        var newsHeadingArray = arrayOf(
            "1111111111111111111111111111111111111111111",
            "2222222222222222222222222222222222222222222",
            "33333333333333333333333333333333333333333",
            "44444444444444444444444444444444444444444444",
            "555555555555555555555555555555555555555555",
            "6666666666666666666666666666666666666666666",
            "777777777777777777777777777777777777777777777",
            "88888888888888888888888888888888888888888888",
            "99999999999999999999999999999999999999999999",
            "10001101010101010110110101011010100000000000001111110000000000"
        )


        val newsContent = arrayOf(
            getString(R.string.news_content),
            getString(R.string.news_content),
            getString(R.string.news_content),
            getString(R.string.news_content),
            getString(R.string.news_content),
            getString(R.string.news_content),
            getString(R.string.news_content),
            getString(R.string.news_content),
            getString(R.string.news_content),
            getString(R.string.news_content),

        )



        myRecyclerView.layoutManager = LinearLayoutManager(this)
        newsArrayList = arrayListOf<News>()

        for( index in newsImageArray.indices) {
            val news = News(newsHeadingArray[index], newsImageArray[index], newsContent[index])
            newsArrayList.add(news)


        }

            var myAdapter = MyAdapter(newsArrayList, this)
        myRecyclerView.adapter = myAdapter
        myAdapter.setonItemClickListener(object : MyAdapter.onItemClickListener {
            override fun onItemClick(position: Int) {
                val intent = Intent(this@MainActivity , NewsDetailActivity::class.java)
            intent.putExtra("heading" , newsArrayList[position].newsHeading)
            intent.putExtra("imageID" , newsArrayList[position].newsImage)
            intent.putExtra("newscontent" , newsArrayList[position].newsContent)
                startActivity(intent)

            }

        })












    }
}