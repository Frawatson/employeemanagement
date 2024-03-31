package DevOpsMastery.UserManagement.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import DevOpsMastery.UserManagement.Model.User;
import DevOpsMastery.UserManagement.Service.UserNotFoundExeception;
import DevOpsMastery.UserManagement.Service.UserService;


@Controller
public class UserController {
	@Autowired UserService service;
	
    @GetMapping
    public String showHomePage(){
        return "index";
    }
    
    @GetMapping("/user")
    public String showUserList(Model model) {
    	List<User> listUsers = service.findAllUsers();
    	model.addAttribute("listUsers", listUsers);
    	
    	return "users";
    }
    
    @GetMapping("/users/new")
    public String showNewForm(Model model) {
    	model.addAttribute("user", new User());
    	model.addAttribute("pageTitle", "Add New Employee");
    	return "user_form";
    }
    
    @PostMapping("/users/save")
    public String save(User user, RedirectAttributes ra) {
    	service.saveUser(user);
    	ra.addFlashAttribute("message", "Employee Added Successfully.");
    	return "redirect:/user";
    }
    
    @GetMapping("/users/edit/{id}")
    public String showEditForm(@PathVariable("id") Long id, Model model, RedirectAttributes ra) {
    	try {
    		User user = service.get(id);
    		model.addAttribute("user", user);
    		model.addAttribute("pageTitle", "Edit Employee (ID: " + id + ")");
    		return "user_form";
    	} catch (UserNotFoundExeception e) {
    		ra.addFlashAttribute("message",  e.getMessage());
        	return "redirect:/user";
    	}
    	
    }
    
    @GetMapping("/users/delete/{id}")
    public String deleteUser(@PathVariable("id") Long id, Model model, RedirectAttributes ra) {
    	try {
    		service.deleteUser(id);
    		ra.addFlashAttribute("message", "Employee with ID " + id + " has been deleted");
    	} catch (UserNotFoundExeception e) {
    		ra.addFlashAttribute("message", e.getMessage());
        	
    	}
    	return "redirect:/user";
    }

}
