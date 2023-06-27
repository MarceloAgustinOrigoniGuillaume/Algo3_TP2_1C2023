package edu.fiuba.algo3;

import java.util.Hashtable;

public class Logger {

    private static final Logger unicaInstancia = new Logger();

    private static boolean loggerActivado = true;
    
    private Hashtable<String,Boolean> identifiers;

    // para multiples parametros, los separas por espacio.
    private static final String JOINT= " ";

    // id logs
    public static final String INFO= "info";
    public static final String ERROR= "error";
    public static final String DEBUG= "debug";
    public static final String GENERAL= "general";

    private Logger() {

        identifiers = new Hashtable<String,Boolean>();

        // info, son logs generales de acciones o cosas
        // pero sin entrar en detalles. 
        setIdentifierActive(INFO,true);

        // errores
        setIdentifierActive(ERROR,true);
        
        // general, cualquier log que no sea otro identifier entra aca
        setIdentifierActive(GENERAL,false);

        // debug logs.
        setIdentifierActive(DEBUG,false);
    }

    public void setIdentifierActive(String identifier, boolean activo){
        identifiers.put(identifier,activo);
    }

    public static void setActive(String identifier, boolean activo){
        Logger.obtener().setIdentifierActive(identifier,activo); 
    }

    public static Logger obtener() {
        return unicaInstancia;
    }



    public void toggle(boolean activado){
        loggerActivado = activado;
    }



    // funcion log 


    public void logParams(String identifier, Object ... objetosLogeados) {
        log(identifier, objetosLogeados);
    }

    public void log(String identifier, Object[] objetosLogeados){
        if (loggerActivado){
            if(!identifiers.containsKey(identifier)){
                identifier = GENERAL;
            }

            if(!identifiers.get(identifier)){
                return;// no esta activo.
            }

            String mensajeLogeado = objetosLogeados[0].toString();

            for(int i = 1; i<objetosLogeados.length; i++){
                mensajeLogeado+= JOINT+objetosLogeados[i].toString();
            }


            System.out.println(identifier+">"+mensajeLogeado);
        }

    }

    

    // static loggers
    public static void info(Object ... objetosLogeados){
        Logger.obtener().log(INFO,objetosLogeados);
    }

    public static void Log(Object ... objetosLogeados) {
        Logger.obtener().log(GENERAL,objetosLogeados);
    }

    public static void err(Object ... objetosLogeados) {
        Logger.obtener().log(ERROR,objetosLogeados);
    }

    public static void dbg(Object ... objetosLogeados) {
        Logger.obtener().log(DEBUG,objetosLogeados);
    }


}