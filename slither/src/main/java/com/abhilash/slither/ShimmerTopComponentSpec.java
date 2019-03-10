package com.abhilash.slither;

import android.content.Context;

import com.facebook.litho.Component;
import com.facebook.litho.ComponentContext;
import com.facebook.litho.ComponentLayout;
import com.facebook.litho.Size;
import com.facebook.litho.annotations.MountSpec;
import com.facebook.litho.annotations.OnCreateMountContent;
import com.facebook.litho.annotations.OnMeasure;
import com.facebook.litho.annotations.OnMount;
import com.facebook.litho.annotations.OnUnmount;
import com.facebook.litho.annotations.Prop;
import com.facebook.shimmer.ShimmerFrameLayout;

@MountSpec
class ShimmerTopComponentSpec {

    @OnMeasure
    static void onMeasure(
        ComponentContext c,
        ComponentLayout layout,
        int widthSpec,
        int heightSpec,
        Size size,
        @Prop Component component) {
        component.measure(c, widthSpec, heightSpec, size);
    }

    @OnCreateMountContent
    static ShimmerFrameLayout onCreateMountContent(Context c) {
        ShimmerFrameLayout plainShimmerLayout = new ShimmerFrameLayout(c);
        return plainShimmerLayout;

    }

    @OnMount
    static void onMount(ComponentContext context, ShimmerFrameLayout shimmerLayout, @Prop ShimmerLayoutBinder binder) {
        binder.mount(shimmerLayout);
    }

    @OnUnmount
    static void onUnmount(ComponentContext context, ShimmerFrameLayout shimmerLayout, @Prop ShimmerLayoutBinder binder) {
        binder.unmount(shimmerLayout);
    }
}
