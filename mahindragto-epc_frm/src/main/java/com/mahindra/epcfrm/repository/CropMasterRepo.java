package com.mahindra.epcfrm.repository;


import com.mahindra.epcfrm.entity.CropMasterEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CropMasterRepo extends JpaRepository<CropMasterEntity,Integer> {


}
