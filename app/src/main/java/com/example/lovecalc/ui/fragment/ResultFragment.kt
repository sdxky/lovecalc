package com.example.lovecalc.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.setFragmentResultListener
import androidx.navigation.fragment.findNavController
import com.example.lovecalc.LoveModel
import com.example.lovecalc.R
import com.example.lovecalc.databinding.FragmentResultBinding

class ResultFragment : Fragment() {
    private lateinit var binding: FragmentResultBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentResultBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        fillInTheData()
        initListener()
    }

    private fun initListener() {
        binding.btnTryAgain.setOnClickListener {
            findNavController().navigate(R.id.loveCalcFragment)
        }
    }

    private fun fillInTheData() = with(binding) {
        setFragmentResultListener("key") {_, bundle ->
            val result = bundle.getSerializable("data") as? LoveModel
            tvName1.text = result?.firstName
            tvName2.text = result?.secondName
            tvPercent.text = result?.percentage
            tvResult.text = result?.result
        }
    }
}