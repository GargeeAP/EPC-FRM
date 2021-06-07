package com.mahindra.epcfrm.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import com.mahindra.epcfrm.entity.WorkOrderMasterEntity;

public interface WorkOrderMasterRepo extends JpaRepository<WorkOrderMasterEntity,Integer> {

	Optional<WorkOrderMasterEntity> findByLeadId(int leadId);
}
