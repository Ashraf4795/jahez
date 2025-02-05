package com.jahez.home.ui.sections

import androidx.compose.foundation.lazy.LazyListScope
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.ui.Modifier
import com.jahez.CategoryCard
import com.jahez.home.CategoriesWidget


fun LazyListScope.CategoriesSection(
    modifier: Modifier = Modifier,
    categoriesWidget: CategoriesWidget
) {

    if (categoriesWidget.categories.isNotEmpty() == true) {
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