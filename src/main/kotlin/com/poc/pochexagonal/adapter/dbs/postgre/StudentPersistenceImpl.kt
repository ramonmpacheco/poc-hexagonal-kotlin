package com.poc.pochexagonal.adapter.dbs.postgre

import com.poc.pochexagonal.domain.student.Student
import com.poc.pochexagonal.domain.student.ports.output.StudentPersistenceInterface
import org.springframework.data.repository.findByIdOrNull
import javax.inject.Named

@Named
class StudentPersistenceImpl(
    private val studentRepository: StudentRepository
) : StudentPersistenceInterface {

    override fun save(student: Student): Student {
        return studentRepository.save(student.toModel())
            .toStudent()
    }

    override fun findById(id: String): Student? {
        return studentRepository.findByIdOrNull(id)
            ?.toStudent()
    }
}