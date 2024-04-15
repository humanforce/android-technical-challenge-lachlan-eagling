package com.humanforce.practice

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import com.humanforce.practice.models.ShiftDetail
import com.humanforce.practice.ui.theme.HumanofrcePracticeAppTheme
import com.humanforce.practice.viewmodel.MainActivityViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            HumanofrcePracticeAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
                    ShiftListScreen()
                }
            }
        }
    }
}

@Composable
fun ShiftListScreen(viewModel: MainActivityViewModel = viewModel()) {
    // TODO
}


@Composable
fun ShiftDetailsScreen(shiftDetail: ShiftDetail) {
    // TODO
}


@Preview(showBackground = true)
@Composable
fun ShiftListPreview() {
    HumanofrcePracticeAppTheme {
       // TODO
    }
}