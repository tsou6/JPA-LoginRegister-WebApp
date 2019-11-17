/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ent;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Teo
 */
@Entity
@Table(name = "regdata")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Regdata.findAll", query = "SELECT r FROM Regdata r"),
    @NamedQuery(name = "Regdata.findByUname", query = "SELECT r FROM Regdata r WHERE r.uname = :uname"),
    @NamedQuery(name = "Regdata.findByEmail", query = "SELECT r FROM Regdata r WHERE r.email = :email"),
    @NamedQuery(name = "Regdata.findByPass", query = "SELECT r FROM Regdata r WHERE r.pass = :pass"),
    @NamedQuery(name = "Regdata.findByMphone", query = "SELECT r FROM Regdata r WHERE r.mphone = :mphone")})
public class Regdata implements Serializable {
    private static final long serialVersionUID = 1L;
    @Size(max = 40)
    @Column(name = "uname")
    private String uname;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "email")
    private String email;
    @Size(max = 40)
    @Column(name = "pass")
    private String pass;
    @Size(max = 40)
    @Column(name = "mphone")
    private String mphone;

    public Regdata() {
    }
    
    public Regdata(String uname , String email, String pass, String mphone) {
        
        this.uname = uname; 
        this.email = email;
        this.pass = pass;
        this.mphone = mphone;
    }
    
    public Regdata(String email, String pass) {
        
        this.uname = uname; 
        this.email = email;
        this.pass = pass;
        this.mphone = mphone;
    }
    

    public Regdata(String email) {
        this.email = email;
    }

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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (email != null ? email.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Regdata)) {
            return false;
        }
        Regdata other = (Regdata) object;
        if ((this.email == null && other.email != null) || (this.email != null && !this.email.equals(other.email))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ent.Regdata[ email=" + email + " ]";
    }
    
}
