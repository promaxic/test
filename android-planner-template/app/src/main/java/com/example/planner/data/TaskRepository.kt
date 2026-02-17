package com.example.planner.data

import kotlinx.coroutines.flow.Flow

class TaskRepository(private val taskDao: TaskDao) {
    fun observeTasksByDate(date: String): Flow<List<TaskEntity>> = taskDao.observeTasksByDate(date)

    suspend fun addTask(title: String, date: String, time: String, note: String = "") {
        taskDao.insert(TaskEntity(title = title, date = date, time = time, note = note))
    }

    suspend fun toggleDone(task: TaskEntity) {
        taskDao.update(task.copy(isDone = !task.isDone))
    }
}
