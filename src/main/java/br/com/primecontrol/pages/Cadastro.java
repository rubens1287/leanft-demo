package br.com.primecontrol.pages;

import br.com.primecontrol.constantes.Constantes;
import com.github.javafaker.Faker;
import com.hp.lft.report.ReportException;
import com.hp.lft.report.Reporter;
import com.hp.lft.report.Status;
import com.hp.lft.sdk.GeneralLeanFtException;
import com.hp.lft.sdk.web.*;
import core.Base;

public class Cadastro extends Base implements Constantes {

    private EditFieldDescription txtNome = new EditFieldDescription.Builder().id("nome").build();
    private EditFieldDescription txtEmail = new EditFieldDescription.Builder().id("email").build();
    private EditFieldDescription txtSenha = new EditFieldDescription.Builder().id("senha").build();
    private ButtonDescription btnCadastrar = new ButtonDescription.Builder().name("Cadastrar").build();
    private WebElementDescription lblMsg = new WebElementDescription.Builder().xpath("//DIV[@role='alert'][1]").build();

    /**
     *  Cadastra usuário
     *
     *  @author Rubens Lobo
     *
     * @throws GeneralLeanFtException
     */
    public void cadastrarUsuario() throws GeneralLeanFtException, ReportException {
        Faker faker = new Faker();
        String fullname = faker.name().fullName().replace(" ","");
        browser.describe(EditField.class,txtNome).setValue(fullname);
        browser.describe(EditField.class,txtEmail).setValue(fullname+"@teste.com");
        browser.describe(EditField.class,txtSenha).setValue("1234");
        browser.describe(Button.class,btnCadastrar).click();

        if(browser.describe(WebElement.class,lblMsg).exists(TIME_OUT) &&
                browser.describe(WebElement.class,lblMsg).getInnerText().contains("Usuário inserido com sucesso")){
            Reporter.reportEvent("Cadastro","Cadastro efetuado com sucesso!", Status.Passed);
        }else {
            Reporter.reportEvent("Cadastro","Cadastro não foi efetuado com sucesso!", Status.Failed);
        }
    }
}
