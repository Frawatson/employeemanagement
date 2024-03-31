package DevOpsMastery.UserManagement.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import DevOpsMastery.UserManagement.Model.User;
import DevOpsMastery.UserManagement.Repository.UserRepository;

@Service
public class UserService {
	
	@Autowired UserRepository repository;
	
	public User saveUser (User user) {
		return repository.save(user);
	}
	
	public List<User> findAllUsers(){
		return repository.findAll();
	}
	
	public User updateUser(User user) {
		return repository.save(user);
	}
	
	public User get(long id) throws UserNotFoundExeception {
		Optional<User> result = repository.findById(id);
		if (result.isPresent()) {
			return result.get();
		}
		throw new UserNotFoundExeception("Employee with id: " + id + " not found.");
	}
	
	public void deleteUser(long id) throws UserNotFoundExeception {
		Long count = repository.countById(id);
		if (count == null || count == 0) {
			throw new UserNotFoundExeception("Employee with id: " + id + " not found.");
		}
		repository.deleteById(id);
	}

}
