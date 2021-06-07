package com.mahindra.epcfrm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.mahindra.epcfrm.entity.LeadMasterEntity;
import java.util.List;
import javax.transaction.Transactional;



@Repository
public interface LeadMasterRepo extends JpaRepository<LeadMasterEntity, Integer> {

	
	
	List<LeadMasterEntity> findByUserMobile(String userMobile);
	
	@Modifying
	@Query("UPDATE LeadMasterEntity l SET  l.formStatus=:formStatus Where l.id= :leadId")
	@Transactional
	void updateFormStatus(String formStatus,int leadId);
	
	@Query("SELECT l FROM LeadMasterEntity l  Where l.userMobile= :userMobile ORDER BY l.createdOn ASC")
	List<LeadMasterEntity> findByUserMobileAndAscOrder(String userMobile);
	
	
	@Query("SELECT l FROM LeadMasterEntity l  Where l.userMobile= :userMobile ORDER BY l.createdOn DESC")
	List<LeadMasterEntity> findByUserMobileAndDescOrder(String userMobile);
	
	
	//@Query("SELECT l FROM LeadMasterEntity l where l.workOrderStatus ='WoPending' or l.kycStatus ='KycPending' or l.quotationStatus = 'QuPending'")
	//List<LeadMasterEntity> findLeads();
	
	
}
