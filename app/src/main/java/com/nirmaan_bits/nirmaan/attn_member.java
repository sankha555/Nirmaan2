package com.nirmaan_bits.nirmaan;

public class attn_member {
    String name;
    String status;

    public attn_member() {
    }

    public attn_member(String name, String status) {
        this.name = name;
        this.status = status;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
