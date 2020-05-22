package br.com.gabryel.concessionaria.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import br.com.gabryel.concessionaria.model.Vehicle;
import br.com.gabryel.concessionaria.service.VehicleService;

@Controller
public class VehicleController implements ErrorController {
	
	@Autowired
	private VehicleService vehicleService;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String homePage(final Model model) {
		 
		return "home";
	}
	
	@RequestMapping(value = "/add_vehicle", method = RequestMethod.GET)
	public ModelAndView addVehicle() {	
		
		return new ModelAndView("add_vehicle", "vehicle", new Vehicle());
	}	
	
	@RequestMapping(value = "/add", method = { RequestMethod.GET, RequestMethod.POST} )
    public ModelAndView addVehicle(final Model model, @ModelAttribute("vehicle") Vehicle vehicle, BindingResult result)  {
       
		try {
            if (result.hasErrors()) {        
                return new ModelAndView("error_page");
            }          
          
        	getVehicleService().addOrUpdateVehicle(vehicle);
        	model.addAttribute("status","success");
        	model.addAttribute("message", "<strong>Sucesso! </strong>Veiculo Cadastrado");
           
            return new ModelAndView("add_vehicle", "vehicle", new Vehicle());
			
		} catch (Exception e) {
			System.out.println("erro /add : " + e);
		}
        
        model.addAttribute("status","danger");
        model.addAttribute("message", "<strong>Erro ao salvar!</strong> tente novamente");
        return new ModelAndView("add_vehicle", "vehicle", new Vehicle());
    }
	
	
	@RequestMapping(value = "/list_vehicle", method = RequestMethod.GET)
	public String listVehicle(final Model model) {
		
		model.addAttribute("listVehicles", getVehicleService().listVehicle());		
		return "/list_vehicle";
	}	
	
	@RequestMapping(value = "/remove_vehicle", method = RequestMethod.GET)
	public String deleteVehicle(final Model model, @RequestParam("idVehicle") final String idVehicle ) {
		
		model.addAttribute("status","success");
        model.addAttribute("message", "<strong>Sucesso!</strong> veiculo removido");
		getVehicleService().deleteVehicle(idVehicle);
		return listVehicle(model);
	}	
	
	@RequestMapping(value = "/alter_vehicle", method = RequestMethod.GET)
	public ModelAndView alterVehicle(final Model model, @RequestParam("idVehicle") final String idVehicle ) {
		
		model.addAttribute("alterVehicle", getVehicleService().selectVehicleForId(idVehicle));
		return  addVehicle();
	}	
	
	@RequestMapping("/error")
    public String handleError() {        
		return "error_page";
    } 	
	
	@Override
	public String getErrorPath() {		
		return "/error";
	} 
	
	public VehicleService getVehicleService() {
		return vehicleService;
	}	
}