package com.jahez.search

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavController
import com.jahez.EmptyView
import com.jahez.inputs.AnimatedSearchBar


@Composable
fun SearchScreen(
    modifier: Modifier = Modifier,
    searchViewModel: SearchViewModel = hiltViewModel<SearchViewModel>(),
    navController: NavController
) {
    val searchUiState by searchViewModel.searchUiState.collectAsStateWithLifecycle()

    SearchScreenImpl(
        modifier = modifier,
        searchUiState = searchUiState,
        onSearch = { query -> /* Handle search */ },
        onClose = { navController.popBackStack() }
    )
}

@Composable
private fun SearchScreenImpl(
    modifier: Modifier = Modifier,
    searchUiState: SearchUiState,
    onSearch: (String) -> Unit,
    onClose: () -> Unit
) {
    Box(
        modifier = modifier
            .background(MaterialTheme.colorScheme.primary.copy(alpha = 0.5f))
            .clickable(onClick = onClose)
    ) {
        Column(
            modifier = Modifier
                .background(MaterialTheme.colorScheme.surface)
                .padding(16.dp)
        ) {

            when (searchUiState) {
                is SearchUiState.Loading -> {
                    CircularProgressIndicator()
                }

                is SearchUiState.Idle -> {
                    EmptyView(Modifier.weight(1f))
                }

                is SearchUiState.Success -> {
                    SearchScreenContent(
                        searchUiState = searchUiState,
                        onSearch = onSearch
                    )
                }
            }

        }
    }
}


@Composable
private fun ColumnScope.SearchScreenContent(
    searchUiState: SearchUiState.Success,
    onSearch: (String) -> Unit
) {
    AnimatedSearchBar(
        modifier = Modifier.fillMaxWidth(),
        onValueChange = { query ->
            onSearch(query)
        }
    )

    Spacer(modifier = Modifier.height(8.dp))

    LazyColumn (
        modifier = Modifier.weight(1f)
    ){
        items(searchUiState.searchResults) { result ->
            Text(
                text = result,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(12.dp)
                    .clickable { /* Handle selection */ },
                style = MaterialTheme.typography.bodyMedium
            )
            HorizontalDivider()
        }
    }
}


@Preview
@Composable
private fun SearchScreenPreview() {
    SearchScreenImpl(
        searchUiState = SearchUiState.Idle,
        onSearch = {},
        onClose = {}
    )
}