package api.model;

import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "knowledge_package_set")
public class KnowledgePackageSet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length = 250)
    private String title;
    @ManyToMany
    @JoinTable(name = "knowledge_package_set_knowledge_package",
            joinColumns = @JoinColumn(name = "package_set_id"),
            inverseJoinColumns = @JoinColumn(name = "package_id"))
    private Set<KnowledgePackage> packages;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Set<KnowledgePackage> getPackages() {
        return packages;
    }

    public void setPackages(Set<KnowledgePackage> packages) {
        this.packages = packages;
    }
}
