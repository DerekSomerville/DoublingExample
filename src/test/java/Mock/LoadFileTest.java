package Mock;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static org.mockito.Mockito.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LoadFileTest {

    Mock.LoadFile loadFile = new Mock.LoadFile();

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



}