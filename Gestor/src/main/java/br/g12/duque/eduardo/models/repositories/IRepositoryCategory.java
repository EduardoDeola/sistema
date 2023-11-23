/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package br.g12.duque.eduardo.models.repositories;

import br.g12.duque.eduardo.models.Category;
import java.util.ArrayList;

/**
 *
 * @author 08057
 */
public interface IRepositoryCategory {
    public boolean insert(); // Métodos abstratos // Clean code
    public boolean update();
    public boolean delete();
    public ArrayList findAll();
    public Category findById(); //Parametros ==> variaveis locais 
}
