package api.controller;

import api.dto.request.KnowledgePackageRequestDto;
import api.dto.response.KnowledgePackageResponseDto;
import api.model.KnowledgePackage;
import api.service.KnowledgePackageService;
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
@RequestMapping("/kpacs")
public class KnowledgePackageController {
    private KnowledgePackageService knowledgePackageService;
    private ResponseDtoMapper<KnowledgePackageResponseDto, KnowledgePackage> knowledgePackageResponseDtoMapper;
    private RequestDtoMapper<KnowledgePackageRequestDto, KnowledgePackage> knowledgePackageRequestDtoMapper;

    public KnowledgePackageController(
            KnowledgePackageService knowledgePackageService,
            ResponseDtoMapper<KnowledgePackageResponseDto, KnowledgePackage> knowledgePackageResponseDtoMapper,
            RequestDtoMapper<KnowledgePackageRequestDto, KnowledgePackage> knowledgePackageRequestDtoMapper) {
        this.knowledgePackageService = knowledgePackageService;
        this.knowledgePackageResponseDtoMapper = knowledgePackageResponseDtoMapper;
        this.knowledgePackageRequestDtoMapper = knowledgePackageRequestDtoMapper;
    }

    @GetMapping
    public List<KnowledgePackageResponseDto> getAll() {
        List<KnowledgePackageResponseDto> collect = knowledgePackageService.getAll()
                .stream()
                .map(knowledgePackageResponseDtoMapper::mapToDto)
                .collect(Collectors.toList());
        return collect;
    }

    @PostMapping
    public KnowledgePackageResponseDto add(@RequestBody @Valid KnowledgePackageRequestDto requestDto) {
        KnowledgePackage knowledgePackage = knowledgePackageService.add(
                knowledgePackageRequestDtoMapper.mapToModel(requestDto));
        return knowledgePackageResponseDtoMapper.mapToDto(knowledgePackage);
    }

    @DeleteMapping
    public void delete(@PathVariable Long id) {
        knowledgePackageService.delete(id);
    }
}
