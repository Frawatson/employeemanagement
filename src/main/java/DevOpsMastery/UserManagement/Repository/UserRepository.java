package DevOpsMastery.UserManagement.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import DevOpsMastery.UserManagement.Model.User;



public interface UserRepository extends JpaRepository <User, Long>{
	public Long countById(Long id);
}
