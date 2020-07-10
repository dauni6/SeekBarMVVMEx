package com.dontsu.seekbarmvvmex.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SeekBar
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.dontsu.seekbarmvvmex.R
import com.dontsu.seekbarmvvmex.databinding.FragmentSeekBarBinding
import com.dontsu.seekbarmvvmex.viewmodel.ShareViewModel


class SeekBarFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_seek_bar, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val viewModel = ViewModelProvider(requireActivity()).get(ShareViewModel::class.java)

        var binding: FragmentSeekBarBinding? = null
        view?.let {
            binding = DataBindingUtil.bind(view)
            binding!!.lifecycleOwner = requireActivity()
            binding!!.viewModel = viewModel

        }

        binding?.seekBar?.setOnSeekBarChangeListener(object: SeekBar.OnSeekBarChangeListener{
            override fun onProgressChanged(seekbar: SeekBar?, progress: Int, fromUser: Boolean) {
                viewModel.progress.value = progress
            }

            override fun onStartTrackingTouch(seekbar: SeekBar?) {

            }

            override fun onStopTrackingTouch(seekbar: SeekBar?) {

            }

        })

       /*viewModel.progress.observe(requireActivity(), Observer { progress ->
            // UI 업데이트
            binding?.seekBar?.progress = progress
        })*/

    }

}