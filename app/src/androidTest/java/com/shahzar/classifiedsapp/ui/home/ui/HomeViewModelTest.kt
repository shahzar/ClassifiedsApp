package com.shahzar.classifiedsapp.ui.home.ui

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.shahzar.classifiedsapp.data.ProductRepository
import com.shahzar.classifiedsapp.ui.home.HomeViewModel
import com.shahzar.classifiedsapp.ui.home.data.MockApiServiceImpl
import com.shahzar.classifiedsapp.ui.home.util.getOrAwaitValue
import org.junit.Before

import org.junit.Assert.*
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class HomeViewModelTest {

    private lateinit var viewModel: HomeViewModel
    private lateinit var productRepository: ProductRepository

    @get:Rule
    val instantTaskExecutorRule = InstantTaskExecutorRule()

    @Before
    fun setUp() {
        productRepository = ProductRepository(MockApiServiceImpl())
        viewModel = HomeViewModel(productRepository)
    }

    @Test
    fun fetchedProductsValid_shouldReturnTrue() {
        val productList = viewModel.onProductList.getOrAwaitValue()
        assertTrue(productList.size == 20)
    }
}