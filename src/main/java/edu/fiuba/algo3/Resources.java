package edu.fiuba.algo3;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;

import java.io.IOException;
import java.net.URL;

public class Resources {
    public static final String resources_path = "src/main/resources/";
    public static final String jsons_path = "archivos-json/";
    public static final String fxml_path = "vistas/";


    public static <T extends Parent> T getVista(String vista){
        FXMLLoader loader = new FXMLLoader();
        T view;
        try {
            URL url = getVistaPath(vista);
            Logger.Log("Loading Vista "+url.toString());
            loader.setLocation(url);
            view = loader.load();
        } catch (Exception e) {
            Logger.Log("ERROR while loading vista '"+vista+"' "+e.toString());
            e.printStackTrace();
            return null;
        }
        //loader.setLocation(new URL());
        //FXMLLoader.load();

        return view;

    }

    public static URL getFxmlPath(String filename){
        return App.class.getResource("/"+fxml_path+filename);

        //se podria hacer esto sino y creas la URL
        //return resources_path+fxml_path+filename;
    }

    public static URL getVistaPath(String vistaName){
        return getFxmlPath(vistaName+".fxml");
    }

    public static String getJsonPath(String fileName){
        return resources_path+jsons_path+fileName+".json";
    }

    public static String getResourcePath(String path){
        return resources_path+path;
    }



}
