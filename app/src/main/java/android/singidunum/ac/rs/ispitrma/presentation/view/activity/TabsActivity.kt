package android.singidunum.ac.rs.ispitrma.presentation.view.activity

import android.os.Bundle
import android.singidunum.ac.rs.ispitrma.R
import android.singidunum.ac.rs.ispitrma.presentation.view.viewpager.PagerAdapter
import androidx.appcompat.app.AppCompatActivity

import kotlinx.android.synthetic.main.activity_tabs.*

class TabsActivity : AppCompatActivity(R.layout.activity_tabs) {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        init()
    }

    private fun init() {
        initTabs()
    }

    private fun initTabs() {
        viewPager.adapter = PagerAdapter(supportFragmentManager)
        tabLayout.setupWithViewPager(viewPager)
    }
}