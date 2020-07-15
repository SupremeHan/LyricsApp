package android.singidunum.ac.rs.ispitrma.presentation.view.activity


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.singidunum.ac.rs.ispitrma.R
import kotlinx.android.synthetic.main.activity_tabs.*

class MainActivity : AppCompatActivity(R.layout.activity_tabs) {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        init()
    }

    private fun init() {
       initTabs()
    }

    private fun initTabs() {
        viewPager.adapter = android.singidunum.ac.rs.ispitrma.presentation.view.viewpager.PagerAdapter(supportFragmentManager)
        tabLayout.setupWithViewPager(viewPager)
    }

}
