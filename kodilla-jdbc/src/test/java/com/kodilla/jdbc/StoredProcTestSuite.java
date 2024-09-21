package com.kodilla.jdbc;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class StoredProcTestSuite {
    @Test
    public void testUpdateVipLevels() throws SQLException {
        // Given
        DbManager dbManager = DbManager.getInstance();
        String sqlUpdate = "UPDATE READERS SET VIP_LEVEL='Not set'"; // Użyj pojedynczych cudzysłowów
        Statement statement = dbManager.getConnection().createStatement();
        statement.executeUpdate(sqlUpdate);
        String sqlCheckTable = "SELECT COUNT(*) AS HOW_MANY FROM READERS WHERE VIP_LEVEL='Not set'"; // Użyj pojedynczych cudzysłowów

        // When
        Statement statement2 = dbManager.getConnection().createStatement();
        String sqlProcedureCall = "CALL UpdateVipLevels()";
        statement2.execute(sqlProcedureCall);
        ResultSet rs = statement.executeQuery(sqlCheckTable);

        // Then
        int howMany = -1;
        if (rs.next()) {
            howMany = rs.getInt("HOW_MANY");
        }
        assertEquals(0, howMany);
        rs.close();
        statement.close();
        statement2.close();
    }

    @Test
    public void testUpdateBestsellers() throws SQLException {
        // Given
        DbManager dbManager = DbManager.getInstance();
        String sqlUpdate = "UPDATE BOOKS SET BESTSELLER='No'";
        Statement statement = dbManager.getConnection().createStatement();
        statement.executeUpdate(sqlUpdate);

        String sqlCheckBefore = "SELECT COUNT(*) AS HOW_MANY FROM BOOKS WHERE BESTSELLER='No'";
        ResultSet rsBefore = statement.executeQuery(sqlCheckBefore);
        int howManyBefore = 0;
        if (rsBefore.next()) {
            howManyBefore = rsBefore.getInt("HOW_MANY");
        }

        // When
        String sqlProcedureCall = "CALL UpdateBestsellers()";
        statement.execute(sqlProcedureCall);

        // Then
        String sqlCheckAfter = "SELECT COUNT(*) AS HOW_MANY FROM BOOKS WHERE BESTSELLER='Yes'";
        ResultSet rsAfter = statement.executeQuery(sqlCheckAfter);
        int howManyAfter = 0;
        if (rsAfter.next()) {
            howManyAfter = rsAfter.getInt("HOW_MANY");
        }

        assertEquals(howManyBefore, 0);
        assertTrue(howManyAfter > 0);

        // Cleanup
        rsBefore.close();
        rsAfter.close();
        statement.close();
    }
}

