package br.com.primecontrol;

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

    public void logar() throws GeneralLeanFtException {
        browser.describe(EditField.class,txtEmail).exists(5);
        browser.describe(EditField.class,txtEmail).setValue("teste123@teste.com.br");
        browser.describe(EditField.class,txtSenha).setValue("1234");
        browser.describe(Button.class,btnEntrar).click();
    }

}
