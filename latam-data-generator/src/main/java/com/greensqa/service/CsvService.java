package com.greensqa.service;

import com.greensqa.database.DatabaseConnection;
import com.opencsv.CSVWriter;

import java.io.FileWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class CsvService {

    public void exportToCsv(){

        try(
                Connection connection =
                        DatabaseConnection.getConnection();

                Statement statement =
                        connection.createStatement();

                ResultSet rs =
                        statement.executeQuery(
                                "SELECT * FROM users");

                CSVWriter writer =
                        new CSVWriter(
                                new FileWriter(
                                        "users.csv"))
        ){

            writer.writeNext(
                    new String[]{
                            "name",
                            "lastname",
                            "age",
                            "document",
                            "city",
                            "country",
                            "language",
                            "type",
                            "origen",
                            "destino"
                    }
            );

            while(rs.next()){

                writer.writeNext(
                        new String[]{
                                rs.getString("name"),
                                rs.getString("lastname"),
                                String.valueOf(
                                        rs.getInt("age")),
                                rs.getString("document"),
                                rs.getString("city"),
                                rs.getString("country"),
                                rs.getString("language"),
                                rs.getString("type"),
                                rs.getString("origen"),
                                rs.getString("destino")
                        }
                );
            }

        }catch(Exception e){

            e.printStackTrace();
        }
    }
}