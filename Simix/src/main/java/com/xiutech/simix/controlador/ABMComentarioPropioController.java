package com.xiutech.simix.controlador;

import com.xiutech.simix.modelo.Comentario;
import com.xiutech.simix.modelo.ComentarioDAO;
import com.xiutech.simix.modelo.ComentarioId;
import com.xiutech.simix.modelo.Comentarista;
import com.xiutech.simix.modelo.ComentaristaDAO;
import com.xiutech.simix.modelo.Marcador;
import com.xiutech.simix.modelo.MarcadorDAO;

import java.util.Date;
import javax.faces.bean.ManagedBean;
//No sabemos si lo necesitamos
import javax.faces.bean.RequestScoped;

/** Clase del controlador para comentario
 *  Se Agregara, Borrará y modificará un comentario.
 * @author Ummyers
 */

@ManagedBean
@RequestScoped


public class ABMComentarioPropioController {
    
    //private int id_marcador;
    //private String correo_comentarista;
    private String texto; 
    //private ComentarioId id_comentario;
    

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }
    
    public void agregaComentario(){
        ComentaristaDAO udb = new ComentaristaDAO ();
        Comentarista cmn = udb.find("mu.andrea@ciencias.unam.mx");
        
        MarcadorDAO udb_prima = new MarcadorDAO();
        Marcador ma = udb_prima.find(1);
        
        ComentarioId id = new ComentarioId();
        id.setIdMarcador(ma.getIdMarcador());
        id.setCorreoComentarista(cmn.getCorreo());
        
        //Se crea el objeto comentario para agregarlo a la base de datos
        Comentario u = new Comentario();
        u.setTexto(texto);
        u.setComentarista(cmn);
        u.setMarcador(ma);
        
        //Para agregar a la base de datos.
        //udb.save(u);
    }
    
    public void eliminaComentario(){}
    
    public void editaComentario(){

    }
    
}