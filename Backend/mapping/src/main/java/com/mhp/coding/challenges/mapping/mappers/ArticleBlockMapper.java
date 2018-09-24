package com.mhp.coding.challenges.mapping.mappers;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import com.mhp.coding.challenges.mapping.models.db.blocks.ArticleBlock;
import com.mhp.coding.challenges.mapping.models.dto.blocks.ArticleBlockDto;

@Component
public class ArticleBlockMapper extends ModelMapper {

	public ArticleBlockDto map(ArticleBlock articleBlock) {
		ArticleBlockDto articleBlockDto = this.map(articleBlock, ArticleBlockDto.class);
		return articleBlockDto;
	}

	public Set<ArticleBlockDto> mapList(Collection<ArticleBlock> articleBlocks) {
		Set<ArticleBlockDto> articleBlockDtoList = new HashSet<>();
		for (ArticleBlock articleBlock : articleBlocks) {
			ArticleBlockDto articleBlockDto = this.map(articleBlock);
			articleBlockDtoList.add(articleBlockDto);
		}
		return articleBlockDtoList;
	}
}
