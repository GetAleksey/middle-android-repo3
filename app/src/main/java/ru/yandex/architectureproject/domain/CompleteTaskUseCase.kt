package ru.yandex.architectureproject.domain

import kotlinx.coroutines.delay
import ru.yandex.architectureproject.data.repository.TaskRepository

private const val AUTO_DELETE_DELAY_MS = 10_000L

class CompleteTaskUseCase(
    private val repository: TaskRepository,
) {
    suspend operator fun invoke(taskId: Int) {
        repository.completeTask(taskId)
        delay(AUTO_DELETE_DELAY_MS)
        repository.deleteTask(taskId)
    }
}
