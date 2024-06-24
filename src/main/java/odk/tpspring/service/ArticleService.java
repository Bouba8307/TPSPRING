package odk.tpspring.service;

import odk.tpspring.model.Article;
import odk.tpspring.repository.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArticleService {
    @Autowired
    private ArticleRepository articleRepository;

    public List<Article> findAll() {
        return articleRepository.findAll();
    }

    public Article findById(Long id) {
        return articleRepository.findById(id).orElse(null);
    }

    public Article save(Article article) {
        return articleRepository.save(article);
    }

    public void delete(Long id) {
        articleRepository.deleteById(id);
    }
}
