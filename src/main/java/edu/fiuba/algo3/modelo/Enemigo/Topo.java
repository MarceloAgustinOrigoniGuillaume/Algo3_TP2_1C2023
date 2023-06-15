package edu.fiuba.algo3.modelo.Enemigo;

import edu.fiuba.algo3.Logger;
import edu.fiuba.algo3.modelo.Mapa.Mapa;

public class Topo implements Enemigo{

        private int vida;
        private int turno;
        private int velocidad ;
        private int contadorMovimientos;

        public Topo(int turnoActual){
            this.turno = turnoActual;
            this.vida = 1;
            this.velocidad = 1;
            this.contadorMovimientos = 0;
        }

        public int velocidad(){

            if(this.contadorMovimientos > 5 && this.contadorMovimientos <= 10){
                this.velocidad = 2;
            }
            if(this.contadorMovimientos >= 11){
                this.velocidad = 3;
            }
            return this.velocidad;
        }

        @Override
        public void reducirVelocidad() {
            this.velocidad = (int)Math.floor(this.velocidad / 2);
        }

        public void incrementarContadorDePasos(){
            this.contadorMovimientos++;
            this.turno++;
        }

    @Override
    public int ataque(Mapa mapa) {
        return 0;
    }

    @Override
        public int creditosDados() {
            return 0;
        }

        @Override
        public void recibirAtaque(int danioRecibido) {
            Logger.info("El daño recibido es: 0");
        }

        @Override
        public boolean estaMuerto() {
            return false;
        }

        @Override
        public Enemigo copiar() {
            return null;
        }

        @Override
        public int ataque() {

            if((this.turno)%2 == 0){
                return 5;
            }
            return 2;
        }
}
