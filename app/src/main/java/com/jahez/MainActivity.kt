package com.jahez

import android.content.Context
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.displayCutout
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeContent
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import com.jahez.ui.JahezApp
import com.jahez.ui.theme.JahezTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            JahezTheme {
                Scaffold(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(WindowInsets.displayCutout.asPaddingValues()),
                    contentWindowInsets = WindowInsets.safeContent,
                ) { innerPadding ->
                    JahezApp(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }

    fun showMsg(context: Context, msg: String) {
        Toast.makeText(context, msg, Toast.LENGTH_SHORT).show()
    }
}