package org.depinfo.testsexercice1;

import android.content.Context;

import androidx.room.Room;
import androidx.test.core.app.ApplicationProvider;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import org.depinfo.testsexercice1.bd.BD;
import org.depinfo.testsexercice1.modele.Personne;
import org.depinfo.testsexercice1.service.ServiceImplementation;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;


@RunWith(AndroidJUnit4.class)
public class ApplicationTests {

    private BD bd;
    private ServiceImplementation service;

    // S'exécute avant chacun des tests. Crée une BD en mémoire
    @Before
    public void createDb() {
        Context context = ApplicationProvider.getApplicationContext();
        bd = Room.inMemoryDatabaseBuilder(context, BD.class).build();
        service = ServiceImplementation.getInstance(bd);
    }


    @Test
    public void ajoutPersonneOKBD() {
        Personne personne = new Personne();
        personne.nomPersonne = "Maudie";
        personne.agePersonne = 24;
        personne.adressePersonne = "1234 De la Mortagne MTL CA";
        bd.monDao().insertPersonne(personne);
        Assert.assertNull(personne.idPersonne);
    }


    @Test
    public void ajoutPersonneKOService() throws Exception {
        Personne personne = new Personne();
        personne.nomPersonne = "Maudie";
        personne.agePersonne = 24;
        personne.adressePersonne = "1234 De la Mortagne MTL CA";
        service.ajouterPersonne(personne);
        Assert.assertNotNull(personne.idPersonne);
    }

    @Test
    public void validePostal() {
        Assert.assertTrue(service.isValidZipCode("H1Y 1E1"));

    }


}