package BaseDeDatos.Libros;

import BaseDeDatos.Alumnos.FrmAlumno;
import BaseDeDatos.Alumnos.OdtAlumno;
import BaseDeDatos.ClaseConec;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class NegocioSQLLibros {
     private OdtLibros odtLibros;
    private ClaseConec connect;
    private ResultSet rs;
    
    public NegocioSQLLibros() {
        connect = new ClaseConec();
        odtLibros = new OdtLibros();
    }
    public String inicializarSQLTabla(){
        return "Select * from Libros";
    }
    public String SQLBusqueda(String codigo){
        
        return "Select * from Libros where codigo ='" + codigo + "'";
    }

    public void ConectarBase() {
        try {
            connect.abrirConeccion();
            rs = connect.ejecutarTabla(inicializarSQLTabla());
        } catch (SQLException ex) {
            Logger.getLogger(NegocioSQLLibros.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void Reconectar(){
        try {
            connect.reconectar();
            connect.ejecutarTabla(inicializarSQLTabla());
        } catch (SQLException ex) {
            Logger.getLogger(NegocioSQLLibros.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void avanzarCursor() {
        try {
            connect.actualizar();
        } catch (SQLException ex) {
            Logger.getLogger(NegocioSQLLibros.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public ResultSet getResultSetConect(){
        return connect.getResulSet();
    }
    
    public void SQLAltas(OdtLibros libro) {
        try {
            String sql = "Insert into biblioteca(titulo, autor, editorial, asignatura, estado) values('"
                    + libro.getTitulo() + "','" +libro.getAutor() + "','" + libro.getEditorial() +
                        "','" + libro.getAsignatura() +"','" + libro.getEstado() + "')";
            connect.realizarUpdateInsertDelete(sql);
            connect.ejecutarTabla(inicializarSQLTabla());
        } catch (SQLException ex) {
            Logger.getLogger(NegocioSQLLibros.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void SQLBajas(OdtLibros libro) {
        try {
            String sql = "Delete from libros where registro = '" + libro.getCodigo() + "'";
            connect.realizarUpdateInsertDelete(sql);
            connect.ejecutarTabla(inicializarSQLTabla());
        } catch (SQLException ex) {
            Logger.getLogger(NegocioSQLLibros.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void BotonAvanzar() {
        try {
            if (connect.isTablaFinal()) {
                connect.tablaInicio();
            } else {
                connect.tablaSiguiente();
            }
        } catch (SQLException ex) {
            Logger.getLogger(FrmAlumno.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void BotonRetroceder() {
        try {
            if (connect.isTablaInicio()) {
                connect.tablaFinal();

            } else {
                connect.tablaAnterior();
            }
        } catch (SQLException ex) {
            Logger.getLogger(FrmAlumno.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void Buscar(String registro) {
        try {
            connect.realizarConsulta(SQLBusqueda(registro));
            connect.getResulSet();
        } catch (SQLException ex) {
            Logger.getLogger(NegocioSQLLibros.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
     public OdtLibros getOdtLibros() throws SQLException {
        
        ResultSet resulsetAlum;
        resulsetAlum = connect.getResulSet();
        
        odtLibros.setCodigo(resulsetAlum.getString("codigo"));
        odtLibros.setTitulo(resulsetAlum.getString("titulo"));
        odtLibros.setAutor(resulsetAlum.getString("autor"));
        odtLibros.setEditorial(resulsetAlum.getString("editorial"));
        odtLibros.setAsignatura(resulsetAlum.getString("asignatura"));
        odtLibros.setEstado(resulsetAlum.getString("estado"));
        return odtLibros;
    }

}
