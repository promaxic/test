package com.example.planner

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.room.Room
import com.example.planner.data.AppDatabase
import com.example.planner.data.TaskRepository
import com.example.planner.ui.PlannerScreen
import com.example.planner.viewmodel.TaskViewModel
import com.example.planner.viewmodel.TaskViewModelFactory

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        val db = Room.databaseBuilder(
            applicationContext,
            AppDatabase::class.java,
            "planner.db"
        ).build()

        val repository = TaskRepository(db.taskDao())
        val factory = TaskViewModelFactory(repository)

        setContent {
            val viewModel: TaskViewModel = viewModel(factory = factory)
            PlannerScreen(viewModel)
        }
    }
}
