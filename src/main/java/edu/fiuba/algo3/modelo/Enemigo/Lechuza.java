package edu.fiuba.algo3.modelo.Enemigo;
import edu.fiuba.algo3.Logger;
import edu.fiuba.algo3.modelo.Mapa.Mapa;

public class Lechuza implements Enemigo {

        private int vida;
        private int vidaTotal;
        private int velocidad = 1;
        public Lechuza(){

            this.vidaTotal = 5;
            this.vida = 5;
            this.velocidad = 5;
        }

        public void nuevoMoviento(Mapa mapa){

            if((this.vidaTotal - this.vida) >= (this.vidaTotal)/2){
                //Deberia enviar el movimiento correcto.
            }
        }

        public int velocidad(){

            return this.velocidad;
        }

        @Override
        public void reducirVelocidad() {
            this.velocidad = (int)Math.floor(this.velocidad / 2);
        }

        public boolean estaMuerto(){
            return vida <= 0;
        }

        @Override
        public void recibirAtaque(int danioRecibido) {
            this.vida = this.vida - danioRecibido;
            Logger.info("El daño recibido es: "+danioRecibido);
        }

        public int creditosDados(){
            return 1;
        }

        public Enemigo copiar(){
            return new edu.fiuba.algo3.modelo.Enemigo.Lechuza();
        }

        @Override
        public void incrementarContadorDePasos(){

        }

    @Override
    public int ataque(Mapa mapa) {
        return 0;
    }

    @Override
        public String toString(){
            return "Lechuza";
        }

        @Override
        public int ataque() {

            //Lechuza le dice a mapa que destruya una de las torres.
            //mapa.atacarPrimeraTorre();

            return 0;

        }


}
