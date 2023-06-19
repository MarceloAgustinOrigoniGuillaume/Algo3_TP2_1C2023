package edu.fiuba.algo3.celdas;


import edu.fiuba.algo3.modelo.Enemigo.terrestres.Hormiga;
import edu.fiuba.algo3.modelo.Enemigo.terrestres.Arania;
import edu.fiuba.algo3.modelo.Enemigo.Enemigo;
import edu.fiuba.algo3.modelo.Enemigo.aereos.Lechuza;
import edu.fiuba.algo3.modelo.Enemigo.subterraneos.Topo;
import edu.fiuba.algo3.modelo.Defensas.Trampa;
import edu.fiuba.algo3.modelo.Defensas.torres.TorreBlanca;
import edu.fiuba.algo3.modelo.Defensas.torres.TorrePlateada;

import edu.fiuba.algo3.modelo.Celdas.habitantes.*;
//import edu.fiuba.algo3.modelo.Celdas.terrenos.*;

import edu.fiuba.algo3.modelo.Celdas.Construccion;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class HabitantesTests {
    @Test
    public void verificarHabitantesPasarelaGuardaHormiga() {
        Habitantes habs = new HabitantesPasarela();

        Enemigo enemigo = new Hormiga();

        assertEquals(true , enemigo.posicionarEn(habs));
        assertEquals(1, habs.cantidadUnidades());

    }

    @Test
    public void verificarHabitantesPasarelaAgregaHormigaYTopo() {
        Habitantes habs = new HabitantesPasarela();

        Enemigo enemigo = new Hormiga();
        Enemigo enemigo2 = new Topo(0);
        enemigo.posicionarEn(habs);
        assertEquals(true , enemigo2.posicionarEn(habs));
        assertEquals(2, habs.cantidadUnidades());

    }

    @Test
    public void verificarHabitantesPasarelaQuitaHormiga() {
        Habitantes habs = new HabitantesPasarela();

        Enemigo enemigo = new Hormiga();
        Enemigo enemigo2 = new Topo(0);
        enemigo.posicionarEn(habs);
        enemigo2.posicionarEn(habs);

        habs.sacar(enemigo);

        //assertEquals(true , );
        assertEquals(1, habs.cantidadUnidades());

    }

    @Test
    public void verificarHabitantesPasarelaQuitaTrampaPuedePonerOtra() {
        Habitantes habs = new HabitantesPasarela();

        Construccion trampa = new Trampa();

        assertEquals(true , trampa.posicionarEn(habs));
        assertEquals(false , trampa.posicionarEn(habs));
        habs.sacar(trampa);

        trampa = new Trampa();

        assertEquals(true , trampa.posicionarEn(habs));

    }


    @Test
    public void verificarHabitantesPasarelaGuardaLechuza() {
        Habitantes habs = new HabitantesPasarela();

        Enemigo enemigo = new Lechuza();

        assertEquals(true , enemigo.posicionarEn(habs));


    }

    @Test
    public void verificarHabitantesPasarelaGuardaArania() {
        Habitantes habs = new HabitantesPasarela();

        Enemigo enemigo = new Arania();

        assertEquals(true , enemigo.posicionarEn(habs));


    }

    @Test
    public void verificarHabitantesPasarelaGuardaTopo() {
        Habitantes habs = new HabitantesPasarela();

        Enemigo enemigo = new Topo(0);

        assertEquals(true , enemigo.posicionarEn(habs));


    }

    @Test
    public void verificarHabitantesPasarelaGuardaTrampa() {
        Habitantes habs = new HabitantesPasarela();

        Construccion cons = new Trampa();

        assertEquals(true , cons.posicionarEn(habs));


    }

    @Test
    public void verificarHabitantesPasarelaNOGuardaTorres() {
        Habitantes habs = new HabitantesPasarela();

        Construccion cons = new TorreBlanca();
        Construccion cons2 = new TorrePlateada();


        assertEquals(false , cons.posicionarEn(habs));
        assertEquals(false , cons2.posicionarEn(habs));


    }

    @Test
    public void verificarHabitantesTierraNOGuardaEnemigosMenosLechuza() {
        Habitantes habs = new HabitantesTierra();

        Enemigo enemigo = new Arania();
        Enemigo hormiga = new Hormiga();
        Enemigo topo = new Topo(0);
        Enemigo lechuza = new Lechuza();


        assertEquals(false , enemigo.posicionarEn(habs));
        assertEquals(false , hormiga.posicionarEn(habs));
        assertEquals(false , topo.posicionarEn(habs));
        assertEquals(true , lechuza.posicionarEn(habs));
    }


    @Test
    public void verificarHabitantesRocosoNOGuardaEnemigosMenosLechuza() {
        Habitantes habs = new HabitantesTerreno();

        Enemigo enemigo = new Arania();
        Enemigo hormiga = new Hormiga();
        Enemigo topo = new Topo(0);
        Enemigo lechuza = new Lechuza();


        assertEquals(false , enemigo.posicionarEn(habs));
        assertEquals(false , hormiga.posicionarEn(habs));
        assertEquals(false , topo.posicionarEn(habs));
        assertEquals(true , lechuza.posicionarEn(habs));
    }



    @Test
    public void verificarHabitantesTierraGuardaTorresYNoTrampas() {
        Habitantes habs = new HabitantesTierra();

        Construccion cons = new TorreBlanca();
        Construccion cons2 = new TorrePlateada();
        Construccion cons3 = new Trampa();


        assertEquals(true , cons.posicionarEn(habs));
        habs = new HabitantesTierra();
        assertEquals(true , cons2.posicionarEn(habs));
        assertEquals(false , cons3.posicionarEn(habs));
    }

    @Test
    public void verificarHabitantesTierraGuardaTorresMaximo1() {
        Habitantes habs = new HabitantesTierra();

        Construccion cons = new TorreBlanca();
        Construccion cons2 = new TorrePlateada();


        assertEquals(true , cons.posicionarEn(habs));
        assertEquals(false , cons2.posicionarEn(habs));
    }


    @Test
    public void verificarRocosoNoGuardaConstrucciones() {
        Habitantes habs = new HabitantesTerreno();

        Construccion cons = new TorreBlanca();
        Construccion cons2 = new TorrePlateada();
        Construccion cons3 = new Trampa();


        assertEquals(false , cons.posicionarEn(habs));
        assertEquals(false, cons2.posicionarEn(habs));
        assertEquals(false , cons3.posicionarEn(habs));
    }




}
