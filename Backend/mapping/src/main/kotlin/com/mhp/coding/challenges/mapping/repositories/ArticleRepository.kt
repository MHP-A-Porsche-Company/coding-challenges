package com.mhp.coding.challenges.mapping.repositories

import com.mhp.coding.challenges.mapping.models.db.Article
import com.mhp.coding.challenges.mapping.models.db.Image
import com.mhp.coding.challenges.mapping.models.db.ImageSize
import com.mhp.coding.challenges.mapping.models.db.blocks.*
import org.springframework.stereotype.Component
import java.util.*

@Component
class ArticleRepository {
    fun all(): List<Article> = setOf(1001L, 2002L, 3003L, 4004L, 5005L).map { it.createDummyArticle }

    fun findBy(id: Long): Article = id.createDummyArticle

    fun create(article: Article?) {
        //Ignore
    }

    private val Long.createDummyArticle
        get() = Article(
            id = this,
            lastModified = Date(),
            lastModifiedBy = "Hans Müller",
            title = "Article Nr.: $this",
            description = "Article Description $this",
            author = "Max Mustermann",
            blocks = createBlocks(),
        )

    private fun Long.createBlocks(): Set<ArticleBlock> {
        val textBlock = TextBlock(
            text = "Some Text for $this",
            sortIndex = 0
        )

        val imageBlock = ImageBlock(
            image = createImage(1L),
            sortIndex = 1
        )

        val secondTextBlock = TextBlock(
            text = "Second Text for $this",
            sortIndex = 2
        ).also { textBlock.sortIndex = 1 }

        val galleryBlock = GalleryBlock(
            images = listOf(
                createImage(2L),
                createImage(3L)
            )
        ).also { secondTextBlock.sortIndex = 3 }

        val thirdTextBlock = TextBlock(
            text = "Third Text for $this",
            sortIndex = 4
        )

        val videoBlock = VideoBlock(
            type = VideoBlockType.YOUTUBE,
            url = "https://youtu.be/myvideo",
            sortIndex = 4
        )

        return setOf(textBlock, imageBlock, secondTextBlock, galleryBlock, thirdTextBlock, videoBlock)
    }

    private fun createImage(imageId: Long): Image? {
        return Image(
            url = "https://someurl.com/image/$imageId",
            id = imageId,
            imageSize = ImageSize.LARGE,
            lastModified = Date(),
            lastModifiedBy = "John Doe"
        ).let { null }
    }
}
