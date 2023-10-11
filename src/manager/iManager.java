package manager;

import java.util.List;

public interface iManager<P> {
    void add(P p);

    boolean update(int id,P p);
    boolean delete(int id);
    List<P> findAll();
    List<P> searchByHighPrice();
    int findIndexById(int id);
}
