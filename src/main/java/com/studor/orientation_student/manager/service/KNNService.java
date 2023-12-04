// package com.studor.orientation_student.manager.service;

// // import java.util.Arrays;
// // import java.util.List;

// // import org.netlib.util.doubleW;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.stereotype.Service;

// // import com.studor.orientation_student.entity.Profil;
// // import com.studor.orientation_student.manager.repository.ProfilRepository;

// import weka.classifiers.lazy.IBk;
// // import weka.core.Attribute;
// // import weka.core.DenseInstance;
// // import weka.core.Instance;
// import weka.core.Instances;
// import weka.core.converters.ConverterUtils.DataSource;

// @Service
// public class KNNService {

//     @Autowired
//     // private ProfilRepository profilRepo;

//     public Instances loadARFFData(String filepath) throws Exception
//     {
//         DataSource source = new DataSource(filepath);
//         Instances data = source.getDataSet();

//         //Set the class index
//         data.setClassIndex(data.numAttributes() -  1);
//         return data;
//     }

//     public Instances loadDBData()
//     {
//         // List<Profil> profils = profilRepo.findAll();

//         //// Create attributes for the instances object
//         // Attribute notes = new Attribute("notes");
//         // Attribute jobs = new Attribute("jobs");
//         // Attribute category = new Attribute("category");
//         // Attribute mean = new Attribute("mean");

//         //Create the Instance object with the attributes
//         // Instances data = new Instances("Data", Arrays.asList(notes, jobs, category, mean), profils.size());

//         // //Set the class attributes
//         // data.setClassIndex(data.numAttributes() -1);
//         //Add instances to the dataset
//         // for (Profil profil : profils)
//         // {
//         //     Instance instance = new DenseInstance(data.numAttributes());

//         //     instance.setValue(notes, profil.getNotesReport().getMatiere().get(0).getNotes());
//         //     instance.setValue(jobs, profil.getJobs().getNom());
//         //     instance.setValue(category, profil.getCategory().getNom());
//         //     instance.setValue(mean, profil.getNotesReport().getMoyenne());

//              // data.add(instance);
//         // }
//         // return data;
//         return null;
//     }

//     public Instances combineData(Instances arffData, Instances dbData)
//     {
//         Instances combinedData = new Instances(arffData, 0);
//         for (int i = 0; i < dbData.numInstances(); i++){
//             combinedData.add(dbData.instance(i));
//         }
//         return combinedData;
//     }

//     public IBk trainModel(Instances data) throws Exception
//     {
//         IBk classifier = new IBk();

//         //Set the value of k
//         int k = 4;
//         classifier.setKNN(k);

//         //Train the classifier
//         classifier.buildClassifier(data);
//         return classifier;
//     }

//     public void classifierARFFData(IBk classifier, Instances arffData) throws Exception
//     {
//         for (int i = 0; i <arffData.numInstances(); i++)
//         {
//             double predictedClass = classifier.classifyInstance(arffData.instance(i));
//             String predictedClassName = arffData.classAttribute().value((int)predictedClass);
//             System.out.println("Instance "+i+": Predicted class - "+predictedClassName);
//         }
//     }
// }
