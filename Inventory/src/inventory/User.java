/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inventory;


/**
 *
 * @author Jovani
 */
public class User 
{
    private Role role;
    private String Username;
    private String Password;

    public User(String Username, String Password, String RoleSelect) 
    {
      this.role = Role.valueOf(RoleSelect);
      this.Username = Username;
      this.Password = Password;
    }

    public Role getRole() {
        return role;
    }

    public String getUsername() {
        return Username;
    }

    public String getPassword() {
        return Password;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public void setUsername(String Username) {
        this.Username = Username;
    }

    public void setPassword(String Password) {
        this.Password = Password;
    }
    
    
    
    
}
