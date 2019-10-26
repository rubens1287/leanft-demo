package br.com.primecontrol;

import br.com.primecontrol.pages.Cadastro;
import br.com.primecontrol.pages.Login;
import br.com.primecontrol.pages.MenuPrincipal;
import com.hp.lft.report.ReportException;
import com.hp.lft.sdk.GeneralLeanFtException;
import core.Base;
import org.testng.annotations.Test;

public class CadastroTest extends Base {

    private Login login = new Login();
    private Cadastro cadastro = new Cadastro();

    @Test
    public void executaCadastroNovoUsuario() throws GeneralLeanFtException, ReportException {
        login.validaTelaLogin();
        login.novoCadastroUsuario();
        cadastro.cadastrarUsuario();
    }
}