package model;

import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import model.Pessoafisica;
import model.Pessoajuridica;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-11-10T00:55:34")
@StaticMetamodel(Endereco.class)
public class Endereco_ { 

    public static volatile CollectionAttribute<Endereco, Pessoafisica> pessoafisicaCollection;
    public static volatile SingularAttribute<Endereco, Integer> id;
    public static volatile CollectionAttribute<Endereco, Pessoajuridica> pessoajuridicaCollection;
    public static volatile SingularAttribute<Endereco, String> rua;

}