package com.mahindra.epcfrm.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import com.mahindra.epcfrm.entity.PostSalesActMasterEntity;

public interface PostSalesActMasterRepo extends JpaRepository<PostSalesActMasterEntity, Integer> {
	
	Optional<PostSalesActMasterEntity> findByLeadId(int leadId);

}
