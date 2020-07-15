package android.singidunum.ac.rs.ispitrma.modules

import android.singidunum.ac.rs.ispitrma.data.datasources.remote.LyricsService
import android.singidunum.ac.rs.ispitrma.data.repository.LyricsRepository
import android.singidunum.ac.rs.ispitrma.data.repository.LyricsRepositoryImpl
import android.singidunum.ac.rs.ispitrma.presentation.viewmodel.LyricsViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val lyricsModule = module {

    viewModel { LyricsViewModel(get()) }

    single<LyricsRepository> { LyricsRepositoryImpl(get()) }

    single<LyricsService> { create(get()) }
}