package com.example.mynewsapp.Fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.mynewsapp.Adapter.NewsAdapter
import com.example.mynewsapp.databinding.NewsFragmentBinding

class NewsFragment : Fragment() {
    private lateinit var adapter: NewsAdapter
    private lateinit var binding: NewsFragmentBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflating the layout
        binding = NewsFragmentBinding.inflate(inflater, container, false)

        return binding.root
    }

}