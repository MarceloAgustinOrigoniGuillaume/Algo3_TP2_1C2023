package edu.fiuba.algo3.modelo.Enemigo;
import edu.fiuba.algo3.Logger;
import edu.fiuba.algo3.modelo.Celdas.Coordenada;
import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.Mapa.Mapa;

import java.util.ArrayList;

public class Lechuza extends Enemigo {

        private int vida;
        private int vidaCambioMovimiento;
        private int velocidad = 1;
        public Lechuza(){

            this.vida = 5;
            this.vidaCambioMovimiento= 2;
            this.velocidad = 5;
        }

        private Coordenada movimientoLechuza(Coordenada desde, Coordenada hasta){
            int x_nuevo = desde.x();
            int y_nuevo = desde.y();

            int x_final = hasta.x();
            int y_final = hasta.y();

            int restantePorMover = this.velocidad;

            if(vida <= vidaCambioMovimiento){
                while(restantePorMover>=2 && x_nuevo <= x_final && y_nuevo <= y_final){
                    restantePorMover-=2;
                    x_nuevo+=1;
                    y_nuevo+=1;
                }
            }

            while(restantePorMover>0 && x_nuevo<=x_final){
                restantePorMover-=1;
                x_nuevo+=1;
            }

            while(restantePorMover>0 && y_nuevo<=y_final){
                restantePorMover-=1;
                y_nuevo+=1;
            }


            return new Coordenada(x_nuevo,y_nuevo);

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


        public void moverse(Mapa mapa, Coordenada posicion){
            Coordenada meta = mapa.posicionFinal();
            mapa.mover(this,posicion,movimientoLechuza(posicion, meta));
        }

        public void atacar(Jugador jugador, Mapa mapa){
            mapa.atacarPrimeraTorre();
        }
}
