package com.google.firebase.quickstart.auth.absafeargs_parcelize

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.google.firebase.quickstart.auth.absafeargs_parcelize.databinding.FragmentExamScoreBinding


class ExamScoreFragment : Fragment() {
    private lateinit var binding: FragmentExamScoreBinding
    private val args: ExamScoreFragmentArgs by navArgs()
    private val midtermExamPercentage = 0.4
    private val finalExamPercentage = 0.6

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentExamScoreBinding.inflate(inflater, container, false)
        val courseName = args.exam.courseName
        val midtermExamScore = args.exam.midtermExamScore
        val finalExamScore = args.exam.finalExamScore
        val averageExamScore = calculateAverageScore(midtermExamScore, finalExamScore)

        binding.textViewCourseName.text = "$courseName Course Exam Scores"
        binding.textViewMidtermExamScore.text = "Midterm Exam Score: $midtermExamScore"
        binding.textViewFinalExamScore.text = "Final Exam Score: $finalExamScore"
        binding.textViewAverageExamScore.text = "Average Score: $averageExamScore"

        return binding.root
    }

    private fun calculateAverageScore(midtermExamScore: Double, finalExamScore: Double): Double {
        return (midtermExamScore * midtermExamPercentage) + (finalExamScore * finalExamPercentage)
    }
}