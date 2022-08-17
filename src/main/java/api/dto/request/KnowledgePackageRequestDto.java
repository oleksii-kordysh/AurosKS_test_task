package api.dto.request;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class KnowledgePackageRequestDto {
    @NotNull
    @Size(max = 250)
    private String title;
    @NotNull
    @Size(max = 2000)
    private String description;

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }
}
