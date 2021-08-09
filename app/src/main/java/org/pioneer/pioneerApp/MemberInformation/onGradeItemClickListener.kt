package org.pioneer.pioneerApp.MemberInformation

import android.view.View
import org.pioneer.pioneerApp.Adapter.GradeAdapter

interface onGradeItemClickListener {
    fun onItemClick(holder: GradeAdapter.ViewHolder?, view: View?, position: Int)
}