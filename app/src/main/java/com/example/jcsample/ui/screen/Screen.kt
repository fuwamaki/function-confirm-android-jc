package com.example.jcsample.ui.screen

enum class Screen {
    Top,
    GitRepo,
    ThreeList,
    WebView;

    val route: String
        get() {
            return when (this) {
                Top -> "top"
                GitRepo -> "gitRepo"
                ThreeList -> "threeList"
                WebView -> "web-view/?url={url}"
            }
        }
}