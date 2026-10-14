package com.example.dessertclicker.ui

import com.example.dessertclicker.R
import org.junit.Assert.assertEquals
import org.junit.Test

class DessertViewModelTest {

    @Test
    fun dessertViewModel_initialState_isCorrect() {
        val viewModel = DessertViewModel()
        val uiState = viewModel.dessertUiState.value

        assertEquals(0, uiState.dessertsSold)
        assertEquals(0, uiState.revenue)
        assertEquals(0, uiState.currentDessertIndex)
        assertEquals(5, uiState.currentDessertPrice)
        assertEquals(R.drawable.cupcake, uiState.currentDessertImageId)
    }

    @Test
    fun dessertViewModel_onDessertClicked_incrementsSoldAndRevenue() {
        val viewModel = DessertViewModel()
        viewModel.onDessertClicked()

        val uiState = viewModel.dessertUiState.value
        assertEquals(1, uiState.dessertsSold)
        assertEquals(5, uiState.revenue)
        assertEquals(0, uiState.currentDessertIndex)
    }

    @Test
    fun dessertViewModel_onDessertClicked_updatesDessertWhenThresholdReached() {
        val viewModel = DessertViewModel()
        repeat(5) {
            viewModel.onDessertClicked()
        }

        val uiState = viewModel.dessertUiState.value
        assertEquals(5, uiState.dessertsSold)
        assertEquals(25, uiState.revenue)
        assertEquals(1, uiState.currentDessertIndex)
        assertEquals(10, uiState.currentDessertPrice)
        assertEquals(R.drawable.donut, uiState.currentDessertImageId)
    }
}
