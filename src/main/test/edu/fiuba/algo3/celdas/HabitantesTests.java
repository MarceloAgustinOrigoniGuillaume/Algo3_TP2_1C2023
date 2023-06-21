package edu.fiuba.algo3.celdas;


import edu.fiuba.algo3.modelo.Enemigo.terrestres.Hormiga;
import edu.fiuba.algo3.modelo.Enemigo.terrestres.Arania;
import edu.fiuba.algo3.modelo.Enemigo.Enemigo;
import edu.fiuba.algo3.modelo.Enemigo.aereos.Lechuza;
import edu.fiuba.algo3.modelo.Enemigo.subterraneos.Topo;
import edu.fiuba.algo3.modelo.Defensas.Trampa;
import edu.fiuba.algo3.modelo.Defensas.torres.TorreBlanca;
import edu.fiuba.algo3.modelo.Defensas.torres.TorrePlateada;

//import edu.fiuba.algo3.modelo.Celdas.habitantes.*;

import edu.fiuba.algo3.modelo.Celdas.*;

//import edu.fiuba.algo3.modelo.Celdas.terrenos.*;

import edu.fiuba.algo3.modelo.Defensas.Construccion;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class HabitantesTests {
    @Test
    public void verificarHabitantesPasarelaGuardaHormiga() {
        Pasarela pasarela = new Pasarela(new Coordenada(1,1));

        Enemigo enemigo = new Hormiga();

        assertEquals(true , enemigo.posicionarEn(pasarela.enemigos()));
        assertEquals(1, pasarela.enemigos().cantidadUnidades());

    }

    @Test
    public void verificarHabitantesPasarelaAgregaHormigaYTopo() {
        Pasarela pasarela = new Pasarela(new Coordenada(1,1));

        Enemigo enemigo = new Hormiga();
        Enemigo enemigo2 = new Topo(0);


        enemigo.posicionarEn(pasarela.enemigos());
        assertEquals(true , enemigo2.posicionarEn(pasarela.enemigos()));
        assertEquals(2, pasarela.enemigos().cantidadUnidades());
    }

    @Test
    public void verificarHabitantesPasarelaQuitaHormiga() {
        Pasarela pasarela = new Pasarela(new Coordenada(1,1));

        Enemigo enemigo = new Hormiga();
        Enemigo enemigo2 = new Topo(0);


        enemigo.posicionarEn(pasarela.enemigos());
        enemigo2.posicionarEn(pasarela.enemigos());

        pasarela.enemigos().sacar(enemigo);

        assertEquals(1, pasarela.enemigos().cantidadUnidades());

    }

    @Test
    public void verificarHabitantesPasarelaQuitaTrampaPuedePonerOtra() {
        Pasarela pasarela = new Pasarela(new Coordenada(1,1));

        Construccion trampa = new Trampa();

        assertEquals(true , trampa.posicionarEn(pasarela.defensas()));
        assertEquals(false , trampa.posicionarEn(pasarela.defensas()));
        pasarela.defensas().clear();

        trampa = new Trampa();

        assertEquals(true , trampa.posicionarEn(pasarela.defensas()));

    }


    @Test
    public void verificarHabitantesPasarelaGuardaLechuza() {
        Pasarela pasarela = new Pasarela(new Coordenada(1,1));

        Enemigo enemigo = new Lechuza();

        assertEquals(true , enemigo.posicionarEn(pasarela.enemigos()));
        assertEquals(1, pasarela.enemigos().cantidadUnidades());


    }

    @Test
    public void verificarHabitantesPasarelaGuardaArania() {
        Pasarela pasarela = new Pasarela(new Coordenada(1,1));

        Enemigo enemigo = new Arania();

        assertEquals(true , enemigo.posicionarEn(pasarela.enemigos()));
        assertEquals(1, pasarela.enemigos().cantidadUnidades());


    }

    @Test
    public void verificarHabitantesPasarelaGuardaTopo() {
        Pasarela pasarela = new Pasarela(new Coordenada(1,1));

        Enemigo enemigo = new Topo(1);

        assertEquals(true , enemigo.posicionarEn(pasarela.enemigos()));
        assertEquals(1, pasarela.enemigos().cantidadUnidades());


    }

    @Test
    public void verificarHabitantesPasarelaGuardaTrampa() {
        Pasarela pasarela = new Pasarela(new Coordenada(1,1));

        Construccion construccion = new Trampa();

        assertEquals(true , construccion.posicionarEn(pasarela.defensas()));

    }

    @Test
    public void verificarHabitantesPasarelaNOGuardaTorres() {
        Pasarela pasarela = new Pasarela(new Coordenada(1,1));


        Construccion cons = new TorreBlanca();
        Construccion cons2 = new TorrePlateada();

        assertEquals(false , cons.posicionarEn(pasarela.defensas()));
        assertEquals(false , cons2.posicionarEn(pasarela.defensas()));

    }

    @Test
    public void verificarHabitantesTierraNOGuardaEnemigosMenosLechuza() {
        Celda celda = new Tierra(new Coordenada(1,1));

        Enemigo enemigo = new Arania();
        Enemigo hormiga = new Hormiga();
        Enemigo topo = new Topo(0);
        Enemigo lechuza = new Lechuza();


        assertEquals(false , enemigo.posicionarEn(celda.enemigos()));
        assertEquals(false , hormiga.posicionarEn(celda.enemigos()));
        assertEquals(false , topo.posicionarEn(celda.enemigos()));
        assertEquals(true , lechuza.posicionarEn(celda.enemigos()));


    }


    @Test
    public void verificarHabitantesRocosoNOGuardaEnemigosMenosLechuza() {
        Celda celda = new Rocosa(new Coordenada(1,1));

        Enemigo enemigo = new Arania();
        Enemigo hormiga = new Hormiga();
        Enemigo topo = new Topo(0);
        Enemigo lechuza = new Lechuza();


        assertEquals(false , enemigo.posicionarEn(celda.enemigos()));
        assertEquals(false , hormiga.posicionarEn(celda.enemigos()));
        assertEquals(false , topo.posicionarEn(celda.enemigos()));
        assertEquals(true , lechuza.posicionarEn(celda.enemigos()));
    }



    @Test
    public void verificarHabitantesTierraGuardaTorresYNoTrampas() {
        Celda celda = new Tierra(new Coordenada(1,1));


        Construccion cons = new TorreBlanca();
        Construccion cons2 = new TorrePlateada();
        Construccion cons3 = new Trampa();

        assertEquals(true , cons.posicionarEn(celda.defensas()));
        assertEquals(false , cons3.posicionarEn(celda.defensas()));

        celda = new Tierra(new Coordenada(1,1));

        assertEquals(true , cons2.posicionarEn(celda.defensas()));



    }

    @Test
    public void verificarHabitantesTierraGuardaTorresMaximo1() {
        Celda celda = new Tierra(new Coordenada(1,1));


        Construccion cons = new TorreBlanca();
        Construccion cons2 = new TorrePlateada();

        assertEquals(true , cons.posicionarEn(celda.defensas()));
        assertEquals(false , cons2.posicionarEn(celda.defensas()));
    }


    @Test
    public void verificarRocosoNoGuardaConstrucciones() {
        Celda celda = new Rocosa(new Coordenada(1,1));


        Construccion cons = new TorreBlanca();
        Construccion cons2 = new TorrePlateada();
        Construccion cons3 = new Trampa();

        assertEquals(false , cons.posicionarEn(celda.defensas()));
        assertEquals(false , cons2.posicionarEn(celda.defensas()));
        assertEquals(false , cons3.posicionarEn(celda.defensas()));

    }




}
