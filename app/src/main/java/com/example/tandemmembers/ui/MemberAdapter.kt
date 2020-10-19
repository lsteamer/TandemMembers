package com.example.tandemmembers.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView.*
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.tandemmembers.R
import com.example.tandemmembers.model.TandemMember
import kotlinx.android.synthetic.main.view_member.view.*

class MemberAdapter(
    private val members: List<TandemMember>
) : Adapter<MemberAdapter.MemberViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MemberViewHolder =
        MemberViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.view_member, parent, false)
        )

    override fun onBindViewHolder(holder: MemberViewHolder, position: Int) =
        holder.bind(members[position])


    override fun getItemCount(): Int = members.size

    class MemberViewHolder constructor(
        memberTandemView: View
    ) : ViewHolder(memberTandemView) {

        val memName = memberTandemView.tv_name
        val memTopic = memberTandemView.tv_topic
        val memImage = memberTandemView.iv_user_profile
        val memNative = memberTandemView.tv_native
        val memLearns = memberTandemView.tv_learns
        val memCounter = memberTandemView.tv_counter

        val requestOptions = RequestOptions()
            .placeholder(R.drawable.user_profile_default)
            .error(R.drawable.user_profile_default)

        fun bind(member: TandemMember) {
            memName.text = member.firstName
            memTopic.text = member.topic
            memCounter.text = member.referenceCnt.toString()
            Glide.with(itemView.context).applyDefaultRequestOptions(requestOptions)
                .load(member.pictureUrl)
                .into(memImage)

            memNative.text = member.natives.toString()
            memLearns.text = member.learns.toString()
        }

    }
}