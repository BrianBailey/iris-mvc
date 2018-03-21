package com.example.irismvc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class IrisMvcApplication {
	public static String makeCapital(String name){
		return name.toUpperCase();
	}

	private static final String SAMPLE_CSV_FILE_PATH = "C:\\stocks\\csv-capstone-db\\data\\iris.csv";

	private static final String SAMPLE_CSV_FILE = "C:\\stocks\\csv-capstone-db\\data\\3-17-2018-results.csv";



	public static void main(String[] args) {
		SpringApplication.run(IrisMvcApplication.class, args);





	}
}
