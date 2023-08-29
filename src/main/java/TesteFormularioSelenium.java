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
        System.setProperty("webdriver.edge.driver", "C:\\Users\\Aluno\\Desktop\\edgedriver_win64\\msedgedriver.exe");
        driver = new EdgeDriver();
    }

    @Test
    public void testarPaginaInicial() throws InterruptedException {
        //Abrir a URL informada
        driver.get("https://demo.automationtesting.in/");

        //Incluir e-mail no campo
        driver.findElement(By.xpath("//*[@id=\"email\"]")).sendKeys("marcio@teste.com");

        // Aqui faz aguardar 5 segundos para conferir como foi o teste
        // Caso queira conferir como está o avanço de passo a passo do teste
        // O parâmetro é em microssegundos
        Thread.sleep(2000);

        // Também pode ser pesquisado por id
        // Aqui está sendo apagado o e-mail por algum eventual erro
        driver.findElement(By.id("email")).clear();

        // Reenvia outro e-mail
        driver.findElement(By.id("email")).sendKeys("marcio@marcio.com");

        // Clica no botão enviar
        driver.findElement(By.xpath("//*[@id=\"enterimg\"]")).click();

        //Preencher o campo First Name
        driver.findElement(By.xpath("//*[@id=\"basicBootstrapForm\"]/div[1]/div[1]/input")).sendKeys("marcio");

        //Preencher o campo Last Name
        driver.findElement(By.xpath("//*[@id=\"basicBootstrapForm\"]/div[1]/div[2]/input")).sendKeys("baldo");

        /*
                //Clicar no botão de Enter
        driver.findElement(By.xpath("//*[@id=\"enterbtn\"]")).click();

        //Armazena o texto de erro do elemento
        String texto = driver.findElement(By.xpath("//*[@id=\"errormsg\"]")).getText(); // Digitar aqui o xpath do elemento da mensagem

        //Compara o texto retornado com o que deveria retornar de fato
        Assert.assertEquals("Invalid User Name or PassWord", texto);

        // Outros comandos úteis para teste da página
        //Digitar em elemento de input
        //driver.findElement(By.xpath("//*[@id=\"basicBootstrapForm\"]/div[1]/div[1]/input")).sendKeys("usuario");

        //Limpa o texto digitado
        //driver.findElement(By.xpath("//*[@id=\"basicBootstrapForm\"]/div[1]/div[1]/input")).clear();

        //Caixa de seleção
        //Select Day = new Select(driver.findElement(By.xpath("//*[@id=\"Skills\"]")));
        //Day.selectByVisibleText("Java");

         */
    }


    @AfterMethod
    public void finalizar() throws InterruptedException {
        Thread.sleep(5000);
        driver.quit();
    }

}