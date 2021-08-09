package org.pioneer.pioneerApp.MemberInformation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_member.*
import org.pioneer.pioneerApp.Adapter.MemberAdapter
import org.pioneer.pioneerApp.R

class MemberActivity : AppCompatActivity() {

    val adapter = MemberAdapter()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_member)

        val requestCode = intent.getIntExtra("requestcode",0)
        val layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL,false)
        recyclerview.layoutManager=layoutManager

        when(requestCode) {
            42->{
                adapter.items.add(MemberModel("이승원","소비자학과","보컬","회장"))
                adapter.items.add(MemberModel("김예강","전자공학과","보컬","부회장"))
                adapter.items.add(MemberModel("신상훈","역사교육과","드럼","총무"))
                adapter.items.add(MemberModel("홍석준","전자공학과","기타","기장"))
                adapter.items.add(MemberModel("김보영","무역학부","기타","회원"))
                adapter.items.add(MemberModel("김준수","전자공학과","베이스","회원"))
            }
            43->{
                adapter.items.add(MemberModel("홍석준","전자공학과","기타","기장"))
                adapter.items.add(MemberModel("홍석준","전자공학과","기타","기장"))
                adapter.items.add(MemberModel("홍석준","전자공학과","기타","기장"))
                adapter.items.add(MemberModel("홍석준","전자공학과","기타","기장"))
            }
        }
        recyclerview.adapter=adapter
    }
}