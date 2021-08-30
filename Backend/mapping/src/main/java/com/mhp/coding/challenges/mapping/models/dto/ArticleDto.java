package com.mhp.coding.challenges.mapping.models.dto;


import com.mhp.coding.challenges.mapping.models.dto.blocks.ArticleBlockDto;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.util.Collection;

@Data
@Builder
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ArticleDto {

    private Long id;

    private String title;

    private String description;

    private String author;

    private Collection<ArticleBlockDto> blocks;

}
