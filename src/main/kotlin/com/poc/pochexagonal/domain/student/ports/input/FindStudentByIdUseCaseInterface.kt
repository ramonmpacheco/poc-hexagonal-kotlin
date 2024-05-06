package com.poc.pochexagonal.domain.student.ports.input

import com.poc.pochexagonal.domain.student.Student

interface FindStudentByIdUseCaseInterface {
    fun findById(id: String): Student
}