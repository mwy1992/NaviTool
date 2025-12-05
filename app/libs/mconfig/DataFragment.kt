package ru.monjaro.mconfig

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import ru.monjaro.mconfig.databinding.DataFragmentBinding



class DataFragment : Fragment() {

    private var _binding: DataFragmentBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = DataFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onResume() {
        super.onResume()
        binding.root.invalidate()
        binding.root.requestLayout()
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}