package Fake;

import java.util.ArrayList;
import java.util.List;

public class LoadDelimitedFile {

    private String fileDelimitor = ",";

    private Load loadFile = new LoadFile();

    public void setFileDelimitor(String fileDelimitor){
        this.fileDelimitor = fileDelimitor;
    }

    public void setLoadFile(Load loadFile) {
        this.loadFile = loadFile;
    }

    public List<String[]> getFileData(String fileName) {
        List<String[]> delimtedData = new ArrayList<String[]>();

        List<String> fileData = loadFile.getFileData(fileName);
        for (String row : fileData) {
            delimtedData.add(row.split(fileDelimitor));
        }
        return delimtedData;
    }
}
