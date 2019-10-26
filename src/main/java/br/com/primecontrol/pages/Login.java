package br.com.primecontrol.pages;

import com.hp.lft.sdk.GeneralLeanFtException;
import com.hp.lft.sdk.web.Button;
import com.hp.lft.sdk.web.ButtonDescription;
import com.hp.lft.sdk.web.EditField;
import com.hp.lft.sdk.web.EditFieldDescription;
import core.Base;

public class Login extends Base {

    private EditFieldDescription txtEmail =  new EditFieldDescription.Builder().name("email").build();
    private EditFieldDescription txtSenha =  new EditFieldDescription.Builder().id("senha").build();
    private ButtonDescription btnEntrar = new ButtonDescription.Builder().name("Entrar").build();

    /**
     * Executa login na aplicação
     *
     * @author Rubens Lobo
     *
     * @throws GeneralLeanFtException
     */
    public void logar() throws GeneralLeanFtException {
        browser.describe(EditField.class,txtEmail).exists(5);
        browser.describe(EditField.class,txtEmail).setValue("teste123@teste.com.br");
        browser.describe(EditField.class,txtSenha).setValue("1234");
        browser.describe(Button.class,btnEntrar).click();
    }

    /**
     * Executa login na aplicação
     * @author Rubens Lobo
     * @param email informe o email que será utilizado
     * @param senha informe o senha que será utilizado
     * @throws GeneralLeanFtException
     */
    public void logar(String email, String senha) throws GeneralLeanFtException {
        browser.describe(EditField.class,txtEmail).exists(5);
        browser.describe(EditField.class,txtEmail).setValue(email);
        browser.describe(EditField.class,txtSenha).setValue(senha);
        browser.describe(Button.class,btnEntrar).click();
    }

}
