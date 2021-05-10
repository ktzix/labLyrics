package com.example.lablyrics.test

import android.os.Build
import com.example.lablyrics.model.Lyrics
import com.example.lablyrics.testDI.testInjector
import com.example.lablyrics.ui.search.SearchPresenter
import com.example.lablyrics.ui.search.SearchScreen
import com.example.lablyrics.ui.showLyrics.ShowLyricsPresenter
import com.example.lablyrics.ui.showLyrics.ShowLyricsScreen
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
import org.robolectric.annotation.Config
import javax.inject.Inject
import kotlin.properties.Delegates

@Config(sdk = [Build.VERSION_CODES.O_MR1])
@RunWith(RobolectricTestRunner::class)
class ShowLyricsTest {
    @Inject
    lateinit var showLyricsPresenter: ShowLyricsPresenter
    private lateinit var showLyricsScreen: ShowLyricsScreen
    private lateinit var Artist: String
    private lateinit var Title: String
    private var Id by Delegates.notNull<Int>()

    @Throws(Exception::class)
    @Before
    fun setup(){
        testInjector.inject(this)
        showLyricsScreen = mock()
        showLyricsPresenter.attachScreen(showLyricsScreen)
    }

    @Test
    fun getByIdTest(){

            Id =0

            showLyricsPresenter.getLyricsById(Id)
            val song =
                argumentCaptor<Lyrics>()
            verify(showLyricsScreen, timeout(5000)).showGetLyricsByIdSucces(song.capture())
            assert(song.value.artist == "Eminem")

    }

    @Test
    fun updateLyrics(){
        Id=0
        Artist="Alma"
        Title="korte"
        showLyricsPresenter.updateLyrics(Id, Artist, Title)
        val song = argumentCaptor<String>()
        verify(showLyricsScreen).showUpdateSucces(song.capture())
        assert(song.value.toString() == Id.toString() + " modositva")
    }


    @After
    fun tearDown()
    {
        showLyricsPresenter.detachScreen()
    }
}