package com.kinotech.projectfb;

import com.facebook.ads.sdk.APIContext;
import com.facebook.ads.sdk.APINodeList;
import com.facebook.ads.sdk.AdAccount;
import com.facebook.ads.sdk.AdAccountUser;
import com.facebook.ads.sdk.Campaign;

/**
 *
 * @author 21stking
 */
public class TestFBJavaSDK
{
    public static final APIContext context = new APIContext(
            "{access-token}",
            "{app-secrete}"
    );
    public static void main(String[] args)
    {
        AdAccount account = new AdAccount("26429236", context);
        
        try {
            //APINodeList<Campaign> campaigns = account.getCampaigns().requestAllFields().execute();
            APINodeList<Campaign> campaigns = account.getCampaigns().requestNameField().execute(); 
            for(Campaign campaign : campaigns) {
                System.out.println("Campaign Name: "+campaign.getFieldName());
            }
            
            APINodeList<AdAccountUser> users  = account.getUsers().requestNameField().execute();
            for(AdAccountUser user : users) {
                System.out.println("Ad Account User: "+user.getFieldName());
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }}
