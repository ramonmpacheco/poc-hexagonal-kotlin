package com.poc.pochexagonal.domain.student

import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

internal class StudentUnitTest {

    @Test
    fun `should validate itself`() {
        val student = Student("abc", "Student Test")
        assertTrue(student.isValid())
    }

    @Test
    fun `should fail when not valid`() {
        val student = Student("abc", "")
        assertFalse(student.isValid())
    }
}