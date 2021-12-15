using System;
using System.Collections.Generic;
using System.Linq;
using MHP.CodingChallenge.Backend.Mapping.Data.DB;
using MHP.CodingChallenge.Backend.Mapping.Data.DTO;
using AutoMapper;

namespace MHP.CodingChallenge.Backend.Mapping.Data
{
    public class ArticleMapper
    {
        public ArticleDto Map(Article article)
        {
            //TODO
            return new ArticleDto
            {
                Author = article.Author,
                Description = article.Description,
                Id = article.Id,
                Title = article.Title,
                Blocks = new List<ArticleBlockDto>()
            };
        }

        public Article Map(ArticleDto articleDto)
        {
            // Nicht Teil dieser Challenge.
            return new Article();
        }

    }
}
