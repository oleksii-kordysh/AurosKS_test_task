package api.dto.request;

import java.util.List;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class KnowledgePackageSetRequestDto {
    @NotNull
    @Size(max = 250)
    private String title;
    private List<Long> packageIds;

    public void setTitle(String title) {
        this.title = title;
    }

    public List<Long> getPackageIds() {
        return packageIds;
    }

    public void setPackageIds(List<Long> packageIds) {
        this.packageIds = packageIds;
    }

    public String getTitle() {
        return title;
    }
}
