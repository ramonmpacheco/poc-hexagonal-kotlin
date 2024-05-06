package com.poc.pochexagonal.domain.student.exceptions

class StudentInvalidException(msg: String, val errorCode: String): RuntimeException(msg)