package com.sandeep.multi.db.postgres.entity

import com.sandeep.multi.db.dto.StudentDTO
import jakarta.persistence.*

@Entity
@Table(name = "student")
data class Student(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long,
    val name: String,
    val className: String,
    val fatherName: String,
    val motherName: String
)

fun Student.toDTO() = StudentDTO(
    id = this.id,
    name = this.name,
    className = this.className,
    fatherName = this.fatherName,
    motherName = this.motherName
)
