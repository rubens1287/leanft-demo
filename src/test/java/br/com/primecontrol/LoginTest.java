package br.com.primecontrol;

import br.com.primecontrol.pages.Login;
import br.com.primecontrol.pages.MenuPrincipal;
import com.hp.lft.report.ReportException;
import com.hp.lft.sdk.GeneralLeanFtException;
import org.testng.annotations.Test;

import core.*;

public class LoginTest extends Base {

    private Login login = new Login();
    private MenuPrincipal menuPrincipal = new MenuPrincipal();


    @Test
    public void executaLoginComCredenciaisValidas() throws Exception {
        login.validaTelaLogin();
        login.logar();
        menuPrincipal.validaMenuPrincipal();
    }

    @Test
    public void executaLoginComCredenciaisInvalidas() throws Exception {
        login.validaTelaLogin();
        login.logar("teste@teste.com","12345678");
        login.mensagemErroLogin();
    }

    @Test
    public void executaCadastroNovoUsuario() throws GeneralLeanFtException, ReportException {
        login.validaTelaLogin();
        login.novoCadastroUsuario();
    }


}