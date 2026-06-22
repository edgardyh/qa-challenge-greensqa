package com.greensqa.database;

import java.sql.Connection;
import java.sql.Statement;

public class DatabaseInitializer {

    public static void initialize() {

        String createTableSql = """
                CREATE TABLE IF NOT EXISTS users(
                    id INTEGER PRIMARY KEY AUTOINCREMENT,
                    name TEXT NOT NULL,
                    lastname TEXT,
                    age INTEGER,
                    document TEXT UNIQUE,
                    city TEXT,
                    country TEXT,
                    language TEXT,
                    type TEXT,
                    origen TEXT,
                    destino TEXT
                );
                """;

        String addOrigenSql = "ALTER TABLE users ADD COLUMN origen TEXT;";
        String addDestinoSql = "ALTER TABLE users ADD COLUMN destino TEXT;";

        try (
                Connection conn = DatabaseConnection.getConnection();
                Statement stmt = conn.createStatement()
        ) {

            stmt.execute(createTableSql);

            try {
                stmt.execute(addOrigenSql);
            } catch (Exception e) {
            }

            try {
                stmt.execute(addDestinoSql);
            } catch (Exception e) {
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}