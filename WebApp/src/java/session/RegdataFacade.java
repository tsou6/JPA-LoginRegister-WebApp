/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package session;

import ent.Regdata;
import java.util.List;
import javax.ejb.EJBException;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Teo
 */
@Stateless
public class RegdataFacade extends AbstractFacade<Regdata> {
    @PersistenceContext(unitName = "WebAppPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public RegdataFacade() {
        super(Regdata.class);
    }
    
    public void Save(String uname , String email, String pass, String mphone) {
        try{
            Regdata mRegdata = new Regdata(uname, email, pass, mphone);
            em.persist(mRegdata);
       
        }catch(Exception e){
            throw new EJBException(e.getMessage());
            
        }
        
  
    }
    
    
//     public boolean Validate(String email ,String pass) {
//            boolean isPresent = false;
//            String checkpass;
//            
//            try{
//            Regdata a = em.find(Regdata.class, email);
//            System.out.println(a);
//            if(a!= null){
//            if(pass.equals(a.getPass())){
//             isPresent = true;
//             return(isPresent);
//            }
//          }
//            }
//            catch(Exception e){
//            throw new EJBException(e.getMessage());
//            
//        }
//            
//            return(isPresent);
//        
//  
//     }

    
     public int Validate(String username, String password) {
        try {
            Regdata reg = new Regdata(username, password);
            if (em.find(entityClass, username) == null) {
                return 0;//no such value in the base
            } else {
                if (em.find(entityClass, username).getPass().equals(password)) {
                    return 1; //succes
                } else {
                    return 2; //wrong pass
                }
            }
        } catch (Exception e) {
        }
        return 3;//ERROR
    }
}
        

     
 

