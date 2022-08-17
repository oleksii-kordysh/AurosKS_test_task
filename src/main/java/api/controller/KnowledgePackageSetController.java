package api.controller;

import api.dto.request.KnowledgePackageSetRequestDto;
import api.dto.response.KnowledgePackageSetResponseDto;
import api.model.KnowledgePackageSet;
import api.service.KnowledgePackageSetService;
import api.service.mapper.RequestDtoMapper;
import api.service.mapper.ResponseDtoMapper;
import java.util.List;
import java.util.stream.Collectors;
import javax.validation.Valid;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/sets")
public class KnowledgePackageSetController {
    private KnowledgePackageSetService knowledgePackageSetService;
    private ResponseDtoMapper<KnowledgePackageSetResponseDto, KnowledgePackageSet> knowledgePackageSetResponseDtoMapper;
    private RequestDtoMapper<KnowledgePackageSetRequestDto, KnowledgePackageSet> knowledgePackageSetRequestDtoMapper;

    public KnowledgePackageSetController(
            KnowledgePackageSetService knowledgePackageSetService,
            ResponseDtoMapper<KnowledgePackageSetResponseDto, KnowledgePackageSet> knowledgePackageSetResponseDtoMapper,
            RequestDtoMapper<KnowledgePackageSetRequestDto, KnowledgePackageSet> knowledgePackageSetRequestDtoMapper) {
        this.knowledgePackageSetService = knowledgePackageSetService;
        this.knowledgePackageSetResponseDtoMapper = knowledgePackageSetResponseDtoMapper;
        this.knowledgePackageSetRequestDtoMapper = knowledgePackageSetRequestDtoMapper;
    }

    @GetMapping
    public List<KnowledgePackageSetResponseDto> getAll() {
        List<KnowledgePackageSetResponseDto> collect = knowledgePackageSetService.getAll()
                .stream()
                .map(knowledgePackageSetResponseDtoMapper::mapToDto)
                .collect(Collectors.toList());
        return collect;
    }

    @PostMapping
    public KnowledgePackageSetResponseDto add(@RequestBody @Valid KnowledgePackageSetRequestDto requestDto) {
        KnowledgePackageSet knowledgePackageSet = knowledgePackageSetService.add(
                knowledgePackageSetRequestDtoMapper.mapToModel(requestDto));
        return knowledgePackageSetResponseDtoMapper.mapToDto(knowledgePackageSet);
    }

    @DeleteMapping
    public void delete(@PathVariable Long id) {
        knowledgePackageSetService.delete(id);
    }
}
