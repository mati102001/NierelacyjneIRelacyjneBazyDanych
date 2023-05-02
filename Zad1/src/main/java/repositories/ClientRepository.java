package repositories;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.LockModeType;
import jakarta.persistence.Persistence;
import model.Client;
import jakarta.persistence.*;

import java.util.List;

public class ClientRepository implements Repository<Client> {

    EntityManagerFactory emf = Persistence.createEntityManagerFactory("POSTGRES_RENT_PU");

    @Override
    public Client get(Long id) {
        try (EntityManager em = emf.createEntityManager()) {
            return em.find(Client.class, id);
        }
    }

    @Override
    public boolean remove(Client client) {
        try (EntityManager em = emf.createEntityManager()) {
            em.getTransaction().begin();
            em.remove(em.merge(client));
            em.getTransaction().commit();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public List<Client> getAll() {
        try (EntityManager em = emf.createEntityManager()) {
            List<Client> allClients;
            em.getTransaction().begin();
            Query q = em.createQuery("FROM model.Client").setLockMode(LockModeType.PESSIMISTIC_WRITE);
            allClients = q.getResultList();;
            em.getTransaction().commit();
            return allClients;
        }
    }

    @Override
    public Client update(Client client) {
        try (EntityManager em = emf.createEntityManager()) {
            em.getTransaction().begin();
            Client newClient = em.find(Client.class, client.getId());
            em.getTransaction().commit();
            return newClient;
        }
    }

    @Override
    public Client add(Client client) {
        try (EntityManager em = emf.createEntityManager()) {
            em.getTransaction().begin();
            em.persist(client);
            em.getTransaction().commit();
            return client;
        } catch (Exception e) {
            return null;
        }
    }

}
