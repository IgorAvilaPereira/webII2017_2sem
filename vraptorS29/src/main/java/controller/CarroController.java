package controller;

import database.CarroDAO;
import java.sql.SQLException;
import java.util.ArrayList;
import model.Carro;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.observer.download.Download;
import br.com.caelum.vraptor.observer.download.FileDownload;
import br.com.caelum.vraptor.observer.upload.UploadedFile;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import javax.inject.Inject;
import org.apache.commons.io.IOUtils;

@Controller
public class CarroController {

    @Inject
    private Result result;
    @Inject
    private CarroDAO dao;

    @Get
    @Path("/carro/excluir/{id}")
    public void excluir(int id) throws ClassNotFoundException, SQLException {
        dao.excluir(id);
        result.redirectTo(this).listar();
    }

    @Path("/")
    public ArrayList<Carro> listar() throws ClassNotFoundException, SQLException {
        //CarroDAO dao = new CarroDAO();
        return dao.listar();
    }

    @Get
    @Path("/carro/tela_adicionar")
    public void tela_adicionar() {

    }

    @Get
    @Path("/carro/tela_alterar/{id}")
    public Carro tela_alterar(int id) throws ClassNotFoundException, SQLException {
        //result.include("carro", dao.obter(id));
        return dao.obter(id);
    }

    @Post
    @Path("/carro/alterar")
    public void alterar(Carro carro) throws ClassNotFoundException, SQLException {
        System.out.println("============================");
        System.out.println("============================");
        System.out.println(carro.getId());
        System.out.println(carro.getModelo());
        System.out.println(carro.getMarca());
        System.out.println(carro.getAno());
        System.out.println(carro.getValor());
        System.out.println("============================");
        System.out.println("============================");

        dao.alterar(carro);
        result.redirectTo(this).listar();
    }

    @Get
    @Path("/carro/imagem/{id}")
    public Download imagem(int id) throws ClassNotFoundException, SQLException, FileNotFoundException {
        Carro carro = dao.obter(id);
        File file = new File("E:\\Ricardo Fonseca\\Downloads\\webII\\trabalho_05\\vraptorS29\\src\\main\\webapp\\WEB-INF\\arquivos\\" + carro.getImagem());
        String contentType = "image/png";
        try {
            return new FileDownload(file, contentType, file.getName());
        } catch (FileNotFoundException e) {
            System.out.println("erro: " + e);
            return null;
        }
    }

    @Post
    @Path("/carro/adicionar")
    public void adicionar(UploadedFile file, Carro carro) throws IOException, ClassNotFoundException, SQLException {

        dao.inserir(carro);

        if (null != file && carro.getId() > 0) {
            String extensao = file.getFileName().substring(file.getFileName().indexOf("."), file.getFileName().length());
            long time = System.currentTimeMillis();
            String novoNome = String.format("%08x%05x", time / 1000, time);
            File f = new File("E:\\Ricardo Fonseca\\Downloads\\webII\\trabalho_05\\vraptorS29\\src\\main\\webapp\\WEB-INF\\arquivos\\" + novoNome + extensao);
            IOUtils.copyLarge(file.getFile(), new FileOutputStream(f));
            carro.setImagem(novoNome + extensao);
            dao.alterar(carro);
        } else {
            System.out.println("=================");
            System.out.println("=================");
            System.out.println("nao foi possivel fazer o upload");
            System.out.println("id:" + carro.getId());
            System.out.println("file" + file);
            System.out.println("=================");
            System.out.println("=================");
        }

        result.redirectTo(this).listar();

    }

}
