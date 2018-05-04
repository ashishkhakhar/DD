package com.DimensionData.Servermanagement;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class ServerMapper implements RowMapper<Server> {
    public Server mapRow(ResultSet rs, int rowNum) throws SQLException {
        Server server = new Server();
        server.setId(rs.getString("id"));
        server.setName(rs.getString("name"));
        return server;
    }
}
