package api.service.mapper.response;

import api.dto.response.KnowledgePackageSetResponseDto;
import api.model.KnowledgePackageSet;
import api.service.mapper.ResponseDtoMapper;
import org.springframework.stereotype.Component;

@Component
public class KnowledgePackageSetResponseDtoMapper
        implements ResponseDtoMapper<KnowledgePackageSetResponseDto, KnowledgePackageSet> {
    @Override
    public KnowledgePackageSetResponseDto mapToDto(KnowledgePackageSet knowledgePackageSet) {
        KnowledgePackageSetResponseDto dto = new KnowledgePackageSetResponseDto();
        dto.setId(knowledgePackageSet.getId());
        dto.setTitle(knowledgePackageSet.getTitle());
        return dto;
    }
}
