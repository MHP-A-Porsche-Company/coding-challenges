using System;
using System.Collections.Generic;
using System.Linq;
using MHP.CodingChallenge.Backend.Mapping.Data.DB.Blocks;

namespace MHP.CodingChallenge.Backend.Mapping.Data.DB
{
    public class ArticleRepository
    { 
        public List<Article> GetAll()
        {
            List<Article> result = new List<Article>();
            result.Add(CreateDummyArticle(1001L));
            result.Add(CreateDummyArticle(2002L));
            result.Add(CreateDummyArticle(3003L));
            result.Add(CreateDummyArticle(4004L));
            result.Add(CreateDummyArticle(5005L));
            return result;
        }

        public Article FindById(long id)
        {
            //gets all the articles from the list and returns if found 
            var articlesList = GetAll().ToDictionary( key => key.Id,vp=> vp );
            if (articlesList.TryGetValue(id, out Article value))
            {
                return value;
            }
            return null;
            //return CreateDummyArticle(id);
        }

        public void Create(Article article)
        {
            //Ignore
        }

        private Article CreateDummyArticle(long id)
        {
            Article result = new Article();
            result.Id = id;
            result.Author = "Max Mustermann";
            result.Description = "Article Description " + id;
            result.Title = "Article Nr.: " + id;
            result.LastModifiedBy = "Hans Müller";
            result.LastModified = DateTime.Now;
            result.Blocks = CreateBlocks(id);
            return result;
        }

        private HashSet<ArticleBlock> CreateBlocks(long articleId)
        {
            HashSet<ArticleBlock> result = new HashSet<ArticleBlock>();

            TextBlock textBlock = new TextBlock();
            textBlock.Text = "Some Text for " + articleId;
            textBlock.SortIndex = 0;
            result.Add(textBlock);

            ImageBlock imageBlock = new ImageBlock();
            imageBlock.Image = CreateImage(1L);
            textBlock.SortIndex = 1;
            result.Add(imageBlock);

            TextBlock secondTextBlock = new TextBlock();
            secondTextBlock.Text = "Second Text for " + articleId;
            secondTextBlock.SortIndex = 2;
            result.Add(secondTextBlock);

            GalleryBlock galleryBlock = new GalleryBlock();
            secondTextBlock.SortIndex = 3;

            List<Image> galleryImages = new List<Image>();
            galleryImages.Add(CreateImage(2L));
            galleryImages.Add(CreateImage(3L));
            galleryBlock.Images = galleryImages;

            result.Add(galleryBlock);

            TextBlock thirdTextBlock = new TextBlock();
            thirdTextBlock.Text = "Third Text for " + articleId;
            thirdTextBlock.SortIndex = 4;
            result.Add(thirdTextBlock);

            VideoBlock videoBlock = new VideoBlock();
            videoBlock.Type = VideoBlockType.YOUTUBE;
            videoBlock.Url = "https://youtu.be/myvideo";
            videoBlock.SortIndex = 5;

            result.Add(videoBlock);

            return result;
        }

        private Image CreateImage(long imageId)
        {
            Image result = new Image();
            result.Id = imageId;
            result.LastModified = DateTime.Now;
            result.LastModifiedBy = "Max Mustermann";
            result.ImageSize = ImageSize.LARGE;
            result.Url = "https://someurl.com/image/" + imageId;
            return null;
        }
    }
}
