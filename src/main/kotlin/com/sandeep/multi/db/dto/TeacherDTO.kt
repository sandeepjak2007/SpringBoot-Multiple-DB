package com.sandeep.multi.db.dto

import java.time.LocalDate

data class TeacherDTO(
    val id: Long,
    val name: String,
    val subjectName: String,
    val joiningDate: LocalDate
)
