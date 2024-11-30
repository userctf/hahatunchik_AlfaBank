package Alpha_Beta_Gamma_Shtrih.Controller;

import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import java.util.ArrayList;

@RestController //return with json format
public class Controller {
    public Controller(){}
    
    private List<Integer> available_options = List.of(0,1,2,3);
    private int recomended_subscription;
    int[] arr_of_available_options;
    
    public int[] get_recomended_subscription(String doc_type, int client, 
            int organization, String segment, String role, 
            int organizations, String currentMethod, boolean mobileApp,
            int[][] signatures, String[] availableMethods, int claims)
    {
        //starting ML
        
        this.available_options.remove(Integer.valueOf(this.recomended_subscription));
        this.available_options.set(0,this.recomended_subscription);
        if (doc_type != "special")
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
    
    public int select_medod(String metod)
    {
        int token = 1;
        
        return token;
    }
    
}
