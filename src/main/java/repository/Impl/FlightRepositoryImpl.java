package repository.Impl;

import base.repository.impl.BaseRepositoryImpl;
import domain.Flight;
import repository.FlightRepository;
import util.HibernateUtil;

import java.util.List;

public class FlightRepositoryImpl extends BaseRepositoryImpl<Flight, Long>
        implements FlightRepository {


    public FlightRepositoryImpl() {
        super(HibernateUtil.getEntityManager());
    }

    @Override
    public Class<Flight> getClassType() {
        return Flight.class;
    }

    @Override
    public List<Flight> findWithOriginAndDestination(String origin, String destination) {
        return em.createQuery("select f from Flight f where f.origin = :origin and f.destination = :destination", Flight.class)
                .setParameter("origin", origin)
                .setParameter("destination", destination)
                .getResultList();
    }

    @Override
    public List<Flight> groupAllByOrigin(String order) {
        return em.createQuery("select f from Flight f order by f.origin ".concat(order), Flight.class)
                .getResultList();
    }

    @Override
    public List<Flight> groupAllByDestination(String order) {
        return em.createQuery("select f from Flight f order by f.destination ".concat(order), Flight.class)
                .getResultList();
    }

    @Override
    public List<Flight> groupAllByAirline(String order) {
        return em.createQuery("select f from Flight f order by f.airline.name ".concat(order), Flight.class)
                .getResultList();
    }

    @Override
    public List<Flight> groupAllByPrice(String order) {
        return em.createQuery("select f from Flight f order by f.price ".concat(order), Flight.class)
                .getResultList();
    }

}
