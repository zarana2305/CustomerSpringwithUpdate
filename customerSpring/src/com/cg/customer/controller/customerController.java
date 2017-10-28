package com.cg.customer.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.cg.customer.model.Customer;
import com.cg.customer.service.CustomerServiceImpl;
import com.cg.customer.service.ICustomerService;


@Controller
public class customerController {

	@Autowired
	ICustomerService service;
	
	@RequestMapping("/begin")
	public String index(){
		return "index";
	}
	
	@RequestMapping("/start")
	public String goToStart(Model m)// create a model reference
	{
		m.addAttribute("bean",new Customer());//add all the fields and validations 
		//using a single bean reference, which is an obj of cust class
		return "customerRegForm";
	}
	
/*	@RequestMapping("/reg")
	public ModelAndView registration(Customer cust){
		service.addDetails(cust);
		return new ModelAndView("customerSuccess", "k", cust);
	}*/
	
	
	@RequestMapping(value="/reg",method=RequestMethod.POST)
	public ModelAndView addNew(@Valid @ModelAttribute("bean") Customer cust,BindingResult result){
		
		if(result.hasErrors()){
			return new ModelAndView("customerRegForm");
		}
		service.addDetails(cust);
		return new ModelAndView("customerSuccess","k",cust);
		}
	
	
	
	@RequestMapping("/goFind")
	/*public String goToFind(){
		return "custIdFind";}*/
	public ModelAndView goToFind(){
		
		List<Integer> idList= service.retrieveIds();
		return new ModelAndView("custIdFind", "idList", idList);
	}
	
	@RequestMapping("/find")
	public ModelAndView findById(@RequestParam("custId") int custId){
		
		Customer cust = service.retrieveById(custId);
		return new ModelAndView("customerSuccess", "k", cust);
	}
	
	
	@RequestMapping("/goFindAll")
	public ModelAndView findAll(){
		
		List<Customer> custList = service.retrieveDetails();
		return new ModelAndView("customerListSuccess", "list", custList);
	}
	
	
	
	
	@RequestMapping("/goDelete")
	/*public String goToDelete(){
		return "custIdDelete";
	}*/
	
public ModelAndView goToDelete(){
		
		List<Integer> idList= service.retrieveIds();
		return new ModelAndView("custIdDelete", "idList", idList);
	}
	
	
	@RequestMapping("/delete")
	public String deleteById(@RequestParam("custId") int custId){
		//Customer cust = service.retrieveById(custId);
		service.deleteDetails(custId);
		return "deleteCust";
	}
	
	
		@RequestMapping("/goUpdate")
			public ModelAndView goToUpdate(){
				List<Integer> custId=service.retrieveIds();
				return new ModelAndView("custIdUpdate","custId",custId);

			}

			@RequestMapping("/update")
			public String updateById(@RequestParam("custId") int custId,Model m){
				Customer cust = service.retrieveById(custId);
				System.out.println(cust);
				m.addAttribute("customer", cust);
				return "updateRegForm";
			}
			
			@RequestMapping("/doUpdation")
			public String updateDetails(@ModelAttribute("customer") @Valid Customer cust,BindingResult result, Model model){
				
				if(result.hasErrors())
				{
					return "updateRegForm";
				}
				else{
					Customer customer = service.update(cust);
					model.addAttribute("k", customer);
					return "updateSuccess";
				}	 

	
}
}
	
	
