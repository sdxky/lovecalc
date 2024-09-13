package com.example.lovecalc.ui.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.setFragmentResultListener
import androidx.navigation.fragment.findNavController
import com.example.lovecalc.LoveModel
import com.example.lovecalc.R
import com.example.lovecalc.databinding.FragmentResultBinding
import com.example.lovecalc.interfaces.ResultContract
import com.example.lovecalc.ui.presenters.ResultPresenter
class ResultFragment : Fragment(), ResultContract.View {
    private lateinit var binding: FragmentResultBinding
    private lateinit var presenter: ResultContract.Presenter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentResultBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        presenter = ResultPresenter(this)
        fillInTheData()
        initListener()
    }

    private fun fillInTheData() = with(binding) {
        setFragmentResultListener("KEY_ARG") { _, bundle ->
            val result = bundle.getSerializable("data") as? LoveModel
            if (result != null) {
                showData(result)
            } else {
                Log.e("ResultFragment", "No data received or data is null")
            }
        }
    }

    private fun initListener() {
        binding.btnTryAgain.setOnClickListener {
            presenter.onTryAgainClicked()
        }
    }

    override fun showData(loveModel: LoveModel) = with(binding) {
        tvName1.text = loveModel.firstName
        tvName2.text = loveModel.secondName
        tvPercent.text = loveModel.percentage
        tvResult.text = loveModel.result
    }

    override fun navigateToCalculation() {
        findNavController().navigate(R.id.loveCalcFragment)
    }
}