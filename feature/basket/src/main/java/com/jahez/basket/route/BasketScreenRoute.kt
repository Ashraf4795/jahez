package com.jahez.basket.route

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.jahez.basket.BasketScreen
import com.jahez.basket.model.BasketOrderItem
import com.jahez.basket.model.BasketUiState
import com.jahez.basket.model.OrderPriceSummaryUiModel
import com.jahez.navigation.routes.AppRoute
import com.jahez.product_details.ProductDetailsUiModel


fun NavGraphBuilder.basketScreen(navController: NavController) {
    composable<AppRoute.BasketScreenRoute> {
        // todo: viewModel state collect here.
        val basketUiState = BasketUiState.Success(
            basketItems = listOf(
                BasketOrderItem(
                    productDetailsUiModel = ProductDetailsUiModel.getMock().copy(productId = "1"),
                    quantity = 1
                ),
                BasketOrderItem(
                    productDetailsUiModel = ProductDetailsUiModel.getMock().copy(productId = "2"),
                    quantity = 2
                ),
                BasketOrderItem(
                    productDetailsUiModel = ProductDetailsUiModel.getMock().copy(productId = "3", productOldPrice = 0f),
                    quantity = 2
                ),
                BasketOrderItem(
                    productDetailsUiModel = ProductDetailsUiModel.getMock().copy(productId = "4"),
                    quantity = 2
                ),
                BasketOrderItem(
                    productDetailsUiModel = ProductDetailsUiModel.getMock().copy(productId = "5"),
                    quantity = 1
                ),
                BasketOrderItem(
                    productDetailsUiModel = ProductDetailsUiModel.getMock().copy(productId = "6", productOldPrice = 19.99f),
                    quantity = 3
                ),
                BasketOrderItem(
                    productDetailsUiModel = ProductDetailsUiModel.getMock().copy(productId = "7"),
                    quantity = 1
                ),
                BasketOrderItem(
                    productDetailsUiModel = ProductDetailsUiModel.getMock().copy(productId = "8", productOldPrice = 0f),
                    quantity = 4
                ),
                BasketOrderItem(
                    productDetailsUiModel = ProductDetailsUiModel.getMock().copy(productId = "9"),
                    quantity = 2
                ),
                BasketOrderItem(
                    productDetailsUiModel = ProductDetailsUiModel.getMock().copy(productId = "10"),
                    quantity = 1
                )
            ),
            orderPriceSection = OrderPriceSummaryUiModel(
                subTotal = 90f,
                discount = 10,
                deliveryFee = 10f,
                currency = "EGP"
            )
        )

        BasketScreen (basketUiState = basketUiState) {
            navController.popBackStack()
        }
    }
}