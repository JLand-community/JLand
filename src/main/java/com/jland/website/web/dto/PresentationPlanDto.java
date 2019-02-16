package com.jland.website.web.dto;

import com.jland.website.model.PresentationPlanItem;

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

    public static PresentationPlanDto from(PresentationPlanItem presentationPlanItem) {
        return new PresentationPlanDto(presentationPlanItem.getItem());
    }

    @Override
    public String toString() {
        return "PresentationPlanDto{" +
                "item='" + item + '\'' +
                '}';
    }
}
