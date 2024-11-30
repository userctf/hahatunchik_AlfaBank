package Alpha_Beta_Gamma_Shtrih.Controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;

@RestController //return with json format
public class KEPController {
    @GetMapping("/get_KEPController")
    public void get_Subscription(String token)
    {   }
}
