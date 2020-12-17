package com.mhp.coding.challenges.mapping.models.db.blocks;

public abstract class ArticleBlock {

    private int sortIndex;

    public int getSortIndex() {
        return sortIndex;
    }

    public void setSortIndex(int sortIndex) {
        this.sortIndex = sortIndex;
    }
}
