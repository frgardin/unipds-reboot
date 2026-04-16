package com.felipegardin.database;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.felipegardin.model.Categoria;
import com.felipegardin.model.ItemCardapio;

public class Database {

    public List<ItemCardapio> getAll() throws SQLException {
        List<ItemCardapio> itemsDoCardapio = new ArrayList<>();
        
        String sql = """
                SELECT  id, 
                        nome, 
                        descricao, 
                        categoria, 
                        preco, 
                        preco_promocional
                  FROM  item_cardapio
                """;

        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/cardapio", "root", "senha123");
        
        PreparedStatement ps = connection.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();

        while (rs.next()) {
            long id = rs.getLong("id");
            String nome = rs.getString("nome");
            String descricao = rs.getString("descricao");
            String categoria = rs.getString("categoria");
            BigDecimal preco = rs.getBigDecimal("preco");
            BigDecimal precoPromocional = rs.getBigDecimal("preco_promocional");
            
            itemsDoCardapio.add(ItemCardapio.builder()
                                    .id(id)
                                    .nome(nome)
                                    .descricao(descricao)
                                    .categoria(Categoria.valueOf(categoria))
                                    .preco(preco)
                                    .precoPromocional(precoPromocional)
                                    .build());           
        }

        return itemsDoCardapio;
    }
    
}
