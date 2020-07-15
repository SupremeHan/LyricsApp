package android.singidunum.ac.rs.ispitrma.modules

import android.singidunum.ac.rs.ispitrma.data.db.ProjectDatabase
import android.singidunum.ac.rs.ispitrma.data.repository.FavouritesRepository
import android.singidunum.ac.rs.ispitrma.data.repository.FavouritesRepositoryImpl
import android.singidunum.ac.rs.ispitrma.presentation.viewmodel.FavouritesViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val favouritesModule = module {

    viewModel { FavouritesViewModel(get()) }

    single<FavouritesRepository> { FavouritesRepositoryImpl(get()) }

    single { get<ProjectDatabase>().getTracksDao() }

}