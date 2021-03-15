package Foundation;

import java.util.ArrayList;
import java.util.List;

public class LoadDelimitedFile {

    private String fileDelimiter = ",";

    public void setFileDelimiter(String fileDelimiter){
        this.fileDelimiter = fileDelimiter;
    }

    public List<String[]> getFileData(String fileName) {
        List<String[]> delimitedData = new ArrayList<String[]>();
        LoadFile loadFile = new LoadFile();
        List<String> fileData = loadFile.getFileData(fileName);
        for (String row : fileData) {
            delimitedData.add(row.split(fileDelimiter));
        }
        return delimitedData;
    }
}
