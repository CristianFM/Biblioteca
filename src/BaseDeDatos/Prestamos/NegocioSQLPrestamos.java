/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BaseDeDatos.Prestamos;

import BaseDeDatos.Alumnos.DialogAlumno;
import BaseDeDatos.Alumnos.NegocioSQLAlumno;
import BaseDeDatos.ClaseConec;
import BaseDeDatos.Libros.NegocioSQLLibros;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author DAM Mañana - PC
 */
public class NegocioSQLPrestamos {
    public ClaseConec connect;
    public ResultSet rs;
    public OdtPrestamos odtPrestamos;
    
    public static final int COLUMN_PRESTAMO_ID = 0;
    public static final int COLUMN_PRESTAMO_CODALUMNO = 1;
    public static final int COLUMN_PRESTAMO_CODLIBRO = 2;
    //public static final int COLUMN_PRESTAMO_TITULO = 3;
    //public static final int COLUMN_PRESTAMO_AUTOR = 4;
    public static final int COLUMN_PRESTAMO_FECPRESTAMO = 3;
    public static final int COLUMN_PRESTAMO_FECDEVOLUCION = 4;
    public static final int COLUMN_PRESTAMO_ESTADO = 5;

    public NegocioSQLPrestamos(){
    connect = new ClaseConec();
    odtPrestamos = new OdtPrestamos();
    }
    public String inicializarSQLTabla(){
        return "Select * from prestamos";
    }
    public String SQLBusqueda(String id){
        
        return "Select * from Libros where id ='" + id + "'";
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
     public OdtPrestamos getPrestamo(int row) throws Exception {
        OdtPrestamos prestamo = null;
        if (rs.absolute(row +1)) {
            prestamo = new OdtPrestamos();
            prestamo.setId(rs.getInt(1));;
            prestamo.setCodAlumno(rs.getString(2));
            prestamo.setCodLibro(rs.getString(3));
            //prestamo.setTitulo();
            //prestamo.setAutor();
            prestamo.setFecPrestamo(rs.getDate(4));
            prestamo.setFecDevolucion(rs.getDate(5));
            prestamo.setEstado(rs.getString(6));
        }
        return prestamo;
     }
    
    public ResultSet getResultSetConect(){
        return connect.getResulSet();
    }
    
    public int NumeroRegistros() throws Exception {
        int fila = -1;
        if (rs.last()) {
            fila = rs.getRow();
        }
        return fila;
    }
    
    public void Buscar(String registro) {
        try {
            connect.realizarConsulta(SQLBusqueda(registro));
            rs = connect.getResulSet();
        } catch (SQLException ex) {
            Logger.getLogger(NegocioSQLAlumno.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
