package br.com.framework.core.utils;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;

import br.com.framework.core.configuration.ExemploTestRules;

public class ExemploUtils {
	
	/**
	 * Método para gerar arquivo de captura de tela do teste.
	 * 
	 * @param log - Nome do arquivo
	 * @throws IOException
	 */
	private static void printScreen(String log) throws IOException {
		
		File file = ((TakesScreenshot) ExemploTestRules.getDriver()).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(file,
				new File(System.getProperty("user.dir") +
						"\\target\\printScreenHtmlReporter\\" + log +".png"));
		
	}
	
	/**
	 * Método para adicionar evidência de tela do teste no relatório.
	 * 
	 * @param log - Nome do arquivo
	 * @throws IOException
	 */
	public static void logPrintScreen(String log) throws IOException {
		
		ExtentTest extentTest = ExemploTestRules.getExtentTest();
		printScreen(log);
		extentTest.log(Status.INFO, log,
				MediaEntityBuilder.createScreenCaptureFromPath(
						"./printScreenHtmlReporter/" + log + ".png").build());
		
	}
	
	/**
	 * Método para inserir mensagem no relatório quando validação é realizada com sucesso.
	 * 
	 * @param log - Mensagem que será inserida no relatório
	 */
	public static void logPassed(String log) {
		
		ExtentTest extentTest = ExemploTestRules.getExtentTest();
		extentTest.log(Status.PASS, log);
		
	}
	
	/**
	 * Método para inserir mensagem no relatório quando validação não é realizada com sucesso.
	 * 
	 * @param log - Mensagem que será inserida no relatório
	 */
	public static void logFailed(String log) {
		
		ExtentTest extentTest = ExemploTestRules.getExtentTest();
		extentTest.log(Status.FAIL, log);
		
	}
	
}
