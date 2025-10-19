package com.sise.TiendaTecnologica.dao;

import com.sise.TiendaTecnologica.config.DatabaseAccess;
import com.sise.TiendaTecnologica.model.Producto;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class ProductoDao {
    
    public void insertarProducto(Producto producto) throws Exception {
        Connection cn = null;
        try {
            cn = DatabaseAccess.getConnection();
            cn.setAutoCommit(false);
            
            String sql = "INSERT INTO productos (codigo, descripcion, marca, precio, stock) VALUES (?, ?, ?, ?, ?)";
            
            PreparedStatement pstm = cn.prepareStatement(sql);
            pstm.setString(1, producto.getCodigo());
            pstm.setString(2, producto.getDescripcion());
            pstm.setString(3, producto.getMarca());
            pstm.setFloat(4, producto.getPrecio());
            pstm.setInt(5, producto.getStock());
            
            pstm.executeUpdate();
            cn.commit();
            
            pstm.close();
            
        } catch(Exception e) {
            System.out.println(e);
            throw new Exception(e.toString());
        } finally {
            try {
                if(cn != null ){
                    cn.close();
                }
            } catch (Exception e) {
                System.out.println(e);
                throw new Exception(e.toString());
            }  
        }
    }
}