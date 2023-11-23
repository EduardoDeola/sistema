/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.g12.duque.eduardo.dao;

import br.g12.duque.eduardo.models.Category;
import br.g12.duque.gestor.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;
import java.util.ArrayList;
import br.g12.duque.eduardo.models.repositories.IRepositoryCategory;

/**
 *
 * @author 08057
 */
public class CategoryDao implements IRepositoryCategory{
    
    private Category category;
    
    public CategoryDao(Category cat){
        this.category = cat;
    }
// Annotation ou Decorator que indica:
//Que eu vou sobreescrever um método
    @Override 
    public boolean insert() {
        String sql = "INSERT INTO categories "
                +"(name, description) VALUES "
                +"(?,?)";
        boolean success = false;
        Connection conn = Conexao.getConnection();
        try{
            PreparedStatement pst = 
            conn.prepareStatement(sql);
            pst.setString(1,category.getName());
            pst.setString(2,category.getDescription());
            pst.executeUpdate();
            success = true;
        
        }catch(SQLException ex) {
            System.out.println("Erro"+ex.getMessage());
            success = false;
    }
        return success;
    }

    @Override
    public boolean update() {
       // 1. Definir o comando sql que sera executado
       String sql = "UPDATE categories SET "
               +"SET name = ?, description = ? "
               + "WHERE id = ?";
       // 2. Definit uma variavel que dirá se a operação foi bem sucedida
       boolean success = false;
       // 3. Conectar a aplicação no banco de dados
       Connection conn = Conexao.getConnection();
       // 4. Fazer o tratamento de possiveis erros da aplicação
       try{
           PreparedStatement pst = conn.prepareStatement(sql);
           pst.setString(1, category.getName());
           pst.setString(2, category.getDescription());
           pst.setInt(3, category.getId());
           pst.executeUpdate();
           success = true;
       }catch(SQLException ex) {
           System.out.println("Erro na operação: "+ ex.getMessage());
           success = false;
        }
       // 5. Aviso o aplcativo se deu certo ou errado
       return success;
    }

    @Override
    public boolean delete() {
       // 1. Definir o comando sql que será executado
       String sql = "DELETE FROM categories WHERE id = ?";
       //2. Definir uma variavel que dirá se a operação foi bem sucedida
       boolean success = false;
       //3. Conectar a aplicação com o BD.
       Connection conn = Conexao.getConnection();
       //4. Tratamento de possíveis erros
       try{
       PreparedStatement pst = conn.prepareStatement(sql);
       pst.setInt(1,category.getId());
       pst.executeUpdate();
       success = true;
       }catch(SQLException ex) {
           System.out.println("Erro ao excluir o registro. "
           +"/nMensagem do servidor: "+ ex.getMessage());
           success = false;
       }
        // 5. Avisar o aplicativo se deu certo ou errado
        return success;
    }

 
  
    
    
    @Override
    public Category findById() {
       String sql = "SELECT name, description FROM categories"
               +"WHERE id = "+ category.getId();
       
       Category category = null;
       
       Connection conn = Conexao.getConnection();
       try{
           Statement stm = conn.createStatement();
           ResultSet rs = stm.executeQuery(sql);
           rs.next(); // Mover o cursor para o primeiro resultado encontrado
           
           if(rs.getRow() > 0) {
               category = new Category(
               rs.getInt("id"),
               rs.getString("name"),
               rs.getString("description")
               );
           }else{
               System.out.println("Categoria não encontrada");
               return null;
           }
       }catch(SQLException ex) {
           System.out.println("Erro ao executar a consluta: "+ ex.getMessage());
           return null;
           
       }
       
    
    return category;
}

    @Override
    public ArrayList findAll() {
           //1. Criar uma lista que armazenará todas as categorias
        ArrayList<Category> list = new ArrayList<Category>();
        //2. Definir uma variavel que dira se a operação foi bem sucedida
        boolean success = false;
        //3. Definir qual o comando sql será executado.
        String sql = "SELECT id, name, description FROM categories";
        //4. Estabelecer conexão com o banco de dados.
        Connection conn = Conexao.getConnection();
        
        //5. Tratar os possiveis erros ou exceções que podem ocorrer 
        try{
            // 6. Enviar a query para o banco
            Statement stm = conn.createStatement();
            //7. O banco retorna o resultado da consulta
            ResultSet rs = stm.executeQuery(sql);
            //8. Salvar resultado da query dentro da lista
            while(rs.next()) {
                list.add(new Category(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("description")));
            }
        }catch(SQLException ex) {
            System.out.println("Erro: "+ ex.getMessage());
        }
        return list; 
    }
    
}
