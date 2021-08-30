package com.mhp.coding.challenges.mapping.mappers;

import com.mhp.coding.challenges.mapping.models.db.Article;
import com.mhp.coding.challenges.mapping.models.db.Image;
import com.mhp.coding.challenges.mapping.models.db.blocks.ArticleBlock;
import com.mhp.coding.challenges.mapping.models.db.blocks.GalleryBlock;
import com.mhp.coding.challenges.mapping.models.db.blocks.ImageBlock;
import com.mhp.coding.challenges.mapping.models.db.blocks.TextBlock;
import com.mhp.coding.challenges.mapping.models.db.blocks.VideoBlock;
import com.mhp.coding.challenges.mapping.models.dto.ArticleDto;
import com.mhp.coding.challenges.mapping.models.dto.ImageDto;
import com.mhp.coding.challenges.mapping.models.dto.blocks.ArticleBlockDto;
import com.mhp.coding.challenges.mapping.models.dto.blocks.GalleryBlockDto;
import com.mhp.coding.challenges.mapping.models.dto.blocks.ImageBlockDto;
import com.mhp.coding.challenges.mapping.models.dto.blocks.TextBlockDto;
import com.mhp.coding.challenges.mapping.models.dto.blocks.VideoBlockDto;
import javax.validation.constraints.NotNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Comparator;
import java.util.LinkedHashSet;
import java.util.stream.Collectors;

@Component
public class ArticleMapper {

    private static final Logger LOG = LoggerFactory.getLogger(ArticleMapper.class);

    public ArticleDto map(@NotNull Article article) {
        //TODO
        return ArticleDto.builder()
                .id(article.getId())
                .title(article.getTitle())
                .description(article.getDescription())
                .author(article.getAuthor())
                .blocks(article.getBlocks().stream().map(ArticleMapper::mapToDto)
                        .sorted(Comparator.comparing(ArticleBlockDto::getSortIndex))
                        .collect(Collectors.toCollection(LinkedHashSet::new))
                )
                .build();
    }

    private static ArticleBlockDto mapToDto(ArticleBlock block) {

        if (block instanceof ImageBlock) {
            return mapToImageBlockDto((ImageBlock) block);
        }

        if (block instanceof TextBlock) {
            return mapToTextBlockDto((TextBlock) block);
        }

        if (block instanceof VideoBlock) {
            return mapToVideoBlockDto((VideoBlock) block);
        }

        if (block instanceof GalleryBlock) {
            return mapToGalleryBlockDto((GalleryBlock) block);
        }

        LOG.info("Unknown Article Block Type");
        final ArticleBlockDto articleBlockDto = new ArticleBlockDto();
        articleBlockDto.setSortIndex(block.getSortIndex());

        return articleBlockDto;
    }

    @NotNull
    private static GalleryBlockDto mapToGalleryBlockDto(@NotNull GalleryBlock block) {
        final GalleryBlockDto galleryBlockDto = GalleryBlockDto.builder().build();
        galleryBlockDto.setSortIndex(block.getSortIndex());
        galleryBlockDto.setImages(block.getImages().stream()
                .map(ArticleMapper::mapToImageDto).collect(Collectors.toList()));

        return galleryBlockDto;
    }

    @NotNull
    private static VideoBlockDto mapToVideoBlockDto(@NotNull VideoBlock block) {
        final VideoBlockDto videoBlockDto = VideoBlockDto.builder().build();
        videoBlockDto.setSortIndex(block.getSortIndex());
        videoBlockDto.setUrl(block.getUrl());
        videoBlockDto.setType(block.getType());
        return videoBlockDto;
    }

    @NotNull
    private static TextBlockDto mapToTextBlockDto(@NotNull TextBlock block) {
        final TextBlockDto textBlockDto = TextBlockDto.builder().build();
        textBlockDto.setSortIndex(block.getSortIndex());
        textBlockDto.setText(block.getText());
        return textBlockDto;
    }

    @NotNull
    private static ImageDto mapToImageDto(@NotNull Image image) {
        final ImageDto imageDto = ImageDto.builder().build();
        imageDto.setId(image.getId());
        imageDto.setUrl(image.getUrl());
        imageDto.setImageSize(image.getImageSize());

        return imageDto;
    }

    @NotNull
    private static ImageBlockDto mapToImageBlockDto(@NotNull ImageBlock imageBlock) {
        final ImageBlockDto imageBlockDto = ImageBlockDto.builder().build();
        imageBlockDto.setSortIndex(imageBlock.getSortIndex());
        imageBlockDto.setImage(mapToImageDto(imageBlock.getImage()));

        return imageBlockDto;

    }

    public Article map(ArticleDto articleDto) {
        // Nicht Teil dieser Challenge.
        return new Article();
    }
}
