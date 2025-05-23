package com.wise.buddy.wiseBuddy.dto;

public class SuitabilityJsonResponseDTO {
    private String json;

    public SuitabilityJsonResponseDTO() {}

    public SuitabilityJsonResponseDTO(String json) {
        this.json = json;
    }

    public String getJson() {
        return json;
    }

    public void setJson(String json) {
        this.json = json;
    }
}