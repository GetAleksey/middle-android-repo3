package ru.yandex.architectureproject.utils

import kotlinx.coroutines.Job
import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty

fun job(): ReadWriteProperty<Any?, Job?> = JobDelegate()

private class JobDelegate : ReadWriteProperty<Any?, Job?> {

    @Volatile
    private var currentJob: Job? = null

    override operator fun getValue(thisRef: Any?, property: KProperty<*>): Job? {
        return currentJob
    }

    override operator fun setValue(thisRef: Any?, property: KProperty<*>, value: Job?) {
        synchronized(this) {
            currentJob?.cancel()
            currentJob = value
        }
    }
}
