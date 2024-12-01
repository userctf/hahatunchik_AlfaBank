package Alpha_Beta_Gamma_Shtrih.Controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;

@RestController //return with json format
public class AppController {
    AppController(){}
    @GetMapping("/get_AppController")
    public void get_Subscription()
    {System.out.print("Done!");}
}
