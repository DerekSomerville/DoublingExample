package Fake;

import Fake.LoadFile;
import Fake.FakeScanner;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.when;

class LoadFileTest {

    Fake.LoadFile loadFile = new Fake.LoadFile();

    @Test
    void getFileDataSize() {
        assertEquals(9,loadFile.getFileData("Games.csv").size());
    }

    @Test
    void getFileDataFirstRow() {
        assertEquals("Game,Release Date,Developer,Price",loadFile.getFileData("Games.csv").get(0));
    }

    @Test
    void getFileDataSecondRow() {
        assertEquals("DOOM,1993,id Software,£9.99",loadFile.getFileData("Games.csv").get(1));
    }

    @Test
    void getLastLinesOne() {
        List<String> result = new ArrayList<String>();
        result.add("God of War,2005,SCE,£19.99");
        assertEquals(result, loadFile.getLastLines("Games.csv",1));
    }

    @Test
    void getFileDataFirstRowMock() {
        FakeScanner mockScanner = spy(FakeScanner.class);
        when(mockScanner.hasNextLine()).thenReturn(true);
        when(mockScanner.hasNextLine()).thenReturn(false);
        when(mockScanner.nextLine()).thenReturn("MockScanner,Scanner");
        loadFile.setPropertyReader(mockScanner);
        assertEquals("MockScanner,Scanner",loadFile.getFileData("Games.csv").get(0));

    }



}