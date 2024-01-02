package com.studor.orientation_student.manager.service.suggestionCour;

import weka.core.Instances;
import weka.core.Attribute;
import weka.core.DenseInstance;
import weka.core.converters.ConverterUtils.DataSource;
import weka.classifiers.trees.J48;
import weka.classifiers.Classifier;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class SuggestionService {
    private Classifier modele;

    public SuggestionService() {
        try {
            // Chargez les données d'entraînement à partir d'un fichier ou d'une source de données
            DataSource source = new DataSource("data.arff");
            Instances instances = source.getDataSet();
            instances.setClassIndex(instances.numAttributes() - 1);

            // Créez un classifieur, par exemple, un arbre de décision J48
            modele = new J48();
            modele.buildClassifier(instances);
        } catch (Exception e) {
            // Gérez les exceptions appropriées
        }
    }

    public List<String> suggererProduits(String clientId, List<String> produitsAchetes) {
        // Supposez que vous avez déjà le modèle entraîné (this.modele) à partir des données d'entraînement

        // Créez une instance pour chaque exemple
        Instances instance = new Instances(instances, 0);
        Attribute clientIdAttr = new Attribute("clientId");
        Attribute produitsAchetesAttr = new Attribute("produitsAchetes");

        // Créez l'instance pour le nouveau client et ses produits achetés
        DenseInstance newClientInstance = new DenseInstance(2);
        newClientInstance.setValue(clientIdAttr, clientId);
        newClientInstance.setValue(produitsAchetesAttr, produitsAchetes.toString());

        // Faites la prédiction
        try {
            double prediction = modele.classifyInstance(newClientInstance);
            // Retournez les produits suggérés sur la base de la prédiction
            // ...
        } catch (Exception e) {
            // Gérez les exceptions appropriées
        }

        return null; // Remplacez null par la liste des produits suggérés
    }
}

