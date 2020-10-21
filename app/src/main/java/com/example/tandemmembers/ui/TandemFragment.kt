package com.example.tandemmembers.ui

import android.os.Bundle
import android.view.View
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import com.example.tandemmembers.R
import androidx.lifecycle.lifecycleScope
import androidx.paging.LoadState
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.fragment_members.*
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.viewModel

class TandemFragment : Fragment(R.layout.fragment_members) {

    private val viewModel by viewModel<TandemViewModel>()
    private val memberAdapter: TandemAdapter by inject()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        getTandemMembers()
        initAdapter()
        retry_button.setOnClickListener { memberAdapter.retry() }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        recycler_view.adapter = null
    }

    private fun initAdapter(){
        recycler_view.layoutManager = LinearLayoutManager(context)
        recycler_view.adapter = memberAdapter

        memberAdapter.addLoadStateListener { loadState ->
            recycler_view.isVisible = loadState.source.refresh is LoadState.NotLoading
            progressBar.isVisible = loadState.source.refresh is LoadState.Loading
            retry_button.isVisible = loadState.source.refresh is LoadState.Error
        }
    }

    private fun getTandemMembers() {
        lifecycleScope.launch {
            viewModel.getMembers().collect {
                memberAdapter.submitData(it)
            }
        }
    }
}