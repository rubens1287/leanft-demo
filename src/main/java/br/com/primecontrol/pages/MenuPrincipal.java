package br.com.primecontrol.pages;

import com.hp.lft.report.ReportException;
import com.hp.lft.report.Reporter;
import com.hp.lft.report.Status;
import com.hp.lft.sdk.GeneralLeanFtException;
import com.hp.lft.sdk.web.Link;
import com.hp.lft.sdk.web.LinkDescription;
import core.Base;

public class MenuPrincipal extends Base {

    private LinkDescription lnkSair = new LinkDescription.Builder().innerText("Sair").tagName("A").build();

    /**
     *  Valida se a página do MenuPrincipal foi apresentada com sucesso.
     *
     * @author Rubens Lobo
     *
     * @throws GeneralLeanFtException
     * @throws ReportException
     */
    public void validaMenuPrincipal() throws GeneralLeanFtException, ReportException {
       if(browser.describe(Link.class,lnkSair).exists(5)){
           Reporter.reportEvent("Step","Menu principal apresentado com sucesso", Status.Passed);
       }else{
           Reporter.reportEvent("Step","Menu principal apresentado com sucesso", Status.Failed);
       }

    }
}
