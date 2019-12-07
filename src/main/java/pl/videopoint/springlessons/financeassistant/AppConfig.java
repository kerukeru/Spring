package pl.videopoint.springlessons.financeassistant;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import pl.videopoint.springlessons.financeassistant.services.CurrencyRateProvider;
import pl.videopoint.springlessons.financeassistant.services.FileCurrencyRateProvider;
import pl.videopoint.springlessons.financeassistant.services.RateConversionService;
import pl.videopoint.springlessons.financeassistant.services.SecondRateConversionService;

@Configuration
public class AppConfig { //moze to tez byc plik XML lub same adnotacje
	
	
	@Bean
	@Scope("prototype")
	public CurrencyRateProvider fileCurrencyRateProvider() { //tworzy nowy obiekt kt�ry b�dzie podpi�ty do beana
		return new FileCurrencyRateProvider();
	}
	
	@Bean
	public RateConversionService rateConversionService(CurrencyRateProvider currencyRateProvider) { //
		RateConversionService rateConversionService = new RateConversionService(); //tworzy nowy obiekt kt�ry jest beanem
		rateConversionService.setRateProvider(fileCurrencyRateProvider()); 	//tutaj okreslamy jaka klase przyjmie bean RateConversionService
																			//czyli na jakiej klasie ten bean b�dzie pracowa�, bo dzi�ki interfejsowi CurrencyRateProvider
																			//mo�emy tam wys�a� r�ne klasy kt�re go implementuj� ;)
		return rateConversionService;	//zwraca obiekt kt�ry jest beanem, czyli go tworzy tutaj
	}
	
//	@Bean
//	public SecondRateConversionService secondRateConversionService() {
//		System.out.println("7");
//		SecondRateConversionService rateConversionService = new SecondRateConversionService();
//		rateConversionService.setRateProvider(fileCurrencyRateProvider()); //tutaj okreslamy jaka klase przyjmie bean SecondRateConversionService
//		return rateConversionService;
//	}

}
