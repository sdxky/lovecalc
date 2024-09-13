package com.example.lovecalc.ui.fragment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.setFragmentResult
import androidx.navigation.fragment.findNavController
import com.example.lovecalc.LoveModel
import com.example.lovecalc.R
import com.example.lovecalc.RetrofitService
import com.example.lovecalc.databinding.FragmentLoveCalcBinding
import com.example.lovecalc.interfaces.LoveCalcContract
import com.example.lovecalc.ui.presenters.LoveCalcPresenter


class LoveCalcFragment : Fragment(), LoveCalcContract.View {

    private lateinit var binding: FragmentLoveCalcBinding
    private lateinit var presenter: LoveCalcContract.Presenter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentLoveCalcBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        presenter = LoveCalcPresenter(this, RetrofitService)

        initListener()
    }

    private fun initListener() = with(binding) {
        btnCalculate.setOnClickListener {
            val firstName = et1.text.toString()
            val secondName = et2.text.toString()
            presenter.calculateLovePercentage(firstName, secondName)
        }
    }

    override fun showLoading() {
        // Показать индикатор загрузки
    }

    override fun hideLoading() {
        // Скрыть индикатор загрузки
    }

    override fun showResult(loveModel: LoveModel) {
        setFragmentResult(
            "KEY_ARG", bundleOf("data" to loveModel)
        )
    }

    override fun navigateToResult() {
        findNavController().navigate(R.id.resultFragment)
    }

    override fun showError(message: String) {
        Log.e("Error", message)
        // Показать сообщение об ошибке
    }
}