package com.example.roommvvm.screens.addnote

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.example.roommvvm.APP
import com.example.roommvvm.R
import com.example.roommvvm.databinding.FragmentAddNoteBinding
import com.example.roommvvm.databinding.FragmentStartBinding
import com.example.roommvvm.model.NoteModel

class AddNoteFragment : Fragment() {

    lateinit var binding: FragmentAddNoteBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentAddNoteBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        init()
    }

    private fun init() {
        val viewModel = ViewModelProvider(this).get(AddNoteViewModel::class.java)

        binding.addButton.setOnClickListener {
            val title = binding.addTitleEditText.text.trim().toString()
            val desc = binding.addDescEditText.text.trim().toString()
            if (title.isEmpty() || desc.isEmpty()){
                Toast.makeText(APP, "Please enter all inputs", Toast.LENGTH_SHORT).show()
            } else {
                viewModel.insert(NoteModel(title = title, description = desc)){}
                APP.navController.navigate(R.id.action_addNoteFragment_to_startFragment)
            }

        }

        binding.backButton.setOnClickListener {
            APP.navController.navigate(R.id.action_addNoteFragment_to_startFragment)
        }
    }
}