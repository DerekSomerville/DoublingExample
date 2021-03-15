package Foundation;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LoadDelimitedFileTest {

    LoadDelimitedFile loadDelimitedFile = new LoadDelimitedFile();

    @Test
    void setFileDelimiter() {
        loadDelimitedFile.setFileDelimiter("e");
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


}