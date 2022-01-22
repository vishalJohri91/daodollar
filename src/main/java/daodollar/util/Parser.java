package daodollar.util;

import com.fasterxml.jackson.databind.ObjectMapper;
import daodollar.model.Child;
import daodollar.model.ChildInputData;
import daodollar.model.Parent;
import daodollar.model.ParentInputData;

import java.io.File;
import java.io.IOException;

public class Parser {

    public static Parent[] getParentData() {

        String directory = System.getProperty("user.dir");
        String filename = directory + "/src/main/java/daodollar/json_input/Parent.json";
        ObjectMapper objectMapper = new ObjectMapper();
        ParentInputData parents = null;
        try {
            parents = objectMapper.readValue(new File(filename), ParentInputData.class);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return parents.getData();
    }

    public static Child[] getChildData() {

        String directory = System.getProperty("user.dir");
        String filename = directory + "/src/main/java/daodollar/json_input/Child.json";
        ObjectMapper objectMapper = new ObjectMapper();
        ChildInputData children = null;
        try {
            children = objectMapper.readValue(new File(filename), ChildInputData.class);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return children.getData();
    }
}
