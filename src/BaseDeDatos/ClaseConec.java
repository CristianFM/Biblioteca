package BaseDeDatos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

public class ClaseConec {

    private Connection conn;
    private ResultSet resulSet;

    public ClaseConec() {
       
    }

    public void abrirConeccion() throws SQLException {
        String sUrl = "jdbc:mysql://localhost:3306/bibliioteca";
        conn = DriverManager.getConnection(sUrl, "root", "");
        JOptionPane.showMessageDialog(null, "Has sido conectado, bienvenido.");
    }
    public void reconectar() throws SQLException{
        String sUrl = "jdbc:mysql://localhost:3306/bibliioteca";
        conn = DriverManager.getConnection(sUrl, "root", "");
        JOptionPane.showMessageDialog(null, "Has sido reconectado.");
    }
    public ResultSet ejecutarTabla(String sql) throws SQLException {
        Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
        System.out.println(sql);
        resulSet = stmt.executeQuery(sql);
        actualizar();
        return resulSet;
    }

    public void realizarUpdateInsertDelete(String sql) throws SQLException {
        Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
        stmt.executeUpdate(sql);
    }

    public void actualizar() throws SQLException {
        resulSet.next();
    }

    public void realizarConsulta(String sql) throws SQLException {
        Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
        resulSet = stmt.executeQuery(sql);
        resulSet.next();
    }

    public ResultSet getResulSet(){
        return resulSet;
    }

    public void tablaSiguiente() throws SQLException {
        resulSet.next();
    }

    public void tablaAnterior() throws SQLException {
        resulSet.previous();
    }

    public boolean isTablaFinal() throws SQLException {
        return resulSet.isLast();
    }

    public void tablaFinal() throws SQLException {
        resulSet.last();
    }

    public boolean isTablaInicio() throws SQLException {
        return resulSet.isFirst();
    }

    public void tablaInicio() throws SQLException {
        resulSet.first();
    }       
}
