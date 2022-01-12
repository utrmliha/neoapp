package com.br.neoapp.controller.form;

import javax.validation.constraints.NotBlank;

public class LoginForm {

    @NotBlank(message = "{notBlank.login}")
    private String login;

    @NotBlank(message = "{notBlank.password}")
    private String password;

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
