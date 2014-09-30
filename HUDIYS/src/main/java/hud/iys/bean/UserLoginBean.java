package hud.iys.bean;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.primefaces.event.SelectEvent;
import org.primefaces.event.UnselectEvent;
import org.springframework.dao.DataAccessException;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
 
import org.primefaces.context.RequestContext;

@ManagedBean(name="userLoginMB")
@ViewScoped
public class UserLoginBean implements Serializable {

	 private static final long serialVersionUID = 1L;
	 private static final String SUCCESS = "success";
	 private static final String ERROR   = "error";
	 
	 private String username;
	 private String password;
	 
	 	
	 public String getUsername() {
	 	 return username;
	 }

	 public void setUsername(String username) {
		 this.username = username;
	 }

	 public String getPassword() {
		 return password;
	 }

	 public void setPassword(String password) {
		 this.password = password;
	 }

	 public void login(ActionEvent event) throws IOException{
	        RequestContext context = RequestContext.getCurrentInstance();
	        FacesMessage message = null;
	        boolean loggedIn = false;
	         
	        if(username != null && username.equals("admin") && password != null && password.equals("admin")) {
	            loggedIn = true;
	            FacesContext.getCurrentInstance().getExternalContext().redirect("mevzuatSeti.jsf");
	            message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Welcome", username);
	        } else {
	            loggedIn = false;
	            message = new FacesMessage(FacesMessage.SEVERITY_WARN, "Login Olunamadý!", "Kullanýcý adý veya þifre yanlýþ!");
	        }
	         
	        FacesContext.getCurrentInstance().addMessage(null, message);
	        context.addCallbackParam("loggedIn", loggedIn);
	    }
	 
	 

}