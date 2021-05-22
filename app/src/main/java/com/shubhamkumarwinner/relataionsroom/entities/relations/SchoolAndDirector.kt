package com.shubhamkumarwinner.relataionsroom.entities.relations

import androidx.room.Embedded
import androidx.room.Relation
import com.shubhamkumarwinner.relataionsroom.entities.Director
import com.shubhamkumarwinner.relataionsroom.entities.School

data class SchoolAndDirector(
    @Embedded val school: School,
    @Relation(
        parentColumn = "schoolName",
        entityColumn = "schoolName"
    )
    val director: Director
)