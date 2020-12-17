package com.mhp.coding.challenges.mapping.repositories

import com.mhp.coding.challenges.mapping.models.db.Article
import com.mhp.coding.challenges.mapping.models.db.Image
import com.mhp.coding.challenges.mapping.models.db.ImageSize
import com.mhp.coding.challenges.mapping.models.db.blocks.*
import org.springframework.stereotype.Component
import java.util.*

@Component
class ArticleRepository {
    fun all(): List<Article> = listOf(
        createDummyArticle(1001L),
        createDummyArticle(2002L),
        createDummyArticle(3003L),
        createDummyArticle(4004L),
        createDummyArticle(5005L),
    )

    fun findBy(id: Long): Article = createDummyArticle(id)

    fun create(article: Article?) {
        //Ignore
    }

    private fun createDummyArticle(id: Long): Article {
        val result = Article()
        result.id = id
        result.author = "Max Mustermann"
        result.description = "Article Description $id"
        result.title = "Article Nr.: $id"
        result.lastModifiedBy = "Hans Müller"
        result.lastModified = Date()
        result.blocks = createBlocks(id)
        return result
    }

    private fun createBlocks(articleId: Long): Set<ArticleBlock> {
        val result: MutableSet<ArticleBlock> = HashSet()
        val textBlock = TextBlock()
        textBlock.text = "Some Text for $articleId"
        textBlock.sortIndex = 0
        result.add(textBlock)
        val imageBlock = ImageBlock()
        imageBlock.image = createImage(1L)
        textBlock.sortIndex = 1
        result.add(imageBlock)
        val secondTextBlock = TextBlock()
        secondTextBlock.text = "Second Text for $articleId"
        secondTextBlock.sortIndex = 2
        result.add(secondTextBlock)
        val galleryBlock = GalleryBlock()
        secondTextBlock.sortIndex = 3
        val galleryImages: MutableList<Image> = ArrayList()
        galleryImages.add(createImage(2L))
        galleryImages.add(createImage(3L))
        galleryBlock.images = galleryImages
        result.add(galleryBlock)
        val thirdTextBlock = TextBlock()
        thirdTextBlock.text = "Third Text for $articleId"
        thirdTextBlock.sortIndex = 4
        result.add(thirdTextBlock)
        val videoBlock = VideoBlock()
        videoBlock.type = VideoBlockType.YOUTUBE
        videoBlock.url = "https://youtu.be/myvideo"
        videoBlock.sortIndex = 5
        result.add(videoBlock)
        return result
    }

    private fun createImage(imageId: Long): Image {
        return Image().apply {
            id = imageId
            lastModified = Date()
            imageSize = ImageSize.LARGE
            url = "https://someurl.com/image/$imageId"
        }.let { Image() }
    }
}
