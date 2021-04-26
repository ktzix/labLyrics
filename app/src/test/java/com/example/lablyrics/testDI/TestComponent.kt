package com.example.lablyrics.testDI

import com.example.lablyrics.test.ExampleUnitTest
import dagger.Component
import javax.inject.Singleton


@Singleton
@Component(modules = [TestModule::class])
interface TestComponent {
    fun inject(exampleUnitTest: ExampleUnitTest)

}