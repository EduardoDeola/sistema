/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.g12.duque.eduardo.tests;

import br.g12.duque.eduardo.dao.CategoryDao;
import br.g12.duque.eduardo.models.Category;
import javax.swing.JOptionPane;

/**
 *
 * @author 08057
 */
public class InsertCategoryUseCase {
    public static void main(String[] args) {
        Category cat = new Category(); 
        String name = JOptionPane.showInputDialog("Nome:");
        String description = JOptionPane.showInputDialog("Descrição:");
        cat.setName(name);
        cat.setDescription(description);
        
        CategoryDao cd = new CategoryDao(cat);
        boolean success = cd.insert();
        
        if(success) {
            JOptionPane.showMessageDialog(null, "Sucesso");
        } else {
            JOptionPane.showConfirmDialog(null, "ERRO!");
        }
        
    }
    
}
