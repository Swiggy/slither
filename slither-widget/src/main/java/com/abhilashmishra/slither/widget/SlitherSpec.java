package com.abhilashmishra.slither.widget;

import com.facebook.litho.Column;
import com.facebook.litho.Component;
import com.facebook.litho.ComponentContext;
import com.facebook.litho.annotations.LayoutSpec;
import com.facebook.litho.annotations.OnCreateLayout;
import com.facebook.litho.annotations.Prop;
import com.facebook.shimmer.Shimmer;
import com.facebook.yoga.YogaPositionType;

@LayoutSpec
class SlitherSpec {

    @OnCreateLayout
    static Component onCreateLayout(ComponentContext c,
                                    @Prop Component component,
                                    @Prop Shimmer shimmer) {
        return Column.create(c)
                .child(Column.create(c)
                        .child(component)
                        .positionType(YogaPositionType.ABSOLUTE))
                .child(ShimmerTopComponent.create(c)
                        .shimmer(shimmer)
                        .positionType(YogaPositionType.ABSOLUTE))
                .build();
    }
}
