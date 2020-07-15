package android.singidunum.ac.rs.ispitrma.modules

import android.singidunum.ac.rs.ispitrma.data.datasources.remote.TrackChartDataSource
import android.singidunum.ac.rs.ispitrma.data.repository.TrackChartRepository
import android.singidunum.ac.rs.ispitrma.data.repository.TrackChartRepositoryImpl
import android.singidunum.ac.rs.ispitrma.presentation.viewmodel.MainViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val trackChartModule = module {
    viewModel { MainViewModel(get()) }

    single<TrackChartRepository> { TrackChartRepositoryImpl(get()) }

    single<TrackChartDataSource> { create(get()) }
}