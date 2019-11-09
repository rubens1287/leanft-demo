package br.com.primecontrol.pages;

import br.com.primecontrol.constantes.Constantes;
import com.hp.lft.report.ReportException;
import com.hp.lft.report.Reporter;
import com.hp.lft.report.Status;
import com.hp.lft.sdk.GeneralLeanFtException;
import com.hp.lft.sdk.web.Browser;
import com.hp.lft.sdk.web.Link;
import com.hp.lft.sdk.web.LinkDescription;
import core.Base;
import org.testng.Assert;

public class MenuPrincipal extends Base implements Constantes {

    private LinkDescription lnkSair = new LinkDescription.Builder().innerText("Sair").tagName("A").build();
    private LinkDescription lnkCriarMovimento =  new LinkDescription.Builder().innerText("Criar Movimentação").tagName("A").build();
    private LinkDescription lnkContas =  new LinkDescription.Builder().innerText("Contas ").tagName("A").build();
    private LinkDescription sbLnkAdicionar =  new LinkDescription.Builder().innerText("Adicionar").tagName("A").build();

    /**
     *  Valida se a página do MenuPrincipal foi apresentada com sucesso.
     *
     * @author Rubens Lobo
     *
     * @throws GeneralLeanFtException
     * @throws ReportException
     */
    public void validaMenuPrincipal() throws GeneralLeanFtException, ReportException {
       if(browser.describe(Link.class,lnkSair).exists(TIME_OUT)){
           Reporter.reportEvent("Menu Principal","Menu principal apresentado com sucesso", Status.Passed);
       }else{
           Reporter.reportEvent("Menu Principal","Menu principal apresentado com sucesso", Status.Failed);
           Reporter.endTest();
       }
    }



    public void selecionaMenu(String menu) throws GeneralLeanFtException {

        switch(menu.toUpperCase()) {
            case "CRIAR MOVIMENTAÇÃO":
                browser.describe(Link.class, lnkCriarMovimento).click();
                break;
            case "ADICIONAR CONTAS":
                browser.describe(Link.class, lnkContas).click();
                browser.describe(Link.class, sbLnkAdicionar).click();
                break;
            default:
                Assert.fail("Menu não encontrado!");
        }
    }
}
