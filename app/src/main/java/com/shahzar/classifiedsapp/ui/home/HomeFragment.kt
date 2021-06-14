package com.shahzar.classifiedsapp.ui.home

import androidx.recyclerview.widget.LinearLayoutManager
import com.shahzar.classifiedsapp.NavMgr
import com.shahzar.classifiedsapp.R
import com.shahzar.classifiedsapp.databinding.HomeFragmentBinding
import com.shahzar.classifiedsapp.ui.base.BaseFragment
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
    }

    override fun setupObservers() {
        super.setupObservers()
        viewModel.onProductList.observe(viewLifecycleOwner, {
            itemListAdapter.items = it
        })
    }


}
