package Dao;

import Connection.ConnectionFactory;
import Connection.IConnection;
import Exception.ConnectionException;
import Domain.TipoUsuario;
import Domain.Usuario;
import Exception.PersistenceException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;

public class DAOUsuario {

    public Collection<Usuario> getAll() throws ConnectionException, PersistenceException {
        Collection<Usuario> usuarios = new ArrayList<>();
        IConnection conn = null;
        Statement sta = null;
        ResultSet res = null;

        try {
            conn = ConnectionFactory.getInstance();

            String sql = "SELECT u.*, tu.ID as IdTIPO, tu.TIPO FROM Usuario u INNER JOIN TipoUsuario tu ON u.IdTipoUsuario = tu.Id";

            sta = conn.getConnection().createStatement();
            res = sta.executeQuery(sql);
            while (res.next()) {
                usuarios.add(new Usuario(
                        res.getInt("ID"),
                        res.getString("NOME"),
                        res.getString("CPFCNPJ"),
                        res.getString("EMAIL"),
                        new TipoUsuario(res.getInt("IdTIPO"), res.getString("TIPO"))
                ));
            }
        } catch (Exception ex) {
            throw new PersistenceException("Erro ao consultar Usuários.", ex.getCause());
        } finally {
            try {
                if (res != null && !res.isClosed()) {
                    res.close();
                }
                if (sta != null && !sta.isClosed()) {
                    sta.close();
                }
                if (conn != null && !conn.getConnection().isClosed()) {
                    conn.close();
                }
            } catch (SQLException ex) {
                throw new ConnectionException(ex.getCause());
            }
        }

        return usuarios;
    }

    public boolean novoUsuario(Usuario usuario) throws ConnectionException {

        IConnection conn = null;
        PreparedStatement sta = null;
        ResultSet res = null;

        try {
            conn = ConnectionFactory.getInstance();
            String sql = "INSERT INTO Usuario (IDTIPOUSUARIO, NOME, CPFCNPJ, EMAIL) VALUES (?,?,?,?)";

            if (usuario.getId() != 0) {
                sql = "UPDATE Usuario SET IDTIPOUSUARIO = ?, NOME = ?, CPFCNPJ = ?, EMAIL = ? WHERE ID = ?";
            }

            sta = conn.getConnection().prepareStatement(sql);
            sta.setInt(1, usuario.getTipoUsuario().getId());
            sta.setString(2, usuario.getNome());
            sta.setLong(3, Long.parseLong(usuario.getCpfCnpj()));
            sta.setString(4, usuario.getEmail());

            if (usuario.getId() != 0) {
                sta.setInt(5, usuario.getId());
            }

            sta.executeUpdate();
            
        } catch (SQLException ex) {
            throw new ConnectionException(ex.getCause());
        } finally {
            try {
                if (res != null && !res.isClosed()) {
                    res.close();
                }
                if (sta != null && !sta.isClosed()) {
                    sta.close();
                }
                if (conn != null && !conn.getConnection().isClosed()) {
                    conn.close();
                }
            } catch (SQLException ex) {
                throw new ConnectionException(ex.getCause());
            }
        }
        
        return true;
    }
}
