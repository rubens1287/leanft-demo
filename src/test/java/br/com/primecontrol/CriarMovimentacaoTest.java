package br.com.primecontrol;

import br.com.primecontrol.pages.Cadastro;
import br.com.primecontrol.pages.CriarMovimentacao;
import br.com.primecontrol.pages.Login;
import br.com.primecontrol.pages.MenuPrincipal;
import com.hp.lft.report.ReportException;
import com.hp.lft.sdk.GeneralLeanFtException;
import core.Base;
import org.testng.annotations.Test;

public class CriarMovimentacaoTest extends Base {

    private Login login = new Login();
    private MenuPrincipal menuPrincipal  = new MenuPrincipal();



    @Test
    public void executaCadastroNovoUsuario() throws GeneralLeanFtException, ReportException {
        login.validaTelaLogin();
        login.logar();
        menuPrincipal.validaMenuPrincipal();
        menuPrincipal.selecionaMenu("Criar Movimentação");
        new CriarMovimentacao(browser).cadastrarMovimentacao();

    }
}