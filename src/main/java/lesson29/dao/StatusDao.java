package lesson29.dao;

import lesson29.model.Status;

public interface StatusDao {
    void save(Status status);

    Status getById(int id);

    void update(Status status);

    void delete(Status status);
}
