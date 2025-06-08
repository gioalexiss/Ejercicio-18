package com.upiiz.searchAJAX.repositories;

import com.upiiz.searchAJAX.models.BuscarElemento;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BuscarRepository {

    private final JdbcTemplate jdbcTemplate;

    public BuscarRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<BuscarElemento> buscar(String query) {
        System.out.println("Consulta recibida: " + query);

        String sql = "SELECT id, nombre, descripcion FROM entidades WHERE LOWER(nombre) LIKE LOWER(?) LIMIT 10";

        return jdbcTemplate.query(sql, (rs, rowNum) -> {
            BuscarElemento item = new BuscarElemento();
            item.setId(rs.getLong("id"));
            item.setNombre(rs.getString("nombre"));
            item.setDescripcion(rs.getString("descripcion"));
            return item;
        }, "%" + query + "%");
    }

}
