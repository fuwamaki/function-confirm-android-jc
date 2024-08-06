package com.example.jcsample.ui.type

import android.content.Context
import com.example.jcsample.R
import com.example.jcsample.ui.screen.Screen

enum class TopItemType {
    GitRepo,
    ThreeList;

    fun title(context: Context): String {
        return when (this) {
            GitRepo -> context.getString(R.string.git_repo_title)
            ThreeList -> context.getString(R.string.three_list_title)
        }
    }

    val screen: Screen
        get() {
            return when (this) {
                GitRepo -> Screen.GitRepo
                ThreeList -> Screen.ThreeList
            }
        }
}