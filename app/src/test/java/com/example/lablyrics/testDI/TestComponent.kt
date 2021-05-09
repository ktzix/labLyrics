package com.example.lablyrics.testDI

import com.example.lablyrics.di.LyricsComponent
import com.example.lablyrics.test.ExampleUnitTest
import com.example.lablyrics.test.LyricsTest
import com.example.lablyrics.test.SearchTest
import dagger.Component
import javax.inject.Singleton


@Singleton
@Component(modules = [TestModule::class])
interface TestComponent: LyricsComponent{
    fun inject(exampleUnitTest: ExampleUnitTest)
    fun inject(searchTest: SearchTest)
    fun inject(lyricsTest: LyricsTest)

}