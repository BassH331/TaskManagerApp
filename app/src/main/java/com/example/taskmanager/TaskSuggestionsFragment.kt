package com.example.taskmanager

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class TaskSuggestionsFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.task_suggestions_fragment, container, false)

        val suggestionList: RecyclerView = view.findViewById(R.id.suggestionList)
        val loadButton: Button = view.findViewById(R.id.loadSuggestionsButton)

        suggestionList.layoutManager = LinearLayoutManager(context)
        val adapter = SuggestionAdapter(emptyList())
        suggestionList.adapter = adapter

        loadButton.setOnClickListener {
            val mockSuggestions = listOf("Study Math", "Read Book", "Exercise")
            adapter.updateSuggestions(mockSuggestions)
        }

        return view
    }
}

class SuggestionAdapter(
    private var suggestions: List<String>
) : RecyclerView.Adapter<SuggestionAdapter.SuggestionViewHolder>() {

    class SuggestionViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val suggestionText: TextView = itemView.findViewById(android.R.id.text1)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SuggestionViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(android.R.layout.simple_list_item_1, parent, false)
        return SuggestionViewHolder(view)
    }

    override fun onBindViewHolder(holder: SuggestionViewHolder, position: Int) {
        holder.suggestionText.text = suggestions[position]
    }

    override fun getItemCount(): Int = suggestions.size

    fun updateSuggestions(newSuggestions: List<String>) {
        suggestions = newSuggestions
        notifyDataSetChanged()
    }
}