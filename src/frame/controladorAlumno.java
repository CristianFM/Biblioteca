package frame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import static javax.swing.JFrame.EXIT_ON_CLOSE;

public class controladorAlumno implements ActionListener {
    NegocioSQLAlumno controlerSQL;
    frmInicial frame;

    public controladorAlumno(frmInicial frame) {
        this.frame = frame;
    }

    public odtAlumno getInfoAlumno(){
        odtAlumno odtAlum = new odtAlumno();
        odtAlum.setDni(frame.getTxtAltaDNI().getText());
        odtAlum.setNombre(frame.getTxtAltaNombre().getText());
        odtAlum.setApellido1(frame.getTxtAltaApellido1().getText());
        odtAlum.setApellido2(frame.getTxtAltaApellido2().getText());
        System.out.println(odtAlum.getNombre());
        return odtAlum;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if ("btmConectar".equals(e.getActionCommand())) {
            try {
                controlerSQL.ConectarBase();
                frame.setTabla();
            } catch (SQLException ex) {
                Logger.getLogger(frmInicial.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
        if ("btmSiguiente".equals(e.getActionCommand())) {
            try {
                controlerSQL.BotonAvanzar();
                frame.setTabla();
            } catch (SQLException ex) {
                Logger.getLogger(frmInicial.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if ("btmAnterior".equals(e.getActionCommand())) {
            try {
                controlerSQL.BotonRetroceder();
                frame.setTabla();
            } catch (SQLException ex) {
                Logger.getLogger(frmInicial.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if ("btmAltas".equals(e.getActionCommand())) {
            odtAlumno alumno = getInfoAlumno();
            controlerSQL.SQLAltas(alumno);
        }
        if ("btmBuscar".equals(e.getActionCommand())) {
            try {
                odtAlumno alumno = new odtAlumno();
                controlerSQL.Buscar(getInfoAlumno());
                frame.setTabla();
                controlerSQL.avanzarCursor();
            } catch (SQLException ex) {
                Logger.getLogger(frmInicial.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if ("btmBajas".equals(e.getActionCommand())) {
            controlerSQL.SQLBajas(txtRegistro.getText());
            controlerSQL.avanzarCursor();
        }
        if ("btSalir".equals(e.getActionCommand())) {
            System.exit(EXIT_ON_CLOSE);
        }
    }

}
