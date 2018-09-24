package com.mhp.coding.challenges.mapping.mappers;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.mhp.coding.challenges.mapping.models.db.Article;
import com.mhp.coding.challenges.mapping.models.db.blocks.ArticleBlock;
import com.mhp.coding.challenges.mapping.models.dto.ArticleDto;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ArticleMapperTest {

	@Autowired
	ArticleMapper articleMapper;

	@Test
	public void testMap() {
		// arrange
		Article article = createTestArticle();

		// act
		ArticleDto articleDto = articleMapper.map(article);

		// assert
		assertEquals(articleDto.getAuthor(), article.getAuthor());
		assertEquals(articleDto.getBlocks(), article.getBlocks());
		assertEquals(articleDto.getDescription(), article.getDescription());
		assertEquals(articleDto.getTitle(), article.getTitle());
	}

	@Test
	public void testMapList() {
		// arrange
		Article article = createTestArticle();
		List<Article> articleList = new ArrayList<>();
		articleList.add(article);

		// act
		List<ArticleDto> articleDtoList = articleMapper.mapList(articleList);

		// assert
		assertEquals(articleDtoList.get(0).getAuthor(), article.getAuthor());
		assertEquals(articleDtoList.get(0).getBlocks(), article.getBlocks());
		assertEquals(articleDtoList.get(0).getDescription(), article.getDescription());
		assertEquals(articleDtoList.get(0).getTitle(), article.getTitle());
	}

	private Article createTestArticle() {
		Article article = new Article();
		article.setAuthor("J.R.R. Tolkien");
		article.setBlocks(new HashSet<ArticleBlock>());
		article.setDescription("The first part of Tolkiens War of the Ring series");
		article.setTitle("The Fellowship of the Ring");
		return article;
	}
}
