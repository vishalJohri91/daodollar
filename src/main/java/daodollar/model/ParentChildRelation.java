package daodollar.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ParentChildRelation {

    @JsonProperty
    private Integer id;

    @JsonProperty
    private String sender;

    @JsonProperty
    private String receiver;

    @JsonProperty
    private Double totalAmount;

    @JsonProperty
    private Double totalPaidAmount;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public String getReceiver() {
        return receiver;
    }

    public void setReceiver(String receiver) {
        this.receiver = receiver;
    }

    public Double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(Double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public Double getTotalPaidAmount() {
        return totalPaidAmount;
    }

    public void setTotalPaidAmount(Double totalPaidAmount) {
        this.totalPaidAmount = totalPaidAmount;
    }
}
