package com.google.firebase.quickstart.auth.absafeargs_parcelize

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.google.firebase.quickstart.auth.absafeargs_parcelize.databinding.FragmentExamInformationBinding


class ExamInformationFragment : Fragment() {
    private lateinit var binding: FragmentExamInformationBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentExamInformationBinding.inflate(inflater, container, false)

        binding.buttonCalculateAverageScore.setOnClickListener {
            val courseName = binding.textInputEditTextCourseName.text.toString()
            val midtermExamScore =
                binding.textInputEditTextMidtermExamScore.text.toString().toDouble()
            val finalExamScore =
                binding.textInputEditTextFinalExamScore.text.toString().toDouble()

            val exam = Exam(courseName, midtermExamScore, finalExamScore)

            val action = ExamInformationFragmentDirections.actionExamInformationFragmentToExamScoreFragment(exam)
            findNavController().navigate(action)
        }

        return binding.root
    }
}