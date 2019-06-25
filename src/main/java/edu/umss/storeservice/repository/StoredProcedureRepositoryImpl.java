package edu.umss.storeservice.repository;

import edu.umss.storeservice.model.ModelBase;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.StoredProcedureQuery;
import java.lang.reflect.ParameterizedType;
import java.util.List;

@Repository
public abstract class StoredProcedureRepositoryImpl<T extends ModelBase> {

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public List<T> findAll(){
        String typeName = (((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0]).getTypeName();
        typeName = typeName.substring(typeName.lastIndexOf('.') + 1);

        StoredProcedureQuery querySP = entityManager.createNamedStoredProcedureQuery("GetAll"+typeName);
        querySP.execute();

        return (List<T>) querySP.getResultList();
    }

    @Transactional
    public T findById(Long id){
        String typeName = (((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0]).getTypeName();
        typeName = typeName.substring(typeName.lastIndexOf('.') + 1);

        StoredProcedureQuery  querySP = entityManager.createNamedStoredProcedureQuery("Get"+typeName+"ById");
        querySP.setParameter("id", id);

        querySP.execute();

        return (T) querySP.getSingleResult();
    }

    @Transactional
    public Boolean deleteById(Long id){
        String typeName = (((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0]).getTypeName();
        typeName = typeName.substring(typeName.lastIndexOf('.') + 1);

        StoredProcedureQuery  querySP = entityManager.createNamedStoredProcedureQuery("Delete"+typeName+"ById");
        querySP.setParameter("id", id);

        querySP.execute();

        return (Boolean) querySP.getOutputParameterValue("result");
    }



}
