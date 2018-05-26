package application.trucker.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import application.trucker.entity.Alerts;
import application.trucker.service.RuleService;

@Controller
@ResponseBody
@CrossOrigin
@RequestMapping(path="alerts")
public class AlertController {
	
	@Autowired
	private RuleService ruleService;
	
	@RequestMapping(method = RequestMethod.GET)
	public Iterable<Alerts> getAllAlert(){
		return ruleService.getAllAlert();
	}

	@RequestMapping(method = RequestMethod.GET,value="{vin}")
	public Iterable<Alerts> getAlertByVin(@PathVariable("vin") String vin){
		return ruleService.getAlertByVin(vin);
	}

}
