import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TesteFormularioSelenium {
    private WebDriver driver;

    @BeforeMethod
    public void iniciar() {
        System.setProperty("webdriver.edge.driver", "C:\\Users\\Aluno\\Desktop\\edgedriver_win64");
        driver = new EdgeDriver();
    }

    @Test
    public void testarPaginaInicial() {
        //Abrir a URL informada
        driver.get("https://demo.automationtesting.in/");

        //Clicar em elementos como botões ou links
        driver.findElement(By.xpath("//*[@id=\"main\"]/div[2]/span/a")).click();

        //Digitar em elemento de input
        driver.findElement(By.xpath("//*[@id=\"basicBootstrapForm\"]/div[1]/div[1]/input")).sendKeys("usuario");

        //Limpa o texto digitado
        driver.findElement(By.xpath("//*[@id=\"basicBootstrapForm\"]/div[1]/div[1]/input")).clear();

        //Armazena o texto do elemento
        String texto = driver.findElement(By.xpath("//*[@id=\"basicBootstrapForm\"]/div[1]/div[1]/input")).getText();

        //Compara o texto retornado com o que deveria retornar de fato
        Assert.assertEquals("//*[@id=\"basicBootstrapForm\"]/div[1]/div[1]/input", texto);

        //Caixa de seleção
        Select Day = new Select(driver.findElement(By.xpath("//*[@id=\"Skills\"]")));
        Day.selectByVisibleText("Java");
    }

    @AfterMethod
    public void finalizar() throws InterruptedException {
        Thread.sleep(5000);
        driver.quit();
    }
}