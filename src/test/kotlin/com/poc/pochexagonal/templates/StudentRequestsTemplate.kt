package com.poc.pochexagonal.templates

class StudentRequestsTemplate {
    companion object {
        fun buildCreateRequest(): String {
            return """ {"name": "Student Test"} """
        }
    }
}
