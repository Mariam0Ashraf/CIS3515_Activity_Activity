package edu.temple.activities

import android.os.Bundle
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView

class DisplayActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_display)

        with(findViewById<TextView>(R.id.lyricsDisplayTextView)) {
            val selectedSize = intent.getIntExtra("selectedSize", 16)
            textSize = selectedSize.toFloat()
        }
    }
}
