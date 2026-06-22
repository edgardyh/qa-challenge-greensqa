/*
 * Copyright 2024 Oracle and/or its affiliates
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

import java.sql.Connection;
import java.sql.Driver;
import java.util.Properties;

/**
 * SQLite JDBC Connector<br>
 * This is generated code. The {@link JdbcConnector#connect()} method is implemented to connect to the
 * SQLite Database using the appropriate JDBC Driver.
 *
 * <p><u>DRIVER LIBRARIES</u></p>
 * To run this class you will need to integrate the SQLite JDBC Driver libraries in your project<br>
 * e.g. by using Maven Project Object Model (POM) <a href="https://repo1.maven.org/maven2/org/xerial/sqlite-jdbc/3.47.1.0/sqlite-jdbc-3.47.1.0.pom">sqlite-jdbc-3.47.1.0.pom</a><br>
 *
 * <p><u>JDBC URL</u></p>
 * The connection is using a JDBC URL of type "Custom"<br>
 * URL pattern: "jdbc:&lt;VENDOR&gt;://&lt;HOST&gt;:&lt;PORT&gt;/&lt;DATABASE&gt;"<br>
 */
public class JdbcConnector {

    /**
     * Creates a jdbc connection to the SQLITE database
     *
     * @return a new {@link Connection}
     * @throws Exception if something goes wrong
     */
    public Connection connect() throws Exception {
        Properties properties = new Properties();

        String jdbcUrl = "jdbc:sqlite:sqlite.db";

        Class<? extends Driver> driverClass = org.sqlite.JDBC.class;
        Driver driver = driverClass.getConstructor().newInstance();

        return driver.connect(jdbcUrl, properties);
    }

    public static void main(String[] args) {

        JdbcConnector connector = new JdbcConnector();
        try (Connection connection = connector.connect()) {
            connection.isValid(10);
            System.out.println("INFO: Successfully connected and validated");

        } catch (Exception e) {
            System.out.println("ERROR: Failed to connect. Cause:  " + e.getMessage());
        }
    }

}