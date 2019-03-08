package com.abhilashmishra.slither

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.abhilashmishra.slither.widget.Slither
import com.facebook.litho.ComponentContext
import com.facebook.litho.LithoView
import com.facebook.litho.widget.Image
import com.facebook.shimmer.Shimmer
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        createLithoView();

    }

    private fun createLithoView() {
        val componentContext = ComponentContext(this)

        val newComponent =
            Slither.create(componentContext)
                .component(
                    Image.create(componentContext)
                        .drawableRes(R.drawable.slither_logo)
                        .build()
                )
                .shimmer(
                    Shimmer
                        .AlphaHighlightBuilder()
                        .setBaseAlpha(0.4f)
                        .setClipToChildren(true)
                        .setDropoff(0.8f)
                        .setTilt(15f)
                        .setDuration(2000).build()
                ).build()

        val lithoView = LithoView.create(componentContext, newComponent)
        root.addView(lithoView)
    }
}
