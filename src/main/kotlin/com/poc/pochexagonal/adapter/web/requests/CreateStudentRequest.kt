package com.poc.pochexagonal.adapter.web.requests

import com.poc.pochexagonal.domain.student.Student

data class CreateStudentRequest(
    var name: String
) {
    fun toStudent() = Student(
        name = name
    )
}
