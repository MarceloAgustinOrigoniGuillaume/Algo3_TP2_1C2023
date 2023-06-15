package edu.fiuba.algo3;

public class Resources {
    public static final String resources_path = "src/main/resources/";
    public static final String jsons_path = "archivos-json/";
    public static final String fxml_path = "vistas/";


    public static String getFxmlPath(String filename){
        return resources_path+fxml_path+filename;
    }

    public static String getVistaPath(String vistaName){
        return getFxmlPath(vistaName+".fxml");
    }

    public static String getJsonPath(String fileName){
        return resources_path+jsons_path+fileName+".json";
    }

    public static String getResourcePath(String path){
        return resources_path+path;
    }



}
