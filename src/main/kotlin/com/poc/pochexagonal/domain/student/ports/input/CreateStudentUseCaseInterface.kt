package com.poc.pochexagonal.domain.student.ports.input

import com.poc.pochexagonal.domain.student.Student

interface CreateStudentUseCaseInterface {
    fun save(student: Student): Student
}