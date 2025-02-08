package com.jahez.home.ui.sections

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListScope
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.jahez.CategoryCard
import com.jahez.home.CategoriesWidget
import com.jahez.home_data.datasource.remote.fake.fakeHomePageContent


fun LazyListScope.CategoriesSection(
    modifier: Modifier = Modifier,
    categoriesWidget: CategoriesWidget?
) {

    if (categoriesWidget?.categories?.isNotEmpty() == true) {
        item {
            LazyRow(modifier) {
                items(categoriesWidget.categories.size) { index ->
                    val category = categoriesWidget.categories[index]
                    CategoryCard(category = category)
                }
            }
        }
    }
}

@Preview
@Composable
private fun PreviewCategorySection() {
    LazyColumn {
        CategoriesSection(
            categoriesWidget = fakeHomePageContent.categoriesWidget
        )
    }
}