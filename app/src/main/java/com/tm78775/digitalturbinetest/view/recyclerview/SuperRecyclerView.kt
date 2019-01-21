package com.tm78775.digitalturbinetest.view.recyclerview

import android.content.Context
import android.util.AttributeSet
import android.util.Log
import androidx.recyclerview.widget.RecyclerView

/**
 * This implementation extends from the RecyclerView. It is put into place so that certain features are available to any
 * implementation that needs the extra features this RecyclerView implements. Current features: OnBottomListenerCallback
 * which will be called when the RecyclerView reaches the bottom of the screen.
 */
open class SuperRecyclerView: RecyclerView {

    //region Private Variables

    private val tag = "SuperRecyclerView"
    private var onBottomOfRecyclerViewCalled = false
    private var onBottomListenerCallback: (() -> Unit)? = null

    //endregion

    //region Constructor(s)

    constructor(context: Context) : super(context) { initialize() }
    constructor(context: Context, set: AttributeSet) : super(context, set) { initialize() }
    constructor(context: Context, set: AttributeSet, defStyle: Int) : super(context, set, defStyle) { initialize() }

    //endregion

    //region Initializing Code

    /**
     * Any methods that should be called at initialization of the RecyclerView should be entered in the
     * initialize method.
     */
    private fun initialize() {
        initializeOnBottomReachedListener()
    }

    /**
     * This method will attach an onScrollListener to the RecyclerView to determine when it has reached the bottom of the
     * data set. It can then call the appropriate methods to allow for loading of more data.
     */
    private fun initializeOnBottomReachedListener() {
        this.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrollStateChanged(recyclerView: RecyclerView, newState: Int) {
                super.onScrollStateChanged(recyclerView, newState)
            }

            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                super.onScrolled(recyclerView, dx, dy)
                if(dy < 0) {
                    // scrolling up
                } else if(dy > 0) {
                    if(!canScrollVertically(RecyclerView.FOCUS_DOWN)) {
                        Log.d(tag, "Bottom of recycler view reached.")
                        if(!onBottomOfRecyclerViewCalled && onBottomListenerCallback != null) {
                            onBottomOfRecyclerViewCalled = true
                            onBottomListenerCallback?.invoke()
                            Log.d(tag, "INVOKED BOTTOM LISTENER CALLBACK.")
                        } else {
                            Log.d(tag, "Not calling onBottomOfRecyclerView because onAdditionalItemsLoaded has not been called to reset the listener.")
                        }
                    }
                }
            }
        })
    }

    //endregion

    //region API

    /**
     * This method provides an API allowing the implementation to "reset" the onBottomReachedCallback
     * flag. Once this flag has been reset, then the onBottomReached method will be called when the
     * RecyclerView once again reaches the bottom of the screen.
     */
    fun onAdditionalItemsLoaded() {
        onBottomOfRecyclerViewCalled = false
    }

    /**
     * This method provides an API allowing the implementation to add a bottom listener to this
     * RecyclerView. When the RecyclerView gets to the bottom of the screen, it will call this method
     * ONLY ONCE. After new items have been loaded and the onAdditionalItemsLoaded method has been called
     * by the implementation, then the onBottomListener will be invoked again upon reaching the bottom
     * of the newly added data.
     * @param callback callback closure that will be invoked when RecyclerView reaches the bottom of the screen.
     * Pass null to clear out the listener.
     */
    fun setOnBottomListener(callback: (() -> Unit)?) {
        onBottomListenerCallback = callback
    }

    //endregion

}