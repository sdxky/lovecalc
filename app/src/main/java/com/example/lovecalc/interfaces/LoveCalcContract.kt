package com.example.lovecalc.interfaces

import com.example.lovecalc.LoveModel

interface LoveCalcContract {
    interface View {
        fun showResult(loveModel: LoveModel)
        fun showError(message: String)
        fun navigateToResult()
    }

    interface Presenter {
        fun calculateLovePercentage(firstName: String, secondName: String)
    }
}