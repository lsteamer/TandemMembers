package com.example.tandemmembers.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView.*
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.tandemmembers.R
import com.example.tandemmembers.cleanStringArrays
import com.example.tandemmembers.model.TandemMember
import kotlinx.android.synthetic.main.view_member.view.*

class MemberAdapter : Adapter<MemberAdapter.MemberViewHolder>() {

    private val members: MutableList<TandemMember> = mutableListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MemberViewHolder =
        MemberViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.view_member, parent, false)
        )

    override fun onBindViewHolder(holder: MemberViewHolder, position: Int) =
        holder.bind(members[position])

    override fun getItemCount(): Int = members.size

    fun setData(updatedMembers: List<TandemMember>) {
        this.members.clear()
        this.members.addAll(updatedMembers)
        notifyDataSetChanged()
    }

    class MemberViewHolder constructor(
        memberTandemView: View
    ) : ViewHolder(memberTandemView) {

        val memName = memberTandemView.tv_name
        val memTopic = memberTandemView.tv_topic
        val memImage = memberTandemView.iv_user_profile
        val memNative = memberTandemView.tv_native
        val memLearns = memberTandemView.tv_learns
        val memCounter = memberTandemView.tv_counter
        val memNewBadge = memberTandemView.iv_new

        val requestOptions = RequestOptions()
            .placeholder(R.drawable.user_profile_default)
            .error(R.drawable.user_profile_default)

        fun bind(member: TandemMember) {
            memName.text = member.firstName
            memTopic.text = member.topic

            memNative.text = member.natives.cleanStringArrays
            memLearns.text = member.learns.cleanStringArrays

            if (member.referenceCnt == 0) {
                memNewBadge.visibility = VISIBLE
            } else {
                memCounter.text = member.referenceCnt.toString()
            }

            Glide.with(itemView.context).applyDefaultRequestOptions(requestOptions)
                .load(member.pictureUrl)
                .into(memImage)
        }
    }
}