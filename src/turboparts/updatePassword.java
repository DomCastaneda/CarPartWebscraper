/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package turboparts;

/**
 *
 * @author jaepark
 */
public class updatePassword
{
    public String password;
    public String newPassword;
    
    public updatePassword() 
    {
        password = "";
        newPassword = "";
    }
    
    public updatePassword(String password, String newPassword) 
    {
        this.password = password;
        this.newPassword = newPassword;
    }
    public String getPassword() 
    {
        return password;
    }
    public void setPassword(String password) 
    {
        this.password = password;
    }
    public String getNewPassword() 
    {
        return newPassword;
    }
    public void SetNewPassword(String newPassword)
    {
        this.newPassword = newPassword;
    }   
    
}
