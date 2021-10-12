package com.example.finalprogrammingproject

import android.text.TextUtils.isEmpty
import androidx.test.espresso.matcher.ViewMatchers.assertThat
import com.example.finalprogrammingproject.ui.profile.ProfileFragment
import junit.framework.Assert.assertEquals
import org.junit.Test

class JUnitTests {
    @Test
    fun testName() {
        val name = "Sean"
        assertEquals(name, testName().toString().equals(true))
    }

    @Test
    fun testBirthday() {
        val birthday = "02/14/2000"
        assertEquals(birthday, testBirthday().toString().equals(true))
    }

    @Test
    fun testAge() {
        val age = "21"
        assertEquals(age, testAge().toString().equals(true))
    }

    @Test
    fun testMajor() {
        val major = "Computer Science"
        assertEquals(major, testMajor().toString().equals(true))
    }

    @Test
    fun testGender() {
        val gender = "Male"
        assertEquals(gender, testGender().toString().equals(true))
    }

    @Test
    fun testEmail() {
        val email = "semorrissey@wpi.edu"
        assertEquals(email, testEmail().toString().equals(true))
    }
}

