package BaseDeDatos.Alumnos;

import BaseDeDatos.ClaseConec;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class NegocioSQLAlumno {
    private OdtAlumno odtAlum;
    private ClaseConec connect;
    private ResultSet rs;
    
    public NegocioSQLAlumno() {
        connect = new ClaseConec();
        odtAlum = new OdtAlumno();
    }
    public String inicializarSQLTabla(){
        return "Select * from alumnos";
    }
    public String SQLBusqueda(String registro){
        
        return "Select * from alumnos where registro ='" + registro + "'";
    }

    public void ConectarBase() {
        try {
            connect.abrirConeccion();
            rs = connect.ejecutarTabla(inicializarSQLTabla());
        } catch (SQLException ex) {
            Logger.getLogger(NegocioSQLAlumno.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void Reconectar(){
        try {
            connect.reconectar();
            connect.ejecutarTabla(inicializarSQLTabla());
        } catch (SQLException ex) {
            Logger.getLogger(NegocioSQLAlumno.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void avanzarCursor() {
        try {
            connect.actualizar();
        } catch (SQLException ex) {
            Logger.getLogger(NegocioSQLAlumno.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public ResultSet getResultSetConect(){
        return connect.getResulSet();
    }
    
    public void SQLAltas(OdtAlumno alumno) {
        try {
            String sql = "Insert into alumnos(dni,nombre,apellido1,apellido2) values('"
                    + alumno.getDni() + "','" + alumno.getNombre() + "','" + alumno.getApellido1() + "','" + alumno.getApellido2() + "')";
            connect.realizarUpdateInsertDelete(sql);
            connect.ejecutarTabla(inicializarSQLTabla());
        } catch (SQLException ex) {
            Logger.getLogger(NegocioSQLAlumno.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void SQLBajas(OdtAlumno alum ) {
        try {
            String sql = "Delete from alumnos where registro = '" + alum.getRegistro() + "'";
            connect.realizarUpdateInsertDelete(sql);
            connect.ejecutarTabla(inicializarSQLTabla());
        } catch (SQLException ex) {
            Logger.getLogger(NegocioSQLAlumno.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void BotonAvanzar() {
        try {
            if (rs.isLast()) {
                rs.first();
            } else {
                rs.next();
            }
        } catch (SQLException ex) {
            Logger.getLogger(DialogAlumno.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void BotonRetroceder() {
        try {
            if (rs.isFirst()) {
                rs.last();

            } else {
                rs.previous();
            }
        } catch (SQLException ex) {
            Logger.getLogger(DialogAlumno.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void Buscar(String registro) {
        try {
            connect.realizarConsulta(SQLBusqueda(registro));
            rs = connect.getResulSet();
        } catch (SQLException ex) {
            Logger.getLogger(NegocioSQLAlumno.class.getName()).log(Level.SEVERE, null, ex);
        }
    }        
    
     public OdtAlumno getOdtAlumno() throws SQLException {
        
        ResultSet resulsetAlum;
        //resulsetAlum = connect.getResulSet();
        
        odtAlum.setRegistro(rs.getString("registro"));
        odtAlum.setDni(rs.getString("dni"));
        odtAlum.setNombre(rs.getString("nombre"));
        odtAlum.setApellido1(rs.getString("Apellido1"));
        odtAlum.setApellido2(rs.getString("Apellido2"));
        return odtAlum;
    }

}
