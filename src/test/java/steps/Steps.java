package steps;

import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import steps.webSelenium.OpenWeb;

public class Steps {

    private String homeURL = "https://imalittletester.com/";
    private String comicsURL = "https://imalittletester.com/category/comics/";
    private OpenWeb openWeb;

    @Before
    public void setUp () {
        openWeb = new OpenWeb();
    }

    @Given("El usuario está en la pantalla Home de imalittletester")
    public void elUsuarioEstaEnLaPaginaHome () {
        openWeb.openWebWithURL(homeURL);
        Assert.assertTrue(openWeb.checkUrl(homeURL));
    }

    @When("El usuario hace clic sobre el botón the little tester comics")
    public void elUsuarioHaceClickEnLittleTesterComics () {
        try {
            openWeb.clickLittleTesterComicLink();
        } catch (RuntimeException e) {
            throw new RuntimeException(e);
        }
        System.out.println("El usuario ha hecho click en el botón the little tester comics");
    }

    @Then("El usuario es redirigido a la pantalla Comics")
    public void elUsuarioEsRedirigidoAPantallaComics (){
        Assert.assertTrue(openWeb.checkUrl(comicsURL));
    }

}
