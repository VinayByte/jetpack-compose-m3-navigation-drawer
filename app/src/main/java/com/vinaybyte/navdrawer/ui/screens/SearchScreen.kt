package com.vinaybyte.navdrawer.ui.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.vinaybyte.navdrawer.R

/**
 * @Author: Vinay
 * @Date: 20-10-2024
 * @Github:VinayByte
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchScreen(navController: NavHostController) {
    var searchQuery by remember { mutableStateOf("") }
    var searchResults by remember { mutableStateOf(listOf<String>()) }

    Column {
        TopAppBar(
            title = {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    IconButton(onClick = { navController.navigateUp() }) {
                        Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "Back")
                    }
                    BasicTextField(
                        value = searchQuery,
                        onValueChange = { searchQuery = it },
                        modifier = Modifier.weight(1f),
                        decorationBox = { innerTextField ->
                            Box(Modifier.padding(8.dp)) {
                                if (searchQuery.isEmpty()) {
                                    Text(
                                        text = stringResource(R.string.search_hint),
                                        color = Color.Gray
                                    )
                                }
                                innerTextField()
                            }
                        },
                        textStyle = TextStyle(color = Color.Black)
                    )
                    IconButton(onClick = {
                        searchResults = listOf("Result 1", "Result 2", "Result 3")
                    }) {
                        Icon(Icons.Default.Search, contentDescription = "Search")
                    }
                }
            }
        )

        Column(modifier = Modifier.padding(16.dp)) {
            for (result in searchResults) {
                Text(text = result, modifier = Modifier.padding(vertical = 8.dp))
            }
        }
    }
}
