package com.rachellima.movies.view

import android.os.Handler
import android.os.Looper
import androidx.appcompat.widget.SearchView

abstract class DebouncingQueryTextListener(
    private var debouncePeriod: Long = 1000
) : SearchView.OnQueryTextListener {
    private val handler: Handler = Handler(Looper.getMainLooper())
    private var runnable: Runnable? = null

    override fun onQueryTextSubmit(query: String?): Boolean {
        return false
    }

    override fun onQueryTextChange(newText: String?): Boolean {
        runnable?.let { handler.removeCallbacks(it) }
        runnable = Runnable { onDelayedQueryTextChange(newText) }
        runnable?.let {
            handler.postDelayed(it, debouncePeriod)
        }
        return true
    }

    abstract fun onDelayedQueryTextChange(query: String?)

}
