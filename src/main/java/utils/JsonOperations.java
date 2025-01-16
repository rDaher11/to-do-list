package utils;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import models.Task;
import org.jetbrains.annotations.NotNull;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class JsonOperations {
    private static ObjectMapper objectMapper = getMapper() ;
    @NotNull
    private static ObjectMapper getMapper() {
        /// here add some configuration to objectMapper
        ObjectMapper configureMapper = new ObjectMapper();
        configureMapper.writerWithDefaultPrettyPrinter();
        configureMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES , false) ;
        configureMapper.configure(DeserializationFeature.READ_ENUMS_USING_TO_STRING, true) ;
        return  configureMapper ;
    }
    public static List<Task> readListOfTasks(File jsonFile) throws IOException {
        return objectMapper.readValue(jsonFile , new TypeReference<ArrayList<Task>>() {}) ;
    }
    public static void saveListOfTasks(List<Task> taskList ,File file) throws IOException{
        objectMapper.writer().writeValue(file , taskList);
    }
}
