package com.example.ipl.CricketAnalysisApplication;

import com.example.ipl.CricketAnalysisApplication.utils.csvFileUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.nio.file.Path;

import static javax.print.attribute.standard.MediaSizeName.C;

@SpringBootApplication
@Slf4j
public class CricketAnalysisApplication {

	public static void main(String[] args) {
//		CricketAnalysisApplication app=new CricketAnalysisApplication();
//		app.loacCSVdataIntoDB();
		SpringApplication.run(CricketAnalysisApplication.class, args);

	}


}
