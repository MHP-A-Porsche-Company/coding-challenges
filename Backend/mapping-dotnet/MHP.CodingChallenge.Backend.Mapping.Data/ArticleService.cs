﻿using System;
using System.Collections.Generic;
using AutoMapper;
using MHP.CodingChallenge.Backend.Mapping.Data.DB;
using MHP.CodingChallenge.Backend.Mapping.Data.DTO;

namespace MHP.CodingChallenge.Backend.Mapping.Data
{
    public class ArticleService :IArticleService
    {
        private ArticleRepository _articleRepository;
       // private ArticleMapper _articleMapper;
       private readonly IMapper _mapper;

        public ArticleService(ArticleRepository articleRepository, IMapper mapper)//ArticleMapper articleMapper
        {
            _articleRepository = articleRepository;
            _mapper = mapper;
            // _articleMapper = articleMapper;
        }

        public List<ArticleDto> GetAll()
        {
            List<Article> articles = _articleRepository.GetAll();
            // TODO 
            var resMapped = _mapper.Map<List<ArticleDto>>(articles);
            return resMapped;
        }

        public object GetById(long id)
        {
            Article article = _articleRepository.FindById(id);
            // TODO
            var resMapped = _mapper.Map<ArticleDto>(article);
            return resMapped;
        }

        public object Create(ArticleDto articleDto)
        {
            return new object();
        }
    }
}
