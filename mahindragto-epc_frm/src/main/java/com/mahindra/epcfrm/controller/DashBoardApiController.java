package com.mahindra.epcfrm.controller;

import javax.servlet.http.HttpSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.mahindra.epcfrm.dto.ActivityRequestDto;
import com.mahindra.epcfrm.dto.CreateUpdateRespDto;
import com.mahindra.epcfrm.dto.DashBoardCountRequestDto;
import com.mahindra.epcfrm.dto.DeleteActivityDto;
import com.mahindra.epcfrm.dto.GetActivityDto;
import com.mahindra.epcfrm.dto.GetLeadNamesDto;
import com.mahindra.epcfrm.dto.MasterResponseDto;
import com.mahindra.epcfrm.service.DashBoardApiService;

@RestController
@RequestMapping("/epc/")
public class DashBoardApiController {

	Logger log = LoggerFactory.getLogger(DashBoardApiController.class);

	@Autowired
	DashBoardApiService dashboardService;

	@GetMapping(value = "getCountOnStatus")
	public MasterResponseDto getCountOnStatus() throws Exception {
		log.info("request processing of getCountOnStatus in dashBoardController");
		return dashboardService.getCountsOnStatus();
	}

	@PostMapping(value = "getLeadsOnPenStatus")
	public MasterResponseDto getLeadsOnPenStatus(@RequestBody DashBoardCountRequestDto reqDto) throws Exception {
		log.info("request processing of getLeadsOnPenStatus in dashBoardController");
		return dashboardService.getListOfPendingLeads(reqDto);
	}

	@PostMapping("/createUpdateActivity")
	public CreateUpdateRespDto createUpdateActivity(@RequestBody ActivityRequestDto actReqDto, HttpSession session) {
		log.info("request processing of createUpdateActivity");
		return dashboardService.createUpdateActivity(actReqDto, session);
	}

	@PostMapping("/getActivity")
	public MasterResponseDto getActivity(@RequestBody GetActivityDto dto, HttpSession session) {
		log.info("request processing of getActivity");
		return dashboardService.getActivity(dto.getDate(), session);
	}

	@PostMapping("/getLeadNames")
	public MasterResponseDto getLeadNames(@RequestBody GetLeadNamesDto leadNameDto, HttpSession session) {
		log.info("request processing of getLeadNames");
		return dashboardService.leadSearchForActivity(leadNameDto.getLeadName(), session);
	}

	@PostMapping("/deleteActivity")
	public MasterResponseDto deleteActivity(@RequestBody DeleteActivityDto delDto) {
		log.info("request processing of deleteActivity");
		return dashboardService.deleteActivity(delDto.getId());
	}

}
