package Alpha_Beta_Gamma_Shtrih.TestController;

import org.springframework.web.bind.annotation.RestController;
import Alpha_Beta_Gamma_Shtrih.Model.Profile;
import Alpha_Beta_Gamma_Shtrih.Model.User;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RestController //return with json format
public class TestController {
    public TestController(){}
    public void create_new_profile(String doc_type, int client, 
            int organization, String segment, String role, 
            int organizations, String currentMethod, boolean mobileApp,
            int[][] signatures, String[] availableMethods, int claims)
    {
        //set data to bd
    }
    
    private void set_profile(Profile Profile)
    {
        //get data from bd
    }
    
    @GetMapping("/user")
    public List<User> getUser(@RequestParam String name) {
        return List.of(new User(name, 15),
                new User(name, 2),
                new User(name, 134));
    }
    
    @GetMapping("/person")
    public List<Profile> get_profiles()
    {
        System.out.print("In ProfileController!");
        Profile Profile0 = new Profile();
        this.set_profile(Profile0);
        Profile Profile1 = new Profile();
        this.set_profile(Profile1);
        Profile Profile2 = new Profile();
        this.set_profile(Profile2);
        
        return List.of(Profile0,Profile1,Profile2);
                
       
    }
    
}