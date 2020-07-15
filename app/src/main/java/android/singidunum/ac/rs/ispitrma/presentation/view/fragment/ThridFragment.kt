package android.singidunum.ac.rs.ispitrma.presentation.view.fragment

import android.os.Bundle
import android.singidunum.ac.rs.ispitrma.R
import android.singidunum.ac.rs.ispitrma.presentation.contract.MainContract
import android.singidunum.ac.rs.ispitrma.presentation.view.recycler.adapter.TrackAdapter
import android.singidunum.ac.rs.ispitrma.presentation.view.recycler.diff.TrackDiffItemCallBack
import android.singidunum.ac.rs.ispitrma.presentation.viewmodel.MainViewModel
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.fragment_third.*
import org.koin.androidx.viewmodel.ext.android.viewModel
import timber.log.Timber

class ThridFragment : Fragment(R.layout.fragment_third)