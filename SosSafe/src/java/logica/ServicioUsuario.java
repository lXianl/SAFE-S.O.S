/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import modelo.Usuario;
import org.hibernate.Session;

/**
 *
 * @author admin
 */
public class ServicioUsuario implements Serializable{
    
    
    private Session sessionDb;

    public ServicioUsuario() {
        this.sessionDb = NewHibernateUtil.getSessionFactory().openSession();
    }

    public Boolean isExisteUsuario(String nombre, String clave) {
        Boolean isExiste = Boolean.FALSE;
        try {
            List<Usuario> lista = new ArrayList<>();
            String hql = "SELECT t FROM Usuario t ";
            lista = this.sessionDb.createQuery(hql).list();
            for (Usuario usuario : lista) {
                if (usuario.getUsuariocol().equals(nombre) && usuario.getContrasena().equals(clave)) {
                    isExiste = Boolean.TRUE;
                    break;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            isExiste = Boolean.FALSE;
        }
        return isExiste;
    }

    public Usuario getUsuario(String codigo, String contrasena) {
        Usuario usuarioRetorno = null;
        try {
            List<Usuario> lista = new ArrayList<>();
            String hql = "SELECT t FROM Usuario t ";
            lista = this.sessionDb.createQuery(hql).list();
            for (Usuario usuario : lista) {
                if (usuario.getUsuariocol().equals(codigo) 
                        && usuario.getContrasena().equals(contrasena)) {
                    usuarioRetorno = usuario;
                    break;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            usuarioRetorno = null;          
            
        }
        return usuarioRetorno;
    }
    
}
