package com.studor.orientation_student.manager.service;
// import net.sourceforge.tess4j.Tesseract;
// import net.sourceforge.tess4j.TesseractException;

// import java.io.File;

// import org.opencv.core.*;
// import org.opencv.imgcodecs.Imgcodecs;
// import org.opencv.imgproc.Imgproc;
// import org.springframework.stereotype.Service;

// @Service
// public class TextExtractionService {

//     public String extractTextFromImage(String imagePath) {
//         // Chargement de l'image avec OpenCV
//         Mat image = Imgcodecs.imread(imagePath);

//         // Conversion en niveaux de gris
//         Mat grayImage = new Mat();
//         Imgproc.cvtColor(image, grayImage, Imgproc.COLOR_BGR2GRAY);

//         // Amélioration de l'image avec un filtre adaptatif
//         Imgproc.adaptiveThreshold(grayImage, grayImage, 255, Imgproc.ADAPTIVE_THRESH_MEAN_C, Imgproc.THRESH_BINARY, 15, 20);

//         // Enregistrement de l'image temporaire pour Tesseract OCR
//         String tempImagePath = "/src/main/resources/dataProjet/texteExtrait/temp.png";
//         Imgcodecs.imwrite(tempImagePath, grayImage);

//         // Extraction de texte avec Tesseract OCR
//         Tesseract tesseract = new Tesseract();
//         tesseract.setDatapath("/src/main/resources/dataProjet");

//         try {
//             String result = tesseract.doOCR(new File(tempImagePath));
//             return result;
//         } catch (TesseractException e) {
//             e.printStackTrace();
//             return "Erreur lors de l'extraction du texte.";
//         } finally {
//             // Suppression de l'image temporaire
//             File tempImageFile = new File(tempImagePath);
//             tempImageFile.delete();
//         }
//     }
// }


import net.sourceforge.tess4j.ITesseract;
import net.sourceforge.tess4j.Tesseract;

import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;

@Component
public class ImageTextExtractor {
    public String extractTextFromImage(String imagePath)  {

        File imageFile = new File("F:\\orientation_student\\src\\main\\java\\com\\studor\\orientation_student\\ressourcesProjet\\test2.jpeg");
        ClassPathResource resource = new ClassPathResource("src\\main\\java\\com\\studor\\orientation_student\\manager\\service");
        try {
            String absolutePath = resource.getFile().getAbsolutePath();
            System.out.println("==========0000>>>>>Absolute path: " + absolutePath);
        } catch (IOException e) {
             System.out.println("==========||||||||||||>>>>>Absolute path: " );
            e.printStackTrace();
        }
        ITesseract tesseract = new Tesseract();
        tesseract.setDatapath("F:\\orientation_student\\src\\main\\java\\com\\studor\\orientation_student\\ressourcesProjet\\tesstData\\fra.traineddata");

        try {
            String result = tesseract.doOCR(imageFile);
            return result;
        } catch (Exception e) {
            e.printStackTrace();
                    System.out.println("[=============(((((())))))]"+imagePath);

            return null;
        }
    }
}

