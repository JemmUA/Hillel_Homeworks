package lesson30.service;

import lesson30.dao.OwnerDao;
import lesson30.entity.Owner;

public class OwnerService {
    private OwnerDao ownerDao = new OwnerDao();

    public void save(final Owner owner) {
        System.out.println("Owner for save: " + owner);
        ownerDao.save(owner);
    }
}
