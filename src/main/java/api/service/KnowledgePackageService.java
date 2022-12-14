package api.service;

import api.model.KnowledgePackage;
import java.util.List;

public interface KnowledgePackageService {
    KnowledgePackage add(KnowledgePackage knowledgePackage);

    KnowledgePackage get(Long id);

    List<KnowledgePackage> getAll();

    void delete(Long id);
}
