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

    public List<ItemCardapio> getAll() {
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
        try (Connection connection = getConnnection()) {
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
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void add(ItemCardapio itemCardapio) {
        String sql = """
                INSERT INTO item_cardapio(nome, descricao, categoria, preco, preco_promocional)
                VALUES (?, ?, ?, ?, ?)
                """;
        try (Connection connection = getConnnection()) {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.execute();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public int count() {
        String sql = """
                SELECT  COUNT(*)
                  FROM  item_cardapio
                """;
        try (Connection connection = getConnnection()) {
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                return rs.getInt(1);
            }

            return 0;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private static Connection getConnnection() throws SQLException {
        return DriverManager.getConnection("jdbc:mysql://localhost:3306/cardapio", "root",
                "senha123");
    }

}
