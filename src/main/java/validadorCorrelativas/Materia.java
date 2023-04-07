package validadorCorrelativas;
import java.util.ArrayList;
import java.util.List;

public class Materia {
    private String nombre;
    private List<Materia> correlativas;
    private String idMateria;

    public String getIdMateria() {
        return idMateria;
    }

    public void setIdMateria(String idMateria) {
        this.idMateria = idMateria;
    }

    public String getNombre() {
        return nombre;
    }

    public List<Materia> getCorrelativas() {
        return correlativas;
    }
    public void agregarCorrelativa (Materia correlativa){
        this.correlativas.add(correlativa);

    }
    public Materia (String nombreMateria){
        this.nombre =nombreMateria;
        this.correlativas= new ArrayList<Materia>();
    }

    public boolean puedeCursar(Alumno alumno){
        /** El Alumno puede cursar la materia si tiene todas las correlativas cursadas
         *
         */
         return this.correlativas.stream().allMatch(materiaCorrelativa -> alumno.tenesCorrelativa(materiaCorrelativa));

    }

    public boolean tenesCorrelativas() {
        return !this.correlativas.isEmpty(); //Si tiene correlativas mi coleccion no esta vacia!
    }

    @Override
    public String toString() {
        return this.nombre;
    }
}
