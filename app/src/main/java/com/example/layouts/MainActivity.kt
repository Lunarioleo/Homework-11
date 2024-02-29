package com.example.layouts



import android.animation.ObjectAnimator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

import com.example.layouts.databinding.ActivityMainBinding

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)



    GlobalScope.launch(Dispatchers.Main) {
        binding.startAnimation.playAnimation()
        binding.startAnimation.repeatCount = 2
        delay(3000)
        binding.startAnimation.visibility = View.INVISIBLE
        binding.secondaryDiv.visibility = View.VISIBLE
        animationSlideUp(binding.secondaryDiv, 1000)
        animationFadeIn(binding.secondaryDiv, 1000)
        animationFadeIn(binding.image, 1500)
    }
    }

     fun animationFadeIn(view: View,   d: Long){
        val a  = ObjectAnimator.ofFloat(view, View.ALPHA, 0.0f, 1.0f)
        a.duration = d
        a.start()
    }

     fun animationSlideUp(view: View, d: Long){
        val a  = ObjectAnimator.ofFloat(view, View.TRANSLATION_X, -700f, 0f)
        a.duration = 500
        a.start()
    }
}


