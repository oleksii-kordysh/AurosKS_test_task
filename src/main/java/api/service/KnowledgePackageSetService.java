package api.service;

import api.model.KnowledgePackageSet;
import java.util.List;

public interface KnowledgePackageSetService {
    KnowledgePackageSet add(KnowledgePackageSet knowledgePackageSet);

    KnowledgePackageSet get(Long id);

    List<KnowledgePackageSet> getAll();

    void delete(Long id);
}
