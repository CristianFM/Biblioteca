package BaseDeDatos.Alumnos;

public class OdtAlumno {
    
    private String registro;
    private String dni;
    private String nombre;
    private String apellido1;
    private String apellido2;
    
    public OdtAlumno(){
        
    }

    public String getRegistro() {
        return registro;
    }

    public void setRegistro(String parametroRegistro) {
        this.registro = parametroRegistro;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String parametroDni) {
        this.dni = parametroDni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String parametroNombre) {
        this.nombre = parametroNombre;
    }

    public String getApellido1() {
        return apellido1;
    }

    public void setApellido1(String parametroApellido1) {
        this.apellido1 = parametroApellido1;
    }

    public String getApellido2() {
        return apellido2;
    }

    public void setApellido2(String parametroApellido2) {
        this.apellido2 =  parametroApellido2;
    }
    
}
