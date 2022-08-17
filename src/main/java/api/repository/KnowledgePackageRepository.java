package api.repository;

import api.model.KnowledgePackage;
import java.util.List;
import java.util.Optional;

public interface KnowledgePackageRepository {
    KnowledgePackage add(KnowledgePackage knowledgePackage);

    Optional<KnowledgePackage> get(Long id);

    List<KnowledgePackage> getAll();

    void delete(Long id);
}
