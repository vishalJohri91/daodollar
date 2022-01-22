package daodollar.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Child {

    @JsonProperty
    private Integer id;

    @JsonProperty
    private Integer parentId;

    @JsonProperty
    private Double paidAmount;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    public Double getPaidAmount() {
        return paidAmount;
    }

    public void setPaidAmount(Double paidAmount) {
        this.paidAmount = paidAmount;
    }
}
