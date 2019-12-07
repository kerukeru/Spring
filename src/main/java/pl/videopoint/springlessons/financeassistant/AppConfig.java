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
	public CurrencyRateProvider fileCurrencyRateProvider() { //tworzy nowy obiekt który bêdzie podpiêty do beana
		return new FileCurrencyRateProvider();
	}
	
	@Bean
	public RateConversionService rateConversionService(CurrencyRateProvider currencyRateProvider) { //
		RateConversionService rateConversionService = new RateConversionService(); //tworzy nowy obiekt który jest beanem
		rateConversionService.setRateProvider(fileCurrencyRateProvider()); 	//tutaj okreslamy jaka klase przyjmie bean RateConversionService
																			//czyli na jakiej klasie ten bean bêdzie pracowa³, bo dziêki interfejsowi CurrencyRateProvider
																			//mo¿emy tam wys³aæ ró¿ne klasy które go implementuj¹ ;)
		return rateConversionService;	//zwraca obiekt który jest beanem, czyli go tworzy tutaj
	}
	
//	@Bean
//	public SecondRateConversionService secondRateConversionService() {
//		System.out.println("7");
//		SecondRateConversionService rateConversionService = new SecondRateConversionService();
//		rateConversionService.setRateProvider(fileCurrencyRateProvider()); //tutaj okreslamy jaka klase przyjmie bean SecondRateConversionService
//		return rateConversionService;
//	}

}
