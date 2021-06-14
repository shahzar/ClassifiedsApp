package com.shahzar.classifiedsapp.ui.main

import androidx.lifecycle.ViewModelProvider
import com.shahzar.classifiedsapp.NavMgr
import com.shahzar.classifiedsapp.R
import com.shahzar.classifiedsapp.ui.base.BaseActivity
import com.shahzar.classifiedsapp.ui.home.HomeFragment
import javax.inject.Inject

class MainActivity : BaseActivity() {

    @Inject
    lateinit var navMgr: NavMgr

    private lateinit var viewModel: MainViewModel

    override fun getLayoutRes() = R.layout.activity_main

    override fun injectDependency() = getDiComponent().inject(this)

    override fun initViews() {
        viewModel = ViewModelProvider(this, viewModelFactory).get(MainViewModel::class.java)
        navMgr.pushFragment(this, HomeFragment.newInstance(), false)
    }

    override fun setupObservers() {
        super.setupObservers()
    }

    override fun onBackPressed() {
        if(!navMgr.pop(this)) {
            finish()
        }
    }
}
