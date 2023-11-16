/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package br.g12.duque.gestor;

/**
 *
 * @author 08057
 */
public interface InterBanco {
    public boolean insert(); // Métodos abstratos // Clean code
    public boolean update();
    public boolean delete();
    public boolean findAll();
    public boolean findById(int id); //Parametros ==> variaveis locais 
}
