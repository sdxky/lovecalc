package com.example.lovecalc.interfaces

import com.example.lovecalc.LoveModel

interface ResultContract {
    interface View {
        fun showData(loveModel: LoveModel)
        fun navigateToCalculation()
    }

    interface Presenter {
        fun onDataReceived(model: LoveModel)
        fun onTryAgainClicked()
    }
}