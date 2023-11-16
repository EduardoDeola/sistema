/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.g12.duque.gestor;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author 08057
 */
public class Conexao {

    public static final String USERNAME = "root"; //Constante
    public static final String PASSWORD = "usbw"; //Constante
    public static final String DBNAME = "sistema"; //Constante
    public static final String SERVER = "jdbc:mysql://localhost:3306"; //Constante

    //Método que realiza a conexão com o banco de dados
    public static Connection getConnection() {
        Connection conn = null;
        String message = "";
        //Tratamento de exceções em java
        try {
            conn = DriverManager.getConnection(SERVER + "/" + DBNAME, USERNAME, PASSWORD);
            message = "DEU CERTO UHULLL!";

        } catch (SQLException ex) {
            message = "A CULPA E DO ESTAGIARIO!";
            System.out.println(message);
            
        }

        System.out.println(message);

        return conn;
    }

}
