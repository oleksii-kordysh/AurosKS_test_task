package api.service.mapper;

import api.dto.response.KnowledgePackageResponseDto;
import api.model.KnowledgePackage;
import org.springframework.stereotype.Component;

@Component
public class KnowledgePackageResponseDtoMapper
        implements ResponseDtoMapper<KnowledgePackageResponseDto, KnowledgePackage> {
    @Override
    public KnowledgePackageResponseDto mapToDto(KnowledgePackage knowledgePackage) {
        KnowledgePackageResponseDto dto = new KnowledgePackageResponseDto();
        dto.setId(knowledgePackage.getId());
        dto.setTitle(knowledgePackage.getTitle());
        dto.setDescription(knowledgePackage.getDescription());
        dto.setCreationDate(knowledgePackage.getCreationDate());
        return dto;
    }
}
