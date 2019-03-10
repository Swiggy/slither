package com.abhilash.slither

import com.facebook.litho.Component
import com.facebook.litho.ComponentContext
import com.facebook.litho.ComponentTree
import com.facebook.litho.EventHandler
import com.facebook.litho.LithoView
import com.facebook.litho.Size
import com.facebook.litho.widget.Binder
import com.facebook.litho.widget.EmptyComponent
import com.facebook.litho.widget.ReMeasureEvent
import com.facebook.litho.widget.ViewportInfo
import com.facebook.shimmer.Shimmer
import com.facebook.shimmer.ShimmerFrameLayout

class ShimmerLayoutBinder : Binder<ShimmerFrameLayout> {
    override fun setCanMeasure(canMeasure: Boolean) {}

    override fun canMeasure(): Boolean {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    companion object {

        val DEFAULT_SHIMMER = Shimmer
            .AlphaHighlightBuilder()
            .build()
    }
    private var componentContext: ComponentContext
    private var wrapContent: Boolean = false
    private var component: Component
    private var componentTree: ComponentTree
    private var shimmer = DEFAULT_SHIMMER
    private var contentView: LithoView? = null
    private var isShimmerSet: Boolean = false

    constructor(builder: Builder) {
        this.wrapContent = builder.wrapContent
        this.shimmer = builder.shimmer
        this.componentContext = builder.componentContext
        if (builder.component != null) {
            this.component = builder.component!!
        } else {
            this.component = EmptyComponent.create(componentContext).build()
        }
        this.componentTree = ComponentTree.create(componentContext, component).build()
    }

    override fun mount(view: ShimmerFrameLayout?) {
        if (isShimmerSet) {
            view?.startShimmer()
        } else {
            val lithoView = LithoView(componentContext)
            lithoView.setComponent(component)
            view?.addView(lithoView)
            view?.setShimmer(shimmer)?.startShimmer()
            isShimmerSet = true
        }
    }

    class Builder {

        internal var wrapContent: Boolean = false
        internal var component: Component? = null
        internal var shimmer: Shimmer = DEFAULT_SHIMMER
        internal lateinit var componentContext: ComponentContext

        fun wrapContent(wrapContent: Boolean): Builder {
            this.wrapContent = wrapContent
            return this
        }

        fun component(component: Component): Builder {
            this.component = component
            return this
        }

        fun shimmer(shimmer: Shimmer): Builder {
            this.shimmer = shimmer
            return this
        }

        fun build(c: ComponentContext): ShimmerLayoutBinder {
            componentContext = c
            return ShimmerLayoutBinder(this)
        }
    }

    override fun measure(outSize: Size?, widthSpec: Int, heightSpec: Int, reMeasureEventHandler: EventHandler<ReMeasureEvent>?) {}

    override fun bind(view: ShimmerFrameLayout?) {}

    override fun getComponentAt(position: Int): ComponentTree {
        return componentTree
    }

    override fun unmount(view: ShimmerFrameLayout?) {
        view?.stopShimmer()
    }

    override fun setViewportChangedListener(viewportChangedListener: ViewportInfo.ViewportChanged?) {}

    override fun setSize(width: Int, height: Int) {}

    override fun unbind(view: ShimmerFrameLayout?) {
    }

    override fun isWrapContent(): Boolean {
        return wrapContent
    }
}