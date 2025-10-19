package com.sise.TiendaTecnologica.dao;

import com.sise.TiendaTecnologica.config.DatabaseAccess;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.security.MessageDigest;

public class UsuarioDAO {
    
    // Método para validar login
    public boolean validarUsuario(String nombreUsuario, String claveIngresada) {
        boolean valido = false;
        String sql = "SELECT clave FROM dbo.usuarios WHERE nombre_usuario = ?";
        
        try (Connection cn = DatabaseAccess.getConnection();
             PreparedStatement ps = cn.prepareStatement(sql)) {
            
            ps.setString(1, nombreUsuario);
            ResultSet rs = ps.executeQuery();
            
            if (rs.next()) {
                String claveEnBD = rs.getString("clave");
                String claveEncriptada = encriptarClave(claveIngresada);
                
                if (claveEnBD.equals(claveEncriptada)) {
                    valido = true;
                }
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return valido;
    }

    // Encriptar clave con SHA-256
    private String encriptarClave(String clave) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] hash = md.digest(clave.getBytes("UTF-8"));
            StringBuilder sb = new StringBuilder();
            for (byte b : hash) {
                sb.append(String.format("%02x", b));
            }
            return sb.toString();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
