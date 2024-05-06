package com.poc.pochexagonal.adapter.web.controllers

import com.fasterxml.jackson.databind.ObjectMapper
import com.poc.pochexagonal.adapter.web.BaseWebIntegrationTest
import com.poc.pochexagonal.adapter.web.responses.StudentResponse
import com.poc.pochexagonal.domain.student.Student
import com.poc.pochexagonal.domain.student.ports.output.StudentPersistenceInterface
import com.poc.pochexagonal.templates.StudentRequestsTemplate
import org.hamcrest.Matchers.`is`
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.MediaType
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.status


class StudentControllerIntegrationTest : BaseWebIntegrationTest() {
    companion object {
        const val BASE_URL: String = "/student-management/v1/students"
    }

    @Autowired
    lateinit var studentData: StudentPersistenceInterface


    private val objectMapper = ObjectMapper()

    @Test
    fun `should save a student`() {
        val body = StudentRequestsTemplate.buildCreateRequest()

        val result = mvc.perform(
            post(BASE_URL)
                .contentType(MediaType.APPLICATION_JSON)
                .content(body)
        )
            .andExpect(status().is2xxSuccessful)
            .andReturn()

        val studentResponse = objectMapper.readValue(result.response.contentAsString, StudentResponse::class.java)
        Assertions.assertEquals("Student Test", studentResponse.name)

        val savedStudent = studentData.findById(studentResponse.id)
        Assertions.assertEquals(studentResponse.id, savedStudent?.id)
    }

    @Test
    fun `should find a student by id`() {
        val toSaveStudent = Student("abc", "Student Test")
        studentData.save(toSaveStudent)

        mvc.perform(
            get("$BASE_URL/abc")
                .contentType(MediaType.APPLICATION_JSON)
        )
            .andExpect(status().is2xxSuccessful)
            .andExpect(jsonPath("id", `is`("abc")))
    }

}