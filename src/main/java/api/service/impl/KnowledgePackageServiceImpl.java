package api.service.impl;

import api.model.KnowledgePackage;
import api.repository.KnowledgePackageRepository;
import api.service.KnowledgePackageService;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class KnowledgePackageServiceImpl implements KnowledgePackageService {
    private KnowledgePackageRepository knowledgePackageRepository;

    public KnowledgePackageServiceImpl(KnowledgePackageRepository knowledgePackageRepository) {
        this.knowledgePackageRepository = knowledgePackageRepository;
    }

    @Override
    public KnowledgePackage add(KnowledgePackage knowledgePackage) {
        return knowledgePackageRepository.add(knowledgePackage);
    }

    @Override
    public KnowledgePackage get(Long id) {
        return knowledgePackageRepository.get(id);
    }

    @Override
    public List<KnowledgePackage> getAll() {
        return knowledgePackageRepository.getAll();
    }

    @Override
    public KnowledgePackage update(KnowledgePackage knowledgePackage) {
        return knowledgePackageRepository.update(knowledgePackage);
    }

    @Override
    public KnowledgePackage delete(Long id) {
        return knowledgePackageRepository.delete(id);
    }
}
