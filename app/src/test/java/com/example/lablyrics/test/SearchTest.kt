package com.example.lablyrics.test

import android.os.Build
import android.os.Looper
import android.util.Log
import com.example.lablyrics.model.Lyrics
import com.example.lablyrics.model.LyricsResponse
import com.example.lablyrics.testDI.testInjector
import com.example.lablyrics.ui.search.SearchPresenter
import com.example.lablyrics.ui.search.SearchScreen
import com.example.lablyrics.utils.argumentCaptor
import com.example.lablyrics.utils.mock
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mockito.timeout
import org.mockito.Mockito.verify
import org.robolectric.RobolectricTestRunner
import org.robolectric.Shadows.shadowOf
import org.robolectric.annotation.Config
import org.robolectric.annotation.LooperMode
import javax.inject.Inject


@RunWith(RobolectricTestRunner::class)
@Config(sdk = [Build.VERSION_CODES.O_MR1])
class SearchTest {
@Inject
lateinit var searchPresenter: SearchPresenter
private lateinit var searchScreen: SearchScreen
private lateinit var myString: String

@Throws(Exception::class)
@Before
fun setup(){
    testInjector.inject(this)
    searchScreen = mock()
    searchPresenter.attachScreen(searchScreen)
}

    @Test
    fun testSearch(){

          myString = "Lorem ipsum"
           searchPresenter.getLyrics("Without Me", "Eminem")

            val getResponse = argumentCaptor<LyricsResponse>()
            verify(searchScreen, timeout(5000)).showSearch(getResponse.capture())
            val responseString = getResponse.value.lyrics
            assert(myString == responseString)
    }


    @Test
    fun addToDB(){
        val emi = Lyrics("Eminem", "Without Me","Lorem Ipsum")
        searchPresenter.addLyricsToDB(emi)
        val song = argumentCaptor<Lyrics>()
        verify(searchScreen, timeout(5000)).showAddSucces(song.capture())
        assert(song.value.artist == "Eminem")
    }

    @After
    fun tearDown()
    {
        searchPresenter.detachScreen()
    }

}