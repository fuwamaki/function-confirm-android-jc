package com.example.jcsample.ui.screen.webview

import android.view.ViewGroup
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.viewinterop.AndroidView
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.jcsample.ui.component.CommonTopBar

@Composable
fun WebViewScreen(
    url: String,
    navController: NavController,
    webViewModel: WebViewModel = viewModel(),
) {
    val isLoading = webViewModel.isLoading.collectAsState().value
    val title = webViewModel.title.collectAsState().value

    Scaffold(
        topBar = { CommonTopBar(navController, string = title) },
    ) { innerPadding ->
        AndroidView({ context ->
            WebView(context).apply {
                layoutParams = ViewGroup.LayoutParams(
                    ViewGroup.LayoutParams.MATCH_PARENT,
                    ViewGroup.LayoutParams.MATCH_PARENT
                )
                webViewClient = object : WebViewClient() {
                    override fun onPageFinished(view: WebView?, url: String?) {
                        super.onPageFinished(view, url)

                        webViewModel.onPageFinished(view?.title)
                    }
                }
                loadUrl(url)
            }
        }, modifier = Modifier.padding(innerPadding))
    }
}