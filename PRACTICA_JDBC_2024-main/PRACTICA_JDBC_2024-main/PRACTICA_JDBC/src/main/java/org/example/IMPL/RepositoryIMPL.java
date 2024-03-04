package org.example.IMPL;

import org.example.CONEXION.ConexionBD;
import org.example.MODELS.Empresas;
import org.example.MODELS.PRODUCTO;
import org.example.REPOSITORIO.Repository;

import java.sql.*;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;

public class RepositoryIMPL  implements Repository {
    private Connection getConnection() throws SQLException {
        return ConexionBD.getInstance();
}
    private Empresas createEmpresa(ResultSet resultSet) throws
            SQLException {
        Empresas empresas = new Empresas();
        empresas.setId(resultSet.getLong("id"));
        empresas.setNombre(resultSet.getString("nombre"));
        empresas.setDescripcion(resultSet.getString("descripcion"));
        empresas.setEstado(resultSet.getString("estado"));
        return empresas;
    }

    public List<Empresas> list() {
        List<Empresas> empresasList = new ArrayList<>();
        try (Statement statement = getConnection().createStatement();
             ResultSet resultSet = statement.executeQuery("SELECT * from empresas")) {
            while (resultSet.next()) {
                Empresas empresas = createEmpresa(resultSet);
                empresasList.add(empresas);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return empresasList;
    }

    public Empresas byId(Long id) {
        Empresas empresas = null;
        try (PreparedStatement preparedStatement = getConnection()
                .prepareStatement("SELECT * FROM empresas WHERE id =?")) {
            preparedStatement.setLong(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                empresas = createEmpresa(resultSet);
            }
            resultSet.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return empresas;
    }

    @Override
    public void save(Object o) {

    }

    @Override
    public void delete(Long id) {

    }
    }
