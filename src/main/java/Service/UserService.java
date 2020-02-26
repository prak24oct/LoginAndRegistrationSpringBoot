package Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import Model.UserModel;
import Repository.UserRepository;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {
	
	private final UserRepository userRepository;
	
	@Autowired
	public UserService(UserRepository userRepository) {
		this.userRepository=userRepository;
	}
	
	public List<UserModel> findAll(){
		return userRepository.findAll();		
	}
	
   public Optional<UserModel> findById(Long id) {	      
	   return userRepository.findById(id);	   
   }

   public UserModel save(UserModel userModel) {	  
	   return userRepository.save(userModel);	    
   }

    public void deleteById(Long id) {
	    	userRepository.deleteById(id);	
    }
}
