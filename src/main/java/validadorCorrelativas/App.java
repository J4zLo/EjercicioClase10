package validadorCorrelativas;

import java.util.ArrayList;
import java.util.List;

/**
 * Hello world!
 *
 */
public class App {
    public static void main(String[] args) {
        System.out.println("Hello World!");

        List<Materia> materias = materias();
        List<Alumno> alumnos = alumnos();
    }

    private static List<Materia> materias() {
        List<Materia> materias = new ArrayList<>();
        Materia prograI = new Materia("Programacion I");
        Materia prograII = new Materia("Programacion II");
        Materia baseDatosI = new Materia("Base de Datos I");

        prograII.agregarCorrelativa(prograI);
        materias.add(prograI);
        materias.add(prograII);
        materias.add(baseDatosI);
        return materias;
    }

    private static List<Alumno> alumnos() {
        List<Alumno> alumnos = new ArrayList<>();
        Alumno ana = new Alumno("Ana Lucia", "1234568");
        Alumno luca = new Alumno("Luca", "1225648");
        Alumno rosario = new Alumno("Rosario", "1234697");
        Alumno pedro = new Alumno("Pedro", "1078926");

        alumnos.add(ana);
        alumnos.add(luca);
        alumnos.add(rosario);
        alumnos.add(pedro);
        return alumnos;
    }
}


