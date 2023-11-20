package org.depinfo.testsexercice1.bd;

import androidx.room.Dao;
import androidx.room.ForeignKey;
import androidx.room.Insert;

import org.depinfo.testsexercice1.modele.Personne;

@Dao
public interface MonDao {

    @Insert

    Long insertPersonne(Personne p);
}
