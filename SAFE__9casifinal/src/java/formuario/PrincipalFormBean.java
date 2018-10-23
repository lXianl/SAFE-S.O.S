package formuario;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import logica.Triaje;
import modelo.Usuario;

@ManagedBean
@ViewScoped
public class PrincipalFormBean implements Serializable {

    private Usuario usuLogin = new Usuario();
    private List<Triaje> Triaje = new ArrayList<Triaje>();

    public List<Triaje> getTriaje() {
        return Triaje;
    }

    public PrincipalFormBean() {
        this.usuLogin = (Usuario) FacesContext.getCurrentInstance()
                .getExternalContext().getSessionMap().get("u1");
        if (this.usuLogin == null) {
            this.usuLogin = new Usuario(0, "No Se encontro Usuario", "", "", "");
        }

        Triaje.add(new Triaje("AGONIZANDO", "NEGRO", "negrox2"));
        Triaje.add(new Triaje("MURIO", "BLANCO", "blancox2"));
        Triaje.add(new Triaje("AGUANTA", "VERDE", "verdex2"));
        Triaje.add(new Triaje("REANIMACION", "ROJO", "rojox2"));
        Triaje.add(new Triaje("EMERGENCIA", "AMARILLO", "amarillox2"));
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
                    .getExternalContext().redirect("/SAFE__9_1/");
            FacesContext.getCurrentInstance().getExternalContext().getSessionMap().remove("usuario");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
