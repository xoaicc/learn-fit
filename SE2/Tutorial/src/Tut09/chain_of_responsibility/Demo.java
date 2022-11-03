package Tut09.chain_of_responsibility;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import Tut09.chain_of_responsibility.middleware.Middleware;
import Tut09.chain_of_responsibility.middleware.RoleCheckMiddleware;
import Tut09.chain_of_responsibility.middleware.ThrottlingMiddleware;
import Tut09.chain_of_responsibility.middleware.UserExistsMiddleware;
import Tut09.chain_of_responsibility.server.Server;

/**
 * Demo class. Everything comes together here.
 */
public class Demo {
    private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private static Server server;

    private static void init() {
        server = new Server();
        //TO-DO: Register email & pass for 2 account types: admin & user
        server.register("admin@example.com", "xccpro");
        server.register("xoaic@xcc.one", "xccpro2");

        // All checks are linked. Client can build various chains using the same components.
        Middleware middleware = new ThrottlingMiddleware(2);
        middleware.linkWith(new UserExistsMiddleware(server))
                .linkWith(new RoleCheckMiddleware());

        // Server gets a chain from client code.
        server.setMiddleware(middleware);
    }

    public static void main(String[] args) throws IOException {
        init();

        boolean success;
        do {
        	//TO-DO: Ask for email & password then save to suitable variables
            System.out.print("Enter email: ");
            String email = reader.readLine();

            System.out.print("Enter password: ");
            String password = reader.readLine();

        	//TO-DO: Try to login to server with given email & password
        	//then store the result to variable 'success'
            success = server.logIn(email, password);
        } while (!success);
    }
}
