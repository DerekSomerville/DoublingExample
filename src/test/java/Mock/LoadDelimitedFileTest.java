package Mock;

import Mock.LoadStub;
import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.when;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LoadDelimitedFileTest {

    Mock.LoadDelimitedFile loadDelimitedFile = new Mock.LoadDelimitedFile();

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
        loadDelimitedFile.setLoadFile(new Mock.LoadStub());
        assertEquals("Derek",loadDelimitedFile.getFileData("Games.csv").get(0)[0]);
    }

    @Test
    void getFileDataFirstLineSizeStub() {
        loadDelimitedFile.setLoadFile(new Mock.LoadStub());
        assertEquals(2,loadDelimitedFile.getFileData("Games.csv").get(0).length );
    }

    @Test
    void setFileDelimitorStub() {
        loadDelimitedFile.setLoadFile(new Mock.LoadStub());
        loadDelimitedFile.setFileDelimitor("k");
        assertEquals("Dere",loadDelimitedFile.getFileData("Games.csv").get(0)[0]);
    }

    @Test
    void setFileDelimitorMock() {
        List<String> mockData = new ArrayList<String>();
        mockData.add("SaraSomervillexFrank,Somerville");
        mockData.add("Matt,Barr");
        LoadFile mockLoadFile = spy(LoadFile.class);
        when(mockLoadFile.getFileData("Games.csv")).thenReturn(mockData);
        loadDelimitedFile.setLoadFile(mockLoadFile);
        loadDelimitedFile.setFileDelimitor("x");
        assertEquals("SaraSomerville",loadDelimitedFile.getFileData("Games.csv").get(0)[0]);
    }

}