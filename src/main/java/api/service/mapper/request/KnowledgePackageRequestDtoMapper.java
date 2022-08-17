package api.service.mapper.request;

import api.dto.request.KnowledgePackageRequestDto;
import api.model.KnowledgePackage;
import api.service.mapper.RequestDtoMapper;
import java.time.LocalDate;
import org.springframework.stereotype.Component;

@Component
public class KnowledgePackageRequestDtoMapper
        implements RequestDtoMapper<KnowledgePackageRequestDto, KnowledgePackage> {
    @Override
    public KnowledgePackage mapToModel(KnowledgePackageRequestDto requestDto) {
        KnowledgePackage knowledgePackage = new KnowledgePackage();
        knowledgePackage.setTitle(requestDto.getTitle());
        knowledgePackage.setDescription(requestDto.getDescription());
        knowledgePackage.setCreationDate(LocalDate.now());
        return knowledgePackage;
    }
}
