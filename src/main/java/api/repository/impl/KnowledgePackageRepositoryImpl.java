package api.repository.impl;

import api.model.KnowledgePackage;
import api.repository.AbstractRepository;
import api.repository.KnowledgePackageRepository;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

@Repository
public class KnowledgePackageRepositoryImpl extends AbstractRepository<KnowledgePackage>
        implements KnowledgePackageRepository {

    public KnowledgePackageRepositoryImpl(SessionFactory factory) {
        super(factory, KnowledgePackage.class);
    }
}
