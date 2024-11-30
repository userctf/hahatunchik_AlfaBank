package Alpha_Beta_Gamma_Shtrih.Model;

import java.util.List;

public class Profile {
    private String name;
    
    private int clientId;
    private int organizationId;
    private String segment;
    private String role;
    private int organizations;
    private String currentMethod;
    private boolean mobileApp;
    private int[][] signatures;
    private int[] common;
    private int[] special;
    private String[] availableMethods;
    private int claims;
    
    public Profile(){}
    public Profile(String name, int client, int organization, String segment, String role, int organizations, String currentMethod, boolean mobileApp,
            int[][] signatures, String[] availableMethods, int claims)
    {
        this.name = name;
        
        this.clientId = client;
        this.organizationId = organization;
        this.organizationId = client;
        this.segment = segment;
        this.role = role;
        this.organizations = organizations;
        this.mobileApp = mobileApp;
        this.signatures = signatures;
        this.common = this.signatures[0];
        this.special = this.signatures[1];
        this.availableMethods = availableMethods;
        this.claims = claims;
        
    }
    
}


