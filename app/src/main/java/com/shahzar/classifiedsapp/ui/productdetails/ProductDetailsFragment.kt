package com.shahzar.classifiedsapp.ui.productdetails

import com.shahzar.classifiedsapp.NavMgr
import com.shahzar.classifiedsapp.R
import com.shahzar.classifiedsapp.data.model.response.Product
import com.shahzar.classifiedsapp.databinding.ProductDetailsFragmentBinding
import com.shahzar.classifiedsapp.ui.base.BaseFragment
import com.shahzar.classifiedsapp.ui.home.ItemListAdapter
import com.shahzar.classifiedsapp.ui.home.ProductDetailsViewModel
import javax.inject.Inject

class ProductDetailsFragment : BaseFragment<ProductDetailsViewModel>() {

    private var selProduct: Product? = null
    private lateinit var binding: ProductDetailsFragmentBinding

    @Inject
    lateinit var navMgr: NavMgr

    companion object {
        fun newInstance(product: Product): ProductDetailsFragment {
            val fragment = ProductDetailsFragment()
            fragment.selProduct = product
            return fragment
        }
    }

    override fun getLayoutRes() = R.layout.product_details_fragment
    override fun getViewModelClass() = ProductDetailsViewModel::class.java
    override fun injectDependency() = getDiComponent().inject(this)

    override fun initViews() {

        binding = ProductDetailsFragmentBinding.bind(rootView)

        binding.tvProductName.text = selProduct?.name
        binding.tvProductPrice.text = selProduct?.price

        getImageLoader()
            .load(selProduct?.imageUrls?.firstOrNull())
            .into(binding.imgProduct)

        binding.imgProduct
    }

    override fun setupObservers() {
        super.setupObservers()

    }


}
