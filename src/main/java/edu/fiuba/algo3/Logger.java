package edu.fiuba.algo3;

    public class Logger {

        private static final Logger unicaInstancia = new Logger();

        private static boolean loggerActivado = true;
        private static boolean loggerTests = true;

        private Logger() {
        }

        public void setTestsMode(boolean activo){
            loggerTests = activo;
        }

        public static void setTestMode(boolean activo){
            Logger.obtener().setTestsMode(activo);       
        }

        public static Logger obtener() {
            return unicaInstancia;
        }

        public static void info(String unString){
            if(loggerTests){
                Logger.obtener().log(unString);
            }
        }

        public void toggle(boolean bool){
            loggerActivado = bool;
        }

        public void log(String mensajeLogeado) {
            if (loggerActivado)
                System.out.println(mensajeLogeado);
        }

        public static void Log(String unString) {
            Logger.obtener().log(unString);
        }

    }