package com.mhp.coding.challenges.mapping.models.dto.blocks;

import com.mhp.coding.challenges.mapping.models.dto.ImageDto;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor(access = AccessLevel.PROTECTED)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Setter
public class ImageBlock extends ArticleBlockDto {

    private ImageDto image;

}
