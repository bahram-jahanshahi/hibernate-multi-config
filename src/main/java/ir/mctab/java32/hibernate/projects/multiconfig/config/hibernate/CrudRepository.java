package ir.mctab.java32.hibernate.projects.multiconfig.config.hibernate;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.io.Serializable;
import java.util.List;

public abstract class CrudRepository< Entity extends PersistenceEntity, ID extends Serializable> {

    protected abstract Class<Entity> getEntityClass();

    protected abstract Session getSession();

    public Entity save(Entity entity) {
        getSession().beginTransaction();
        getSession().save(entity);
        getSession().getTransaction().commit();
        return entity;
    }

    public Entity update(Entity entity) {
        getSession().beginTransaction();
        getSession().update(entity);
        getSession().getTransaction().commit();
        return entity;
    }

    public void delete(Entity entity) {
        getSession().beginTransaction();
        getSession().remove(entity);
        getSession().getTransaction().commit();
    }

    public void deleteById(ID id) {
        Entity entity = findById(id);
        if (entity != null) {
            getSession().beginTransaction();
            getSession().remove(entity);
            getSession().getTransaction().commit();
        }
    }

    public Entity findById(ID id) {
        getSession().beginTransaction();
        Entity entity = getSession().get(getEntityClass(), id);
        getSession().getTransaction().commit();
        return entity;
    }

    public List<Entity> findAll() {
        getSession().beginTransaction();
        List<Entity> tList = getSession().createQuery("from " + getEntityClass().getName()).list();
        getSession().getTransaction().commit();
        return tList;
    }

    public List<Entity> findAll(int firstResult, int maxResults) {
        getSession().beginTransaction();
        Query query = getSession().createQuery("from " + getEntityClass().getName());
        query.setFirstResult(firstResult);
        query.setMaxResults(maxResults);
        List<Entity> tList = query.list();
        getSession().getTransaction().commit();
        return tList;
    }
}

