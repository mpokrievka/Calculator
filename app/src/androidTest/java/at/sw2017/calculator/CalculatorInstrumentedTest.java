package at.sw2017.calculator;

import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.junit.Assert.assertEquals;

/**
 * Instrumentation test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class CalculatorInstrumentedTest {

    @Rule
    public ActivityTestRule<Calculator> mActivityRule = new ActivityTestRule<>(Calculator.class);

    @Test
    public void TestButtons() throws Exception{

        for(int i = 0; i <= 9; i++){
            onView(withText(Integer.toString(i))).perform(click());
        }
        onView(withText("+")).perform(click());
        onView(withText("-")).perform(click());
        onView(withText("*")).perform(click());
        onView(withText("/")).perform(click());
        onView(withText("=")).perform(click());
        onView(withText("C")).perform(click());


    }

    @Test
    public void TestInputFields() {
        for(int i = 9; i >= 0; i--){
          onView(withText(Integer.toString(i))).perform(click());
        }
        onView(withText("9876543210")).check(matches(isDisplayed()));
    }

}
