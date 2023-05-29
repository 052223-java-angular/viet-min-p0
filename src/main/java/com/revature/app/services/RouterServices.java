package com.revature.app.services;

import java.util.Scanner;

import com.revature.app.daos.ProductDAO;
import com.revature.app.daos.RoleDAO;
import com.revature.app.daos.UserDAO;
import com.revature.app.models.Cart;
import com.revature.app.models.Session;
import com.revature.app.screens.BrowseProductScreen;
import com.revature.app.screens.HomeScreen;
import com.revature.app.screens.RegisterScreen;
import com.revature.app.screens.LogInScreen;

public class RouterServices {
    private Session session;
    private String productId;
    public void navigate(String path, Scanner scan) {
        switch (path) {
            case "/home":
                new HomeScreen(this).start(scan);
                break;
            case "/login":
            new LogInScreen(this, getUserService()).start(scan);
                break;
            case "/register":
                new RegisterScreen(this, getUserService()).start(scan);
                break;
            case "/review":
                //new 
                break;
            case "/menu":
                break;
            case "/browse":
                new BrowseProductScreen(this, getProductService(), new Cart()).start(scan);
                break;
            case "product":
                //new ProductDetailScreen().start(scan);
                break;
            default:
                break;
        }
    }

    private UserService getUserService() {
        return new UserService(new UserDAO(), getRoleService());
    }

    private RoleService getRoleService() {
        return new RoleService(new RoleDAO());
    }

    private ProductService getProductService() {
        return new ProductService(new ProductDAO());
    }

    public void setProdId(String id) {
        productId = id;
    }
}
