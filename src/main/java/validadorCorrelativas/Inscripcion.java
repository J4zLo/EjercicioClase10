package validadorCorrelativas;

import java.time.LocalDate;

public class Inscripcion {
    private Alumno alumno;
    private Materia materia;
    private LocalDate fecha;
    public Inscripcion(Alumno alumno, Materia materia) {
        this.alumno = alumno;
        this.materia = materia;
        this.fecha = LocalDate.now();
    }

    public Alumno getAlumno() {
        return alumno;
    }

    public Materia getMateria() {
        return materia;
    }

    public LocalDate getFecha() {
        return fecha;
    }
    public boolean aprobada(){
        /** La Inscripcion estará aceptada (true) si la materia:
         * - No tiene correlativas o
         * - Si la materia tiene correlativas y el alumno cursó todas ellas.
         */

        return !this.materia.tenesCorrelativas() || this.materia.puedeCursar (this.alumno);
    }

    public String leyendaEstado (){
        return this.aprobada()?"Aprobada" : "Rechazada";
    }

}
