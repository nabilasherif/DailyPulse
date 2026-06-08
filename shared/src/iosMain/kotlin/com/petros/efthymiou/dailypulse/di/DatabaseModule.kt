package com.petros.efthymiou.dailypulse.di

import app.cash.sqldelight.db.SqlDriver
import com.petros.efthymiou.dailypulse.DailyPulseDatabase
import com.petros.efthymiou.dailypulse.db.DatabaseDriverFactory
import org.koin.dsl.module

val databaseModule = module{
    single<SqlDriver>{ DatabaseDriverFactory().createDriver() }
    single<DailyPulseDatabase> { DailyPulseDatabase(get()) }

}