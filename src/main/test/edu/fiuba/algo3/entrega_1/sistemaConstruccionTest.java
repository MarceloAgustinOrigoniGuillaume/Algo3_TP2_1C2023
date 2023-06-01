package edu.fiuba.algo3.entrega_1;

import edu.fiuba.algo3.modelo.moduloContruccion.ConstruccionTentativa;
import edu.fiuba.algo3.modelo.moduloContruccion.SistemaConstruccion;
import edu.fiuba.algo3.modelo.moduloDefensas.EstructurasActivas;
import edu.fiuba.algo3.modelo.moduloDefensas.TorrePlateada;
import edu.fiuba.algo3.modelo.moduloMapa.Posicion;
import org.junit.jupiter.api.Test;
import org.mockito.exceptions.base.MockitoException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class sistemaConstruccionTest {
    @Test
    public void verificarDefensaTardaEnContruirseLoQueDebePaseSerActivo() {
        SistemaConstruccion SistConstruccion = new SistemaConstruccion();
        TorrePlateada torrePlateada = new TorrePlateada(new Posicion(0,0));

        ConstruccionTentativa enContruccion = new ConstruccionTentativa(torrePlateada);

        EstructurasActivas mock = mock(EstructurasActivas.class);

        SistConstruccion.agregarEnConstruccion(enContruccion);

        /*
        Posible separacion de test al verificar cada turno
        */

        assertEquals(enContruccion.finalizoContruccion(),false);
        verify(mock,times(0)).agregar(torrePlateada);

        /*
        Recien para despues lo del Mock, al verificar que esten operativas
        */
    }

    @Test
    public void PasoUnTurno() {
        SistemaConstruccion SistConstruccion = new SistemaConstruccion();
        TorrePlateada torrePlateada = new TorrePlateada(new Posicion(0,0));

        ConstruccionTentativa enContruccion = new ConstruccionTentativa(torrePlateada);

        EstructurasActivas mock =  mock(EstructurasActivas.class);

        SistConstruccion.agregarEnConstruccion(enContruccion);

        SistConstruccion.activarEstructuras(mock);
        assertEquals(enContruccion.finalizoContruccion(),false);
        verify(mock,times(0)).agregar(torrePlateada);
        /*
        Recien para despues lo del Mock, al verificar que esten operativas
        */
    }

    @Test
    public void MultiplesTurno() {
        SistemaConstruccion SistConstruccion = new SistemaConstruccion();
        TorrePlateada torrePlateada = new TorrePlateada(new Posicion(0,0));

        ConstruccionTentativa enContruccion = new ConstruccionTentativa(torrePlateada);

        EstructurasActivas mock =  mock(EstructurasActivas.class);

        SistConstruccion.agregarEnConstruccion(enContruccion);

        for(int i = 0; i < 3; i++ ){
            SistConstruccion.activarEstructuras(mock);
        }

        assertEquals(enContruccion.finalizoContruccion(),true);
        verify(mock,times(1)).agregar(torrePlateada);
    }

    @Test
    public void VerificarQueAgregar1vez() {
        SistemaConstruccion SistConstruccion = new SistemaConstruccion();
        TorrePlateada torrePlateada = new TorrePlateada(new Posicion(0,0));

        ConstruccionTentativa enContruccion = new ConstruccionTentativa(torrePlateada);

        EstructurasActivas mock =  mock(EstructurasActivas.class);

        SistConstruccion.agregarEnConstruccion(enContruccion);

        for(int i = 0; i < 20; i++ ){
            SistConstruccion.activarEstructuras(mock);
        }

        assertEquals(enContruccion.finalizoContruccion(),true);
        verify(mock,times(1)).agregar(torrePlateada);
    }
}
