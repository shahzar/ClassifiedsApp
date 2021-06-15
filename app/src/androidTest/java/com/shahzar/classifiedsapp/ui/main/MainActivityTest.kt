package com.shahzar.classifiedsapp.ui.main

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.IdlingRegistry
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.idling.CountingIdlingResource
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.LargeTest
import androidx.test.rule.ActivityTestRule
import com.levibostian.recyclerviewmatcher.RecyclerViewMatcher
import com.shahzar.classifiedsapp.R
import org.junit.After
import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith


@RunWith(AndroidJUnit4::class)
@LargeTest
class MainActivityTest {

    @get:Rule
    val activityRule = ActivityScenarioRule(MainActivity::class.java)

    @Before
    fun setUp() {
    }

    @After
    fun tearDown() {
    }

    @Test
    fun listVisible_shouldReturnTrue() {
        onView(withId(R.id.listItems))
            .check(matches(isDisplayed()))
    }

    @Test
    fun itemClickToNavigateToDetailsPage_shouldReturnTrue() {

        // Not recommended way. Preferred to use idling resource
        Thread.sleep(10000)

        onView(
            RecyclerViewMatcher(R.id.listItems)
                .itemViewAtIndex(0)
        ).perform(click())

        onView(withId(R.id.tvProductName))
            .check(matches(isDisplayed()))
    }
}