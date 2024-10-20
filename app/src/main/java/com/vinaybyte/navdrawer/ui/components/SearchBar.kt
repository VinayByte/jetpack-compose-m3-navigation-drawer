package com.vinaybyte.navdrawer.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.vinaybyte.navdrawer.R

/**
 * @Author: Vinay
 * @Date: 20-10-2024
 * @Github:VinayByte
 */
@Composable
fun SearchBar(
    modifier: Modifier = Modifier,
    onDrawerClick: () -> Unit,
    onSearchClick: () -> Unit
) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .clip(RoundedCornerShape(30.dp))
                .background(MaterialTheme.colorScheme.surface)
                .border(1.dp, Color.LightGray, RoundedCornerShape(30.dp))
                .clickable { onSearchClick() } // Activate search on click
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp, vertical = 8.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                IconButton(onClick = onDrawerClick) {
                    Icon(
                        Icons.Default.Menu,
                        contentDescription = stringResource(R.string.cd_drawer)
                    )
                }
                Text(
                    text = stringResource(id = R.string.search_hint),
                    color = Color.Gray,
                    modifier = Modifier.weight(1f)
                )
                Box(
                    modifier = Modifier
                        .size(40.dp)
                        .clip(CircleShape)
                        .background(Color.LightGray)
                ) {
                    IconButton(onClick = onSearchClick, modifier = Modifier.fillMaxSize()) {
                        Icon(
                            Icons.Default.Search,
                            contentDescription = stringResource(R.string.cd_trailing_icon)
                        )
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun SearchBarPreview() {
    MaterialTheme {
        SearchBar(
            onDrawerClick = {},
            onSearchClick = {},
        )
    }
}
