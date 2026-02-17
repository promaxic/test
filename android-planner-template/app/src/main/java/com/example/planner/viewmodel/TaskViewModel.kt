package com.example.planner.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.example.planner.data.TaskEntity
import com.example.planner.data.TaskRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.flatMapLatest
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import java.time.LocalDate
import java.time.format.DateTimeFormatter

class TaskViewModel(private val repository: TaskRepository) : ViewModel() {
    private val formatter = DateTimeFormatter.ISO_DATE

    private val selectedDate = MutableStateFlow(LocalDate.now())

    val tasks: StateFlow<List<TaskEntity>> = selectedDate
        .flatMapLatest { date -> repository.observeTasksByDate(date.format(formatter)) }
        .stateIn(viewModelScope, SharingStarted.WhileSubscribed(5_000), emptyList())

    fun dateText(): String = selectedDate.value.format(formatter)

    fun shiftDate(days: Long) {
        selectedDate.value = selectedDate.value.plusDays(days)
    }

    fun addDemoTask() {
        viewModelScope.launch {
            val date = selectedDate.value.format(formatter)
            val nextHour = (8..20).random().toString().padStart(2, '0') + ":00"
            repository.addTask(
                title = "Задача ${System.currentTimeMillis() % 1000}",
                date = date,
                time = nextHour
            )
        }
    }

    fun toggleDone(task: TaskEntity) {
        viewModelScope.launch { repository.toggleDone(task) }
    }
}

class TaskViewModelFactory(private val repository: TaskRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(TaskViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return TaskViewModel(repository) as T
        }
        error("Unknown ViewModel class: ${modelClass.name}")
    }
}
