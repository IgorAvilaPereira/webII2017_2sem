package controller;

import javax.inject.Inject;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Result;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import model.Usuario;

@Controller
public class IndexController {

    @Inject
    private Result result;
//    private EntityManagerFactory entityManagerFactory;
//    private EntityManager entityManager;

    @Path("/")
    public void index() {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("PU");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        result.include("variable", "VRaptor!");
        entityManager.getTransaction().begin();
        List<Usuario> vetUsuario = entityManager.createQuery("select u from Usuario u", Usuario.class).getResultList();
        entityManager.getTransaction().commit();
        entityManager.close();
        result.include("vetUsuario", vetUsuario);
    }
    
    
    @Get
    @Path("/tchan/{id}")
    public void excluir(int id){
        
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("PU");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();        
        Usuario usuario = entityManager.find(Usuario.class, id);
        entityManager.remove(usuario);
        entityManager.remove(usuario.getEndereco());
        entityManager.getTransaction().commit();
        entityManager.close();        
        this.result.redirectTo(this).index();
        
    }
    
     @Post
    @Path("/flash")
    public void adicionar(Usuario usuario){
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("PU");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        //Usuario usuarioAux = entityManager.find(Usuario.class, usuario.getId());
        //usuarioAux.setId(usuario.getId());
        //usuarioAux.setNome(usuario.getNome());
        //usuarioAux.setEmail(usuario.getEmail());
        //usuarioAux.setPreferencias(Character.MIN_VALUE);
        entityManager.persist(usuario);
        entityManager.getTransaction().commit();
        entityManager.close();
        this.result.redirectTo(this).index();
    }
    
    
    
    @Get
    @Path("/aquaman")
    public void tela_adicionar(){
        
    }
    
    @Post
    @Path("/charliebrown")
    public void alterar(Usuario usuario){
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("PU");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        //Usuario usuarioAux = entityManager.find(Usuario.class, usuario.getId());
        //usuarioAux.setId(usuario.getId());
        //usuarioAux.setNome(usuario.getNome());
        //usuarioAux.setEmail(usuario.getEmail());
        //usuarioAux.setPreferencias(Character.MIN_VALUE);
        entityManager.merge(usuario);
        entityManager.getTransaction().commit();
        entityManager.close();
        this.result.redirectTo(this).index();
    }
    
    @Get
    @Path("/virguloides/{id}")
    public void tela_alterar(int id){
         EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("PU");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        Usuario usuario = entityManager.find(Usuario.class, id);
        entityManager.getTransaction().commit();
        entityManager.close();
        result.include("usuario", usuario);
    }
    
}
