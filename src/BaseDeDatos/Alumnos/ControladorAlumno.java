package BaseDeDatos.Alumnos;

import Main.FrmMain;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
public class ControladorAlumno implements ActionListener {
    NegocioSQLAlumno controlerSQL;
    DialogAlumno dialogo;
    OdtAlumno odtAlumo;
    FrmMain frmMain;
    public ControladorAlumno(FrmMain frmMain) {
        try {
            this.frmMain = frmMain;
            controlerSQL = new NegocioSQLAlumno();
            this.dialogo = new DialogAlumno(frmMain, true, this);
            controlerSQL.ConectarBase();
            dialogo.setVisible(true);
            setTablaAlumno();
        } catch (SQLException ex) {
            Logger.getLogger(ControladorAlumno.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void getInfoAlumnoAlta(OdtAlumno alumnoAltas){
        alumnoAltas.setDni(dialogo.getTxtAltaDNI().getText());
        alumnoAltas.setNombre(dialogo.getTxtAltaNombre().getText());
        alumnoAltas.setApellido1(dialogo.getTxtAltaApellido1().getText());
        alumnoAltas.setApellido2(dialogo.getTxtAltaApellido2().getText());
    }
    public OdtAlumno getInfoAlumno() throws SQLException{
        return controlerSQL.getOdtAlumno();
    }
    public void setTablaAlumno() throws SQLException{
        odtAlumo = getInfoAlumno();   
        dialogo.getTxtRegistro().setText(odtAlumo.getRegistro());
        dialogo.getTxtDNI().setText(odtAlumo.getDni());
        dialogo.getTxtNombre().setText(odtAlumo.getNombre());
        dialogo.getTxtApellido1().setText(odtAlumo.getApellido1());
        dialogo.getTxtApellido2().setText(odtAlumo.getApellido2());
        
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if ("btmSiguiente".equals(e.getActionCommand())) {
            try {
                controlerSQL.BotonAvanzar();
                setTablaAlumno();
            } catch (SQLException ex) {
                Logger.getLogger(DialogAlumno.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if ("btmAnterior".equals(e.getActionCommand())) {
            try {
                controlerSQL.BotonRetroceder();
                setTablaAlumno();
            } catch (SQLException ex) {
                Logger.getLogger(DialogAlumno.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if ("btmAltas".equals(e.getActionCommand())) {
                    OdtAlumno alumnoAltas = new OdtAlumno();
                    getInfoAlumnoAlta(alumnoAltas);
                    controlerSQL.SQLAltas(alumnoAltas);
                    controlerSQL.Reconectar();
                    JOptionPane.showMessageDialog(null, "ENTRADA AÑADIDA");
        }
        if ("btmBuscar".equals(e.getActionCommand())) {
            try {
                controlerSQL.Buscar(dialogo.getTxtRegistro().getText());
                setTablaAlumno();
            } catch (SQLException ex) {
                Logger.getLogger(ControladorAlumno.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if ("btmBaja".equals(e.getActionCommand())) {
            try {
                OdtAlumno alumno = getInfoAlumno();
                controlerSQL.SQLBajas(alumno);
                controlerSQL.Reconectar();
                setTablaAlumno();
                JOptionPane.showMessageDialog(null, "ENTRADA ELIMINADA");
            } catch (SQLException ex) {
                Logger.getLogger(ControladorAlumno.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if ("btmSalir".equals(e.getActionCommand())) {
            dialogo.dispose();
        }
        if("btmRefrescar".equals(e.getActionCommand())){
            try {
                controlerSQL.Reconectar();
                setTablaAlumno();
            } catch (SQLException ex) {
                Logger.getLogger(ControladorAlumno.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

}
