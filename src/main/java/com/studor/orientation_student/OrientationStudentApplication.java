package com.studor.orientation_student;

import java.nio.file.Paths;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.studor.orientation_student.manager.service.Implements.WekaClassify;

@SpringBootApplication
public class OrientationStudentApplication {

	public static void main(String[] args) throws Exception {
		SpringApplication.run(OrientationStudentApplication.class, args);
		String projectPath = Paths.get("").toAbsolutePath().toString();
        String trainingDataFile = projectPath + "/data/dataSource.arff";
		WekaClassify.trainModel(trainingDataFile);
	}

}
