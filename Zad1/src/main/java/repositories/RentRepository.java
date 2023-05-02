package repositories;

import jakarta.persistence.*;
import model.Rent;

import java.util.ArrayList;
import java.util.List;

public class RentRepository implements Repository<Rent> {

    EntityManagerFactory emf = Persistence.createEntityManagerFactory("POSTGRES_RENT_PU");

    @Override
    public Rent get(Long id) {
        try (EntityManager em = emf.createEntityManager()) {
            return em.find(Rent.class, id);
        }
    }

    @Override
    public boolean remove(Rent client) {
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
    public List<Rent> getAll() {
        try (EntityManager em = emf.createEntityManager()) {
            List<Rent> allRents = new ArrayList<Rent>();
            em.getTransaction().begin();
            Query q = em.createQuery("FROM model.Rent").setLockMode(LockModeType.PESSIMISTIC_WRITE);
            allRents = q.getResultList();;
            em.getTransaction().commit();
            return allRents;
        }
    }

    @Override
    public Rent update(Rent rent) {
        try (EntityManager em = emf.createEntityManager()) {
            em.getTransaction().begin();
            Rent newRent = em.find(Rent.class, rent.getRentId());
            em.getTransaction().commit();
            return newRent;
        }
    }

    @Override
    public Rent add(Rent rent) {
        try (EntityManager em = emf.createEntityManager()) {
            List<Rent> allRents = new ArrayList<Rent>();
            em.getTransaction().begin();
            Query q = em.createQuery("FROM model.Rent").setLockMode(LockModeType.PESSIMISTIC_WRITE);
            allRents = q.getResultList();
           /* for (Rent r : allRents) {
                if (r.getField().getSportFieldId().equals(rent.getField().getSportFieldId())) {
                    if (r.getBeginTime().equals(rent.getBeginTime()) && r.getEndTime().equals(rent.getEndTime())) {
                        em.close();
                        throw new IllegalArgumentException("Rent collides with another rent");
                    }
                    if (r.getBeginTime().equals(rent.getBeginTime())) {
                        em.close();
                        throw new IllegalArgumentException("Rent collides with another rent");
                    }
                    if (r.getBeginTime().isAfter(rent.getBeginTime()) && r.getEndTime().isAfter(rent.getBeginTime())) {
                        em.close();
                        throw new IllegalArgumentException("Rent collides with another rent");
                    }
                    if (r.getBeginTime().isBefore(rent.getBeginTime()) && r.getEndTime().isAfter(rent.getBeginTime())) {
                        em.close();
                        throw new IllegalArgumentException("Rent collides with another rent");
                    }
                    if (r.getBeginTime().isBefore(rent.getBeginTime()) && r.getEndTime().isAfter(rent.getBeginTime())) {
                        em.close();
                        throw new IllegalArgumentException("Rent collides with another rent");
                    }
                    if (r.getBeginTime().isAfter(rent.getBeginTime()) && r.getEndTime().isBefore(rent.getBeginTime())) {
                        em.close();
                        throw new IllegalArgumentException("Rent collides with another rent");
                    }
                }
            }*/
            em.persist(rent);
            em.getTransaction().commit();
            return rent;
        } catch (Exception e) {
            return null;
        }
    }

}
