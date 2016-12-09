/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BaseDeDatos.Prestamos;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author DAM Mañana - PC
 */
public class ControladorVistaTabla extends AbstractTableModel {
    public OdtPrestamos prestamos;
    public NegocioSQLPrestamos prestamosSQL;
    public String[] parametrosTabla={"Id", "Prestamo", "Autor", "Titulo", "Devolución", "Estado"};
    
    //NyanNyan
    
    ControladorVistaTabla(NegocioSQLPrestamos prestamosSQL){
    this.prestamosSQL = prestamosSQL;
    }
    
    @Override
    public int getRowCount() {
        try {
            return prestamosSQL.NumeroRegistros();
        } catch (Exception ex) {
            return -1;
        }
       
    }

    @Override
    public int getColumnCount() {
       return parametrosTabla.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        try {
            DateFormat df = new SimpleDateFormat("dd/MM/yy");
            prestamos = prestamosSQL.getPrestamo(rowIndex);
            switch(columnIndex){
                case 0 : // Id
                        return prestamos.getId();
                    case 1 : // Titulo
                        return prestamos.getCodAlumno();
                    case 2 : // Autor
                        return prestamos.getCodLibro();
                    case 3 : // Prestamo
                        return df.format(prestamos.getFecPrestamo());
                    case 4 : // Devolucion
                        return df.format(prestamos.getFecDevolucion());
                    case 5 : // Estado
                        return prestamos.getEstado();
                   
            }
        } catch (Exception ex) {
            Logger.getLogger(ControladorVistaTabla.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "";
    }    
}
