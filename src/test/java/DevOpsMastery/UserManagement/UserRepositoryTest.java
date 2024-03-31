package DevOpsMastery.UserManagement;


import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import DevOpsMastery.UserManagement.Model.User;
import DevOpsMastery.UserManagement.Repository.UserRepository;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)
public class UserRepositoryTest {
	
	@Autowired private UserRepository repository;
	
	@Test
	public void testAddNew() {
		User user = new User();
		user.setEmail("Billyjean@mail.com");
		user.setPassword("password");
		user.setFirstname("Billy");
		user.setLastname("Jean");
		
		User savedUser = repository.save(user);
		
		Assertions.assertThat(savedUser).isNotNull();
		Assertions.assertThat(savedUser.getId()).isGreaterThan(0);
	}
	
	@Test
	public void testlistAll() {
		Iterable<User> users = repository.findAll();
		Assertions.assertThat(users).hasSizeGreaterThan(0);
		
		for (User user : users) {
			System.out.println(user);
		}
	}

}
