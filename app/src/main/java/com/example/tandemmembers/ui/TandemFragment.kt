package com.example.tandemmembers.ui

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.example.tandemmembers.R
import com.example.tandemmembers.model.TandemMember
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.fragment_members.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class TandemFragment : Fragment(R.layout.fragment_members) {

    private val viewModel by viewModel<TandemViewModel>()
    private val memberAdapter by lazy { MemberAdapter() }

    private val membersObserver = Observer<List<TandemMember>> {
        memberAdapter.setData(it)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        viewModel.tandemMembersLiveData.observe(viewLifecycleOwner, membersObserver)

        recycler_view.layoutManager = LinearLayoutManager(context)
        recycler_view.adapter = memberAdapter
    }
}