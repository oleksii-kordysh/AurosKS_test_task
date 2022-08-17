package api.controller;

import api.dto.request.KnowledgePackageRequestDto;
import api.dto.response.KnowledgePackageResponseDto;
import api.model.KnowledgePackage;
import api.service.KnowledgePackageService;
import api.service.mapper.KnowledgePackageRequestDtoMapper;
import api.service.mapper.KnowledgePackageResponseDtoMapper;
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
    private KnowledgePackageResponseDtoMapper knowledgePackageResponseDtoMapper;
    private KnowledgePackageRequestDtoMapper knowledgePackageRequestDtoMapper;

    public KnowledgePackageController(
            KnowledgePackageService knowledgePackageService,
            KnowledgePackageResponseDtoMapper knowledgePackageResponseDtoMapper) {
        this.knowledgePackageService = knowledgePackageService;
        this.knowledgePackageResponseDtoMapper = knowledgePackageResponseDtoMapper;
    }

    @GetMapping
    public List<KnowledgePackageResponseDto> getAll() {
        return knowledgePackageService.getAll()
                .stream()
                .map(knowledgePackageResponseDtoMapper::mapToDto)
                .collect(Collectors.toList());
    }

    @PostMapping()
    public KnowledgePackageResponseDto add(@RequestBody @Valid KnowledgePackageRequestDto requestDto) {
        KnowledgePackage knowledgePackage = knowledgePackageService.add(
                knowledgePackageRequestDtoMapper.mapToModel(requestDto));
        return knowledgePackageResponseDtoMapper.mapToDto(knowledgePackage);
    }

    @DeleteMapping()
    public void delete(@PathVariable Long id) {
        knowledgePackageService.delete(id);
    }
}