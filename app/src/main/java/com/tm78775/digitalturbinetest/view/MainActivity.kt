package com.tm78775.digitalturbinetest.view

import android.animation.Animator
import android.animation.AnimatorListenerAdapter
import android.os.Bundle
import android.view.View
import android.widget.ProgressBar
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProviders
import com.tm78775.digitalturbinetest.R

class MainActivity : AppCompatActivity(), ProgressBarInterface {

    // region Variables

    private lateinit var progressBar: ProgressBar
    private val progressBarAnimDuration: Long = 400

    // endregion

    // region Lifecycle Methods

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        progressBar = findViewById(R.id.progressBar)
    }

    // endregion

    // region UI Methods

    override fun showProgressBar(show: Boolean) {
        when(show) {
            true -> {
                progressBar.apply {
                    alpha = 0f
                    visibility = View.VISIBLE

                    animate()
                        .alpha(1f)
                        .setListener(object : AnimatorListenerAdapter() {
                            override fun onAnimationEnd(animation: Animator?) {
                                super.onAnimationEnd(animation)
                                visibility = View.VISIBLE
                                alpha = 1f
                            }
                        })
                        .duration = progressBarAnimDuration
                }
            }
            false -> {
                progressBar.animate()
                    .alpha(0f)
                    .setListener(object : AnimatorListenerAdapter() {
                        override fun onAnimationEnd(animation: Animator?) {
                            super.onAnimationEnd(animation)
                            progressBar.alpha = 0f
                        }
                    })
                    .duration = progressBarAnimDuration
            }
        }
    }

    // endregion

}
