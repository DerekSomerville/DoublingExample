package Stub;

import java.util.ArrayList;
import java.util.List;

public class LoadStub implements Load{
    @Override
    public List<String> getFileData(String fileName) {
        List<String> stubData = new ArrayList<String>();
        stubData.add("Derek,Somerville");
        stubData.add("Matt,Barr");
        return stubData;
    }

    @Override
    public List<String> getLastLines(String fileName, int numberOfLines) {
        return null;
    }
}
