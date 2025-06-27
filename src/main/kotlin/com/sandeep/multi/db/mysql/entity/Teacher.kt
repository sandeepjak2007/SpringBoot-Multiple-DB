package com.sandeep.multi.db.mysql.entity

import com.sandeep.multi.db.dto.TeacherDTO
import jakarta.persistence.*
import java.time.LocalDate

@Entity
@Table(name = "teacher")
data class Teacher(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long,
    val name: String,
    val subjectName: String,
    val joiningDate: LocalDate
)

fun Teacher.toDTO() = TeacherDTO(
    id = this.id,
    name = this.name,
    subjectName = this.subjectName,
    joiningDate = this.joiningDate
)


