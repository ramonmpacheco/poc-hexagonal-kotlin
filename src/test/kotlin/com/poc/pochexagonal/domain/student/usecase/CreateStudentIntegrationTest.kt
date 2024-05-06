package com.poc.pochexagonal.domain.student.usecase

import com.poc.pochexagonal.domain.BaseDatabaseIntegrationTest
import com.poc.pochexagonal.domain.student.Student
import com.poc.pochexagonal.domain.student.ports.input.CreateStudentUseCaseInterface
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired

class CreateStudentIntegrationTest : BaseDatabaseIntegrationTest() {
    @Autowired
    lateinit var createStudentUseCase: CreateStudentUseCaseInterface

    @Test
    fun `should create a student`() {
        val toSaveStudent = Student("abc", "Student Test")
        val savedStudent = createStudentUseCase.save(toSaveStudent)

        Assertions.assertEquals(toSaveStudent, savedStudent)
    }
}