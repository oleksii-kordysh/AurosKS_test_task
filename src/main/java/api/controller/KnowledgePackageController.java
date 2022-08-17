package api.controller;

import api.dto.request.KnowledgePackageRequestDto;
import api.dto.response.KnowledgePackageResponseDto;
import api.model.KnowledgePackage;
import api.service.KnowledgePackageService;
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
import org.springframework.web.bind.annotation.RestController;

@RestController
public class KnowledgePackageController {
    private KnowledgePackageService knowledgePackageService;
    private KnowledgePackageSetService knowledgePackageSetService;
    private ResponseDtoMapper<KnowledgePackageResponseDto, KnowledgePackage> knowledgePackageResponseDtoMapper;
    private RequestDtoMapper<KnowledgePackageRequestDto, KnowledgePackage> knowledgePackageRequestDtoMapper;

    public KnowledgePackageController(
            KnowledgePackageService knowledgePackageService,
            KnowledgePackageSetService knowledgePackageSetService,
            ResponseDtoMapper<KnowledgePackageResponseDto, KnowledgePackage> knowledgePackageResponseDtoMapper,
            RequestDtoMapper<KnowledgePackageRequestDto, KnowledgePackage> knowledgePackageRequestDtoMapper) {
        this.knowledgePackageService = knowledgePackageService;
        this.knowledgePackageSetService = knowledgePackageSetService;
        this.knowledgePackageResponseDtoMapper = knowledgePackageResponseDtoMapper;
        this.knowledgePackageRequestDtoMapper = knowledgePackageRequestDtoMapper;
    }

    @GetMapping("/kpacs")
    public List<KnowledgePackageResponseDto> getAll() {
        List<KnowledgePackageResponseDto> collect = knowledgePackageService.getAll()
                .stream()
                .map(knowledgePackageResponseDtoMapper::mapToDto)
                .collect(Collectors.toList());
        return collect;
    }

    @PostMapping("/kpacs")
    public KnowledgePackageResponseDto add(@RequestBody @Valid KnowledgePackageRequestDto requestDto) {
        KnowledgePackage knowledgePackage = knowledgePackageService.add(
                knowledgePackageRequestDtoMapper.mapToModel(requestDto));
        return knowledgePackageResponseDtoMapper.mapToDto(knowledgePackage);
    }

    @DeleteMapping("/kpacs")
    public void delete(@PathVariable Long id) {
        knowledgePackageService.delete(id);
    }

    @GetMapping("/set/{id}")
    public List<KnowledgePackageResponseDto> getKnowledgePackagesBySetId(@PathVariable Long id) {
        return knowledgePackageSetService.get(id).getPackages().stream()
                .map(p -> knowledgePackageResponseDtoMapper.mapToDto(p))
                .collect(Collectors.toList());
    }
}
