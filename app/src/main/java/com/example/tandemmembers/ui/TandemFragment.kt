package com.example.tandemmembers.ui

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.example.tandemmembers.R
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.fragment_members.*
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel

class TandemFragment : Fragment(R.layout.fragment_members) {

    private val viewModel by viewModel<TandemViewModel>()
    private val memberAdapter by lazy { MemberAdapter() }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        getTandemMembers()

        recycler_view.layoutManager = LinearLayoutManager(context)
        recycler_view.adapter = memberAdapter
    }

    private fun getTandemMembers(){
        lifecycleScope.launch {
            viewModel.getMembers().collect {
                memberAdapter.submitData(it)
            }
        }
    }
}