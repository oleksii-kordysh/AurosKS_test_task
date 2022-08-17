package api.service.impl;

import api.model.KnowledgePackageSet;
import api.repository.KnowledgePackageSetRepository;
import api.service.KnowledgePackageSetService;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class KnowledgePackageSetServiceImpl implements KnowledgePackageSetService {
    private KnowledgePackageSetRepository knowledgePackageSetRepository;

    public KnowledgePackageSetServiceImpl(KnowledgePackageSetRepository knowledgePackageSetRepository) {
        this.knowledgePackageSetRepository = knowledgePackageSetRepository;
    }

    @Override
    public KnowledgePackageSet add(KnowledgePackageSet knowledgePackageSet) {
        return knowledgePackageSetRepository.add(knowledgePackageSet);
    }

    @Override
    public KnowledgePackageSet get(Long id) {
        return knowledgePackageSetRepository.get(id).orElseThrow(
                () -> new RuntimeException("KnowledgePackageSet with id " + id + " not found"));
    }

    @Override
    public List<KnowledgePackageSet> getAll() {
        return knowledgePackageSetRepository.getAll();
    }

    @Override
    public void delete(Long id) {
        knowledgePackageSetRepository.delete(id);
    }
}
