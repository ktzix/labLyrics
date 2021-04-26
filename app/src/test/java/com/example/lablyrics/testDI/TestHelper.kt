package com.example.lablyrics.testDI




val testInjector: TestComponent
        get(){
                return DaggerTestComponent.builder().testModule(TestModule()).build()
        }