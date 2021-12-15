using System.Collections.Generic;
using MHP.CodingChallenge.Backend.Mapping.Data.DTO;

namespace MHP.CodingChallenge.Backend.Mapping.Data
{
    public interface IArticleService
    {

        List<ArticleDto> GetAll();
        object GetById(long id);
    }
}