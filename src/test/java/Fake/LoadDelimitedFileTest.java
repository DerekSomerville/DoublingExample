package Fake;

import Fake.LoadDelimitedFile;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LoadDelimitedFileTest {

    Fake.LoadDelimitedFile loadDelimitedFile = new Fake.LoadDelimitedFile();

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
        loadDelimitedFile.setLoadFile(new Fake.LoadStub());
        assertEquals("Derek",loadDelimitedFile.getFileData("Games.csv").get(0)[0]);
    }

    @Test
    void getFileDataFirstLineSizeStub() {
        loadDelimitedFile.setLoadFile(new Fake.LoadStub());
        assertEquals(2,loadDelimitedFile.getFileData("Games.csv").get(0).length );
    }

    @Test
    void setFileDelimitorStub() {
        loadDelimitedFile.setLoadFile(new Fake.LoadStub());
        loadDelimitedFile.setFileDelimitor("k");
        assertEquals("Dere",loadDelimitedFile.getFileData("Games.csv").get(0)[0]);
    }

}