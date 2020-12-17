package com.mhp.coding.challenges.mapping.models.dto.blocks;

public class TextBlock extends ArticleBlockDto {

    private String text;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
