package repositories;

import jakarta.persistence.*;
import model.SportField;

import java.util.List;

public class SportCentreRepository implements Repository<SportField> {

    EntityManagerFactory emf = Persistence.createEntityManagerFactory("POSTGRES_RENT_PU");

    @Override
    public SportField get(Long id) {
        try (EntityManager em = emf.createEntityManager()) {
            return em.find(SportField.class, id);
        }
    }

    @Override
    public boolean remove(SportField sportField) {
        try (EntityManager em = emf.createEntityManager()) {
            em.getTransaction().begin();
            em.remove(em.merge(sportField));
            em.getTransaction().commit();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public List<SportField> getAll() {
        try (EntityManager em = emf.createEntityManager()) {
            List<SportField> allSportFields;
            em.getTransaction().begin();
            Query q = em.createQuery("FROM model.Client").setLockMode(LockModeType.PESSIMISTIC_WRITE);
            allSportFields = q.getResultList();;
            em.getTransaction().commit();
            return allSportFields;
        }
    }

    @Override
    public SportField update(SportField sportField) {
        try (EntityManager em = emf.createEntityManager()) {
            em.getTransaction().begin();
            SportField newSportField = em.find(SportField.class, sportField.getSportFieldId());
            em.getTransaction().commit();
            return newSportField;
        }
    }

    @Override
    public SportField add(SportField sportField) {
        try (EntityManager em = emf.createEntityManager()) {
            em.getTransaction().begin();
            em.persist(sportField);
            em.getTransaction().commit();
            return sportField;
        } catch (Exception e) {
            return null;
        }
    }


}
