package com.DimensionData.Servermanagement;

import com.mysql.jdbc.EscapeTokenizer;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.awt.*;
import java.io.DataInputStream;
import java.io.IOException;
import java.util.List;

public class ServerManager {
    public static void main(String[] args) throws IOException {
        boolean running = true;
        ApplicationContext context = new ClassPathXmlApplicationContext("conf/Beans.xml");

        ServerJDBCTemplate serverJDBCTemplate =
                (ServerJDBCTemplate) context.getBean("serverJDBCTemplate");
        showHelp();
        while (running) {
            System.out.print("Enter your option: ");
            DataInputStream in = new DataInputStream(System.in);
            String option = in.readLine();

            if (option.equalsIgnoreCase("help")) {
                //System.out.println("Your option is: " + option);
                showHelp();
            } else if (option.equalsIgnoreCase("quit")) {
                //System.out.println("Your option is: " + option);
                running = false;
            } else if (option.equalsIgnoreCase("countServers")) {
                //System.out.println("Your option is: " + option);
                System.out.println("Total servers: " + serverJDBCTemplate.count());
            } else if (option.equalsIgnoreCase("addServer")) {
                //System.out.println("Your option is: " + option);
                System.out.println("Enter Server ID:");
                String sId = in.readLine();
                try {
                    System.out.println("Enter Server Name:");
                    String sName = in.readLine();
                    //System.out.println("Enter Server id:" + id +  " Name: " + sName);
                    if (serverJDBCTemplate.findbyId(sId) == null) {
                        Server server = new Server();
                        server.setId(sId);
                        server.setName(sName);
                        serverJDBCTemplate.insert(server);
                    } else {
                        System.out.println("Server already exists");
                    }
                } catch (Exception e) {
                    System.out.println("wrong input");
                }

            } else if (option.equalsIgnoreCase("deleteServer")) {
                //System.out.println("Your option is: " + option);
                System.out.println("Enter Server ID:");
                String sId = in.readLine();
                try {
                    //int id = Integer.parseInt(sId);
                    if (serverJDBCTemplate.findbyId(sId) != null) {
                        Server server = new Server();
                        server.setId(sId);
                        serverJDBCTemplate.delete(server);
                    } else {
                        System.out.println("Server does not exists");
                    }
                } catch (Exception e) {
                    System.out.println("wrong input");
                }
            } else if (option.equalsIgnoreCase("editServer")) {
                //System.out.println("Your option is: " + option);
                System.out.println("Enter Server ID:");
                String sId = in.readLine();
                try {
                    int id = Integer.parseInt(sId);
                    System.out.println("Enter Server Name:");
                    String sName = in.readLine();
                    if (serverJDBCTemplate.findbyId(sId) != null) {
                        Server server = new Server();
                        server.setId(sId);
                        server.setName(sName);
                        serverJDBCTemplate.update(server);
                    } else {
                        System.out.println("Server does not exists");
                    }
                } catch (Exception e) {
                    System.out.println("wrong input");
                }
            } else if (option.equalsIgnoreCase("listAll")) {
                List<Server> servers = serverJDBCTemplate.listall();
                boolean found = false;
                if (servers.size() > 0) {
                    for (Server servertemp : servers) {
                        System.out.println(servertemp.toStringID());
                    }
                } else {
                    System.out.println("No servers");
                }
            } else if (option.equalsIgnoreCase("findServer")) {
                //System.out.println("Your option is: " + option);
                System.out.println("Enter Server ID:");
                String sId = in.readLine();
                try {
                    //int id = Integer.parseInt(sId);
                    Server server = serverJDBCTemplate.findbyId(sId);
                    if (server == null) {
                        System.out.println("No such server");
                    } else {
                        System.out.println(server.toStringID());
                    }
                } catch (Exception e) {
                    System.out.println("wrong input");
                }
            } else if (option.equalsIgnoreCase("deleteAll")) {
                //System.out.println("Your option is: " + option);
                serverJDBCTemplate.deleteall();
            } else {
                System.out.println("No such options:");

            }
        }
    }

    private static void showHelp() {
        System.out.println("------------------------------------------------------------");
        System.out.println("Here are your options");
        System.out.println("help:  To display this message");
        System.out.println("countServers:  To display the current number of servers present");
        System.out.println("addServer:  To add new server with id and name");
        System.out.println("editServer: To change the name of a server identified by id (requires use to enter - the id and the new name)");
        System.out.println("deleteServer: To delete a server (requires user to enter the id of the server to delete)");
        System.out.println("listAll: To display details of all servers");
        System.out.println("findServer: To display a server details (Requires user to enter the id of the server");
        System.out.println("deleteAll: To delete all servers");
        System.out.println("------------------------------------------------------------");
    }

}
