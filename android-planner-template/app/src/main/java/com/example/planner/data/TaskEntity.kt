package com.example.planner.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "tasks")
data class TaskEntity(
    @PrimaryKey(autoGenerate = true) val id: Long = 0,
    val title: String,
    val date: String, // yyyy-MM-dd
    val time: String, // HH:mm
    val note: String = "",
    val isDone: Boolean = false
)
