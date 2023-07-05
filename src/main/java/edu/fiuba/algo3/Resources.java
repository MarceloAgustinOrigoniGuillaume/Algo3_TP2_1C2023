package edu.fiuba.algo3;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;

import java.io.IOException;
import java.net.URL;

import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.Background;
import javafx.scene.image.Image;
import java.io.File;
import java.util.Hashtable;

import java.util.ResourceBundle;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;


public class Resources {
    public static final String resources_path = "src/main/resources/";
    public static final String jsons_path = "archivos-json/";
    public static final String fxml_path = "vistas/";
    public static final String imgs_path = "images/";
    public static final String sounds_path = "sounds/";


    public static final Resources recursos = new Resources(); 

    private Hashtable<String,Object> resources;
    private Resources(){
        resources = new Hashtable<String,Object>();
    }

    private void load(String resource, Object value){
        resources.put(resource,value);
    }

    private <T> T get(String resource){
        return (T)resources.get(resource);
    }


    private boolean contains(String resource){
        return resources.containsKey(resource);
    }

    private void remove(String resource){
        resources.remove(resource);
    }




    //### loaders fxml vistas...
    public static <T extends Parent> T getVista(String vista, Object controlador, ResourceBundle bundle){
        FXMLLoader loader = new FXMLLoader();
        T view;
        try {
            URL url = getVistaPath(vista);
            Logger.Log("Loading vista ",url,"with controller: ",controlador);
            loader.setResources(bundle);
            loader.setController(controlador); // seteamos el controlador
            loader.setLocation(url);
            view = loader.load();
        } catch (Exception e) {
            Logger.err("ERROR while loading vista (",vista,") ",e);
            e.printStackTrace();
            return null;
        }

        return view;

    }

    public static <T extends Parent> T getVista(String vista, Object controlador){
        FXMLLoader loader = new FXMLLoader();
        T view;
        try {
            URL url = getVistaPath(vista);
            Logger.Log("Loading vista ",url,"with controller: ",controlador);
            loader.setController(controlador); // seteamos el controlador
            loader.setLocation(url);
            view = loader.load();
        } catch (Exception e) {
            Logger.err("ERROR while loading vista (",vista,") ",e);
            e.printStackTrace();
            return null;
        }

        return view;

    }

    public static <T extends Parent> T loadVista(String vista, T root, Object controlador){
        try {
            FXMLLoader loader = new FXMLLoader();
            URL url = getVistaPath(vista);
            Logger.Log("Loading vista ",url,"with controller: ",controlador);
            loader.setRoot(root);
            loader.setController(controlador); // seteamos el controlador
            loader.setLocation(url);
            
            loader.load();
        } catch (Exception e) {
            Logger.err("ERROR while loading vista (",vista,") ",e);
            e.printStackTrace();
        }
        return root;
    }



    public static <T extends Parent> T getVista(String vista){
        FXMLLoader loader = new FXMLLoader();
        T view;
        try {
            URL url = getVistaPath(vista);
            Logger.Log("Loading Vista ",url);
            loader.setLocation(url);
            view = loader.load();
        } catch (Exception e) {
            Logger.err("At loading vista (",vista,")",e);
            e.printStackTrace();
            return null;
        }

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





    //### no preload images
    public static Image getImg(String image){
        return new Image(getImgPath(image));
    }

    public static Image getImg(String image, int w, int h){
        return new Image(getImgPath(image),w,h, true, true);
    }

    public static Image getImg(String image, int w, int h, boolean preserve){
        return new Image(getImgPath(image),w,h, preserve, true);
    }

    public static Background getBckImage(String image, int w, int h){
        BackgroundImage bkImage= new BackgroundImage(getImg(image,w,h,false),
        BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,
          BackgroundSize.DEFAULT);


        return new Background(bkImage);
    }


    public static Background getBckImage(String image){
        BackgroundImage bkImage= new BackgroundImage(getImg(image),
        BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,
          BackgroundSize.DEFAULT);


        return new Background(bkImage);
    }

    public static String getImgPath(String filename){
        return "file:"+resources_path+imgs_path+filename;
    }



    //### no preload sounds
    private static String getSound(String filename){
        return resources_path+sounds_path+filename;
    }

    public static String getSoundPath(String filename){
        return new File(getSound(filename)).toURI().toString();
    }

    //### paths utilities
    public static String getJsonPath(String fileName){
        return resources_path+jsons_path+fileName+".json";
    }


    public static String getAssetTerreno(String asset){
        return "terrenos/"+asset+".jpg";
    }

    public static String getResourcePath(String path){
        return resources_path+path;
    }


    public interface Loader{
        Object load();
    }


    public static void preload(String resource, Object objeto){
        recursos.load(resource,objeto);
    }

    public static void preloadOnce(String resource, Loader loader){


        if(recursos.contains(resource)){
            return;
        }

        preload(resource,loader.load());
    }


    public static void removeLoaded(String resource){
        if(recursos.contains(resource)){
            recursos.remove(resource);
        }

    }


    public static <T> T load(String resource, Loader loader){

        if(recursos.contains(resource)){
            return recursos.get(resource);
        }

        return (T) loader.load();
    }

    public static <T> T loaded(String resource){
        return recursos.get(resource);
    }

    //###


    public static Media loadSound(String sound){
        return new Media(Resources.getSoundPath(sound));//new MediaPlayer(new Media(Resources.getSoundPath(sound)));
    }


    public static MediaPlayer loadPlayer(String sound){
        return new MediaPlayer(new Media(Resources.getSoundPath(sound)));
    }


}
