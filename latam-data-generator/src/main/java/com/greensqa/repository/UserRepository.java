package com.greensqa.repository;

import com.greensqa.database.DatabaseConnection;
import com.greensqa.model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserRepository
        implements IUserRepository {

    private static final String INSERT_USER = """
        INSERT INTO users(
            name, lastname, age, document,
            city, country, language, type,
            origen, destino)
        VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?)
        """;

    public void save(User user) {
        try(
                Connection connection = DatabaseConnection.getConnection();
                PreparedStatement statement = connection.prepareStatement(INSERT_USER)
        ) {
            statement.setString(1, user.getName());
            statement.setString(2, user.getLastName());
            statement.setInt(3, user.getAge());
            statement.setString(4, user.getDocument());
            statement.setString(5, user.getCity());
            statement.setString(6, user.getCountry());
            statement.setString(7, user.getLanguage());
            statement.setString(8, user.getUserType());
            statement.setString(9, user.getOrigen());
            statement.setString(10, user.getDestino());

            statement.executeUpdate();
        } catch(SQLException e) {
            e.printStackTrace();
        }
    }

    public int countUsers(){

        try(
                Connection connection =
                        DatabaseConnection.getConnection();

                PreparedStatement statement =
                        connection.prepareStatement(
                                "SELECT COUNT(*) FROM users");

                ResultSet resultSet =
                        statement.executeQuery()
        ){

            return resultSet.getInt(1);

        }catch(Exception e){

            return 0;
        }
    }

    public void deleteAll(){

        try(
                Connection connection =
                        DatabaseConnection.getConnection();

                PreparedStatement statement =
                        connection.prepareStatement(
                                "DELETE FROM users")
        ){

            statement.executeUpdate();

        }catch(Exception e){

            e.printStackTrace();
        }
    }
}