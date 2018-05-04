package com.DimensionData.Servermanagement;

import java.sql.SQLException;
import java.util.List;
import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;


public class ServerJDBCTemplate implements ServerDAO {
    private DataSource dataSource;
    private JdbcTemplate jdbcTemplateObject;

    public void setDataSource(DataSource dataSource) {
        try {
            this.dataSource = dataSource;
            this.jdbcTemplateObject = new JdbcTemplate(dataSource);
        } catch (Exception e) {
            System.out.println("DB connection issue:");
        }
    }

    public void insert(Server server) {
        try {
            String SQL = "INSERT INTO servers.server (id ,name) VALUES (?, ?)";
            jdbcTemplateObject.update(SQL, server.getId(), server.getName());
            //System.out.println("Created Record Name = " + server.getName() + " ID = " + server.getId());
        } catch (Exception e) {
            //e.printStackTrace();
            System.out.println("DB issue:");
        }
        return;
    }

    public List<Server> listall() {
        try {
            String SQL = "select * from servers.server";
            List<Server> servers = jdbcTemplateObject.query(SQL, new ServerMapper());
            return servers;
        } catch (Exception e) {
            //e.printStackTrace();
            System.out.println("DB connection issue:");
            return null;
        }
    }

    public void delete(Server server) {
        try {
            String SQL = "delete from servers.server where id = ?";
            jdbcTemplateObject.update(SQL, server.getId());
            //System.out.println("Deleted Record with ID = " + server.getId());
        } catch (Exception e) {
            //e.printStackTrace();
            System.out.println("DB issue:");
        }
        return;
    }

    public void update(Server server) {
        try {
            String SQL = "UPDATE servers.server set name = ? where id = ?";
            jdbcTemplateObject.update(SQL, server.name, server.id);
            //System.out.println("Updated Record with ID = " + server.getId());
        } catch (Exception e) {
            //e.printStackTrace();
            System.out.println("DB issue:");
        }
        return;
    }

    public Long count() {
        try {
            String SQL = "select count(*) from servers.server";
            Long rowcount = jdbcTemplateObject.queryForLong(SQL);
            //System.out.println("Total Count = " + rowcount);
            return rowcount;
        } catch (Exception e) {
            //e.printStackTrace();
            System.out.println("DB connection issue:");
            return 0L;
        }
    }

    @Override
    public Server findbyId(String id) {

        Server server = new Server();
        server = null;
        try {
            String SQL = "SELECT * FROM servers.server  where id = " + "'" + id +"'";
            List<Server> servers = jdbcTemplateObject.query(SQL, new ServerMapper());
            if (servers.size() == 1) {
                server = servers.get(0);
            }
        } catch (Exception e) {
            //e.printStackTrace();
            System.out.println("DB connection issue:");
        }
        return server;
    }

    public void deleteall() {
        try {
            String SQL = "delete from servers.server";
            jdbcTemplateObject.update(SQL);
        } catch (Exception e) {
            //e.printStackTrace();
            System.out.println("DB connection issue:");
        }
        return;
    }
}

