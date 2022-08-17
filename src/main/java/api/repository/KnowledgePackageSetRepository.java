package api.repository;

import api.model.KnowledgePackageSet;
import java.util.List;
import java.util.Optional;

public interface KnowledgePackageSetRepository {
    KnowledgePackageSet add(KnowledgePackageSet knowledgePackageSet);

    Optional<KnowledgePackageSet> get(Long id);

    List<KnowledgePackageSet> getAll();

    void delete(Long id);
}
