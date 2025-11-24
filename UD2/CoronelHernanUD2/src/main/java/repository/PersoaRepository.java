package repository;

import dbconnector.DBConnector;
import entidades.Proxecto;
import entidades.ProxectoConEmails;
import entidades.TotalOrzamento;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PersoaRepository {
    public static List<ProxectoConEmails> listaProxectosPorDenominacion() {
        List<ProxectoConEmails> proxectoList = new ArrayList<>();
        String sqlProx = "SELECT p.* FROM proxectos p ORDER BY denominacion;";
        String sqlPers = "SELECT pe.email FROM persoas_empregadas " +
                "pe JOIN persoas_proxectos pp ON pp.id_persoa = " +
                "pe.id_persoa AND pp.id_proxecto = ?";
        try (Connection connection = DBConnector.connect()) {
            PreparedStatement statement = connection.prepareStatement(sqlProx);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                PreparedStatement persoaStatement = connection.prepareStatement(sqlPers);
                persoaStatement.setInt(1, rs.getInt("id_proxecto"));
                ResultSet persoaRs = persoaStatement.executeQuery();
                List<String> emails = new ArrayList<>();
                while (persoaRs.next()) {
                    emails.add(persoaRs.getString("email"));
                }
                proxectoList.add(new ProxectoConEmails(
                        new Proxecto(
                                rs.getInt("id_proxecto"),
                                rs.getString("denominacion"),
                                rs.getInt("nivel_minimo"),
                                (Proxecto.Estado) rs.getString("estado"),
                                rs.getDouble("orzamento")
                        ),
                        emails
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return proxectoList;
    }

    public static TotalOrzamento sumaOrzamentoProxectoEstado(String estado) {
        String sql = "SELECT estado, COUNT(*) as total_proxectos," +
                " SUM(orzamento) total_orzamento FROM proxectos WHERE estado = '?'";
        try (Connection connection = DBConnector.connect()) {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, estado);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                return new TotalOrzamento(
                        rs.getString("estado"),
                        rs.getInt("total_proxectos"),
                        rs.getDouble("total_orzamento")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static boolean novoProxectoAsignacion(String denominacion, int nivelMinimo, double orzamento, int cantidadAsignados) {
        String sql = "INSERT INTO proxectos (denominacion, nivel_minimo, estado, orzamento) " +
                "VALUES ('?',?,'?',?)";
        Connection connection = null;
        try {
            connection = DBConnector.connect();
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, denominacion);
            statement.setInt(2, nivelMinimo);
            statement.setString(3, "creado");
            statement.setDouble(4, orzamento);

            connection.setAutoCommit(false);

            int result = statement.executeUpdate();
            ResultSet proxecto = statement.getGeneratedKeys();
            if (!proxecto.next() || result != 1) {
                throw new SQLException();
            }

            sql = "SELECT id_persoa FROM persoas_empregadas WHERE nivel >= ?  TAKE ?";
            statement = connection.prepareStatement(sql);

            statement.setInt(1, nivelMinimo);
            statement.setInt(2, cantidadAsignados);

            ResultSet rs = statement.executeQuery();
            sql = "INSERT INTO persoas_proxectos (id_persoa, id_proxecto) VALUES (?, ?)";
            statement = connection.prepareStatement(sql);
            while (rs.next()) {
                statement.setInt(1, rs.getInt("id_persoa"));
                statement.setInt(2, proxecto.getInt("id_proxecto"));
                result = statement.executeUpdate();
                if (result != 1) {
                    throw new SQLException();
                }
            }
            connection.commit();
            return true;
        } catch (SQLException e) {
            if (connection != null)
                try {
                    connection.rollback();

                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            e.printStackTrace();
            return false;
        }
    }
}
