package com.example.tandemmembers.ui

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.example.tandemmembers.R
import com.example.tandemmembers.model.TandemMember
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import org.koin.androidx.viewmodel.ext.android.viewModel

class MembersFragment : Fragment(R.layout.fragment_members) {

    private val viewModel by viewModel<MembersViewModel>()
    private lateinit var memberAdapter: MemberAdapter

    private lateinit var recyclerView: RecyclerView

    private val membersObserver = Observer<List<TandemMember>> {
        memberAdapter = MemberAdapter(it)
        recyclerView.layoutManager = LinearLayoutManager(context)
        recyclerView.adapter = memberAdapter
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        init()

        //synth not working, view binding?
        recyclerView = view.findViewById(R.id.recycler_view)

    }

    private fun init() {
        initObservers()
    }


    private fun initObservers() {
        viewModel.membersLiveData2.observe(viewLifecycleOwner, membersObserver)
    }
}