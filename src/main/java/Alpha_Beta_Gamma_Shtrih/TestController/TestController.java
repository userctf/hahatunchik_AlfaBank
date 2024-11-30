package Alpha_Beta_Gamma_Shtrih.TestController;

import org.springframework.web.bind.annotation.RestController;
import Alpha_Beta_Gamma_Shtrih.Model.Profile;
import java.util.List;

@RestController //return with json format
public class TestController {
    public TestController(){}
    
    private void set_profile(Profile Profile)
    {
        //get data from bd
    }
    
    public List<Profile> get_profiles()
    {
        System.out.print("In ProfileController!");
        Profile Profile0 = new Profile();
        this.set_profile(Profile0);
        
        return List.of
        (
                Profile0
                
        );
    }
    
}