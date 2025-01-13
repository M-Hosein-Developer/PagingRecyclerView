# Paging Recycler View

This library is for using the paging and skeleton in the project.

  
## Features
- Easy implementation of paging
- Use skeleton with paging

  
## Installation
You can add the library to your project via Gradle:

Step 1. Add the JitPack repository to your build file
```
allprojects {
    repositories {
        maven { url 'https://jitpack.io' }
    }
}
```

Step 2. Add the dependency
```
dependencies {
    implementation("com.github.M-Hosein-Developer:PagingRecyclerView:1.0.2")
}
```
[![](https://jitpack.io/v/M-Hosein-Developer/PagingRecyclerView.svg)](https://jitpack.io/#M-Hosein-Developer/PagingRecyclerView)

## Usage XML
XML Example for Attributes
```
<ir.androidcoder.pagingrecyclerviewlibrary.PagingRecyclerView
        android:id="@+id/paging_recycler_view"
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        app:prv_activatedSkeleton="true"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toTopOf="parent" />
```

## Usage Kotlin
Kotlin Example for Attributes

 
Add paging dependencies in buil.gradle(Module: app)
```
implementation("androidx.paging:paging-runtime:3.3.2")
```

 
Create Paging adapter and inheritance BasePagingAdapter - The BasePagingAdapter is available in the library.
```
class ExampleAdapter : BasePagingAdapter<TestModel, ExampleAdapter.ExampleViewHolder>(
    BaseDiffCallback(
        {oldItem, newItem -> oldItem.id == newItem.id},
        {oldItem, newItem -> oldItem == newItem}
    )
) {
    .
    .
    .
}
``` 

 
Set Adapter
```
val adapter = ExampleAdapter()
binding.pagingRecyclerView.setAdapter(adapter)
```

 
Set Layout Manager
```
binding.pagingRecyclerView
            .setAdapter(adapter)
            .setLayoutManager(YOUR LAYOUT MANAGER)
```

 
Set Enable Or Disable Skeleton
```
binding.pagingRecyclerView.skeletonEnable = true or false
```

 
Use Another Attributes Of Recyceler View
```
binding.pagingRecyclerView.getRecyclerView().itemAnimator ...
binding.pagingRecyclerView.getRecyclerView().scrollState ...
binding.pagingRecyclerView.getRecyclerView().isAnimating ...
.
.
.

```

 

## License
MIT License

Copyright (c) [Year] [Your Name or Organization]

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies
of the Software, and to permit persons to whom the Software is provided to do so,
subject to the following conditions:

The above copyright notice and this permission notice shall be included in all copies
or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED,
INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR
PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE
FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE,
ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
