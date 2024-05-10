package com.example.jcsample.ui.screen

enum class Screen {
    Top,
    GitRepo,
    WebView;

    val route: String
        get() {
            return when (this) {
                Top -> "top"
                GitRepo -> "gitRepo"
                WebView -> "web-view/?url={url}"
            }
        }
}