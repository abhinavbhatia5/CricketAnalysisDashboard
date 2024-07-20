package com.example.ipl.CricketAnalysisApplication;

import com.example.ipl.CricketAnalysisApplication.utils.csvFileUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.nio.file.Path;

import static javax.print.attribute.standard.MediaSizeName.C;

@SpringBootApplication
@Slf4j
public class CricketAnalysisApplication {
	private static ApplicationContext applicationContext;

	public static void main(String[] args) {
//		CricketAnalysisApplication app=new CricketAnalysisApplication();
//		app.loacCSVdataIntoDB();
		SpringApplication.run(CricketAnalysisApplication.class, args);
//		applicationContext=SpringApplication.run(CricketAnalysisApplication.class, args);
//		displayAllBeans();

	}
//	public static void displayAllBeans() {
//		String[] allBeanNames = applicationContext.getBeanDefinitionNames();
//		System.out.println("Beans: ");
//		for(String beanName : allBeanNames) {
//			System.out.println(beanName);
//		}
//	}


}
