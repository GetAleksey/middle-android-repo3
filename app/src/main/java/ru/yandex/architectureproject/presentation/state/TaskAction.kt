package ru.yandex.architectureproject.presentation.state

sealed interface TaskAction {
    data object LoadTasks : TaskAction
    data class AddTask(val task: String) : TaskAction
    data class DeleteTask(val taskId: Int) : TaskAction
    data class UpdateTaskStatus(val taskId: Int, val isDone: Boolean) : TaskAction
}
