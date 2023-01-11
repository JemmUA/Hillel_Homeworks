package lesson29.service;

import lesson29.dao.StatusDao;
import lesson29.dao.StatusDaoImpl;
import lesson29.model.Status;

public class StatusService {

    StatusDao statusDao = new StatusDaoImpl();

    public void save(Status status) {
        if (status == null) {
            System.out.println("Client is null");
        }
        // logic here
        System.out.println("Saving status: " + status.toString());
        statusDao.save(status);
    }

    public Status getById(int id) {
        System.out.println("Getting status by ID: " + id);

        return statusDao.getById(id);
    }

    public void update(Status status) {
        System.out.println("Updating status: " + status.toString());
        statusDao.update(status);
    }

    public void delete(Status status) {
        System.out.println("Deleting status: " + status.toString());
        statusDao.delete(status);
    }

}
