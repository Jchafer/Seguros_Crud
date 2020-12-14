/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import conexion.Conexion;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import modelo.AsistenciaMedica;
import modelo.Coberturas;
import modelo.Enfermedades;
import modelo.Nif;
import modelo.Seguro;
import modelo.Sexo;
import modelo.TipoAsistencia;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 *
 * @author jesus
 */
public class App {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws ParseException {
        //CREAMOS CONEXION
        SessionFactory sessionFactory;

        sessionFactory = Conexion.getSessionFactory();
        
        //CREAMOS UNA SESION
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        
        // CONSULTAS 
        /*Lanza una consulta que nos retorne todos los seguros que hay en la base de datos.Haz que se
        muestren en la pantalla*/
        /*Query query = session.createQuery("SELECT s FROM Seguro s");
        List<Seguro> seguros = query.list();
        for (Seguro seguro : seguros) {
            System.out.println(seguro.toString());
        }*/
        
        /*Lanza una consulta que nos retorne solo las columnas NIF y Nombre de todos los seguros que hay
        en la base de datos.Haz que se muestren en pantalla*/
        /*Query query = session.createQuery("SELECT s.nif, s.nombre FROM Seguro s");
        List<Object[]> listDatos = query.list();
        System.out.println("\tNIF\t\tNombre");
        for (Object[] datos : listDatos) {
            System.out.println("\t" + datos[0] + "\t" + datos[1]);
        }*/
        
        
        /*Lanza una consulta que nos retorne sólo la columna NIF de todos los seguros que hay en la base de
        datos.Haz que se muestren en pantalla*/
        /*Query query = session.createQuery("SELECT s.nif FROM Seguro s");
        List<Object> listDatos = query.list();
        System.out.println("\tNIF");
        for (Object datos : listDatos) {
            System.out.println("\t" + datos);
        }*/
        
        
        /*Lanza una consulta que nos retorne sólo el NIF para el seguro con nombre “Marcos Tortosa Oltra”
        Usa el método uniqueResult() y 3 parámetros con nombre para el nombre y los apellidos*/
        /*Seguro seguro =(Seguro) session.createQuery("SELECT s FROM Seguro s WHERE nombre='Marcos' AND ape1='Tortosa' AND ape2='Oltra'").uniqueResult();        
        System.out.println("\tNIF de Marcos Tortosa Oltra -> " + seguro.getNif());
        
        String nif =(String) session.createQuery("SELECT s.nif FROM Seguro s WHERE nombre='Marcos' AND ape1='Tortosa' AND ape2='Oltra'").uniqueResult();        
        System.out.println("\tNIF de Marcos Tortosa Oltra -> " + nif);*/
        
        
        
        
        
        //CREAMOS OBJETO
                /*SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String fechaComoCadena = sdf.format(new Date());
        
        java.sql.Timestamp.valueOf(fechaComoCadena);*/ /*Seguro seguro = new Seguro(1, "12345678Z", "Juan", "Cano", "Morales", 38, 3);
        
        Set<AsistenciaMedica> am = new HashSet<>();
        am.add(new AsistenciaMedica(311, seguro, "Ir al médico de cabecera por fiebre", "Valencia"));
        am.add(new AsistenciaMedica(312, seguro, "Operacion de apendicitis", "Castellón"));

        seguro.setAsistenciasMedicas(am);*/ 

        //Create
        //session.saveOrUpdate(seguro);
        //Read
        //Seguro seguroRecibido = (Seguro) session.get(Seguro.class, 1);
        //System.out.println(seguroRecibido);
        //Update
        //seguro.setNombre("Pablo");
        //session.update(seguro);
        //Delete
        //session.delete(seguro);
        
        
        SimpleDateFormat sdfFecha=new SimpleDateFormat("dd/MM/yyyy");
        sdfFecha.setLenient(false);
        SimpleDateFormat sdfHora=new SimpleDateFormat("HH:mm:ss");
        sdfHora.setLenient(false);
        Seguro seguro = new Seguro(new Nif("36254784E"), "Rosa", "Ramirez", "Arellano", 41, Sexo.MUJER, true, 1, false,
                new Coberturas(false, true, false), new Enfermedades(true, false, true, false, null), new Date());
        AsistenciaMedica asistenciaMedica1 = new AsistenciaMedica(seguro, "Golpe en el brazo", "Madrid",
                "Fractura del radio derecho de la mano debido a golpe contundente con el suelo. Se escayola el brazo",
                TipoAsistencia.HOSPITALARIA, sdfFecha.parse("31/12/2013"),sdfHora.parse("11:21:45"), new BigDecimal("700.31"));
        AsistenciaMedica asistenciaMedica2 = new AsistenciaMedica(seguro, "Fiebre alta", "Alzira",
                "El paciente presenta cuadro alto de fiabre con deficultad para respirar. Se recetan antibioticos.",
                TipoAsistencia.AMBULATORIA, sdfFecha.parse("27/02/2013"), sdfHora.parse("12:34:16"), new BigDecimal("81.14"));
        //seguro.getAsistenciasMedicas().add(asistenciaMedica1);
        //seguro.getAsistenciasMedicas().add(asistenciaMedica2);
        
        Set<AsistenciaMedica> am = new HashSet<>();
        am.add(asistenciaMedica1);
        am.add(asistenciaMedica2);
        seguro.setAsistenciasMedicas(am);
        
        session.saveOrUpdate(seguro);
        
        //CERRAMOS LA SESION
        session.getTransaction().commit();
        session.close();
    }

}
