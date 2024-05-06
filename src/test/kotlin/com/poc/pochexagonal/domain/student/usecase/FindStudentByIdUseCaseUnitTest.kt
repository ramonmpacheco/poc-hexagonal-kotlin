package com.poc.pochexagonal.domain.student.usecase

import com.poc.pochexagonal.domain.student.Student
import com.poc.pochexagonal.domain.student.exceptions.StudentNotFoundException
import com.poc.pochexagonal.domain.student.ports.output.StudentPersistenceInterface
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.junit.jupiter.MockitoExtension

@ExtendWith(MockitoExtension::class)
internal class FindStudentByIdUseCaseUnitTest {
    @Mock
    lateinit var studentPersistence: StudentPersistenceInterface

    @InjectMocks
    lateinit var findStudentByIdUseCase: FindStudentByIdUseCaseImpl

    @Test
    fun `should get a student by id`() {
        val student = Student("abc", "Student Test")
        Mockito.`when`(studentPersistence.findById("abc")).then { student }

        val result = findStudentByIdUseCase.findById("abc")

        assertEquals(student, result)
    }

    @Test
    fun `should throw an exception when student not found by id`() {

        Mockito.`when`(studentPersistence.findById("abc")).then { null }

        val exception =
            org.junit.jupiter.api.assertThrows<StudentNotFoundException> { findStudentByIdUseCase.findById("abc") }

        val expected = "Student with id: abc not found!"
        assertEquals(expected, exception.message)
    }
}