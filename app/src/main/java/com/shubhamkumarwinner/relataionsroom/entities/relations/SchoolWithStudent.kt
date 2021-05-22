package com.shubhamkumarwinner.relataionsroom.entities.relations

import androidx.room.Embedded
import androidx.room.Relation
import com.shubhamkumarwinner.relataionsroom.entities.School
import com.shubhamkumarwinner.relataionsroom.entities.Student

data class SchoolWithStudent(
    @Embedded val school: School,
    @Relation(
        parentColumn = "schoolName",
        entityColumn = "schoolName"
    )
    val students: List<Student>
)
