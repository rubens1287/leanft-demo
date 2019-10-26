package br.com.primecontrol;

import org.testng.annotations.Test;

import core.*;

public class LoginTest extends Base {

    private Login login = new Login();
    private MenuPrincipal menuPrincipal = new MenuPrincipal();

    @Test
    public void validaLoginComSucesso() throws Exception {
        browser.navigate("https://seubarriga.wcaquino.me/login");
        login.logar();
        menuPrincipal.validaMenuPrincipal();
    }

}