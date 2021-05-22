package com.shubhamkumarwinner.relataionsroom.entities.relations

import androidx.room.Embedded
import androidx.room.Junction
import androidx.room.Relation
import com.shubhamkumarwinner.relataionsroom.entities.Student
import com.shubhamkumarwinner.relataionsroom.entities.Subject

data class SubjectWithStudents(
    @Embedded val subject: Subject,
    @Relation(
        parentColumn = "subjectName",
        entityColumn = "studentName",
        associateBy = Junction(StudentSubjectCrossRef::class)
    )
    val students: List<Student>
)
