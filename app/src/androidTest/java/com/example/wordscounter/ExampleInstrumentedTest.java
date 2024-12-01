package com.example.wordscounter;

import android.content.Context;

import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.platform.app.InstrumentationRegistry;

import androidx.test.ext.junit.rules.ActivityScenarioRule;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.clearText;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static org.junit.Assert.assertEquals;

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class ExampleInstrumentedTest {

    @Rule
    public ActivityScenarioRule<MainActivity> activityRule = new ActivityScenarioRule<>(MainActivity.class);

    @Test
    public void useAppContext() {
        Context appContext = InstrumentationRegistry.getInstrumentation().getTargetContext();
        assertEquals("com.example.wordscounter", appContext.getPackageName());
    }

    @Test
    public void userCanCountWords() {
        // uses this text as an example
        onView(withId(R.id.editText)).perform(typeText("Hello world!"), closeSoftKeyboard());

        // selects "Words" from the spinner
        onView(withId(R.id.spinner)).perform(click());
        onView(withText("Words")).perform(click());

        onView(withId(R.id.button)).perform(click());

        // checks if the result text displays "Count: 2"
        onView(withId(R.id.textView)).check(matches(withText("Count: 2")));
    }



    @Test
    public void emptyInputShowsZeroWords() {

        onView(withId(R.id.editText)).perform(clearText());

        onView(withId(R.id.button)).perform(click());

        // checks that the TextView remains unchanged
        onView(withId(R.id.textView)).check(matches(withText("")));
    }
}
