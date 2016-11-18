package BaseDeDatos.Libros;

import BaseDeDatos.ClaseConec;
import java.sql.ResultSet;
import java.sql.SQLException;

public class NegocioSQLLibros {
    private odtLibros odtLibros;
    private ClaseConec connect;
    private ResultSet rs;
    
    public NegocioSQLLibros() {
        connect = new ClaseConec();
    }
    public String inicializarSQLTabla(){
        return "Select * from libros";
    }
    public String SQLBusqueda(String codigo){
        
        return "Select * from libros where codigo ='" + codigo + "'";
    }

    public void ConectarBase() {
        try {
            connect.abrirConeccion();
            rs = connect.ejecutarTabla(inicializarSQLTabla());
        } catch (SQLException ex) {
}
    }
    public void Reconectar(){
        try {
            connect.reconectar();
            rs = connect.ejecutarTabla(inicializarSQLTabla());
        } catch (SQLException ex) {
        }
    }
    
    public void avanzarCursor() {
        try {
            connect.actualizar();
        } catch (SQLException ex) {
        }
    }
    
    public void SQLAltas(odtLibros libro) {
        try {
            String sql = "Insert into libros(tiulo,autor,editorial,asignatura,estado) values('"
                    + libro.getTitulo() + "','" + libro.getAutor() + "','" + libro.getEditorial()+ "','" + libro.getAsignatura()+ "','"+libro.getEstado()+"')";
            connect.realizarUpdateInsertDelete(sql);
            connect.ejecutarTabla(inicializarSQLTabla());
        } catch (SQLException ex) {
        }
    }

    public void SQLBajas(odtLibros libro ) {
        try {
            String sql = "Delete from libros where registro = '" + libro.getCodigo() + "'";
            connect.realizarUpdateInsertDelete(sql);
            connect.ejecutarTabla(inicializarSQLTabla());
        } catch (SQLException ex) {
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
        }
    }

    public void Buscar(String codigo) {
        try {
            connect.realizarConsulta(SQLBusqueda(codigo));
            rs=connect.getResulSet();
        } catch (SQLException ex) {
        }
    }

    

     public odtLibros getOdtAlumno() throws SQLException {
        
        odtLibros = new odtLibros();
        
        odtLibros.setCodigo(rs.getString("codigo"));
        odtLibros.setTitulo(rs.getString("titulo"));
        odtLibros.setAutor(rs.getString("autor"));
        odtLibros.setEditorial(rs.getString("editorial"));
        odtLibros.setAsignatura("asignatura");
        odtLibros.setEstado(rs.getString("estado"));
        return odtLibros;
    }

}
