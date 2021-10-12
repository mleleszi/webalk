package hu.me.iit.webalk.first;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ArticleRepositoryMemoryTest {

    @Test
    void findAll_Empty() {
        // GIVEN
        ArticleRepositoryMemory articleRepositoryMemory = new ArticleRepositoryMemory();

        // WHEN
        List<ArticleDto> result = articleRepositoryMemory.findAll();

        // THEN
        assertEquals(0, result.size());

    }

    @Test
    void finAll_NotEmpty() {
        // GIVEN
        ArticleRepositoryMemory articleRepositoryMemory = new ArticleRepositoryMemory();
        ArticleDto articleDto = new ArticleDto();
        articleDto.setAuthor("Author");
        articleDto.setPages(23);
        articleDto.setId(2L);
        articleDto.setTitle("title");

        articleRepositoryMemory.save(articleDto);
        // WHEN
        List<ArticleDto> result = articleRepositoryMemory.findAll();

        // THEN
        assertEquals(1, result.size());
    }

    @Test
    void findArticleById_exists() {
        // GIVEN
        ArticleRepositoryMemory articleRepositoryMemory = new ArticleRepositoryMemory();
        Long id = 2L;
        ArticleDto articleDto = new ArticleDto();
        articleDto.setAuthor("Author");
        articleDto.setPages(23);
        articleDto.setId(id);
        articleDto.setTitle("title");

        articleRepositoryMemory.save(articleDto);
        // WHEN
        int result = articleRepositoryMemory.findArticleById(id);

        // THEN
        assertEquals(0, result);
    }

    @Test
    void findArticleById_notExists() {
        // GIVEN
        ArticleRepositoryMemory articleRepositoryMemory = new ArticleRepositoryMemory();
        Long id = 2L;
        Long notExistsId = 4L;
        ArticleDto articleDto = new ArticleDto();
        articleDto.setAuthor("Author");
        articleDto.setPages(23);
        articleDto.setId(id);
        articleDto.setTitle("title");

        articleRepositoryMemory.save(articleDto);
        // WHEN
        int result = articleRepositoryMemory.findArticleById(notExistsId);

        // THEN
        assertEquals(-1, result);
    }


    @Test
    void deleteById_exists() {
        // GIVEN
        ArticleRepositoryMemory articleRepositoryMemory = new ArticleRepositoryMemory();
        Long id = 2L;
        ArticleDto articleDto = new ArticleDto();
        articleDto.setAuthor("Author");
        articleDto.setPages(23);
        articleDto.setId(id);
        articleDto.setTitle("title");

        articleRepositoryMemory.save(articleDto);
        // WHEN
        articleRepositoryMemory.deleteById(id);

        // THEN
        assertEquals(0, articleRepositoryMemory.findAll().size());
    }



    @Test
    void deleteById_notExists() {
        // GIVEN
        ArticleRepositoryMemory articleRepositoryMemory = new ArticleRepositoryMemory();
        Long id = 2L;
        Long notExistsId = 4L;
        ArticleDto articleDto = new ArticleDto();
        articleDto.setAuthor("Author");
        articleDto.setPages(23);
        articleDto.setId(id);
        articleDto.setTitle("title");

        articleRepositoryMemory.save(articleDto);
        // WHEN
        articleRepositoryMemory.deleteById(notExistsId);

        // THEN
        assertEquals(1, articleRepositoryMemory.findAll().size());
    }


    @Test
    void getById_notExists() {
        // GIVEN
        ArticleRepositoryMemory articleRepositoryMemory = new ArticleRepositoryMemory();
        Long id = 2L;
        Long notExistsId = 4L;
        ArticleDto articleDto = new ArticleDto();
        articleDto.setAuthor("Author");
        articleDto.setPages(23);
        articleDto.setId(id);
        articleDto.setTitle("title");

        articleRepositoryMemory.save(articleDto);

        // WHEN
        ArticleDto dto = articleRepositoryMemory.getById(notExistsId);

        // THEN
        assertNull(dto);
    }

    @Test
    void getById_Exists() {
        // GIVEN
        ArticleRepositoryMemory articleRepositoryMemory= new ArticleRepositoryMemory();
        Long id = 2L;
        ArticleDto articleDto = new ArticleDto();
        articleDto.setAuthor("Author");
        articleDto.setPages(23);
        articleDto.setId(id);
        articleDto.setTitle("title");

        articleRepositoryMemory.save(articleDto);

        // WHEN
        ArticleDto dto = articleRepositoryMemory.getById(id);

        // THEN
        assertEquals(articleDto, dto);
    }

    @Test
    void save_update() {
        // GIVEN
        ArticleRepositoryMemory articleRepositoryMemory = new ArticleRepositoryMemory();
        Long id = 2L;
        ArticleDto articleDto = new ArticleDto();
        articleDto.setAuthor("Author");
        articleDto.setPages(23);
        articleDto.setId(id);
        articleDto.setTitle("title");

        articleRepositoryMemory.save(articleDto);

        // WHEN
        ArticleDto articleDto2 = new ArticleDto();
        articleDto2.setAuthor("Author 2");
        articleDto2.setPages(14);
        articleDto2.setId(id);
        articleDto2.setTitle("title 2");

        articleRepositoryMemory.save(articleDto2);

        // THEN
        List<ArticleDto> articleDtoList = articleRepositoryMemory.findAll();
        assertEquals(1, articleDtoList.size());

        assertEquals(articleDto2, articleDtoList.get(0));
    }

}