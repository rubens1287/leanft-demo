package br.com.primecontrol.pages;

import com.hp.lft.report.ReportException;
import com.hp.lft.report.Reporter;
import com.hp.lft.report.Status;
import com.hp.lft.sdk.GeneralLeanFtException;
import com.hp.lft.sdk.web.*;
import org.testng.Assert;

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
            Reporter.reportEvent("Cadastrar Conta","Realiza o cadastro de nova conta", Status.Passed,browser.getPage().getSnapshot());
        }else{
            Reporter.reportEvent("Cadastrar Conta","Realiza o cadastro de novo conta", Status.Failed,browser.getPage().getSnapshot());
            Reporter.endTest();
        }

        browser.describe(EditField.class,txtNome).setValue("Contas William 3");
        browser.describe(Button.class,btnSalvar).click();

        if(browser.describe(WebElement.class,lblMsgSucesso).exists(10)){
            Reporter.reportEvent("Cadastrar Conta","Conta Cadastrado com sucesso!", Status.Passed,browser.getPage().getSnapshot());
        }else{
            Reporter.reportEvent("Cadastrar Conta","Conta Cadastrado com sucesso!", Status.Failed,browser.getPage().getSnapshot());
            Assert.fail();
        }

        Table contaTable = browser.describe(Table.class, new TableDescription.Builder()
                .id("tabelaContas").build());

        contaTable.findRowWithCellText("Contas William 3");
    }
}
