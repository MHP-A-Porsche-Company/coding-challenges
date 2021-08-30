package com.mhp.coding.challenges.mapping;

import com.mhp.coding.challenges.mapping.mappers.ArticleMapper;
import com.mhp.coding.challenges.mapping.models.dto.ArticleDto;
import com.mhp.coding.challenges.mapping.models.dto.blocks.ArticleBlockDto;
import com.mhp.coding.challenges.mapping.repositories.ArticleRepository;
import com.mhp.coding.challenges.mapping.services.ArticleService;
import javax.validation.constraints.NotNull;
import org.junit.jupiter.api.Test;

import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ArticleServiceTest {

    private final ArticleService service = new ArticleService(new ArticleRepository(), new ArticleMapper());

    @Test
    void shouldListAllArticles() {
        // arrange
        final int expectedAmount = 5;

        // act
        final List<ArticleDto> articleDtoList = service.list();

        // assert
        assertEquals(expectedAmount, articleDtoList.size());
    }

    @Test
    void shouldSortBlocksBySortingIndex() {

        // act
        final List<ArticleDto> articleDtoList = service.list();

        // assert
        assertTrue(isSorted(articleDtoList));
    }

    @Test
    void shouldThrowNoSuchElementException() {

        // act and assert
        assertThrows(NoSuchElementException.class, () -> service.articleForId(9999L));
    }

    private static boolean isSorted(@NotNull final List<ArticleDto> articleDtoList) {

        if (articleDtoList.isEmpty() || articleDtoList.size() == 1) {
            return true;
        }

        for (ArticleDto articleDto : articleDtoList) {

            final Iterator<ArticleBlockDto> iter = articleDto.getBlocks().iterator();

            ArticleBlockDto current, previous = iter.next();

            while (iter.hasNext()) {
                current = iter.next();
                if (current.getSortIndex() < previous.getSortIndex()) {
                    return false;
                }
                previous = current;
            }
        }

        return true;
    }
}