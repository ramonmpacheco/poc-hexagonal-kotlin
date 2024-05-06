package com.poc.pochexagonal.adapter.web.responses

import com.poc.pochexagonal.domain.student.Student

data class StudentResponse(
    var id: String = "",
    var name: String = ""
)

fun Student.toStudentResponse() = StudentResponse(
    id = id!!,
    name = name
)