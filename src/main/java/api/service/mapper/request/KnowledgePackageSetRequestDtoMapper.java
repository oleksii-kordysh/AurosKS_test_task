package api.service.mapper.request;

import api.dto.request.KnowledgePackageSetRequestDto;
import api.model.KnowledgePackageSet;
import api.service.KnowledgePackageService;
import api.service.mapper.RequestDtoMapper;
import java.util.stream.Collectors;
import org.springframework.stereotype.Component;

@Component
public class KnowledgePackageSetRequestDtoMapper
        implements RequestDtoMapper<KnowledgePackageSetRequestDto, KnowledgePackageSet> {
    private KnowledgePackageService knowledgePackageService;

    public KnowledgePackageSetRequestDtoMapper(KnowledgePackageService knowledgePackageService) {
        this.knowledgePackageService = knowledgePackageService;
    }

    @Override
    public KnowledgePackageSet mapToModel(KnowledgePackageSetRequestDto requestDto) {
        KnowledgePackageSet knowledgePackageSet = new KnowledgePackageSet();
        knowledgePackageSet.setTitle(requestDto.getTitle());
        knowledgePackageSet.setPackages(requestDto.getPackageIds().stream()
                .map(id -> knowledgePackageService.get(id)).collect(Collectors.toSet()));
        return knowledgePackageSet;
    }
}
