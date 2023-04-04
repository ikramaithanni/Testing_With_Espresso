package com.example.testingwithespresso;

import static java.util.regex.Pattern.matches;
import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

import androidx.test.espresso.matcher.ViewMatchers;
import androidx.test.rule.ActivityTestRule;

import org.junit.Rule;
import org.junit.Test;


public class MainActivityEspressoTest {
    @Rule
    public ActivityTestRule<MainActivity> mActivityRule =
            new ActivityTestRule<>(MainActivity.class);

    @Test
    public void VerifierChangementText() {
// Taper le texte puis appuyer sur le bouton.
        onView(ViewMatchers.withId(R.id.inputField))
                .perform(typeText("HELLO Dev"), closeSoftKeyboard());
        onView(withId(R.id.changeText)).perform(click());
// Vérifier que le texte a été modifié.
        onView(withId(R.id.inputField)).check(matches(withText("Dev mobile")));
    }
    @Test
    public void changerTexteSecondActivity() {
// Taper le texte puis cliquer sur le bouton.
        onView(withId(R.id.inputField)).perform(typeText("Nouveau Texte"),
                closeSoftKeyboard());
        onView(withId(R.id.switchActivity)).perform(click());
// Cette vue est dans une activité différente, pas besoin de le signaler à
// Espresso.
        onView(withId(R.id.resultView)).check(matches(withText("Nouveau Texte")));
    }
}