package com.example.tiptime


import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.action.ViewActions.typeText
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.hamcrest.Matchers.containsString
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

import org.junit.Assert.*

/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */


@RunWith(AndroidJUnit4::class)
class ExampleInstrumentedTest {
    @get:Rule()
    val activity=ActivityScenarioRule(MainActivity::class.java)



    @Test
    fun useAppContext() {
        // Context of the app under test.
        onView(withId(R.id.cost_of_service))
            .perform(typeText("100"))

        onView(withId(R.id.B1)).perform(click())

        onView(withId(R.id.tip_result))
            .check(matches(withText(containsString("120"))))
    }
}
