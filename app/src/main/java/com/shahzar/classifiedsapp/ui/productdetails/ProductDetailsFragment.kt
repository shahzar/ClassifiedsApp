package com.shahzar.classifiedsapp.ui.productdetails

import com.shahzar.classifiedsapp.NavMgr
import com.shahzar.classifiedsapp.R
import com.shahzar.classifiedsapp.databinding.ProductDetailsFragmentBinding
import com.shahzar.classifiedsapp.ui.base.BaseFragment
import com.shahzar.classifiedsapp.ui.home.HomeFragment
import com.shahzar.classifiedsapp.ui.home.ItemListAdapter
import com.shahzar.classifiedsapp.ui.home.ProductDetailsViewModel
import javax.inject.Inject

class ProductDetailsFragment : BaseFragment<ProductDetailsViewModel>() {

    private lateinit var binding: ProductDetailsFragmentBinding

    @Inject
    lateinit var itemListAdapter: ItemListAdapter

    @Inject
    lateinit var navMgr: NavMgr

    companion object {
        fun newInstance() = HomeFragment()
    }

    override fun getLayoutRes() = R.layout.product_details_fragment
    override fun getViewModelClass() = ProductDetailsViewModel::class.java
    override fun injectDependency() = getDiComponent().inject(this)

    override fun initViews() {

        binding = ProductDetailsFragmentBinding.bind(rootView)

    }

    override fun setupObservers() {
        super.setupObservers()
        viewModel.onProductList.observe(viewLifecycleOwner, {
            itemListAdapter.items = it
        })
    }


}
