package com.studor.orientation_student.manager.service.nouriture;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.studor.orientation_student.entities.nutritionEntities.DataNutrition;
import com.studor.orientation_student.manager.service.suggestionCour.GetAbsoluePath;


public class DataNutritionGeneration {
    public List<DataNutrition> generateRandomData(int count) {
        Random random = new Random();
        List<DataNutrition> dataList = new ArrayList<>();
        List<String> nomrepas1 = new ArrayList<>();
        List<String> nomrepas2 = new ArrayList<>();
        List<String> nomrepas3 = new ArrayList<>();
        List<String> nom = new ArrayList<>();
        List<String> symptoms = new ArrayList<>();

        nomrepas1.add("asperges_grillées");
        nomrepas1.add("poulet_rôti");
        nomrepas1.add("légumes_sautés");
        nomrepas1.add("riz_basmati");
        nomrepas1.add("spaghetti_bolognaise");
        nomrepas1.add("salade_verte");
        nomrepas1.add("pain_à_l_ail");
        nomrepas1.add("saumon_grillé");
        nomrepas1.add("purée_de_pommes_de_terre");
        nomrepas1.add("koki");
        nomrepas1.add("eru");

        nomrepas2.add("asperges_grillées");
        nomrepas2.add("poulet_rôti");
        nomrepas2.add("légumes_sautés");
        nomrepas2.add("riz_basmati");
        nomrepas2.add("spaghetti_bolognaise");
        nomrepas2.add("salade_verte");
        nomrepas2.add("pain_à_l_ail");
        nomrepas2.add("saumon_grillé");
        nomrepas2.add("purée_de_pommes_de_terre");
        nomrepas2.add("koki");
        nomrepas2.add("eru");

        nomrepas3.add("asperges_grillées");
        nomrepas3.add("poulet_rôti");
        nomrepas3.add("légumes_sautés");
        nomrepas3.add("riz_basmati");
        nomrepas3.add("spaghetti_bolognaise");
        nomrepas3.add("salade_verte");
        nomrepas3.add("pain_à_l_ail");
        nomrepas3.add("saumon_grillé");
        nomrepas3.add("purée_de_pommes_de_terre");
        nomrepas3.add("koki");
        nomrepas3.add("eru");

        nom.add("Gastro_entériteastro_entérite");
        nom.add("Grippe");
        nom.add("Rhume");
        nom.add("Sinusite");
        

        symptoms.add("nausées");
        symptoms.add("toux");
        symptoms.add("maux_de_ventre");
        symptoms.add("eternuements");
        symptoms.add("mal_de_gorge");
        symptoms.add("fatigue");
        symptoms.add("congestion_nasale");
        symptoms.add("douleur_faciale");
        symptoms.add("maux_de_tête");
        symptoms.add("fièvre");
        symptoms.add("diarrhée");
        symptoms.add("vomissements");

        for (int i = 0; i < count; i++) {
            DataNutrition data = new DataNutrition();
            data.setNomrepas1(getRandomValue(nomrepas1));
            data.setNomrepas2(getRandomValue(nomrepas2));
            data.setNomrepas3(getRandomValue(nomrepas3));
            data.setNom(getRandomValue(nom));
            data.setSymptoms(getRandomValue(symptoms));
            dataList.add(data);
        }

        return dataList;
    }

    private String getRandomValue(List<String> values) {
        Random random = new Random();
        int index = random.nextInt(values.size());
        return values.get(index);
    }

    public void writeARFFFile(List<DataNutrition> dataList, int numFile) throws IOException {
        GetAbsoluePath getAbsoluePath = new GetAbsoluePath();
        String path = getAbsoluePath.getAbsolutePathOfFile();
        if (numFile == 1)
            path = path + "/data/nutritionData/dataNutritionForTrainning.arff";
        if (numFile == 0)
            path = path + "/data/nutritionData/dataNutritionprediction.arff";

        FileWriter writer = new FileWriter(path);

        writer.write("@relation MaladiesPredicion\n\n");
        writer.write("@attribute nomrepas1{poulet_rôti,légumes_sautés,riz_basmati,spaghetti_bolognaise,salade_verte,pain_à_l_ail,saumon_grillé,purée_de_pommes_de_terre,asperges_grillées,koki,eru}\n");
        writer.write("@attribute nomrepas2{poulet_rôti,légumes_sautés,riz_basmati,spaghetti_bolognaise,salade_verte,pain_à_l_ail,saumon_grillé,purée_de_pommes_de_terre,asperges_grillées,koki,eru}\n");
        writer.write("@attribute nomrepas3{poulet_rôti,légumes_sautés,riz_basmati,spaghetti_bolognaise,salade_verte,pain_à_l_ail,saumon_grillé,purée_de_pommes_de_terre,asperges_grillées,koki,eru}\n");
        writer.write("@attribute symptoms{toux,eternuements,mal_de_gorge,fatigue,congestion_nasale,douleur_faciale,maux_de_tête,fièvre,diarrhée,vomissements,nausées,maux_de_ventre}\n");
        writer.write("@attribute nommaladie{Grippe,Rhume,Sinusite,Gastro_entériteastro_entérite}\n\n");
        writer.write("@data\n");

        for (DataNutrition data : dataList) {
            writer.write(data.getNomrepas1() + ",");
            writer.write(data.getNomrepas2() + ",");
            writer.write(data.getNomrepas3() + ",");
            writer.write(data.getSymptoms() + ",");
            writer.write(data.getNom() + "\n");
        }

        writer.close();
    }
}
