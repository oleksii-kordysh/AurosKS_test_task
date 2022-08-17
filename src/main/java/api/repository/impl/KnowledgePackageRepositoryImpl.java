package api.repository.impl;

import api.model.KnowledgePackage;
import api.repository.AbstractRepository;
import api.repository.KnowledgePackageRepository;
import java.util.List;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

@Repository
public class KnowledgePackageRepositoryImpl extends AbstractRepository<KnowledgePackage>
        implements KnowledgePackageRepository {

    public KnowledgePackageRepositoryImpl(SessionFactory factory, Class<KnowledgePackage> clazz) {
        super(factory, clazz);
    }
}
