package Stub;

import Foundation.LoadDelimitedFile;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LoadDelimitedFileTest {

    Stub.LoadDelimitedFile loadDelimitedFile = new Stub.LoadDelimitedFile();

    @Test
    void setFileDelimiter() {
        loadDelimitedFile.setFileDelimitor("e");
        assertEquals("Gam",loadDelimitedFile.getFileData("Games.csv").get(0)[0]);
    }

    @Test
    void getFileDataFirstLineFirstColumn() {
        assertEquals("Game",loadDelimitedFile.getFileData("Games.csv").get(0)[0]);
    }

    @Test
    void getFileDataFirstLineSize() {
        assertEquals(4,loadDelimitedFile.getFileData("Games.csv").get(0).length );
    }

    @Test
    void getFileDataFirstLineFirstColumnStub(){
        loadDelimitedFile.setLoadFile(new Stub.LoadStub());
        assertEquals("Derek",loadDelimitedFile.getFileData("Games.csv").get(0)[0]);
    }

    @Test
    void getFileDataFirstLineSizeStub() {
        loadDelimitedFile.setLoadFile(new Stub.LoadStub());
        assertEquals(2,loadDelimitedFile.getFileData("Games.csv").get(0).length );
    }

    @Test
    void setFileDelimitorStub() {
        loadDelimitedFile.setLoadFile(new Stub.LoadStub());
        loadDelimitedFile.setFileDelimitor("k");
        assertEquals("Dere",loadDelimitedFile.getFileData("Games.csv").get(0)[0]);
    }

}