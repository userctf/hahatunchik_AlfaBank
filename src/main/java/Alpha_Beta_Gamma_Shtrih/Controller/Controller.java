package Alpha_Beta_Gamma_Shtrih.Controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.GetMapping;
import Alpha_Beta_Gamma_Shtrih.Model.CheckSignIn;
import Alpha_Beta_Gamma_Shtrih.Model.CheckSignOut;
import Alpha_Beta_Gamma_Shtrih.Model.Profile;
import Alpha_Beta_Gamma_Shtrih.Model.SignMethodIn;
import Alpha_Beta_Gamma_Shtrih.Model.SignMethodOut;
import java.util.List;
import java.util.ArrayList;

@RestController //return with json format
public class Controller {
    public Controller(){}
    
    private List<Integer> available_options = List.of(0,1,2,3);
    private int recomended_subscription=1;
    int[] arr_of_available_options;
    
    @GetMapping("/get_sign_method")
    public int[] get_sign_method(@RequestParam SignMethodIn SignMethodIn)
    {
        //starting ML
        
        System.out.print("starting ML");
        this.available_options.remove(Integer.valueOf(this.recomended_subscription));
        this.available_options.set(0,this.recomended_subscription);
        if (SignMethodIn.getAge() != "special")
        {
            this.available_options.remove(Integer.valueOf(2));
            this.available_options.remove(Integer.valueOf(3));
        }
        for (Integer i : available_options)
        {
            arr_of_available_options[0] = this.available_options.get(i);
        }
           
        return arr_of_available_options;
    }
    
    @GetMapping("/check_sign")
    public CheckSignOut check_sign(@RequestParam CheckSignIn CheckSignIn)
    {
        System.out.print("OK");
        return new CheckSignOut("OK");
    }
    
    
    
}
