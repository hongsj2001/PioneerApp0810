package org.pioneer.pioneerApp.Concert

import android.view.View
import org.pioneer.pioneerApp.Adapter.ConcertAdapter

interface onConcertItemClickListener {
    fun onItemClick(holder: ConcertAdapter.ViewHolder?, view: View?, position: Int)
}