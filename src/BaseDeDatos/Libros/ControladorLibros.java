package BaseDeDatos.Libros;

import BaseDeDatos.Alumnos.ControladorAlumno;
import BaseDeDatos.Alumnos.FrmAlumno;
import BaseDeDatos.Alumnos.NegocioSQLAlumno;
import BaseDeDatos.Alumnos.OdtAlumno;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JOptionPane;


public class ControladorLibros implements ActionListener{
    NegocioSQLLibros controlerSQL;
    OdtLibros odtLibros;
    FrmLibros frm;
    public ControladorLibros(){
        try {
            controlerSQL = new NegocioSQLLibros();
            this.frm                                                                                                                                                                                        = new FrmLibros(this);
            frm.setVisible(true);
            controlerSQL.ConectarBase();
            setTablaLibros();
        } catch (SQLException ex) {
            Logger.getLogger(ControladorAlumno.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void getInfoLibrosAlta(OdtLibros libroAltas){
        libroAltas.setTitulo(frm.getTxtTituloAlta().getText());
        libroAltas.setAsignatura(frm.getTxtAsignaturaAlta().getText());
        libroAltas.setEditorial(frm.getTxtEditorialAlta().getText());
        libroAltas.setEstado(frm.getTxtEstadoAlta().getText());
    }
    public OdtLibros getInfoLibros() throws SQLException{
        return controlerSQL.getOdtLibros();
    }
    public void setTablaLibros() throws SQLException{
        odtLibros = getInfoLibros();   
        frm.getTxtCodigo().setText(odtLibros.getCodigo());
        frm.getTxtTitulo().setText(odtLibros.getTitulo());
        frm.getTxtAutor().setText(odtLibros.getAutor());
        frm.getTxtEditorial().setText(odtLibros.getEditorial());
        frm.getTxtAsignatura().setText(odtLibros.getAsignatura());
        frm.getTxtEstado().setText(odtLibros.getEstado());
        
    }
    @Override
    public void actionPerformed(ActionEvent e) {
       if ("btmSiguiente".equals(e.getActionCommand())) {
            try {
                controlerSQL.BotonAvanzar();
                setTablaLibros();
            } catch (SQLException ex) {
                Logger.getLogger(FrmAlumno.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if ("btmAnterior".equals(e.getActionCommand())) {
            try {
                controlerSQL.BotonRetroceder();
                setTablaLibros();
            } catch (SQLException ex) {
                Logger.getLogger(FrmAlumno.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if ("btmConfirmarAlta".equals(e.getActionCommand())) {
                    OdtLibros librosAltas = new OdtLibros();
                    getInfoLibrosAlta(librosAltas);
                    controlerSQL.SQLAltas(librosAltas);
                    controlerSQL.Reconectar();
                    JOptionPane.showMessageDialog(null, "ENTRADA AÑADIDA");
        }
        if ("btmBuscar".equals(e.getActionCommand())) {
            try {
                controlerSQL.Buscar(frm.getTxtCodigo().getText());
                setTablaLibros();
            } catch (SQLException ex) {
                Logger.getLogger(ControladorAlumno.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if ("btmBaja".equals(e.getActionCommand())) {
            try {
                OdtLibros libro = getInfoLibros();
                controlerSQL.SQLBajas(libro);
                controlerSQL.Reconectar();
                setTablaLibros();
                JOptionPane.showMessageDialog(null, "ENTRADA ELIMINADA");
            } catch (SQLException ex) {
                Logger.getLogger(ControladorAlumno.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if ("btmSalir".equals(e.getActionCommand())) {
            System.exit(EXIT_ON_CLOSE);
        }
        if("btmRefrescar".equals(e.getActionCommand())){
            try {
                controlerSQL.Reconectar();
                setTablaLibros();
            } catch (SQLException ex) {
                Logger.getLogger(ControladorAlumno.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
}
