package com.cpad.assignment.repository;

import com.arangodb.springframework.annotation.Query;
import com.arangodb.springframework.repository.ArangoRepository;
import com.cpad.assignment.model.Medicine;

import java.util.List;

public interface MedicineRepository extends ArangoRepository<Medicine,String> {

    @Query("FOR doc IN #COLLECTION \n"+
    "FILTER doc.name like '%@query%' \n"+
    "RETURN doc")
    List<Medicine> searchMedicines(String query);

}
