package repository.Impl;

import base.repository.impl.BaseRepositoryImpl;
import domain.Airline;
import repository.AirlineRepository;
import util.HibernateUtil;

public class AirlineRepositoryImpl extends BaseRepositoryImpl<Airline, Long>
        implements AirlineRepository {

    public AirlineRepositoryImpl() {
        super(HibernateUtil.getEntityManager());
    }

    @Override
    public Class<Airline> getClassType() {
        return Airline.class;
    }

    @Override
    public Airline findByName(String name) {
        return em.createQuery("select a from Airline a where a.name = :name", Airline.class)
                .setParameter("name", name)
                .getSingleResult();
    }

}
