package com.example.planner.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Checkbox
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.planner.data.TaskEntity
import com.example.planner.viewmodel.TaskViewModel

@Composable
fun PlannerScreen(viewModel: TaskViewModel) {
    val tasks by viewModel.tasks.collectAsState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        Text("Планер на ${viewModel.dateText()}", style = MaterialTheme.typography.headlineSmall)

        Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
            Button(onClick = { viewModel.shiftDate(-1) }) { Text("-1 день") }
            Button(onClick = { viewModel.shiftDate(1) }) { Text("+1 день") }
        }

        Button(onClick = viewModel::addDemoTask) {
            Text("Добавить демо-задачу")
        }

        if (tasks.isEmpty()) {
            Text("На выбранную дату задач пока нет")
        } else {
            LazyColumn(verticalArrangement = Arrangement.spacedBy(8.dp)) {
                items(tasks, key = { it.id }) { task ->
                    TaskRow(task = task, onToggle = { viewModel.toggleDone(task) })
                }
            }
        }
    }
}

@Composable
private fun TaskRow(task: TaskEntity, onToggle: () -> Unit) {
    Card(modifier = Modifier.fillMaxWidth()) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(12.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Column(modifier = Modifier.weight(1f)) {
                Text(text = "${task.time} — ${task.title}", style = MaterialTheme.typography.titleMedium)
                if (task.note.isNotBlank()) {
                    Text(text = task.note, style = MaterialTheme.typography.bodyMedium)
                }
            }
            Checkbox(checked = task.isDone, onCheckedChange = { onToggle() })
        }
    }
}
