package Dao;

import Connection.ConnectionFactory;
import Connection.IConnection;
import Domain.Bem;
import Domain.CategoriaBem;
import Exception.ConnectionException;
import Exception.PersistenceException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;

public class DAOBem implements IDAOBem {

    @Override
    public Collection<Bem> getAll() throws ConnectionException, PersistenceException {
        Collection<Bem> bens = new ArrayList<>();
        IConnection conn = null;
        Statement sta = null;
        ResultSet res = null;

        try {
            conn = ConnectionFactory.getInstance();

            String sql = "SELECT b.*, cb.ID as IdCategoria, cb.CATEGORIA FROM Bem b INNER JOIN CategoriaBem cb ON b.IdCategoriaBem = cb.Id";

            sta = conn.getConnection().createStatement();
            res = sta.executeQuery(sql);
            while (res.next()) {
                bens.add(new Bem(
                        res.getInt("ID"),
                        res.getString("DESCRICAO"),
                        res.getString("DESCRICAOCOMPLETA"),
                        new CategoriaBem(res.getInt("IdCategoria"), res.getString("CATEGORIA"))
                ));
            }
        } catch (ConnectionException | SQLException ex) {
            throw new PersistenceException("Erro ao consultar Bens.", ex.getCause());
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

        return bens;
    }

    @Override
    public boolean insert(Bem bem) throws ConnectionException {
        IConnection conn = null;
        PreparedStatement sta = null;
        ResultSet res = null;

        try {
            conn = ConnectionFactory.getInstance();
            String sql = "INSERT INTO Bem (IDCATEGORIABEM, DESCRICAO, DESCRICAOCOMPLETA) VALUES (?,?,?)";

            if (bem.getId() != 0) {
                sql = "UPDATE Bem SET IDCATEGORIABEM = ?, DESCRICAO = ?, DESCRICAOCOMPLETA = ? WHERE ID = ?";
            }

            sta = conn.getConnection().prepareStatement(sql);
            sta.setInt(1, bem.getCategoriaBem().getId());
            sta.setString(2, bem.getDescricao());
            sta.setString(3, bem.getDescricaocompleta());

            if (bem.getId() != 0) {
                sta.setInt(4, bem.getId());
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

    @Override
    public Collection<Bem> getAllFree() throws PersistenceException, ConnectionException {
        Collection<Bem> bens = new ArrayList<>();
        IConnection conn = null;
        Statement sta = null;
        ResultSet res = null;

        try {
            conn = ConnectionFactory.getInstance();

            String sql = "select b.ID as IdBem, b.IDCATEGORIABEM, b.DESCRICAO, b.DESCRICAOCOMPLETA, cb.CATEGORIA from bem b\n"
                    + "INNER JOIN CategoriaBem cb ON b.IdCategoriaBem = cb.Id\n"
                    + "where b.ID NOT IN (select idbem from lote)";

            sta = conn.getConnection().createStatement();
            res = sta.executeQuery(sql);
            while (res.next()) {
                bens.add(new Bem(
                        res.getInt("IdBem"),
                        res.getString("DESCRICAO"),
                        res.getString("DESCRICAOCOMPLETA"),
                        new CategoriaBem(res.getInt("IDCATEGORIABEM"), res.getString("CATEGORIA"))
                ));
            }
        } catch (ConnectionException | SQLException ex) {
            throw new PersistenceException("Erro ao consultar Bens.", ex.getCause());
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

        return bens;
    }
}
