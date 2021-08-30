package com.mhp.coding.challenges.mapping.models.db;

import com.mhp.coding.challenges.mapping.models.db.blocks.ArticleBlock;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;


@Getter
@Setter
public class Article extends DBEntity {

    private String title;

    private String description;

    private String author;

    private Set<ArticleBlock> blocks;
    
}
