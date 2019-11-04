package br.com.primecontrol.pages;

import com.hp.lft.report.ReportException;
import com.hp.lft.report.Reporter;
import com.hp.lft.report.Status;
import com.hp.lft.sdk.GeneralLeanFtException;
import com.hp.lft.sdk.web.*;

public class CriarConta {

    private Browser browser;
    private EditFieldDescription txtNome = new EditFieldDescription.Builder().name("nome").tagName("INPUT").type("text").build();
    private ButtonDescription btnSalvar =  new ButtonDescription.Builder().buttonType("submit").name("Salvar").tagName("BUTTON").build();
    private WebElementDescription lblNome =  new WebElementDescription.Builder().innerText("Nome").tagName("LABEL").build();
    private WebElementDescription lblMsgSucesso = new WebElementDescription.Builder().className("alert alert-success").tagName("DIV").build();

    public CriarConta(Browser browser) {
        this.browser = browser;
    }

    public void cadastrarConta() throws GeneralLeanFtException, ReportException {
        if(browser.describe(WebElement.class,lblNome).exists(10)){
            Reporter.reportEvent("Cadastrar Conta","Realiza o cadastro de nova conta", Status.Passed);
        }else{
            Reporter.reportEvent("Cadastrar Conta","Realiza o cadastro de novo conta", Status.Failed);
        }

        browser.describe(EditField.class,txtNome).setValue("Contas William 1");
        browser.describe(Button.class,btnSalvar).click();

        if(browser.describe(WebElement.class,lblMsgSucesso).exists(10)){
            Reporter.reportEvent("Cadastrar Conta","Conta Cadastrado com sucesso!", Status.Passed);
        }else{
            Reporter.reportEvent("Cadastrar Conta","Conta Cadastrado com sucesso!", Status.Failed);
        }
    }
}
