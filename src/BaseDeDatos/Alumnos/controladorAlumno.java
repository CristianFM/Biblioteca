package BaseDeDatos.Alumnos;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JOptionPane;

public class controladorAlumno implements ActionListener {
    NegocioSQLAlumno controlerSQL;
    frmAlumno frame;
    odtAlumno odtAlum;
    public controladorAlumno(frmAlumno frame) {
        this.frame = frame;
        NegocioSQLAlumno controlerSQL = new NegocioSQLAlumno();
    }

    public void getInfoAlumnoAlta(odtAlumno alumnoAltas){
        alumnoAltas.setDni(frame.getTxtAltaDNI().getText());
        alumnoAltas.setNombre(frame.getTxtAltaNombre().getText());
        alumnoAltas.setApellido1(frame.getTxtAltaApellido1().getText());
        alumnoAltas.setApellido2(frame.getTxtAltaApellido2().getText());
    }
    public odtAlumno getInfoAlumno() throws SQLException{
        return controlerSQL.getOdtAlumno();
    }
    public void setTablaAlumno() throws SQLException{
        odtAlumno odtAlum= getInfoAlumno();       
        frame.getTxtRegistro().setText(odtAlum.getRegistro());
        frame.getTxtDNI().setText(odtAlum.getDni());
        frame.getTxtNombre().setText(odtAlum.getNombre());
        frame.getTxtApellido1().setText(odtAlum.getApellido1());
        frame.getTxtApellido2().setText(odtAlum.getApellido2());
        
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if ("btmSiguiente".equals(e.getActionCommand())) {
            try {
                controlerSQL.BotonAvanzar();
                setTablaAlumno();
            } catch (SQLException ex) {
                Logger.getLogger(frmAlumno.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if ("btmAnterior".equals(e.getActionCommand())) {
            try {
                controlerSQL.BotonRetroceder();
                setTablaAlumno();
            } catch (SQLException ex) {
                Logger.getLogger(frmAlumno.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if ("btmAltas".equals(e.getActionCommand())) {
                    odtAlumno alumnoAltas = new odtAlumno();
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
                Logger.getLogger(controladorAlumno.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if ("btmBaja".equals(e.getActionCommand())) {
            try {
                odtAlumno alumno = getInfoAlumno();
                controlerSQL.SQLBajas(alumno);
                controlerSQL.Reconectar();
                setTablaAlumno();
                JOptionPane.showMessageDialog(null, "ENTRADA ELIMINADA");
            } catch (SQLException ex) {
                Logger.getLogger(controladorAlumno.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if ("btmSalir".equals(e.getActionCommand())) {
            System.exit(EXIT_ON_CLOSE);
        }
        if("btmRefrescar".equals(e.getActionCommand())){
            try {
                controlerSQL.Reconectar();
                setTablaAlumno();
            } catch (SQLException ex) {
                Logger.getLogger(controladorAlumno.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

}
