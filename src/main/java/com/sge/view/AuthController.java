package com.sge.view;

import com.sge.model.User;
import com.sge.service.AuthService;
import com.sge.service.UserService;
import jakarta.enterprise.context.RequestScoped;
import jakarta.faces.context.FacesContext;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import jakarta.servlet.http.HttpServletRequest;

@Named
@RequestScoped
public class AuthController {

    @Inject
    private AuthService authService;

    @Inject
    private UserService userService;

    private String email;
    private String password;
    private User user = new User();

    public String login() {
        boolean loggedIn = authService.login(email, password);
        if (loggedIn) {
            return "/profile.xhtml?faces-redirect=true";
        }
        return "/login.xhtml?error=true";
    }

    public String logout() {
        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
        return "/login.xhtml?faces-redirect=true";
    }

    public String register() {
        authService.register(user);
        return "/login.xhtml?faces-redirect=true";
    }

    public User getCurrentUser() {
        HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
        String email = request.getUserPrincipal().getName();
        return userService.findByEmail(email).orElse(null);
    }

    // Getters and Setters
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
