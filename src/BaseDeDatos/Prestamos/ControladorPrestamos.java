/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BaseDeDatos.Prestamos;

import Main.FrmMain;

/**
 *
 * @author DAM Mañana - PC
 */
public class ControladorPrestamos {
    NegocioSQLPrestamos prestamosSQL;
    OdtPrestamos prestamos;
    DialogPrestamos dlgPrestamos;
    FrmMain frmMain;
    
    public ControladorPrestamos(FrmMain frmMain){
        this.frmMain=frmMain;
        prestamosSQL = new NegocioSQLPrestamos();
        this.dlgPrestamos = new DialogPrestamos(frmMain, true, this);
        prestamosSQL.ConectarBase();
        dlgPrestamos.setVisible(true);
        
    }

    public NegocioSQLPrestamos getPrestamosSQL() {
        return prestamosSQL;
    }
    
}
