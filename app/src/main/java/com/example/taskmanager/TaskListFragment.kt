package com.example.taskmanager

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class TaskListFragment : Fragment() {

    private lateinit var taskManager: TaskManager
    private lateinit var adapter: TaskAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.task_list_fragment, container, false)

        taskManager = TaskManager()

        val searchBar: EditText = view.findViewById(R.id.searchBar)
        val taskInput: EditText = view.findViewById(R.id.taskInput)
        val addButton: Button = view.findViewById(R.id.addButton)
        val taskList: RecyclerView = view.findViewById(R.id.taskList)
        val deleteCompletedButton: Button = view.findViewById(R.id.deleteCompletedButton)

        taskList.layoutManager = LinearLayoutManager(context)
        adapter = TaskAdapter(taskManager.getTasks()) { task ->
            taskManager.deleteTask(task)
            adapter.updateTasks(taskManager.getTasks())
            Toast.makeText(context, "Task deleted: ${task.title}", Toast.LENGTH_SHORT).show()
        }
        taskList.adapter = adapter

        addButton.setOnClickListener {
            val taskTitle = taskInput.text.toString().trim()
            if (taskTitle.isNotEmpty()) {
                val newTask = Task().apply {
                    title = taskTitle
                    description = "Details to be added later"
                    isCompleted = false
                }
                taskManager.addTask(newTask)
                adapter.updateTasks(taskManager.getTasks())
                taskInput.text.clear()
                Toast.makeText(context, "Task added: $taskTitle", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(context, "Please enter a task!", Toast.LENGTH_SHORT).show()
            }
        }

        deleteCompletedButton.setOnClickListener {
            val completedTasks = taskManager.getTasks().filter { it.isCompleted }
            completedTasks.forEach { taskManager.deleteTask(it) }
            adapter.updateTasks(taskManager.getTasks())
            Toast.makeText(context, "Completed tasks deleted", Toast.LENGTH_SHORT).show()
        }

        searchBar.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                val query = s.toString().trim()
                val filteredTasks = taskManager.getTasks().filter {
                    it.title.contains(query, ignoreCase = true)
                }
                adapter.updateTasks(filteredTasks)
            }
            override fun afterTextChanged(s: Editable?) {}
        })

        return view
    }
}

class TaskAdapter(
    private var tasks: List<Task>,
    private val onLongClick: (Task) -> Unit
) : RecyclerView.Adapter<TaskAdapter.TaskViewHolder>() {

    class TaskViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val taskTitle: android.widget.TextView = itemView.findViewById(R.id.taskTitle)
        val taskCheckBox: android.widget.CheckBox = itemView.findViewById(R.id.taskCheckBox)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TaskViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.task_item, parent, false)
        return TaskViewHolder(view)
    }

    override fun onBindViewHolder(holder: TaskViewHolder, position: Int) {
        val task = tasks[position]
        holder.taskTitle.text = task.title
        holder.taskCheckBox.isChecked = task.isCompleted

        holder.taskCheckBox.setOnCheckedChangeListener { _, isChecked ->
            task.setStatus(isChecked)
        }

        holder.itemView.setOnLongClickListener {
            onLongClick(task)
            true
        }
    }

    override fun getItemCount(): Int = tasks.size

    fun updateTasks(newTasks: List<Task>) {
        tasks = newTasks
        notifyDataSetChanged()
    }
}