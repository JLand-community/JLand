package com.jland.website.web.dto;

import com.jland.website.model.PresentationPlan;

public class PresentationPlanDto {

    public PresentationPlanDto() {
    }

    public PresentationPlanDto(String item) {
        this.item = item;
    }

    private String item;

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public static PresentationPlanDto from(PresentationPlan presentationPlan) {
        return new PresentationPlanDto(presentationPlan.getItem());
    }

    @Override
    public String toString() {
        return "PresentationPlanDto{" +
                "item='" + item + '\'' +
                '}';
    }
}
