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
    FrmAlumno frame;
    OdtAlumno odtAlumo;
    FrmMain frmMain;
    public ControladorAlumno(FrmMain frmMain) {
        try {
            this.frmMain = frmMain;
            controlerSQL = new NegocioSQLAlumno();
            this.frame = new FrmAlumno(frmMain, true, this);
            frame.setVisible(true);
            controlerSQL.ConectarBase();
            setTablaAlumno();
        } catch (SQLException ex) {
            Logger.getLogger(ControladorAlumno.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void getInfoAlumnoAlta(OdtAlumno alumnoAltas){
        alumnoAltas.setDni(frame.getTxtAltaDNI().getText());
        alumnoAltas.setNombre(frame.getTxtAltaNombre().getText());
        alumnoAltas.setApellido1(frame.getTxtAltaApellido1().getText());
        alumnoAltas.setApellido2(frame.getTxtAltaApellido2().getText());
    }
    public OdtAlumno getInfoAlumno() throws SQLException{
        return controlerSQL.getOdtAlumno();
    }
    public void setTablaAlumno() throws SQLException{
        odtAlumo = getInfoAlumno();   
        frame.getTxtRegistro().setText(odtAlumo.getRegistro());
        frame.getTxtDNI().setText(odtAlumo.getDni());
        frame.getTxtNombre().setText(odtAlumo.getNombre());
        frame.getTxtApellido1().setText(odtAlumo.getApellido1());
        frame.getTxtApellido2().setText(odtAlumo.getApellido2());
        
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if ("btmSiguiente".equals(e.getActionCommand())) {
            try {
                controlerSQL.BotonAvanzar();
                setTablaAlumno();
            } catch (SQLException ex) {
                Logger.getLogger(FrmAlumno.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if ("btmAnterior".equals(e.getActionCommand())) {
            try {
                controlerSQL.BotonRetroceder();
                setTablaAlumno();
            } catch (SQLException ex) {
                Logger.getLogger(FrmAlumno.class.getName()).log(Level.SEVERE, null, ex);
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
                controlerSQL.Buscar(frame.getTxtRegistro().getText());
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
            frame.dispose();
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
