package controller;

import javax.inject.Inject;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Path;
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
}
