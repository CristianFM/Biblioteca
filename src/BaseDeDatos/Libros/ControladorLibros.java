package BaseDeDatos.Libros;

import Main.FrmMain;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import javax.swing.JOptionPane;


public class ControladorLibros implements ActionListener{
    NegocioSQLLibros controlerSQL;
    OdtLibros odtLibros;
    DialogLibros dialogo;
    FrmMain frmMain;
    public ControladorLibros(FrmMain frmMain){
        try {
            this.frmMain = frmMain;
            controlerSQL = new NegocioSQLLibros();
            this.dialogo = new DialogLibros(frmMain, true, this);    
            controlerSQL.ConectarBase();
            dialogo.setVisible(true);
            setTablaLibros();
        } catch (SQLException ex) {
            
        }
    }
    public void getInfoLibrosAlta(OdtLibros libroAltas){
        libroAltas.setTitulo(dialogo.getTxtTituloAlta().getText());
        libroAltas.setAsignatura(dialogo.getTxtAsignaturaAlta().getText());
        libroAltas.setEditorial(dialogo.getTxtEditorialAlta().getText());
        libroAltas.setEstado(dialogo.getTxtEstadoAlta().getText());
    }
    public OdtLibros getInfoLibros() throws SQLException{
        return controlerSQL.getOdtLibros();
    }
    public void setTablaLibros() throws SQLException{
        odtLibros = getInfoLibros();   
        dialogo.getTxtCodigo().setText(odtLibros.getCodigo());
        dialogo.getTxtTitulo().setText(odtLibros.getTitulo());
        dialogo.getTxtAutor().setText(odtLibros.getAutor());
        dialogo.getTxtEditorial().setText(odtLibros.getEditorial());
        dialogo.getTxtAsignatura().setText(odtLibros.getAsignatura());
        dialogo.getTxtEstado().setText(odtLibros.getEstado());
        
    }
    @Override
    public void actionPerformed(ActionEvent e) {
       if ("btmSiguiente".equals(e.getActionCommand())) {
            try {
                controlerSQL.BotonAvanzar();
                setTablaLibros();
            } catch (SQLException ex) {
            }
        }
        if ("btmAnterior".equals(e.getActionCommand())) {
            try {
                controlerSQL.BotonRetroceder();
                setTablaLibros();
            } catch (SQLException ex) {
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
                controlerSQL.Buscar(dialogo.getTxtCodigo().getText());
                setTablaLibros();
            } catch (SQLException ex) {
            }
        }
        if ("btmEliminar".equals(e.getActionCommand())) {
            try {
                OdtLibros libro = getInfoLibros();
                controlerSQL.SQLBajas(libro);
                JOptionPane.showMessageDialog(null, "ENTRADA ELIMINADA");
                controlerSQL.Reconectar();
                setTablaLibros();
            } catch (SQLException ex) {
            }
        }
        if ("btmSalir".equals(e.getActionCommand())) {
            dialogo.dispose();
        }
        if("btmRefrescar".equals(e.getActionCommand())){
            try {
                controlerSQL.Reconectar();
                setTablaLibros();
            } catch (SQLException ex) {
            }
        }
    }
    
}

