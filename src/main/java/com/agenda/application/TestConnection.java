package com.agenda.application;

import com.agenda.infrastructure.sql.ConnectionManager;

public class TestConnection {
    public static void main(String[] args) {
        try {

            var connection = ConnectionManager.getConnection();

            System.out.println("Connected successfully!");

            connection.close();

        } catch (Exception e) {

            e.printStackTrace();

        }
    }
}
