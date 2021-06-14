package com.shahzar.classifiedsapp.ui.base

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import com.shahzar.classifiedsapp.BaseApplication
import com.shahzar.classifiedsapp.R
import com.shahzar.classifiedsapp.di.ViewModelFactory
import com.shahzar.classifiedsapp.di.components.AppComponent
import javax.inject.Inject

abstract class BaseActivity: AppCompatActivity() {

    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    abstract fun getLayoutRes(): Int
    abstract fun injectDependency()
    abstract fun initViews()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(getLayoutRes())
        injectDependency()
        setupToolbar()
        initViews()
        setupObservers()
    }

    private fun setupToolbar() {
        findViewById<Toolbar>(R.id.toolbar)?.let { toolbar ->
            setSupportActionBar(toolbar)
        }
    }

    open fun setupObservers() {

    }

    fun getDiComponent() : AppComponent {
        return (application as BaseApplication).appComponent
    }

    fun setToolbarTitle(title: String?) {
        findViewById<Toolbar>(R.id.toolbar)?.let { toolbar ->
            if (title != null) {
                toolbar.visibility = View.VISIBLE
                toolbar.title = title
            } else {
                toolbar.title = ""
                toolbar.visibility = View.GONE
            }
        }
    }

}