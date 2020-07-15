package android.singidunum.ac.rs.ispitrma.presentation.view.viewpager

import android.singidunum.ac.rs.ispitrma.presentation.view.fragment.FirstFragment
import android.singidunum.ac.rs.ispitrma.presentation.view.fragment.SecondFragment
import android.singidunum.ac.rs.ispitrma.presentation.view.fragment.ThridFragment
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter

class PagerAdapter (fragmentManager: FragmentManager) : FragmentPagerAdapter(fragmentManager, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {

    companion object {
        private const val ITEM_COUNT = 2
        const val FRAGMENT_1 = 0
        const val FRAGMENT_2 = 1
    }

    override fun getItem(position: Int): Fragment {
        return when(position) {
            FRAGMENT_1 -> FirstFragment()
            else -> SecondFragment()
        }
    }

    override fun getCount(): Int {
        return ITEM_COUNT
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return when(position) {
            FRAGMENT_1 -> "Home"
            else -> "Fav Tracks"
        }
    }

}