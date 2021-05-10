package com.example.lablyrics.testDI

import com.example.lablyrics.di.LyricsApplication
import org.robolectric.RuntimeEnvironment
import androidx.test.core.app.ApplicationProvider

val testInjector: TestComponent
        get(){

                val application = ApplicationProvider.getApplicationContext() as LyricsApplication
                val component = DaggerTestComponent.builder().testModule(TestModule(application.applicationContext)).build()
                application.injector = component
                return component
        }