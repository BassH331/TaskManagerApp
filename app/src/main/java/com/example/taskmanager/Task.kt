package com.example.taskmanager

class Task {
    var title: String = ""
    var description: String = ""
    var isCompleted: Boolean = false

    fun setStatus(done: Boolean) {
        isCompleted = done
    }
}