package com.example.tandemmembers.ui

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.example.tandemmembers.R
import com.example.tandemmembers.model.TandemMember
import androidx.lifecycle.Observer
import org.koin.androidx.viewmodel.ext.android.viewModel

class MembersFragment : Fragment(R.layout.fragment_members) {

    private val viewModel by viewModel<MembersViewModel>()

    private val membersObserver = Observer<List<TandemMember>> {

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) = init()

    private fun init() {
        initObservers()
    }


    private fun initObservers() {
        viewModel.membersLiveData2.observe(viewLifecycleOwner, membersObserver)
    }
}