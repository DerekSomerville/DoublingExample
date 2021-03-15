package Mock;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LoadFile implements Load {

    private String filePathPrefix = DataConstants.RESOURCE;
    private Scanner propertyReader = null;

    public void setPropertyReader(Scanner propertyReader) {
        this.propertyReader = propertyReader;
    }

    private void createPropertyReader(String fileName ){
        Scanner propertyReader = null;
        if (propertyReader == null) {
            try {
                File propertyFile = new File(filePathPrefix + fileName);
                propertyReader = new Scanner(propertyFile);
            } catch (IOException e) {
                System.out.println("An error occurred in " + "getPropertyReader");
                e.printStackTrace();
            }
        }
    }

    public List<String> getFileData( String fileName){
        List<String> fileData = new ArrayList<String>();
        createPropertyReader(fileName);
        try {
            while (propertyReader.hasNextLine()) {
                String fileRow = propertyReader.nextLine();
                fileData.add(fileRow);
            }
            propertyReader.close();
        } catch (Exception exp) {
            System.out.println("An error occurred in " + "getFileData");
            exp.printStackTrace();
        }
        return fileData;
    }

    public List<String> getLastLines( String fileName,int numberOfLines){
        List<String> lastLines = new ArrayList<String>();
        List<String> dataFile = this.getFileData(fileName);
        for (int counter=dataFile.size() - numberOfLines;counter < dataFile.size();counter++){
            lastLines.add(dataFile.get(counter));
        }
        return lastLines;
    }
}
