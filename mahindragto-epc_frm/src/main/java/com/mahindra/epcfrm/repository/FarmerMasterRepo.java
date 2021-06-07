package com.mahindra.epcfrm.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.mahindra.epcfrm.dto.GetLeadNamesResponseDto;
import com.mahindra.epcfrm.entity.FarmerMasterEntity;

@Repository
public interface FarmerMasterRepo extends JpaRepository<FarmerMasterEntity, Integer> {

	/*
	 * @Query("select f  from FarmerMasterEntity f where f.firstName like :name% and createdBy =:createdBy"
	 * ) List<GetLeadNamesResponseDto> findByFirstName(String name,String
	 * createdBy);
	 */
	Optional<FarmerMasterEntity> findByLeadId(int leadId);
	
	@Query("select new com.mahindra.epcfrm.dto.GetLeadNamesResponseDto(f.firstName,f.lastName,f.faMobile)  from FarmerMasterEntity f where f.firstName like :name% and createdBy =:createdBy")
	List<GetLeadNamesResponseDto> findByFirstName(String name,String createdBy);
}
