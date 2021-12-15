using AutoMapper;
using MHP.CodingChallenge.Backend.Mapping.Data.DB;
using MHP.CodingChallenge.Backend.Mapping.Data.DB.Blocks;
using MHP.CodingChallenge.Backend.Mapping.Data.DTO;

namespace MHP.CodingChallenge.Backend.Mapping.Data
{
    public class ArticleAutoMapper : Profile
    {
        public ArticleAutoMapper()
        {
            //mapping between dtos, entities and its members
            CreateMap<ArticleBlock, ArticleBlockDto>()
                .ForMember(dst => dst.SortIndex, opt => opt.MapFrom(src => src.SortIndex))
                .ReverseMap();
            CreateMap<Image, ImageDto>();
            CreateMap<Article, ArticleDto>()
                .ForMember(dst => dst.Author, opt => opt.MapFrom(src => src.Author))
                .ForMember(dst => dst.Blocks, opt => opt.MapFrom(src => src.Blocks))
                .ForMember(dst => dst.Description, opt => opt.MapFrom(src => src.Description))
                .ForMember(dst => dst.Title, opt => opt.MapFrom(src => src.Title))
                .ReverseMap();
        }
    }
}