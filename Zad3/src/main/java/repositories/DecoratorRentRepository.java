package repositories;

import model.Rent;

import java.util.List;

public class DecoratorRentRepository implements Repository<Rent> {

    protected Repository<Rent> rentRepo;

    DecoratorRentRepository(Repository<Rent> rentRepo) {
        this.rentRepo = rentRepo;
    }

    public Rent get(String id) {
        return rentRepo.get(id);
    }

    public boolean remove(String id) {
        return rentRepo.remove(id);
    }

    public List<Rent> getAll() {
        return rentRepo.getAll();
    }

    public Rent update(Rent rent) {
        return rentRepo.update(rent);
    }

    public Rent add(Rent rent) {
        return rentRepo.add(rent);
    }
}
