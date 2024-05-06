package com.poc.pochexagonal.domain.student.ports.output

import com.poc.pochexagonal.domain.student.Student

interface StudentPersistenceInterface {
    fun save(student: Student): Student
    fun findById(id: String): Student?
}