package com.example.plantshandbook

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import com.example.plantshandbook.databinding.ActivityEditBinding

class EditActivity : AppCompatActivity() {
    private lateinit var binding: ActivityEditBinding
    private var index = 0
    private var imageId = R.drawable.flower
    private val imageIdList = listOf(
        R.drawable.flower,
        R.drawable.flower2,
        R.drawable.flower3,
        R.drawable.flower4,
        R.drawable.flower5
    )
    override fun onCreate(savedInstanceState: Bundle?) {
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = "Edit plant"
        binding = ActivityEditBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        binding.imageView.setImageResource(imageId)
        initButtons()
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if(item.itemId == android.R.id.home) finish()
        return true
    }
    private fun initButtons() = with(binding){
        bNext.setOnClickListener {
            index++
            if(index > imageIdList.size - 1) index = 0
            imageId = imageIdList[index]
            imageView.setImageResource(imageId)
        }
        btDone.setOnClickListener {
            val plant = Plant(imageId, edName.text.toString(), edTitle.text.toString())
            val editIntent = Intent().apply {
                putExtra("plant", plant)
            }
            setResult(RESULT_OK, editIntent)
            finish()
        }
    }
}