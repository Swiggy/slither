[![](https://jitpack.io/v/com.abhilashmishra/slither.svg)](https://jitpack.io/#com.abhilashmishra/slither)


<img src="https://raw.githubusercontent.com/mishrabhilash/slither/master/slither_logo_text.png" alt="Slither logo" title="slither" align="right" height="60" />

# Slither

A widget that helps you put facebook-shimmer in litho widgets 

## Getting Started

### Prerequisites

You should have some experience with facebook litho and facebook shimmer libraries

### Installing

Add following line to you project's root .gradle file

```
allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}
```

Add following line to your module(usually app) .gradle file

```
implementation 'com.abhilashmishra:slither:1.0.0'
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

 <img src="https://raw.githubusercontent.com/mishrabhilash/slither/master/example1.gif" alt="Example" title="example" align="center"/>

Check links for facebook shimmer below to know about more shimmer modifications

## Built With

* [Facebook Litho](https://fblitho.com/)
* [Facebook Shimmer](http://facebook.github.io/shimmer-android/)

## License

This project is licensed under the Apache License 2.0 - see the [LICENSE.md](LICENSE.md) file for details
