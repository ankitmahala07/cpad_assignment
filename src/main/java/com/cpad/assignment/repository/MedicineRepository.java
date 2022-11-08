package com.cpad.assignment.repository;

import com.arangodb.springframework.annotation.Query;
import com.arangodb.springframework.repository.ArangoRepository;
import com.cpad.assignment.model.Medicine;

import java.util.List;

public interface MedicineRepository extends ArangoRepository<Medicine,String> {

    @Query("FOR doc IN medicines \n" +
            "LET nameToken = TOKENS(doc.name, \"text_en\") \n" +
            "LET queryToken = TOKENS(@query, \"text_en\") \n" +
            "FILTER queryToken ANY IN nameToken \n" +
            "RETURN DISTINCT doc")
    List<Medicine> searchMedicines(String query);

}
