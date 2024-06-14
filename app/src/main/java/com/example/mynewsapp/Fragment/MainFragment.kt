package com.example.mynewsapp.Fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mynewsapp.Adapter.NewsAdapter
import com.example.mynewsapp.ViewModel.NewsViewModel
import com.example.mynewsapp.databinding.MainFragmentBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainFragment : Fragment() {
        private lateinit var adapter: NewsAdapter
        private var _binding: MainFragmentBinding? = null
        private val binding get() = _binding
        private val viewModel: NewsViewModel by viewModel()
        override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
        ): View? {
            // Inflating the layout
            _binding = MainFragmentBinding.inflate(inflater, container, false)
            return _binding!!.root
        }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        // Set layout manager
        _binding!!.recyclerview.layoutManager = LinearLayoutManager(context)

        // Initialize adapter and set it to RecyclerView
        adapter = NewsAdapter(emptyList())
        _binding!!.recyclerview.adapter = adapter

        viewModel.newsData.observe(viewLifecycleOwner, Observer {newsItemList ->
            adapter.updateData(newsItemList)
        })

        // Fetch News Data
        viewModel.getNews()

        // fetchNewsData()

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

//    private fun fetchNewsData(){
//        val retrofitService = RetrofitInstance.getRetrofitInstance()
//            .create(NewsService::class.java)
//
//        val response = retrofitService.getNews()
//
//        response.enqueue(object: Callback<News> {
//            override fun onResponse(call: Call<News>, response: Response<News>) {
//                if(response.isSuccessful) {
//                    val newsList = response.body()?.newsList ?: emptyList()
//                    adapter.updateData(newsList)
//                }
//            }
//
//            override fun onFailure(call: Call<News>, t: Throwable) {
//                Log.d("tag","No News Found")
//            }
//        })
//    }
}
