package api.repository.impl;

import api.exception.DataProcessingException;
import api.model.KnowledgePackageSet;
import api.repository.AbstractRepository;
import api.repository.KnowledgePackageSetRepository;
import java.util.Optional;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

@Repository
public class KnowledgePackageSetRepositoryImpl extends AbstractRepository<KnowledgePackageSet>
        implements KnowledgePackageSetRepository {

    public KnowledgePackageSetRepositoryImpl(SessionFactory factory) {
        super(factory, KnowledgePackageSet.class);
    }

    @Override
    public Optional<KnowledgePackageSet> get(Long id) {
        try (Session session = factory.openSession()) {
            return session.createQuery(
                    "FROM KnowledgePackageSet kps JOIN FETCH kps.packages "
                    + "WHERE kps.id = :id ORDER BY kps.id", KnowledgePackageSet.class)
                    .setParameter("id", id)
                    .uniqueResultOptional();
        } catch (Exception e) {
            throw new DataProcessingException("Cannot get KnowledgePackageSet by id " + id, e);
        }
    }
}
