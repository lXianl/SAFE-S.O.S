/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package formulario;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import logica.ServicioUsuario;
import modelo.Usuario;

/**
 *
 * @author admin
 */
public class LoginFormBean {

    private Usuario usuLogin = new Usuario();

    private String usuario;
    private String contraseña;
    private ServicioUsuario servicioUsuario;

    public LoginFormBean() {
        this.servicioUsuario = new ServicioUsuario();
        FacesContext.getCurrentInstance().getExternalContext().getSessionMap().clear();
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void validarUsuario() {
        try {
            Usuario u1 = this.servicioUsuario.getUsuario(this.usuario, this.contraseña);
            if (u1 != null) {
                FacesContext.getCurrentInstance()
                        .getExternalContext().redirect("./faces/principal.xhtml");
                FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("u1", u1);
            } else {
                FacesContext.getCurrentInstance()
                        .addMessage(null,
                                new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "Usuario no encontrado."));

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
