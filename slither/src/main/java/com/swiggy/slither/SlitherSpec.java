package com.swiggy.slither;

import com.facebook.litho.Component;
import com.facebook.litho.ComponentContext;
import com.facebook.litho.annotations.LayoutSpec;
import com.facebook.litho.annotations.OnCreateLayout;
import com.facebook.litho.annotations.Prop;
import com.facebook.shimmer.Shimmer;

@LayoutSpec
class SlitherSpec {
    @OnCreateLayout
    static Component onCreateLayout(ComponentContext c,
                                    @Prop Component component,
                                    @Prop Shimmer shimmer) {
        ShimmerLayoutBinder binder = new ShimmerLayoutBinder.Builder()
            .component(component)
            .shimmer(shimmer)
            .wrapContent(true)
            .build(c);

        return ShimmerTopComponent.create(c)
            .binder(binder)
            .component(component)
            .build();
    }
}
