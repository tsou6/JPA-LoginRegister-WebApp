/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package collect;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import session.RegdataFacade;

/**
 *
 * @author Teo
 */
@Named
@RequestScoped

public class Web {
    @EJB
    private RegdataFacade uf;
    private String uname;
    private String email;
    private String pass;
    private String mphone;

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getMphone() {
        return mphone;
    }

    public void setMphone(String mphone) {
        this.mphone = mphone;
    }
    
   public void save(){
       try{
           uf.Save(uname, email, pass, mphone);
       }catch(Exception e){
           
       }
   }
}
