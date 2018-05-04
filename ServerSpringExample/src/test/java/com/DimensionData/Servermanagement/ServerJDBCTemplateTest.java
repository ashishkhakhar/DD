package com.DimensionData.Servermanagement;

import org.junit.Before;
import org.junit.Test;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

import static org.junit.Assert.*;

public class ServerJDBCTemplateTest {
    private DataSource dataSource;
    private JdbcTemplate jdbcTemplateObject;
    @Before
    public void setUp() throws Exception {
        this.dataSource = dataSource;
        this.jdbcTemplateObject = new JdbcTemplate(dataSource);
    }


    @Test
    public void setDataSource() {
    }

    @Test
    public void insert() {
    }

    @Test
    public void listall() {
    }

    @Test
    public void delete() {
    }

    @Test
    public void update() {
    }

    @Test
    public void count() {
    }

    @Test
    public void findbyId() {
    }

    @Test
    public void deleteall() {
    }
}