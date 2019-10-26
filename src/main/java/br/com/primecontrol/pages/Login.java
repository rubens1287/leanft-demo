package br.com.primecontrol.pages;

import br.com.primecontrol.constantes.Constantes;
import com.hp.lft.report.ReportException;
import com.hp.lft.report.Reporter;
import com.hp.lft.report.Status;
import com.hp.lft.sdk.GeneralLeanFtException;
import com.hp.lft.sdk.web.*;
import core.Base;

public class Login extends Base implements Constantes{

    private EditFieldDescription txtEmail =  new EditFieldDescription.Builder().name("email").build();
    private EditFieldDescription txtSenha =  new EditFieldDescription.Builder().id("senha").build();
    private ButtonDescription btnEntrar = new ButtonDescription.Builder().name("Entrar").build();
    private WebElementDescription msgError = new WebElementDescription.Builder().tagName("DIV").innerText("Problemas com o login do usuário").build();
    private LinkDescription novoUsuario = new LinkDescription.Builder().innerText("Novo usuário?").build();

    /**
     * Valida se a Tela de Login foi apresentada
     *
     * @author Rubens Lobo
     *
     * @throws GeneralLeanFtException
     * @throws ReportException
     */
    public void validaTelaLogin() throws GeneralLeanFtException, ReportException {
        if( browser.describe(EditField.class,txtEmail).exists(TIME_OUT)){
            Reporter.reportEvent("Login","Tela de Login apresentada com sucesso!", Status.Passed);
        }else{
            Reporter.reportEvent("Login","Tela de Login não foi apresentada com sucesso!", Status.Failed);
        }
    }
    /**
     * Executa login na aplicação
     *
     * @author Rubens Lobo
     *
     * @throws GeneralLeanFtException
     */
    public void logar() throws GeneralLeanFtException {

        browser.describe(EditField.class,txtEmail).setValue("teste123@teste.com.br");
        browser.describe(EditField.class,txtSenha).setValue("1234");
        browser.describe(Button.class,btnEntrar).click();
    }

    /**
     * Executa login na aplicação
     *
     * @author Rubens Lobo
     * @param email informe o email que será utilizado
     * @param senha informe o senha que será utilizado
     * @throws GeneralLeanFtException
     */
    public void logar(String email, String senha) throws GeneralLeanFtException {
        browser.describe(EditField.class,txtEmail).setValue(email);
        browser.describe(EditField.class,txtSenha).setValue(senha);
        browser.describe(Button.class,btnEntrar).click();
    }

    /**
     * Valida mensagem de erro pela execução de um login inválido
     *
     * @author Rubens Lobo
     * @throws GeneralLeanFtException
     * @throws ReportException
     */
    public void mensagemErroLogin() throws GeneralLeanFtException, ReportException {

        if(browser.describe(WebElement.class,msgError).exists(TIME_OUT)){
            Reporter.reportEvent("Login","Mensagem de erro foi apresentada com sucesso!", Status.Passed);
        }else {
            Reporter.reportEvent("Login","Mensagem de erro não foi apresentada!", Status.Failed);
        }

    }

    /**
     * Clica no boão noco cadastro
     *
     * @author Rubens Lobo
     * @throws GeneralLeanFtException
     */
    public void novoCadastroUsuario() throws GeneralLeanFtException {
        browser.describe(Link.class, novoUsuario).click();
    }


}
