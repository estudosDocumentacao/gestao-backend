package com.gourmet.gestao;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.TestPropertySource;

import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
@TestPropertySource(locations = "classpath:application-conection.properties") // Caminho da configuração
public class DatabaseConnectionTest {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Test
    public void testDatabaseConnection() {
        try {
            // Execute uma consulta simples para verificar a conexão
            jdbcTemplate.queryForObject("SELECT 1", Integer.class);
            assertTrue(true); // A conexão foi bem-sucedida
        } catch (Exception e) {
            assertTrue(false); // A conexão falhou
        }
    }
}
