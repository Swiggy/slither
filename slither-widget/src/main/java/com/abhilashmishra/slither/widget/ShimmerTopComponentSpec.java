package com.abhilashmishra.slither.widget;

import android.graphics.Color;

import com.facebook.litho.ComponentContext;
import com.facebook.litho.ComponentLayout;
import com.facebook.litho.Size;
import com.facebook.litho.annotations.MountSpec;
import com.facebook.litho.annotations.OnCreateMountContent;
import com.facebook.litho.annotations.OnMeasure;
import com.facebook.litho.annotations.OnMount;
import com.facebook.litho.annotations.OnUnmount;
import com.facebook.litho.annotations.Prop;
import com.facebook.litho.utils.MeasureUtils;
import com.facebook.shimmer.Shimmer;
import com.facebook.shimmer.ShimmerFrameLayout;

@MountSpec
class ShimmerTopComponentSpec {

    @OnMeasure
    static void onMeasure(
            ComponentContext c, ComponentLayout layout, int widthSpec, int heightSpec, Size size) {
        MeasureUtils.measureWithEqualDimens(widthSpec, heightSpec, size);
    }

    @OnCreateMountContent
    static ShimmerFrameLayout onCreateMountContent(ComponentContext c) {
        ShimmerFrameLayout plainShimmerLayout = new ShimmerFrameLayout(c.getBaseContext());
        plainShimmerLayout.setBackgroundColor(Color.parseColor("#ffffff"));
        return plainShimmerLayout;

    }

    @OnMount
    static void onMount(
            ComponentContext context,
            ShimmerFrameLayout shimmerLayout,
            @Prop Shimmer shimmer) {
        shimmerLayout.setShimmer(shimmer).startShimmer();
    }

    @OnUnmount
    static void onUnmount(
            ComponentContext context,
            ShimmerFrameLayout shimmerLayout) {
        shimmerLayout.stopShimmer();
    }
}
