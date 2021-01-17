package rs.ac.bg.is.fpis.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class DemoController {

	@GetMapping("/")
	public String showHome() {
		
		return "newjsp";
	}
	
	// add request mapping for /leaders

	private static final String JSP_SEARCH_CENOVNIK_AJAX = "/cenovnik/cenovnik-search-ajax";
     private static final String JSP_SEARCH_SPEDITER_AJAX = "/spediter/spediter-search-ajax";


    @GetMapping(path = "/cenovnik")
    public String cenovnik(Model model, @RequestParam(value = "term", required = false) String term) throws Exception {
        model.addAttribute("term", term);
        return JSP_SEARCH_CENOVNIK_AJAX;
    }
    
    @GetMapping(path = "/spediter")
    public String spediter(Model model, @RequestParam(value = "term", required = false) String term) throws Exception {
        model.addAttribute("term", term);
        return JSP_SEARCH_SPEDITER_AJAX;
    }

}










