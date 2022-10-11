package com.google.firebase.quickstart.auth.absafeargs_parcelize

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Exam(
    val courseName: String,
    val midtermExamScore: Double,
    val finalExamScore: Double,
) : Parcelable