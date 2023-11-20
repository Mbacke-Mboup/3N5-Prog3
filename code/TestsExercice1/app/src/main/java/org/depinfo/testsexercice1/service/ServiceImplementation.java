package org.depinfo.testsexercice1.service;

import org.depinfo.testsexercice1.bd.BD;
import org.depinfo.testsexercice1.modele.Personne;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ServiceImplementation {

    private static ServiceImplementation single_instance = null;
    private BD maBD;

    private ServiceImplementation(BD maBD) {
        this.maBD = maBD;
    }

    public static ServiceImplementation getInstance(BD maBD) {
        if (single_instance == null) single_instance = new ServiceImplementation(maBD);

        return single_instance;
    }


    public void ajouterPersonne(Personne personne) throws Exception {
        // Ajout
        if(personne.idPersonne != null) throw new Exception();
        personne.idPersonne = maBD.monDao().insertPersonne(personne);
    }

    public boolean isValidZipCode(String code){
        if(code.length() > 6){
            return false;
        }
        if(code.contains(" ")){
            List<String> codes = new ArrayList<>(Arrays.asList(code.split(" ")));
            if(codes.size() < 2){
                return false;
            }
            if(!code.endsWith("8")){
                return false;
            }
            return true;
        }
        return false;

    }
}
