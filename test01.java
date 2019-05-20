//written by Myungsik Kim 05/20/2019

package com.example.testingsample;

import android.support.test.espresso.action.ViewActions;
import android.support.test.espresso.assertion.ViewAssertions;
import android.support.test.espresso.matcher.ViewMatchers;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import android.support.test.espresso.Espresso;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.closeSoftKeyboard;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

@RunWith(AndroidJUnit4.class)
public class test01 {

    @Rule
    public ActivityTestRule<MainActivity> mActivityTestRule = new ActivityTestRule<>(MainActivity.class);
    public MainActivity mActivity = null;

    @Before
    public void setUp(){
        this.mActivity = mActivityTestRule.getActivity();
    }

    //add method C1: num1 = 1 or 101, C2: num2 = 1 or 100
    @Test //CACC - C1 - Test Case: num1 = 1, num 2 = 5(random true value)
    public void test01() throws Exception{
        onView(withId(R.id.num01)).perform(typeText("1"));
        onView(withId(R.id.num02)).perform(typeText("5"));
        onView(withId(R.id.button)).perform(click());
        onView(withId(R.id.textView)).perform().check(matches(withText("6"))); //expected value 6
    }

    @Test //CACC - C1 - Test Case: num1 = 101, num 2 = 5(random true value)
    public void test02() throws Exception{
        onView(withId(R.id.num01)).perform(typeText("101"));
        onView(withId(R.id.num02)).perform(typeText("100"));
        onView(withId(R.id.button)).perform(click());
        onView(withId(R.id.textView)).perform().check(matches(withText("-9999"))); //expected value -9999
    }

    @Test //CACC - C2 - Test Case: num1 = 5(random true value), num 2 = 1
    public void test03() throws Exception{
        onView(withId(R.id.num01)).perform(typeText("5"));
        onView(withId(R.id.num02)).perform(typeText("1"));
        onView(withId(R.id.button)).perform(click());
        onView(withId(R.id.textView)).perform().check(matches(withText("6"))); //expected value 6
    }

    @Test //CACC - C2 - Test Case: num1 = 5(random true value), num 2 = 100
    public void test04() throws Exception{
        onView(withId(R.id.num01)).perform(typeText("101"));
        onView(withId(R.id.num02)).perform(typeText("1"));
        onView(withId(R.id.button)).perform(click());
        onView(withId(R.id.textView)).perform().check(matches(withText("-9999"))); //expected value -9999
    }

    //add method P2 = C3: num1 = 0 or -1, C4: num2 = 0 or -1
    @Test //CACC - C3 - Test Case: num1 = 1, num 2 = 5(random true value)
    public void test05() throws Exception{
        onView(withId(R.id.num01)).perform(typeText("1"));
        onView(withId(R.id.num02)).perform(typeText("5"));
        onView(withId(R.id.button)).perform(click());
        onView(withId(R.id.textView)).perform().check(matches(withText("6"))); //expected value 6
    }

    @Test //CACC - C3 - Test Case: num1 = 0, num2 = 5(random true value)
    public void test06() throws Exception{
        onView(withId(R.id.num01)).perform(typeText("0"));
        onView(withId(R.id.num02)).perform(typeText("5"));
        onView(withId(R.id.button)).perform(click());
        onView(withId(R.id.textView)).perform().check(matches(withText("-9999")));
    }

    @Test //CACC - C4 - Test Case: num1 = 5(random true value), num 2 = 1
    public void test07() throws Exception{
        onView(withId(R.id.num01)).perform(typeText("5"));
        onView(withId(R.id.num02)).perform(typeText("1"));
        onView(withId(R.id.button)).perform(click());
        onView(withId(R.id.textView)).perform().check(matches(withText("6")));
    }

    @Test //CACC - C4 - Test Case: num1 = 5(random true value), num 2 = 0
    public void test08() throws Exception{
        onView(withId(R.id.num01)).perform(typeText("5"));
        onView(withId(R.id.num02)).perform(typeText("0"));
        onView(withId(R.id.button)).perform(click());
        onView(withId(R.id.textView)).perform().check(matches(withText("-9999")));
    }

    //subtraction method P1 = C1: num2 > num1, C2: num1 = 201 or 200, C3: num2 = 200 or 199, C4: num1 = 1 or 0  C5: num 2 = 1 or 0
    @Test //CACC - C1 - Test Case: num1 = 4(random true value), num 2 = 5
    public void test09() throws Exception{
        onView(withId(R.id.num01)).perform(typeText("4"));
        onView(withId(R.id.num02)).perform(typeText("5"));
        onView(withId(R.id.button2)).perform(click());
        onView(withId(R.id.textView)).perform().check(matches(withText("-9999")));
    }

    @Test //CACC - C1 - Test Case: num1 = 4(random true value), num 2 = 3
    public void test10() throws Exception{
        onView(withId(R.id.num01)).perform(typeText("4"));
        onView(withId(R.id.num02)).perform(typeText("3"));
        onView(withId(R.id.button2)).perform(click());
        onView(withId(R.id.textView)).perform().check(matches(withText("1")));
    }

    @Test //CACC - C2 - Test Case: num1 = 201, num 2 = 200(random true value)
    public void test11() throws Exception{
        onView(withId(R.id.num01)).perform(typeText("201"));
        onView(withId(R.id.num02)).perform(typeText("200"));
        onView(withId(R.id.button2)).perform(click());
        onView(withId(R.id.textView)).perform().check(matches(withText("-9999")));
    }

    @Test //CACC - C2 - Test Case: num1 = 200, num 2 = 200(random true value)
    public void test12() throws Exception{
        onView(withId(R.id.num01)).perform(typeText("200"));
        onView(withId(R.id.num02)).perform(typeText("200"));
        onView(withId(R.id.button2)).perform(click());
        onView(withId(R.id.textView)).perform().check(matches(withText("0")));
    }

    @Test //CACC - C3 - Test Case: num1 = 201(random true value), num 2 = 200
    public void test13() throws Exception{
        onView(withId(R.id.num01)).perform(typeText("201"));
        onView(withId(R.id.num02)).perform(typeText("200"));
        onView(withId(R.id.button2)).perform(click());
        onView(withId(R.id.textView)).perform().check(matches(withText("-9999")));
    }

    @Test //CACC - C3 - Test Case: num1 = 200(random true value), num 2 = 199
    public void test14() throws Exception{
        onView(withId(R.id.num01)).perform(typeText("200"));
        onView(withId(R.id.num02)).perform(typeText("199"));
        onView(withId(R.id.button2)).perform(click());
        onView(withId(R.id.textView)).perform().check(matches(withText("1")));
    }

    @Test //CACC - C4 - Test Case: num1 = 0, num 2 = 0(random true value)
    public void test15() throws Exception{
        onView(withId(R.id.num01)).perform(typeText("0"));
        onView(withId(R.id.num02)).perform(typeText("0"));
        onView(withId(R.id.button2)).perform(click());
        onView(withId(R.id.textView)).perform().check(matches(withText("-9999")));
    }

    @Test //CACC - C4 - Test Case: num1 = 1, num 2 = 0(random true value)
    public void test16() throws Exception{
        onView(withId(R.id.num01)).perform(typeText("1"));
        onView(withId(R.id.num02)).perform(typeText("0"));
        onView(withId(R.id.button2)).perform(click());
        onView(withId(R.id.textView)).perform().check(matches(withText("1")));
    }

    @Test //CACC - C5 - Test Case: num1 = 0(random true value), num 2 = 0
    public void test17() throws Exception{
        onView(withId(R.id.num01)).perform(typeText("0"));
        onView(withId(R.id.num02)).perform(typeText("0"));
        onView(withId(R.id.button2)).perform(click());
        onView(withId(R.id.textView)).perform().check(matches(withText("-9999")));
    }

    @Test //CACC - C5 - Test Case: num1 = 0(random true value), num 2 = 1
    public void test18() throws Exception{
        onView(withId(R.id.num01)).perform(typeText("0"));
        onView(withId(R.id.num02)).perform(typeText("1"));
        onView(withId(R.id.button2)).perform(click());
        onView(withId(R.id.textView)).perform().check(matches(withText("-9999"))); //expected value -9999. actually should be -1 but if num 2 is greater than num 1. return -9999
    }

    //multiply method P1 = C1: num1 == num2 or num1 != num2, C2: num1 == 0, C3: num2 == 0, C4: num1 < 0, C5: num2 < 0
    @Test //CACC - C1 - Test Case: num1 = 5, num 2 = 5
    public void test19() throws Exception{
        onView(withId(R.id.num01)).perform(typeText("5"));
        onView(withId(R.id.num02)).perform(typeText("5"));
        onView(withId(R.id.num02)).perform(closeSoftKeyboard()); //keyboard makes hide button so need to close
        onView(withId(R.id.button3)).perform(click());
        onView(withId(R.id.textView)).perform().check(matches(withText("-9999"))); //expected value -9999. because num1 == num 2 is true
    }

    @Test //CACC - C1 - Test Case: num1 = 6, num 2 = 5
    public void test20() throws Exception{
        onView(withId(R.id.num01)).perform(typeText("6"));
        onView(withId(R.id.num02)).perform(typeText("5"));
        onView(withId(R.id.num02)).perform(closeSoftKeyboard()); //keyboard makes hide button so need to close
        onView(withId(R.id.button3)).perform(click());
        onView(withId(R.id.textView)).perform().check(matches(withText("30"))); //expected value 30. because num1 == num 2 is false
    }

    @Test //CACC - C2 - Test Case: num1 = 0, num 2 = 1
    public void test21() throws Exception{
        onView(withId(R.id.num01)).perform(typeText("0"));
        onView(withId(R.id.num02)).perform(typeText("1"));
        onView(withId(R.id.num02)).perform(closeSoftKeyboard()); //keyboard makes hide button so need to close
        onView(withId(R.id.button3)).perform(click());
        onView(withId(R.id.textView)).perform().check(matches(withText("-9999")));
    }

    @Test //CACC - C2 - Test Case: num1 = 1, num 2 = 2
    public void test22() throws Exception{
        onView(withId(R.id.num01)).perform(typeText("1"));
        onView(withId(R.id.num02)).perform(typeText("2"));
        onView(withId(R.id.num02)).perform(closeSoftKeyboard()); //keyboard makes hide button so need to close
        onView(withId(R.id.button3)).perform(click());
        onView(withId(R.id.textView)).perform().check(matches(withText("2"))); //expected value 2.
    }

    @Test //CACC - C3 - Test Case: num1 = 1, num 2 = 0
    public void test23() throws Exception{
        onView(withId(R.id.num01)).perform(typeText("1"));
        onView(withId(R.id.num02)).perform(typeText("0"));
        onView(withId(R.id.num02)).perform(closeSoftKeyboard()); //keyboard makes hide button so need to close
        onView(withId(R.id.button3)).perform(click());
        onView(withId(R.id.textView)).perform().check(matches(withText("-9999")));
    }

    @Test //CACC - C3 - Test Case: num1 = 2, num 2 = 1
    public void test24() throws Exception{
        onView(withId(R.id.num01)).perform(typeText("2"));
        onView(withId(R.id.num02)).perform(typeText("1"));
        onView(withId(R.id.num02)).perform(closeSoftKeyboard()); //keyboard makes hide button so need to close
        onView(withId(R.id.button3)).perform(click());
        onView(withId(R.id.textView)).perform().check(matches(withText("2"))); //expected value 2.
    }

    @Test //CACC - C4 - Test Case: num1 = -1, num2 = -2
    public void test25() throws Exception{
        onView(withId(R.id.num01)).perform(typeText("-1"));
        onView(withId(R.id.num02)).perform(typeText("-2"));
        onView(withId(R.id.num02)).perform(closeSoftKeyboard()); //keyboard makes hide button so need to close
        onView(withId(R.id.button3)).perform(click());
        onView(withId(R.id.textView)).perform().check(matches(withText("-9999"))); //expected value -9999.
    }

    @Test //CACC - C4 - Test Case: num1 = 1, num 2 = -2
    public void test26() throws Exception{
        onView(withId(R.id.num01)).perform(typeText("1"));
        onView(withId(R.id.num02)).perform(typeText("-2"));
        onView(withId(R.id.num02)).perform(closeSoftKeyboard()); //keyboard makes hide button so need to close
        onView(withId(R.id.button3)).perform(click());
        onView(withId(R.id.textView)).perform().check(matches(withText("-2"))); //expected value -2.
    }

    @Test //CACC - C5 - Test Case: num1 = -2, num 2 = -1
    public void test27() throws Exception{
        onView(withId(R.id.num01)).perform(typeText("-2"));
        onView(withId(R.id.num02)).perform(typeText("-1"));
        onView(withId(R.id.num02)).perform(closeSoftKeyboard()); //keyboard makes hide button so need to close
        onView(withId(R.id.button3)).perform(click());
        onView(withId(R.id.textView)).perform().check(matches(withText("-9999"))); //expected value -9999.
    }

    @Test //CACC - C5 - Test Case: num1 = 55, num 2 = 1
    public void test28() throws Exception{
        onView(withId(R.id.num01)).perform(typeText("55"));
        onView(withId(R.id.num02)).perform(typeText("1"));
        onView(withId(R.id.num02)).perform(closeSoftKeyboard()); //keyboard makes hide button so need to close
        onView(withId(R.id.button3)).perform(click());
        onView(withId(R.id.textView)).perform().check(matches(withText("55"))); //expected value 55.
    }

    //divide P1: num1 > 100
    @Test //CACC - C1: num1 = 101
    public void test29() throws Exception{
        onView(withId(R.id.num01)).perform(typeText("101"));
        onView(withId(R.id.num02)).perform(typeText("5"));
        onView(withId(R.id.num02)).perform(closeSoftKeyboard()); //keyboard makes hide button so need to close
        onView(withId(R.id.button4)).perform(click());
        onView(withId(R.id.textView)).perform().check(matches(withText("-9999"))); //expected value -9999.
    }

    @Test //CACC - C1: num1 = 100
    public void test30() throws Exception{
        onView(withId(R.id.num01)).perform(typeText("100"));
        onView(withId(R.id.num02)).perform(typeText("5"));
        onView(withId(R.id.num02)).perform(closeSoftKeyboard()); //keyboard makes hide button so need to close
        onView(withId(R.id.button4)).perform(click());
        onView(withId(R.id.textView)).perform().check(matches(withText("20"))); //expected value 20.
    }

    @After
    public void tearDown() throws Exception {
        mActivity = null;
    }
}