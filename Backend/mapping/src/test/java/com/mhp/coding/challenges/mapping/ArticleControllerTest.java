package com.mhp.coding.challenges.mapping;

import com.mhp.coding.challenges.mapping.models.dto.ArticleDto;
import com.mhp.coding.challenges.mapping.services.ArticleService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import java.util.NoSuchElementException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@ExtendWith(SpringExtension.class)
@AutoConfigureMockMvc
class ArticleControllerTest {

    @MockBean
    private ArticleService service;

    @Autowired
    private MockMvc mockMvc;

    @Test
    void shouldReturnStatusOK() throws Exception {

        // arrange
        final String expected = "\"id\":1001";

        when(service.articleForId(1001L)).thenReturn(ArticleDto.builder().id(1001L).build());

        // act and assert
        assertThat(this.mockMvc.perform(get("/article/1001"))
                .andExpect(status().isOk())
                .andReturn().getResponse().getContentAsString())
                .contains(expected);
    }

    @Test
    void shouldReturnNotFoundIfNoSuchArticleExists() throws Exception {

        // arrange
        when(service.articleForId(any())).thenThrow(new NoSuchElementException("Thrown for test"));

        // act and assert
        this.mockMvc.perform(get("/article/1001")).andExpect(status().isNotFound());
    }

}