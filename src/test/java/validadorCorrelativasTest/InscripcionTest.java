package validadorCorrelativasTest;

import junit.framework.Assert;
import junit.framework.TestCase;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import validadorCorrelativas.Alumno;
import validadorCorrelativas.Inscripcion;
import validadorCorrelativas.Materia;

public class InscripcionTest {
    private Alumno juan;

    private Materia programacionI;
    private Materia programacionII;

    @BeforeEach //Va a correr antes de cada uno de los Test. Con esto me aseguro que los test sean aislados
        public void inicializar(){
            this.juan = new Alumno ( "Juan", "123456789");
            this.programacionI = new Materia ("Programacion I");
            this.programacionII = new Materia ("Programacion II");

            this.programacionII.agregarCorrelativa(programacionI);

        }



    @Test
    public void juanSePuedeAnotarAProgramacionI(){
        Inscripcion inscripcionDeJuanAProgI = new Inscripcion(this.juan, this.programacionI);

        Assertions.assertTrue(inscripcionDeJuanAProgI.aprobada());

    }
    @Test
    public void juanNoSePuedeAnotarAProgramacionII(){
        Inscripcion inscripcionDeJuanAProgII = new Inscripcion(this.juan, this.programacionII);

        Assertions.assertFalse(inscripcionDeJuanAProgII.aprobada());

    }
    @Test
    public void juanSePuedeAnotarAProgramacionII(){
        juan.agregarMateriaAprobada(programacionI);
        Inscripcion inscripcionDeJuanAProgII = new Inscripcion(this.juan, this.programacionII);

        Assertions.assertTrue(inscripcionDeJuanAProgII.aprobada());

    }
}
