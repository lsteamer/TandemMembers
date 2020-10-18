package com.example.tandemmembers.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView.*
import com.example.tandemmembers.R
import com.example.tandemmembers.model.TandemMember

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

        //why can't I use
        val memName = memberTandemView.findViewById<TextView>(R.id.name)
        val memImage = memberTandemView.findViewById<ImageView>(R.id.iv_user_profile)

        fun bind(member: TandemMember) {
            memName.text = member.firstName
            memImage.setImageResource(R.drawable.user_profile_default)
        }

    }
}