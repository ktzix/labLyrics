package com.example.lablyrics.test

import android.os.Build
import com.example.lablyrics.mock.MockLyricsDAO
import com.example.lablyrics.model.Lyrics
import com.example.lablyrics.testDI.testInjector
import com.example.lablyrics.ui.lyrics.LyricsPresenter
import com.example.lablyrics.ui.lyrics.LyricsScreen
import com.example.lablyrics.ui.search.SearchPresenter
import com.example.lablyrics.ui.search.SearchScreen
import com.example.lablyrics.utils.argumentCaptor
import com.example.lablyrics.utils.mock
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mockito.timeout
import org.mockito.Mockito.verify
import org.robolectric.RobolectricTestRunner
import org.robolectric.annotation.Config
import javax.inject.Inject

@Config(sdk = [Build.VERSION_CODES.O_MR1])
@RunWith(RobolectricTestRunner::class)
class LyricsTest {
    @Inject
    lateinit var lyricsPresenter: LyricsPresenter
    private lateinit var lyricsScreen: LyricsScreen
    private lateinit var myString: String

    @Throws(Exception::class)
    @Before
    fun setup(){
        testInjector.inject(this)
        lyricsScreen = mock()
        lyricsPresenter.attachScreen(lyricsScreen)

    }

    @Test
    fun delTest(){
        val emi = Lyrics("Eminem", "Without Me","Lorem Ipsum")
        lyricsPresenter.delLyrics(emi)
        val song = argumentCaptor<String>()
        verify(lyricsScreen).showDeleteSucces(song.capture())
        assert(song.value == emi.artist+" - "+emi.title)
    }

    @Test
    fun getAllTest(){
        lyricsPresenter.getLyrics()
        val songs = argumentCaptor< List<Lyrics> >()
        verify(lyricsScreen, timeout(5000)).showLyricsList(songs.capture())
        assert(songs.value.isNotEmpty())
    }

    @After
    fun tearDown()
    {
        lyricsPresenter.detachScreen()
    }
}