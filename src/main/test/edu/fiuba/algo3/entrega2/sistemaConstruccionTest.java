package edu.fiuba.algo3.entrega2;

import edu.fiuba.algo3.modelo.Lector.ConvertidorParcela;
import edu.fiuba.algo3.modelo.Lector.LectorMapa;
import edu.fiuba.algo3.modelo.Defensas.TorrePlateada;
import edu.fiuba.algo3.modelo.Mapa.Mapa;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class sistemaConstruccionTest {
    @Test
    public void verificarDefensaTardaEnContruirseLoQueDebePaseSerActivo() {
        TorrePlateada torrePlateada = new TorrePlateada();

        /*
        Posible separacion de test al verificar cada turno
        */

        assertEquals(torrePlateada.finalizoContruccion(),false);

        /*
        Recien para despues lo del Mock, al verificar que esten operativas
        */
    }

    @Test
    public void PasoUnTurno() throws Exception {
        TorrePlateada torrePlateada = new TorrePlateada();
        LectorMapa mockLector = mock(LectorMapa.class);


        when(mockLector.siguienteElemento()).thenReturn(new ConvertidorParcela(1,1,"Tierra"));
        when(mockLector.haySiguiente()).thenReturn(true).thenReturn(false);

        Mapa unMapa = new Mapa(mockLector,1,1);

        torrePlateada.accionar(unMapa);
        assertEquals(torrePlateada.finalizoContruccion(),false);


        /*
        Recien para despues lo del Mock, al verificar que esten operativas
        */
    }

    @Test
    public void MultiplesTurno() throws Exception {
        TorrePlateada torrePlateada = new TorrePlateada();
        LectorMapa mockLector = mock(LectorMapa.class);


        when(mockLector.siguienteElemento()).thenReturn(new ConvertidorParcela(1,1,"Tierra"));
        when(mockLector.haySiguiente()).thenReturn(true).thenReturn(false);

        Mapa unMapa = new Mapa(mockLector,1,1);

        torrePlateada.accionar(unMapa);
        torrePlateada.accionar(unMapa);
        torrePlateada.accionar(unMapa);


        assertEquals(torrePlateada.finalizoContruccion(),true);
    }}

//    @Test
//    public void VerificarQueAgregar1vez() {
//        SistemaConstruccion SistConstruccion = new SistemaConstruccion();
//        TorrePlateada torrePlateada = new TorrePlateada(new Posicion(0,0));
//
//        ConstruccionTentativa enContruccion = new ConstruccionTentativa(torrePlateada);
//
//        EstructurasActivas mock =  mock(EstructurasActivas.class);
//
//        SistConstruccion.agregarEnConstruccion(enContruccion);
//
//        for(int i = 0; i < 20; i++ ){
//            SistConstruccion.activarEstructuras(mock);
//        }
//
//        assertEquals(enContruccion.finalizoContruccion(),true);
//        verify(mock,times(1)).agregar(torrePlateada);
//    }
//}
