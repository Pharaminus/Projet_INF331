// package com.studor.orientation_student.manager.controller;



// import java.io.IOException;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.web.bind.annotation.PostMapping;
// import org.springframework.web.bind.annotation.RequestBody;
// import org.springframework.web.bind.annotation.RestController;

// import com.studor.orientation_student.manager.service.ImageTextExtractor;

// @RestController
// public class TextExtractionController {

//     @Autowired
//     private ImageTextExtractor textExtractor;

//     @PostMapping("/extract")
//     public String extractText(@RequestBody String imagePath)  {

//         String extractedText = textExtractor.extractTextFromImage(imagePath);
//         System.out.println("(=========>)"+imagePath + " "+ extractedText);
//         return extractedText;
//     }
// }
