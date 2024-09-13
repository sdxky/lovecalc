package com.example.lovecalc.ui.presenters

import com.example.lovecalc.LoveModel
import com.example.lovecalc.interfaces.ResultContract

class ResultPresenter(private val view: ResultContract.View) : ResultContract.Presenter {

    override fun onDataReceived(model: LoveModel) {
        view.showData(model)
    }

    override fun onTryAgainClicked() {
        view.navigateToCalculation()
    }
}