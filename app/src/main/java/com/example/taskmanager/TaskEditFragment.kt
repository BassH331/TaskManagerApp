package com.example.taskmanagerapp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.taskmanager.R
import com.google.android.material.button.MaterialButton

class TaskListFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.task_list_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        // Set up Add Button
        view.findViewById<MaterialButton>(R.id.addButton)?.setOnClickListener {
            findNavController().navigate(R.id.action_taskList_to_taskEdit)
        }
        // TODO: Set up RecyclerView with task adapter
        // TODO: Set up searchBar functionality
        // TODO: Set up deleteCompletedButton functionality
    }
}