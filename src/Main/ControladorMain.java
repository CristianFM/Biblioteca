package Main;

import BaseDeDatos.Alumnos.ControladorAlumno;
import BaseDeDatos.Libros.ControladorLibros;
import BaseDeDatos.Prestamos.ControladorPrestamos;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControladorMain implements ActionListener{
    FrmMain frm;
    
    public ControladorMain(){
        this.frm = new FrmMain(this);
        frm.setVisible(true);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if ("btmAlum".equals(e.getActionCommand())){
            ControladorAlumno ctrAlum = new ControladorAlumno(frm);
        }
        if ("btmLibros".equals(e.getActionCommand())){
            ControladorLibros ctrlibro = new ControladorLibros(frm);
        }
        if ("btmPrestamos".equals(e.getActionCommand())){
            ControladorPrestamos ctrPrestamos = new ControladorPrestamos(frm);
        }
    }
   
}
