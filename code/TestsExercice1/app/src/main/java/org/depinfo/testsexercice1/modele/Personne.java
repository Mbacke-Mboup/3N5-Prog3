package org.depinfo.testsexercice1.modele;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Personne {
    @PrimaryKey(autoGenerate = true)
    public Long idPersonne;

    public String nomPersonne;

    public int agePersonne;

    public String adressePersonne;
}
