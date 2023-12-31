import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

public class TesteFormularioSelenium {
    private WebDriver driver;

    // Indica o diretório do driver do Edge
    // É necessário que o seu navegador tenha a mesma versão que o driver utilizado para os testes com Selenium
    // Neste exemplo, foi utilizado o navegador Edge
    @BeforeMethod
    public void iniciar() {
        System.setProperty("webdriver.edge.driver", "C:\\Users\\Aluno\\Desktop\\edgedriver_win64\\msedgedriver.exe");
        driver = new EdgeDriver();
    }

    @Test
    public void testarPaginaInicial() throws InterruptedException, AWTException {
        // Abrir a URL informada
        driver.get("https://demo.automationtesting.in/");

        // Incluir e-mail no campo
        driver.findElement(By.xpath("//*[@id=\"email\"]")).sendKeys("marcio@teste.com");

        // Aqui faz aguardar 5 segundos para conferir como foi o teste
        // Caso queira conferir como está o avanço de passo a passo do teste
        // O parâmetro é em microssegundos
        // Caso queira aguardar o tempo, descomente a linha abaixo ao remover as duas "//"
        //Thread.sleep(2000);

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
        WebElement multSelect = driver.findElement(By.xpath("//*[@id=\"msdd\"]"));
        // Inclua o método click()
        multSelect.click();
        // Crie outra variável do tipo WebElement e receberá o texto Portugues
        WebElement opcaoPortuguese = driver.findElement(By.xpath("//a[contains(text(), 'Portuguese')]"));
        opcaoPortuguese.click();
        // E outra para English
        WebElement opcaoEnglish = driver.findElement(By.xpath("//a[contains(text(), 'English')]"));
        opcaoEnglish.click();
        driver.findElement(By.xpath("//*[@id=\"section\"]/div/div")).click();

        // Temporizador para você visualizar a caixa sendo "desclicada"
        //Thread.sleep(2000);

        // Para o form-control Skills é desta forma
        driver.findElement(By.xpath("//*[@id=\"Skills\"]")).sendKeys("Java");

        // Select Country, não há muito diferença
        driver.findElement(By.xpath("//*[@id=\"basicBootstrapForm\"]/div[10]/div/span/span[1]/span/span[2]/b")).click();
        driver.findElement(By.xpath("//*[@id=\"country\"]")).sendKeys("United States of America");
        driver.findElement(By.xpath("//*[@id=\"basicBootstrapForm\"]/div[10]/div/span/span[1]/span/span[2]/b")).click();

        // Preencher o ano do aniversário, mês e dia, respectivamente
        driver.findElement(By.xpath("//*[@id=\"yearbox\"]")).sendKeys("2023");
        driver.findElement(By.xpath("//*[@id=\"basicBootstrapForm\"]/div[11]/div[2]/select")).sendKeys("Setembro");
        driver.findElement(By.xpath("//*[@id=\"daybox\"]")).sendKeys("20");

        // Preencher os dois campos: Password e Confirm Password. Obviamente, cada campo deverá ter o seu próprio XPath
        driver.findElement(By.xpath("//*[@id=\"firstpassword\"]")).sendKeys("senha");
        driver.findElement(By.xpath("//*[@id=\"secondpassword\"]")).sendKeys("senha");

        // Anexar a imagem ao clicar no botão "Escolher ficheiro"
        driver.findElement(By.xpath("//*[@id=\"section\"]/div/div/div[3]/div[2]")).click();
        // Armazene o caminho da URL onde está a imagem. Você precisará adequar o diretório, nome da imagem e extensão da mesma para funcionar no seu
        String urlImagem = "C:\\Users\\Aluno\\Desktop\\modeloImagem.jpg";

        // Use a classe Robot para lidar com a janela de diálogo do sistema operacional
        // Foi deixado InterruptedException e AWTException para tratar as exceções que são necessárias para a classe Robot
        Robot robot = new Robot();

        // Aguardar a janela ser aberta
        Thread.sleep(1000);

        // Copie o caminho do arquivo para a área de transferência
        StringSelection selection = new StringSelection(urlImagem);
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(selection, null);

        // Pressione Ctrl + V para colar o caminho do arquivo na janela de diálogo
        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_CONTROL);

        // Pressione Enter para confirmar o upload
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);

        // Espera para que o envio do arquivo seja concluído
        Thread.sleep(5000);

        // Clique no botão "Submit"
        driver.findElement(By.xpath("//*[@id=\"submitbtn\"]")).click();


        /*
        Abaixo existem outros comandos úteis que podem ser utilizados
        //Armazena em uma variável do tipo String o texto de erro do elemento
        String texto = driver.findElement(By.xpath("//*[@id=\"errormsg\"]")).getText(); // Digitar aqui o xpath do elemento da mensagem

        //Comparação do texto recebido com o que deveria retornar
        Assert.assertEquals("Invalid User Name or PassWord", texto);

        //Limpa o texto digitado
        //driver.findElement(By.xpath("//*[@id=\"basicBootstrapForm\"]/div[1]/div[1]/input")).clear();

        //Caixa de seleção com armazenagem em variável no tipo Select
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