package BaseDeDatos.Libros;

import BaseDeDatos.Alumnos.DialogAlumno;
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
            rs = connect.ejecutarTabla(inicializarSQLTabla());
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
            String sql = "Insert into libros(titulo, autor, editorial, asignatura, estado) values('"
                    + libro.getTitulo() + "','" +libro.getAutor() + "','" + libro.getEditorial() +
                        "','" + libro.getAsignatura() +"','" + libro.getEstado() + "')";
            System.out.println(sql);
            connect.realizarUpdateInsertDelete(sql);
            connect.ejecutarTabla(inicializarSQLTabla());
        } catch (SQLException ex) {
            Logger.getLogger(NegocioSQLLibros.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void SQLBajas(OdtLibros libro) {
        try {
            String sql = "Delete from libros where codigo = '" + libro.getCodigo() + "'";
            connect.realizarUpdateInsertDelete(sql);
            connect.ejecutarTabla(inicializarSQLTabla());
        } catch (SQLException ex) {
            Logger.getLogger(NegocioSQLLibros.class.getName()).log(Level.SEVERE, null, ex);
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
            connect.getResulSet();
        } catch (SQLException ex) {
            Logger.getLogger(NegocioSQLLibros.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
     public OdtLibros getOdtLibros() throws SQLException {
        
        ResultSet resulsetAlum;
        
        odtLibros.setCodigo(rs.getString("codigo"));
        odtLibros.setTitulo(rs.getString("titulo"));
        odtLibros.setAutor(rs.getString("autor"));
        odtLibros.setEditorial(rs.getString("editorial"));
        odtLibros.setAsignatura(rs.getString("asignatura"));
        odtLibros.setEstado(rs.getString("estado"));
        return odtLibros;
    }

}
