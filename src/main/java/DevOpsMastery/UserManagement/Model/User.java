package DevOpsMastery.UserManagement.Model;

import jakarta.persistence.*;
import org.springframework.lang.NonNull;

@Entity
@Table(name="user_data")
public class User {
    @Id
    @Column(name="user_id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;
    @NonNull

    @Column(length = 15)
    private String password;
    @NonNull
    
    @Column(name="user_email")
    private String Email;
    public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@NonNull

    @Column(name="user_firstname")
    private String firstname;
    @NonNull

    @Column(name="user_lastname")
    private String lastname;
    @NonNull
    
    private boolean enabled;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @NonNull
    public String getEmail() {
        return Email;
    }

    public void setEmail(@NonNull String email) {
        Email = email;
    }

    @NonNull
    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(@NonNull String firstname) {
        this.firstname = firstname;
    }

    @NonNull
    public String getLastname() {
        return lastname;
    }

    public void setLastname(@NonNull String lastname) {
        this.lastname = lastname;
    }

    

	@Override
	public String toString() {
		return "User [id=" + id + ", password=" + password + ", Email=" + Email + ", firstname=" + firstname
				+ ", lastname=" + lastname + "]";
	}

	public User(long id, String password, String email, String firstname, String lastname) {
		super();
		this.id = id;
		this.password = password;
		Email = email;
		this.firstname = firstname;
		this.lastname = lastname;
	}

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	public User(String password, String email, String firstname, String lastname) {
		super();
		this.password = password;
		Email = email;
		this.firstname = firstname;
		this.lastname = lastname;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

    
}
