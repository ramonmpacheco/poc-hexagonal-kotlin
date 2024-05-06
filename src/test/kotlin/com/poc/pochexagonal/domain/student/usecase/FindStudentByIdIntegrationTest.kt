package com.poc.pochexagonal.domain.student.usecase

import com.poc.pochexagonal.domain.BaseDatabaseIntegrationTest
import com.poc.pochexagonal.domain.student.Student
import com.poc.pochexagonal.domain.student.ports.input.FindStudentByIdUseCaseInterface
import com.poc.pochexagonal.domain.student.ports.output.StudentPersistenceInterface
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired

class FindStudentByIdIntegrationTest : BaseDatabaseIntegrationTest() {
    @Autowired
    lateinit var findStudentByIdUseCase: FindStudentByIdUseCaseInterface

    @Autowired
    lateinit var studentData: StudentPersistenceInterface

    @Test
    fun `should find a student by id`() {
        val toSaveStudent = Student("abc", "Student Test")
        studentData.save(toSaveStudent)

        val savedStudent = findStudentByIdUseCase.findById("abc")

        Assertions.assertEquals(toSaveStudent, savedStudent)
    }
}