package com.poc.pochexagonal.domain.student.usecase

import com.poc.pochexagonal.domain.student.Student
import com.poc.pochexagonal.domain.student.exceptions.StudentInvalidException
import com.poc.pochexagonal.domain.student.ports.output.StudentPersistenceInterface
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.junit.jupiter.MockitoExtension

@ExtendWith(MockitoExtension::class)
internal class CreateStudentUseCaseUnitTest {
    @Mock
    lateinit var studentPersistence: StudentPersistenceInterface

    @InjectMocks
    lateinit var createStudentUseCase: CreateStudentUseCaseImpl

    @Test
    fun `should save a student`() {
        val student = Student("abc", "Student Test")
        Mockito.`when`(studentPersistence.save(student)).then { student }

        val result = createStudentUseCase.save(student)

        assertEquals(student, result)
    }

    @Test
    fun `should throw exception when student not valid`() {
        val student = Student("abc", "")

        val exception =
            org.junit.jupiter.api.assertThrows<StudentInvalidException> { createStudentUseCase.save(student) }
        val expected = "Sorry, check the information provided. Invalid operation!"
        assertEquals(expected, exception.message)
    }
}