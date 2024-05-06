package com.poc.pochexagonal.domain.student.ports.output

import com.poc.pochexagonal.domain.BaseDatabaseIntegrationTest
import com.poc.pochexagonal.domain.student.Student
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired

class StudentPersistenceIntegrationTest : BaseDatabaseIntegrationTest() {
    @Autowired
    lateinit var studentPersistence: StudentPersistenceInterface

    @Test
    fun `should persist a student`() {
        val toSaveStudent = Student("abc", "Student Test")
        val savedStudent = studentPersistence.save(toSaveStudent)

        Assertions.assertEquals(toSaveStudent, savedStudent)
    }
    
    @Test
    fun `should find a student by id`(){
        val toSaveStudent = Student("abc", "Student Test")
        studentPersistence.save(toSaveStudent)

        val studentFound = studentPersistence.findById("abc")

        Assertions.assertEquals(toSaveStudent, studentFound)

    }
}