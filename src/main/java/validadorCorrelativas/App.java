package validadorCorrelativas;

import validadorCorrelativas.exceptions.AlumnoNoExisteException;
import validadorCorrelativas.exceptions.MateriaNoExisteException;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class App {
    public static void main(String[] args) throws IOException {
        List<Materia> materias = materias();
        List<Alumno> alumnos = alumnos();
        String ruta = "C:\\Users\\PC\\Desktop\\leerArchivo.csv";

        //TODO pasar parametros argumentos
        for (String unaLineaDeInscripcion : Files.readAllLines(Paths.get(ruta))) {
            String[] datos = unaLineaDeInscripcion.split(";");

            Inscripcion inscripcion = generarInscripcionApartirDeDatos(datos, alumnos, materias);
            mostrarPorPantallaEstadoDeInscripcion(inscripcion);
            //TODO escribir en Archivo

        }
    }
    private static void mostrarPorPantallaEstadoDeInscripcion(Inscripcion inscripcion){
        System.out.println("La inscripcion del alumno " + inscripcion.getAlumno()+ " a la materia "+ inscripcion.getMateria() + " fue "+ inscripcion.leyendaEstado());
    }
    private static Inscripcion generarInscripcionApartirDeDatos(String [] datos, List<Alumno> alumnos, List<Materia> materias) {
        Alumno alumno =buscarAlumnoPorLegajo(datos[0], alumnos);
        Materia materia = buscarMateriaPorId(datos[3], materias);

        Inscripcion inscripcion = new Inscripcion (alumno, materia);
        return inscripcion;

    }


    private static Materia buscarMateriaPorId (String id, List<Materia> materias){
        Optional<Materia> supuestaMateria = materias.stream().filter(m->m.getIdMateria().equals(id)).findFirst();
        if (!supuestaMateria.isPresent()) {
            throw new MateriaNoExisteException();
        }
        return supuestaMateria.get();
    }
    private static Alumno buscarAlumnoPorLegajo (String legajo, List<Alumno> alumnos){

        /** Voy a buscar el objeto alumno (alumnos) cuyo legajo coincide con el legajo que yo le di desde el archivo.
         * El metodo findFirst me devuelve un Optional (supuestoalumno) va a intentar devolver el primer objeto que coincida
         * pero puede que no devuelva nada si el archivo esta vacio x ej.
         */
        Optional<Alumno> supuestoAlumno= alumnos.stream().filter(a ->a.getLegajo().equals(legajo)).findFirst();
        if (!supuestoAlumno.isPresent()){
            //Puedo lanzar una excepcion. Si no encuentra el alumno... Print: "El legajo no coincide con ningun Alumno"
            throw new AlumnoNoExisteException("No se encontraron coincidencias para el legajo " + legajo);
        }
        Alumno alumno = supuestoAlumno.get ();
        return alumno;
    }
    private static List<Materia> materias() {
        List<Materia> materias = new ArrayList<>();
        Materia prograI = new Materia("Programacion I");
        prograI.setIdMateria("a");
        Materia prograII = new Materia("Programacion II");
        prograII.setIdMateria("c");
        Materia baseDatosI = new Materia("Base de datos I");
        baseDatosI.setIdMateria("b");

        prograII.agregarCorrelativa(prograI);
        materias.add(prograI);
        materias.add(prograII);
        materias.add(baseDatosI);
        return materias;
    }

    private static List<Alumno> alumnos() {
        List<Alumno> alumnos = new ArrayList<>();
        Alumno ana = new Alumno("Ana", "1212");
        Alumno luca = new Alumno("Luca", "1022");
        Alumno rosario = new Alumno("Rosario", "1459");
        Alumno pedro = new Alumno("Pedro", "978");

        alumnos.add(ana);
        alumnos.add(luca);
        alumnos.add(rosario);
        alumnos.add(pedro);
        return alumnos;
    }
}


