package com.shahzar.classifiedsapp.ui.home

import android.view.View
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.shahzar.classifiedsapp.NavMgr
import com.shahzar.classifiedsapp.R
import com.shahzar.classifiedsapp.databinding.HomeFragmentBinding
import com.shahzar.classifiedsapp.ui.base.BaseFragment
import com.shahzar.classifiedsapp.ui.productdetails.ProductDetailsFragment
import javax.inject.Inject

class HomeFragment : BaseFragment<HomeViewModel>() {

    private lateinit var binding: HomeFragmentBinding

    @Inject
    lateinit var itemListAdapter: ItemListAdapter

    @Inject
    lateinit var navMgr: NavMgr

    companion object {
        fun newInstance() = HomeFragment()
    }

    override fun getLayoutRes() = R.layout.home_fragment
    override fun getViewModelClass() = HomeViewModel::class.java
    override fun injectDependency() = getDiComponent().inject(this)

    override fun initViews() {

        binding = HomeFragmentBinding.bind(rootView)

        binding.listItems.layoutManager = LinearLayoutManager(context)
        binding.listItems.adapter = itemListAdapter

        itemListAdapter.clicklistener = { product ->
            navMgr.pushFragment(activity, ProductDetailsFragment.newInstance(product), true)
        }
    }

    override fun setupObservers() {
        super.setupObservers()

        viewModel.loading.observe(viewLifecycleOwner, { show ->
            binding.progressBar.visibility = if(show) View.VISIBLE else View.GONE
        })

        viewModel.onProductList.observe(viewLifecycleOwner, {
            itemListAdapter.items = it
        })
    }


}
