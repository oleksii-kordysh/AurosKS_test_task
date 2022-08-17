package api.service.mapper.response;

import api.dto.response.KnowledgePackageResponseDto;
import api.model.KnowledgePackage;
import api.service.mapper.ResponseDtoMapper;
import api.util.DatePatternUtil;
import java.time.format.DateTimeFormatter;
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
        dto.setCreationDate(knowledgePackage.getCreationDate()
                .format(DateTimeFormatter.ofPattern(DatePatternUtil.DATE_PATTERN)));
        return dto;
    }
}
