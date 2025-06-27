package com.sandeep.multi.db.mysql.repo

import com.sandeep.multi.db.mysql.entity.Teacher
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface MySqlRepository : JpaRepository<Teacher, Long>