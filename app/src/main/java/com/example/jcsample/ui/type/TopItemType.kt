package com.example.jcsample.ui.type

import android.content.Context
import com.example.jcsample.ui.screen.Screen

enum class TopItemType {
    GitRepo;

    fun title(context: Context): String {
        return when (this) {
            GitRepo -> context.getString(com.example.jcsample.R.string.git_repo_title)
        }
    }

    val screen: Screen
        get() {
            return when (this) {
                GitRepo -> Screen.GitRepo
            }
        }
}