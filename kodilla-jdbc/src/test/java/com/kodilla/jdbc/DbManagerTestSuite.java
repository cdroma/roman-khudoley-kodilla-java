package com.kodilla.jdbc;

import org.junit.jupiter.api.Test;

import java.sql.*;

import static org.junit.jupiter.api.Assertions.*;

class DbManagerTestSuite {

    @Test
    void testConnect() throws SQLException {
        //Given
        //When
        DbManager dbManager = DbManager.getInstance();
        //Then
        assertNotNull(dbManager.getConnection());
    }

    @Test
    void testSelectUsers() throws SQLException {
        //Given
        DbManager dbManager = DbManager.getInstance();

        //When
        String sqlQuery = "SELECT * FROM USERS";
        Statement statement = dbManager.getConnection().createStatement();
        ResultSet rs = statement.executeQuery(sqlQuery);

        //Then
        int counter = 0;
        while (rs.next()) {
            System.out.println(rs.getInt("ID") + ", " +
                    rs.getString("FIRSTNAME") + ", " +
                    rs.getString("LASTNAME"));
            counter++;
        }
        rs.close();
        statement.close();
        assertEquals(5, counter);
    }


    @Test
    void testSelectUsersAndTasks() throws SQLException {
        //Given
        DbManager dbManager = DbManager.getInstance();

        //When
        String sqlQuery = """ 
        SELECT U.FIRSTNAME, U.LASTNAME, I.SUMMARY
        FROM USERS U
        JOIN ISSUES I ON U.ID = I.USER_ID_ASSIGNEDTO 
        """;

        Statement statement = dbManager.getConnection().createStatement();
        ResultSet rs = statement.executeQuery(sqlQuery);

        //Then
        int counter = 0;
        while (rs.next()) {
            System.out.println(rs.getString("FIRSTNAME") + ", " +
                    rs.getString("LASTNAME") + ", " +
                    rs.getString("SUMMARY"));
            counter++;
        }
        rs.close();
        statement.close();
        assertEquals(25, counter);
    }

    @Test
    void testSelectUsersAndPosts() throws SQLException {
        //Given
        DbManager dbManager = DbManager.getInstance();

        //When
        String sqlQuery = """
                SELECT U.FIRSTNAME, U.LASTNAME, COUNT(P.ID) AS POSTS_COUNT
                FROM USERS U
                JOIN POSTS P ON U.ID = P.USER_ID
                GROUP BY U.ID
                HAVING COUNT(P.ID) >= 2
                """;

        Statement statement = dbManager.getConnection().createStatement();
        ResultSet rs1 = statement.executeQuery(sqlQuery);

        //Then
        int counter = 0;
        while (rs1.next()) {
            System.out.println(rs1.getString("FIRSTNAME") + " " +
                    rs1.getString("LASTNAME") + " - Liczba postów: " +
                    rs1.getInt("POSTS_COUNT"));
            counter++;
        }
        rs1.close();
        statement.close();

        int expectedNumberOfUsers = 5;
        assertEquals(expectedNumberOfUsers, counter);
    }
}
