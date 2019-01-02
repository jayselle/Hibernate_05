package dao;

import entities.Cliente;
import entities.Direccion;
import entities.Factura;
import entities.Item;
import manager.SessionManager;
import org.hibernate.Session;
import org.hibernate.Transaction;
import java.util.Iterator;


public class FacturaDAO {

    public FacturaDAO(){

    }

    public static void cargarFacturaEItems(){

        Session sesion = SessionManager.getSession();
        Transaction transaction = sesion.beginTransaction();

        Factura factura = new Factura();

        Item item1 = new Item();
        item1.setDescripcion("Item 1");
        item1.setCantidad(10l);
        item1.setFactura(factura);
        factura.getItems().add(item1);

        Item item2 = new Item();
        item2.setDescripcion("Item 2");
        item2.setCantidad(15l);
        item2.setFactura(factura);
        factura.getItems().add(item2);

        sesion.save(factura);

        transaction.commit();

        sesion.close();

    }

    public static void eliminarItem(Long idFactura, Long idItem){

        Session sesion = SessionManager.getSession();
        Transaction transaction = sesion.beginTransaction();

        Factura factura = sesion.get(Factura.class,idFactura);

        Iterator iter = factura.getItems().iterator();
        while(iter.hasNext()){
            Item item = (Item) iter.next();
            if (item.getId()==idItem){
                factura.getItems().remove(item);
                System.out.println("Item eliminado");
                break;
            }
        }

        sesion.save(factura);

        transaction.commit();

        sesion.close();

    }

    public static void eliminarFactura(Long idFactura){

        Session sesion = SessionManager.getSession();
        Transaction transaction = sesion.beginTransaction();

        Factura factura = sesion.get(Factura.class,idFactura);

        sesion.delete(factura);

        transaction.commit();

        sesion.close();

    }

    public static void registrarCompra(){

        Session sesion = null;
        Transaction transaction = null;

        try{
            sesion = SessionManager.getSession();
            transaction = sesion.beginTransaction();

            Factura factura = new Factura();
            Cliente cliente = new Cliente();
            Direccion direccion = new Direccion();
            direccion.setDireccion("Paraguay 3000");
            cliente.setDireccion(direccion);
            //sesion.save(cliente);
            Item item1 = new Item();
            item1.setDescripcion("Item 1");
            item1.setCantidad(10l);
            Item item2 = new Item();
            item2.setDescripcion("Item 2");
            item2.setCantidad(15l);
            factura.getItems().add(item1);
            factura.getItems().add(item2);
            factura.setCliente(cliente);

            sesion.save(factura);

            transaction.commit();

        }catch(Exception e){

            System.out.println("Error: "+e.getMessage());
            if(transaction!=null)
                transaction.rollback();

        }finally{

            if (sesion!=null)
                sesion.close();

        }

    }

}
