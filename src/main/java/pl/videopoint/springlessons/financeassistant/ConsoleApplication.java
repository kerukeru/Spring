package pl.videopoint.springlessons.financeassistant;

import java.math.BigDecimal;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import pl.videopoint.springlessons.financeassistant.services.RateConversionService;
import pl.videopoint.springlessons.financeassistant.services.SecondRateConversionService;

public class ConsoleApplication {

	public static void main(String[] args) {
		//kontener zarzadza cyklem zycia wszystkich komponentow aplikacj (beanami, zasoby(properties), multilanguage, obsluga zdarzen)
		//serce aplikacji

		ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class); //automatycznie tworzy wszystkie beany

		
		RateConversionService service = context.getBean(RateConversionService.class); 	//mamy beana aplikacji
		service.convertAmount(BigDecimal.valueOf(123.0), "EUR");	// i wywo³ujemy z niego metodê jak¹œ 
			
		
//		SecondRateConversionService service2 = context.getBean(SecondRateConversionService.class); 		
//		service2.convertAmount(BigDecimal.valueOf(124.0), "EUR");
		
	}

}
