package edu.temple.activities

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val textSizes = Array(20) { (it + 1) * 5 }
        Log.d("Array values", textSizes.contentToString())

        with(findViewById<RecyclerView>(R.id.textSizeSelectorRecyclerView)) {
            adapter = TextSizeAdapter(textSizes) { selectedSize ->
                val intent = Intent(this@MainActivity, DisplayActivity::class.java)
                intent.putExtra("selectedSize", selectedSize)
                startActivity(intent)
            }
            layoutManager = LinearLayoutManager(this@MainActivity)
        }
    }
}

class TextSizeAdapter(private val textSizes: Array<Int>, private val callback: (Int) -> Unit) :
    RecyclerView.Adapter<TextSizeAdapter.TextSizeViewHolder>() {

    inner class TextSizeViewHolder(val textView: TextView) : RecyclerView.ViewHolder(textView) {
        init {
            textView.setOnClickListener {
                callback(textSizes[adapterPosition])
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TextSizeViewHolder {
        return TextSizeViewHolder(TextView(parent.context).apply { setPadding(5, 20, 0, 20) })
    }

    override fun onBindViewHolder(holder: TextSizeViewHolder, position: Int) {
        holder.textView.apply {
            text = textSizes[position].toString()
            textSize = textSizes[position].toFloat()
        }
    }

    override fun getItemCount(): Int {
        return textSizes.size
    }
}
