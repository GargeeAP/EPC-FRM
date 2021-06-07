package com.mahindra.epcfrm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.mahindra.epcfrm.entity.StateMasterEntity;
import org.springframework.stereotype.Repository;

@Repository
public interface StateMasterRepo extends JpaRepository<StateMasterEntity,Integer>{

}
