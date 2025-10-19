package com.sise.TiendaTecnologica.dao;

import com.sise.TiendaTecnologica.config.DatabaseAccess;
import com.sise.TiendaTecnologica.model.Cliente;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ClienteDAO {

    public boolean registrarCliente(Cliente c) {
        String sql = "INSERT INTO clientes(tipo_documento_identidad, numero_documento_indentidad, nombres, apellido_paterno, apellido_materno, correo, telefono) VALUES (?, ?, ?, ?, ?, ?, ?)";

        try (Connection cn = DatabaseAccess.getConnection();
             PreparedStatement ps = cn.prepareStatement(sql)) {

            ps.setString(1, c.getTipoDocumento());
            ps.setString(2, c.getNroDocumento());
            ps.setString(3, c.getNombres());
            ps.setString(4, c.getApellidoPaterno());
            ps.setString(5, c.getApellidoMaterno());
            ps.setString(6, c.getCorreo());
            ps.setString(7, c.getTelefono());

            int filas = ps.executeUpdate();
            return filas > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}

