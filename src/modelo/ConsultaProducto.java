package modelo;

//llamadas pal codigo SQL de la Database en XAAMP myphp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ConsultaProducto extends Conexion {

    public boolean registrar(Producto p) {
        PreparedStatement ps = null;
        Connection con = getConexion();
        String sql = "insert into celular (modelo, marca, detalles, precio) values (?,?,?,?)";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, p.getModelo());
            ps.setString(2, p.getMarca());
            ps.setString(3, p.getDetalles());
            ps.setInt(4, p.getPrecio());
            ps.execute();
            return true;
        } catch (SQLException e) {
            System.err.println(e);
            return false;
        }
    }// enddddddd regitryyy

    public boolean modificar(Producto p) {
        PreparedStatement ps = null;
        Connection con = getConexion();
        String sql = "update  celular set modelo=?, marca=?, detalles=?, precio=? where id=?";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, p.getModelo());
            ps.setString(2, p.getMarca());
            ps.setString(3, p.getDetalles());
            ps.setInt(4, p.getPrecio());
            ps.setInt(5, p.getId());
            ps.execute();
            return true;
        } catch (SQLException e) {
            System.err.println(e);
            return false;
        }
    } // end modify

    public boolean eliminar(Producto p) {
        PreparedStatement ps = null;
        Connection con = getConexion();
        String sql = "delete from celular where id=?";
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, p.getId());
            ps.execute();
            return true;
        } catch (SQLException e) {
            System.err.println(e);
            return false;
        }
    }

    public boolean buscar(Producto p) {
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = getConexion();
        String sql = "select * from celular where id=?";
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, p.getId());
            rs = ps.executeQuery();
            if (rs.next()) {
                p.setId(Integer.parseInt(rs.getString("id")));
                p.setModelo(rs.getString("modelo"));
                p.setMarca(rs.getString("marca"));
                p.setDetalles(rs.getString("detalles"));
                p.setPrecio(Integer.parseInt(rs.getString("precio")));
                return true;
            }
            return false;

        } catch (SQLException e) {
            System.err.println(e);
            return false;
        }
    }

}
