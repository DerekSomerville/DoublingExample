package Stub;

import Foundation.LoadFile;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LoadFileTest {

    Stub.LoadFile loadFile = new Stub.LoadFile();

    @org.junit.jupiter.api.Test
    void getFileDataSize() {
        assertEquals(9,loadFile.getFileData("Games.csv").size());
    }

    @org.junit.jupiter.api.Test
    void getFileDataFirstRow() {
        assertEquals("Game,Release Date,Developer,Price",loadFile.getFileData("Games.csv").get(0));
    }

    @org.junit.jupiter.api.Test
    void getFileDataSecondRow() {
        assertEquals("DOOM,1993,id Software,£9.99",loadFile.getFileData("Games.csv").get(1));
    }

    @org.junit.jupiter.api.Test
    void getLastLinesOne() {
        List<String> result = new ArrayList<String>();
        result.add("God of War,2005,SCE,£19.99");
        assertEquals(result, loadFile.getLastLines("Games.csv",1));
    }
}