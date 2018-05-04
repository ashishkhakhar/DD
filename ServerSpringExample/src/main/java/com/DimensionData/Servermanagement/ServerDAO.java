package com.DimensionData.Servermanagement;

import com.DimensionData.Servermanagement.Server;

import java.util.List;
import javax.sql.DataSource;

public interface ServerDAO {

    void setDataSource(DataSource ds);

    void insert(Server server);

    List<Server> listall();

    Long count();

    void delete(Server server);

    void update(Server server);

    Server findbyId(String id);

    void deleteall();
}

