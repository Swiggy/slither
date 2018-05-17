package com.abhilashmishra.slither

import android.graphics.Typeface.BOLD
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.abhilashmishra.slither.widget.Slither
import com.facebook.litho.ComponentContext
import com.facebook.litho.LithoView
import com.facebook.litho.widget.Text
import com.facebook.shimmer.Shimmer
import com.facebook.yoga.YogaAlign
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        createLithoView();

    }

    private fun createLithoView() {
        val componentContext = ComponentContext(this)
        val component =
                Slither.create(componentContext)
                        .heightDip(200f)
                        .widthDip(200f)
                        .component(
                                Text.create(componentContext)
                                        .alignSelf(YogaAlign.CENTER)
                                        .text("Slither Text")
                                        .textStyle(BOLD)
                                        .textSizeSp(20f)
                        )
                        .shimmer(
                                Shimmer
                                        .AlphaHighlightBuilder()
                                        .setBaseAlpha(0.4f)
                                        .setDropoff(0.5f)
                                        .setTilt(0f)
                                        .setDuration(2000).build())
                        .build()

        val lithoView = LithoView.create(componentContext, component)
        root.addView(lithoView)
    }
}
