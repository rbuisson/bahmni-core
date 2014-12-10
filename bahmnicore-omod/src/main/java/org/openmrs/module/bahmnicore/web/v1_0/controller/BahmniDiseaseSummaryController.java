package org.openmrs.module.bahmnicore.web.v1_0.controller;

import org.bahmni.module.bahmnicoreui.contract.DiseaseDataParams;
import org.bahmni.module.bahmnicoreui.contract.DiseaseSummaryData;
import org.bahmni.module.bahmnicoreui.service.BahmniDiseaseSummaryService;
import org.openmrs.module.webservices.rest.web.RestConstants;
import org.openmrs.module.webservices.rest.web.v1_0.controller.BaseRestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping(value = "/rest/" + RestConstants.VERSION_1 + "/bahmnicore/diseaseSummaryData")
public class BahmniDiseaseSummaryController extends BaseRestController {

    @Autowired
    private BahmniDiseaseSummaryService bahmniDiseaseSummaryService;

    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public DiseaseSummaryData getDiseaseSummaryData(@RequestParam(value = "patientUuid") String patientUuid,
                                                    @RequestParam(value = "numberOfVisits") Integer numberOfVisits,
                                                    @RequestParam(value = "obsConcepts") List<String> obsConcepts,
                                                    @RequestParam(value = "drugConcepts") List<String> drugConcepts,
                                                    @RequestParam(value = "labConcepts") List<String> labConcepts ){

        DiseaseDataParams diseaseDataParams = new DiseaseDataParams();
        diseaseDataParams.setNumberOfVisits(numberOfVisits);
        diseaseDataParams.setObsConcepts(obsConcepts);
        diseaseDataParams.setLabConcepts(labConcepts);
        diseaseDataParams.setDrugConcepts(drugConcepts);
        return bahmniDiseaseSummaryService.getDiseaseSummary(patientUuid,diseaseDataParams);
    }
}
