package com.evgeny_m.dragimageview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MotionEvent
import android.widget.ImageView
import com.evgeny_m.dragimageview.databinding.ActivityMainBinding
import kotlin.properties.Delegates

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var imageView: ImageView

    private var x by Delegates.notNull<Float>()
    private var y by Delegates.notNull<Float>()
    private var dx by Delegates.notNull<Float>()
    private var dy by Delegates.notNull<Float>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        imageView = binding.imageView
    }

    override fun onTouchEvent(event: MotionEvent?): Boolean {

        if (event?.action == MotionEvent.ACTION_DOWN) {
            x = event.x
            y = event.y
        }

        if (event?.action == MotionEvent.ACTION_MOVE) {
            dx = event.x - x
            dy = event.y - y

            imageView.x = imageView.x + dx
            imageView.y = imageView.y + dy

            x = event.x
            y = event.y
        }

        return super.onTouchEvent(event)

    }
}