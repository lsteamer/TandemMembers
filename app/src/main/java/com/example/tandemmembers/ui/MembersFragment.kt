package com.example.tandemmembers.ui

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.example.tandemmembers.R
import com.example.tandemmembers.model.TandemMember
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.fragment_members.view.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class MembersFragment : Fragment(R.layout.fragment_members) {

    private val viewModel by viewModel<MembersViewModel>()
    private lateinit var memberAdapter: MemberAdapter

    private lateinit var recyclerView: RecyclerView

    private val membersObserver = Observer<List<TandemMember>> {
        memberAdapter = MemberAdapter(it)
        recyclerView.adapter = memberAdapter
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        viewModel.tandemMembersLiveData.observe(viewLifecycleOwner, membersObserver)

        recyclerView = view.recycler_view
        recyclerView.layoutManager = LinearLayoutManager(context)

    }
}