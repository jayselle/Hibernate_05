package dao;

import entities.Categoria;
import entities.Item;
import manager.SessionManager;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.Iterator;

public class CategoriaDAO {

    public CategoriaDAO(){

    }

    public static void crearCategorias(){

        Session sesion = SessionManager.getSession();
        Transaction transaction = sesion.beginTransaction();

        Categoria c1 = new Categoria();
        c1.setDescripcion("Comida");
        Categoria c2 = new Categoria();
        c2.setDescripcion("Bebida");
        Categoria c3 = new Categoria();
        c3.setDescripcion("Postre");

        sesion.save(c1);
        sesion.save(c2);
        sesion.save(c3);

        transaction.commit();

        sesion.close();

    }

    public static void asignarItemsACategorias(Long idCategoria, Long idItem){

        Session sesion = SessionManager.getSession();
        Transaction transaction = sesion.beginTransaction();

        Categoria categoria = sesion.get(Categoria.class,idCategoria);
        Item item = sesion.get(Item.class,idItem);

        categoria.getItems().add(item);

        sesion.save(categoria);

        transaction.commit();

        sesion.close();

    }

    public static void informar(Long idCategoria){

        Session sesion = SessionManager.getSession();
        Transaction transaction = sesion.beginTransaction();

        Categoria categoria = sesion.get(Categoria.class,idCategoria);

        Iterator iter = categoria.getItems().iterator();
        while(iter.hasNext()){
            Item item = (Item) iter.next();
            System.out.println(item.getId()+" "+item.getDescripcion());
        }
    }

}
