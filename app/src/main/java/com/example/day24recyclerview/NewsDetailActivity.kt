package com.example.day24recyclerview

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.day24recyclerview.databinding.ActivityNewsDetailBinding

class NewsDetailActivity : AppCompatActivity() {
    lateinit var binding: ActivityNewsDetailBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityNewsDetailBinding.inflate(layoutInflater)
        enableEdgeToEdge()
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(binding.main) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }


        val heading = intent.getStringExtra("heading")
        val imageId = intent.getIntExtra("imageID" , R.drawable.img77)
        val newsContent = intent.getStringExtra("newscontent")

        binding.newsHeading.text = heading
        binding.newsContent.text = newsContent
        binding.newsImage.setImageResource(imageId)















    }
}