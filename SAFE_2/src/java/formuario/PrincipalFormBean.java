package formuario;

import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import modelo.Usuario;

@ManagedBean
@ViewScoped
public class PrincipalFormBean implements Serializable {

    private Usuario usuLogin=new Usuario();

    public PrincipalFormBean() {
      this.usuLogin = (Usuario) FacesContext.getCurrentInstance()
                .getExternalContext().getSessionMap().get("u1");
        if (this.usuLogin == null) {
            this.usuLogin = new Usuario(0, "No Se encontro Usuario", "","","");
        }
    }

    public Usuario getUsuLogin() {
        return usuLogin;
    }

    public void setUsuLogin(Usuario usuLogin) {
        this.usuLogin = usuLogin;
    }
    
        public void envioSalir() {
        try {
            FacesContext.getCurrentInstance()
                    .getExternalContext().redirect("/SAFE/");
            FacesContext.getCurrentInstance().getExternalContext().getSessionMap().remove("usuario");
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }
        
        
        
    
}
