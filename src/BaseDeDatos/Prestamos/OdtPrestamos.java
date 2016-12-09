/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BaseDeDatos.Prestamos;

import java.sql.Date;

/**
 *
 * @author DAM Mañana - PC
 */
public class OdtPrestamos {
    private int id;
    private String codAlumno;
    private String codLibro;
    private Date fecPrestamo;
    private Date fecDevolucion;
    private String estado;
    private String titulo;
    private String autor;

    public OdtPrestamos() {
           id = -1;
        codAlumno = "";
        codLibro = "";
        java.util.Date utilDate = new java.util.Date();
        fecPrestamo = new Date( utilDate.getTime() );
        fecDevolucion = new Date( 0 );
        estado = "";
        titulo = "";
        autor = "";
    }

    
    public OdtPrestamos(int id, String codAlumno, String codLibro, Date fecPrestamo, Date fecDevolucion, String estado, String titulo, String autor) {
        this.id = id;
        this.codAlumno = codAlumno;
        this.codLibro = codLibro;
        this.fecPrestamo = fecPrestamo;
        this.fecDevolucion = fecDevolucion;
        this.estado = estado;
        this.titulo = titulo;
        this.autor = autor;
    }
    
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCodAlumno() {
        return codAlumno;
    }

    public void setCodAlumno(String codAlumno) {
        this.codAlumno = codAlumno;
    }

    public String getCodLibro() {
        return codLibro;
    }

    public void setCodLibro(String codLibro) {
        this.codLibro = codLibro;
    }

    public Date getFecPrestamo() {
        return fecPrestamo;
    }

    public void setFecPrestamo(Date fecPrestamo) {
        this.fecPrestamo = fecPrestamo;
    }

    public Date getFecDevolucion() {
        return fecDevolucion;
    }

    public void setFecDevolucion(Date fecDevolucion) {
        this.fecDevolucion = fecDevolucion;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }
    
}
