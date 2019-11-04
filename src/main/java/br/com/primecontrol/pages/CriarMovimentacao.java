package br.com.primecontrol.pages;

import com.hp.lft.report.ReportException;
import com.hp.lft.report.Reporter;
import com.hp.lft.report.Status;
import com.hp.lft.sdk.GeneralLeanFtException;
import com.hp.lft.sdk.web.*;

public class CriarMovimentacao {

    private Browser browser;
    private ListBoxDescription cbbTipoMov = new ListBoxDescription.Builder().id("tipo").build();
    private EditFieldDescription txtTransacao =  new EditFieldDescription.Builder().id("data_transacao").build();
    private EditFieldDescription txtDtPagamento =  new EditFieldDescription.Builder().id("data_pagamento").build();
    private EditFieldDescription txtDescricao = new EditFieldDescription.Builder().id("descricao").build();
    private EditFieldDescription txtValor = new EditFieldDescription.Builder().id("valor").build();
    private EditFieldDescription txtInteressado = new EditFieldDescription.Builder().id("interessado").build();
    private ListBoxDescription cbbConta = new ListBoxDescription.Builder().id("conta").build();
    private RadioGroupDescription rdbSiatuacao = new RadioGroupDescription.Builder().name("status").build();
    private ButtonDescription btnSalvar =  new ButtonDescription.Builder().name("Salvar").build();
    private WebElementDescription lblMsgSucesso = new WebElementDescription.Builder().className("alert alert-success").tagName("DIV").build();


    public CriarMovimentacao(Browser browser) {
        this.browser = browser;
    }

    public void cadastrarMovimentacao() throws GeneralLeanFtException, ReportException {
       if(browser.describe(ListBox.class,cbbConta).exists(10)){
           Reporter.reportEvent("Cadastrar Movimentacao","Realiza o cadastro de uam movimentação financeira", Status.Passed,browser.getPage().getSnapshot());
       }else{
           Reporter.reportEvent("Cadastrar Movimentacao","Realiza o cadastro de uam movimentação financeira", Status.Failed,browser.getPage().getSnapshot());
       }
       browser.describe(ListBox.class,cbbConta).select("Conta mesmo nome");
       browser.describe(ListBox.class,cbbTipoMov).select("Despesa");
       browser.describe(EditField.class,txtTransacao).setValue("01/11/2019");
       browser.describe(EditField.class, txtDtPagamento).setValue("01/11/2019");
       browser.describe(EditField.class, txtDescricao).setValue("Novo cadastro de movimentacao");
       browser.describe(EditField.class, txtValor).setValue("200");
       browser.describe(EditField.class, txtInteressado).setValue("William");
       browser.describe(RadioGroup.class, rdbSiatuacao).select(1);
       browser.describe(Button.class,btnSalvar).click();

       if(browser.describe(WebElement.class,lblMsgSucesso).exists(10)){
           Reporter.reportEvent("Cadastrar Movimentacao","Movimetação realizada com sucesso", Status.Passed,browser.getPage().getSnapshot());
       }else{
           Reporter.reportEvent("Cadastrar Movimentacao","Movimetação realizada com sucesso", Status.Failed,browser.getPage().getSnapshot());
       }
    }

}
