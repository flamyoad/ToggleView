# ToggleView
Toggle button for reactive observables.

## Should you need this?
The default [ToggleButton](https://developer.android.com/guide/topics/ui/controls/togglebutton) that is built in Android does not play nicely 
with observables such as LiveData, Flow or Rx subjects.

For instance, if you have a bookmark button in your app and you want it to be on/off depending on the `LiveData<Boolean>` in your `ViewModel`.
And you also want the user to be able to toggle it on/off by clicking it.

The bad news is that the onClick callback from [ToggleButton](https://developer.android.com/guide/topics/ui/controls/togglebutton) 
will instantly toggle its state, followed by the state change triggered by your observable. This causes weird flickers in the UI.

## How to use ToggleView

Create two XML layouts for ToggleView. Example : `@layout/layout_bookmark_off`, `@layout/layout_bookmark_on`.

There are 2 attributes that need to be set in `ToggleView`.
```xml
app:viewOff="@layout/layout_bookmark_off"
app:viewOn="@layout/layout_bookmark_on"
```

Include `ToggleView` in your activity/fragment
```xml
<com.flamyoad.toggle_view.ToggleView
     android:id="@+id/btnBookmark"
     android:layout_gravity="center"
     android:layout_width="wrap_content"
     android:layout_height="wrap_content"
     android:background="@android:color/transparent"
     app:viewOff="@layout/layout_bookmark_off"
     app:viewOn="@layout/layout_bookmark_on" />
```

To switch the state programatically, call
```kt
toggleView.isChecked = value: Boolean
```

In your activity/fragment
```kt
class MainActivity : AppCompatActivity() {

    private val viewModel: MainViewModel by viewModels ()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnBookmark = findViewById<ToggleView>(R.id.btnBookmark)

        btnBookmark.setOnClickListener {
            viewModel.toggleBookmarkStatus()
        }

        viewModel.bookmarkStatus().observe(this) {
            btnBookmark.isChecked = it
        }
    }
}
```

In your ViewModel
```kt
class MainViewModel: ViewModel() {

    private val bookmarkStatus = MutableLiveData(false)
    fun bookmarkStatus(): LiveData<Boolean> = bookmarkStatus

    fun toggleBookmarkStatus() {
        val prev = bookmarkStatus.value ?: false
        bookmarkStatus.value = !prev
    }
}
```


### Include the dependency in Gradle 
Add the Jitpack repository in your project `build.gradle`
```
repositories {
    maven { url 'https://jitpack.io' }
}
```
Add the dependency in your app `build.gradle`
```
dependencies {
    implementation 'com.github.flamyoad:ToggleView:1.0.0'
}
```
