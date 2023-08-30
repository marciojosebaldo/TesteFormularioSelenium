import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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
        // Abrir a URL informada
        driver.get("https://demo.automationtesting.in/");

        // Incluir e-mail no campo
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

        // Preencher o campo First Name
        driver.findElement(By.xpath("//*[@id=\"basicBootstrapForm\"]/div[1]/div[1]/input")).sendKeys("marcio");

        // Preencher o campo Last Name
        driver.findElement(By.xpath("//*[@id=\"basicBootstrapForm\"]/div[1]/div[2]/input")).sendKeys("baldo");

        // Preencher o campo Address
        driver.findElement(By.xpath("//*[@id=\"basicBootstrapForm\"]/div[2]/div/textarea")).sendKeys("Rua Napoleão Correa Lobo, 200. Pato Branco-PR");

        // Preencher o campo Email address*
        driver.findElement(By.xpath("//*[@id=\"eid\"]/input")).sendKeys("marcio@marcio.com");

        // Prencher o campo Phone*
        driver.findElement(By.xpath("//*[@id=\"basicBootstrapForm\"]/div[4]/div/input")).sendKeys("4612345678");

        // Preencher o campo Male na entrada tipo rádio
        // Aqui também será utilizado o método clique
        driver.findElement(By.xpath("//*[@id=\"basicBootstrapForm\"]/div[5]/div/label[1]")).click();

        // Preencher dois campos no checkbox: segundo e terceiro. Lembre-se de escolher a tag input
        driver.findElement(By.xpath("//*[@id=\"checkbox2\"]")).click();
        driver.findElement(By.xpath("//*[@id=\"checkbox3\"]")).click();

        // Preenche o campo Languages que é um tipo multi-select
        // Para isso, foi criada uma variável do tipo WebElement e receber o XPath do elemento
        WebElement multSelect = driver.findElement(By.xpath("//*[@id=\"basicBootstrapForm\"]/div[7]/div/multi-select"));
        // Inclua o método click()
        multSelect.click();
        // Crie outra variável do tipo WebElement e receberá o texto Portugues
        WebElement opcaoPortugues = driver.findElement(By.xpath("//a[contains(text(), 'Portuguese')]"));



        /*
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