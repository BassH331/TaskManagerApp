package com.example.taskmanager

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.fragment.app.Fragment

class AboutDocFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.about_doc_fragment, container, false)

        val videoButton: Button = view.findViewById(R.id.videoButton)
        videoButton.setOnClickListener {
            Toast.makeText(context, "Opening demo video (placeholder)", Toast.LENGTH_SHORT).show()
        }

        return view
    }
}