package api.service.mapper;

import api.dto.request.KnowledgePackageRequestDto;
import api.model.KnowledgePackage;
import java.time.LocalDate;
import org.springframework.stereotype.Component;

@Component
public class KnowledgePackageRequestDtoMapper {
    public KnowledgePackage mapToModel(KnowledgePackageRequestDto requestDto) {
        KnowledgePackage knowledgePackage = new KnowledgePackage();
        knowledgePackage.setTitle(requestDto.getTitle());
        knowledgePackage.setDescription(requestDto.getDescription());
        knowledgePackage.setCreationDate(LocalDate.now());
        return knowledgePackage;
    }
}
