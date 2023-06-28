package edu.fiuba.algo3.celdas;


import edu.fiuba.algo3.modelo.Celdas.Pasarela;
import edu.fiuba.algo3.modelo.Celdas.Rocosa;
import edu.fiuba.algo3.modelo.Celdas.Tierra;
import edu.fiuba.algo3.modelo.Celdas.CeldaConEnemigos;

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
        Celda pasarela = new Pasarela();

        Enemigo enemigo = new Hormiga();

        assertEquals(true , enemigo.posicionarEn(pasarela));
        assertEquals(1, pasarela.cantidadUnidades());

    }

    @Test
    public void verificarHabitantesPasarelaAgregaHormigaYTopo() {
        Celda pasarela = new Pasarela();

        Enemigo enemigo = new Hormiga();
        Enemigo enemigo2 = new Topo(0);


        enemigo.posicionarEn(pasarela);
        assertEquals(true , enemigo2.posicionarEn(pasarela));
        assertEquals(2, pasarela.cantidadUnidades());
    }

    @Test
    public void verificarHabitantesPasarelaQuitaHormiga() {
        Celda pasarela = new Pasarela();

        Enemigo enemigo = new Hormiga();
        Enemigo enemigo2 = new Topo(0);


        enemigo.posicionarEn(pasarela);
        enemigo2.posicionarEn(pasarela);

        pasarela.sacar(enemigo);

        assertEquals(1, pasarela.cantidadUnidades());

    }

    @Test
    public void verificarHabitantesPasarelaQuitaTrampaPuedePonerOtra() {
        Celda pasarela = new Pasarela();

        Construccion trampa = new Trampa();

        assertEquals(true , trampa.posicionarEn(pasarela));
        assertEquals(false , trampa.posicionarEn(pasarela));
        pasarela.borrarDefensa();

        trampa = new Trampa();

        assertEquals(true , trampa.posicionarEn(pasarela));

    }


    @Test
    public void verificarHabitantesPasarelaGuardaLechuza() {
        Celda pasarela = new Pasarela();

        Enemigo enemigo = new Lechuza();

        assertEquals(true , enemigo.posicionarEn(pasarela));
        assertEquals(1, pasarela.cantidadUnidades());


    }

    @Test
    public void verificarHabitantesPasarelaGuardaArania() {
        Celda pasarela = new Pasarela();

        Enemigo enemigo = new Arania();

        assertEquals(true , enemigo.posicionarEn(pasarela));
        assertEquals(1, pasarela.cantidadUnidades());


    }

    @Test
    public void verificarHabitantesPasarelaGuardaTopo() {
        Celda pasarela = new Pasarela();

        Enemigo enemigo = new Topo(1);

        assertEquals(true , enemigo.posicionarEn(pasarela));
        assertEquals(1, pasarela.cantidadUnidades());


    }

    @Test
    public void verificarHabitantesPasarelaGuardaTrampa() {
        Celda pasarela = new Pasarela();

        Construccion construccion = new Trampa();

        assertEquals(true , construccion.posicionarEn(pasarela));

    }

    @Test
    public void verificarHabitantesPasarelaNOGuardaTorres() {
        Celda pasarela = new Pasarela();


        Construccion cons = new TorreBlanca();
        Construccion cons2 = new TorrePlateada();

        assertEquals(false , cons.posicionarEn(pasarela));
        assertEquals(false , cons2.posicionarEn(pasarela));

    }

    @Test
    public void verificarHabitantesTierraNOGuardaEnemigosMenosLechuza() {
        Celda celda = new Tierra();

        Enemigo enemigo = new Arania();
        Enemigo hormiga = new Hormiga();
        Enemigo topo = new Topo(0);
        Enemigo lechuza = new Lechuza();


        assertEquals(false , enemigo.posicionarEn(celda));
        assertEquals(false , hormiga.posicionarEn(celda));
        assertEquals(false , topo.posicionarEn(celda));
        assertEquals(true , lechuza.posicionarEn(celda));


    }





    @Test
    public void verificarHabitantesTierraGuardaTorresYNoTrampas() {
        Celda celda = new Tierra();


        Construccion cons = new TorreBlanca();
        Construccion cons2 = new TorrePlateada();
        Construccion cons3 = new Trampa();

        assertEquals(true , cons.posicionarEn(celda));
        assertEquals(false , cons3.posicionarEn(celda));

        celda = new Tierra();

        assertEquals(true , cons2.posicionarEn(celda));



    }

    @Test
    public void verificarHabitantesTierraGuardaTorresMaximo1() {
        Celda celda = new Tierra();


        Construccion cons = new TorreBlanca();
        Construccion cons2 = new TorrePlateada();

        assertEquals(true , cons.posicionarEn(celda));
        assertEquals(false , cons2.posicionarEn(celda));
    }



    @Test
    public void verificarHabitantesRocosoNOGuardaEnemigosMenosLechuza() {
        CeldaConEnemigos celda = new Rocosa();

        Enemigo enemigo = new Arania();
        Enemigo hormiga = new Hormiga();
        Enemigo topo = new Topo(0);
        Enemigo lechuza = new Lechuza();


        assertEquals(false , enemigo.posicionarEn(celda));
        assertEquals(false , hormiga.posicionarEn(celda));
        assertEquals(false , topo.posicionarEn(celda));
        assertEquals(true , lechuza.posicionarEn(celda));
    }


    /*
    @Test
    public void verificarRocosoNoGuardaConstrucciones() {
        CeldaConEnemigos celda = new Rocosa();


        Construccion cons = new TorreBlanca();
        Construccion cons2 = new TorrePlateada();
        Construccion cons3 = new Trampa();

        assertEquals(false , cons.posicionarEn(celda));
        assertEquals(false , cons2.posicionarEn(celda));
        assertEquals(false , cons3.posicionarEn(celda));

    }
    */




}
