# Slither

A widget that helps you put facebook-shimmer in litho widgets 

## Getting Started

### Prerequisites

You should have some experience with facebook litho and facebook shimmer libraries

### Installing

Add following line to your .gradle file

```
implementation 'com.abhilashmishra.slither:slither:1.0.0'
```
Note: I am assuming that you are already working with litho ;)

How to use the widget

```
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
```

Check links for facebook shimmer below to know about more shimmer modifications

## Built With

* [Facebook Litho](https://fblitho.com/)
* [Facebook Shimmer](http://facebook.github.io/shimmer-android/)

## License

This project is licensed under the MIT License - see the [LICENSE.md](LICENSE.md) file for details
