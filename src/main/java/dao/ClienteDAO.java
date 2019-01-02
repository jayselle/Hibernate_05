package dao;

import entities.Cliente;
import entities.Direccion;
import entities.Factura;
import manager.SessionManager;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class ClienteDAO {

    public static void registrarCliente(String direc){

        Session sesion = SessionManager.getSession();
        Transaction transaction = sesion.beginTransaction();

        Cliente cliente = new Cliente();
        Direccion direccion = new Direccion();
        direccion.setDireccion(direc);
        cliente.setDireccion(direccion);

        sesion.save(cliente);

        transaction.commit();

        sesion.close();

    }

    public static void cargarFactura(Long idCliente, Long idFactura){

        Session sesion = SessionManager.getSession();
        Transaction transaction = sesion.beginTransaction();

        Factura factura = sesion.get(Factura.class,idFactura);
        Cliente cliente = sesion.get(Cliente.class,idCliente);

        factura.setCliente(cliente);

        sesion.save(factura);

        transaction.commit();

        sesion.close();

    }

}
