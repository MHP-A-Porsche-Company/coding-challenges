package com.mhp.coding.challenges.mapping.mappers;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Set;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.mhp.coding.challenges.mapping.models.db.blocks.ArticleBlock;
import com.mhp.coding.challenges.mapping.models.db.blocks.TextBlock;
import com.mhp.coding.challenges.mapping.models.dto.blocks.ArticleBlockDto;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ArticleBlockMapperTest {

	@Autowired
	ArticleBlockMapper articleBlockMapper;

	@Test
	public void testMap() {
		// arrange
		ArticleBlock articleBlock = new TextBlock();

		// act
		ArticleBlockDto articleBlockDto = articleBlockMapper.map(articleBlock);

		// assert
		assertEquals(articleBlock.getSortIndex(), articleBlockDto.getSortIndex());
	}

	@Test
	public void testMapList() {
		// arrange
		ArticleBlock articleBlock = new TextBlock();
		ArrayList<ArticleBlock> articleBlocks = new ArrayList<>();
		articleBlocks.add(articleBlock);

		// act
		Set<ArticleBlockDto> articleBlockDtoList = articleBlockMapper.mapList(articleBlocks);

		// assert
		assertEquals(articleBlocks.get(0).getSortIndex(), articleBlockDtoList.iterator().next().getSortIndex());
	}
}
