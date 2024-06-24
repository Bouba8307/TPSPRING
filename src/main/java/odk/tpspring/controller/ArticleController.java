package odk.tpspring.controller;

import odk.tpspring.model.Article;
import odk.tpspring.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/articles")
public class ArticleController {
    @Autowired
    private ArticleService articleService;

    @GetMapping
    public List<Article> findAll() {
        return articleService.findAll();
    }

    @GetMapping("/{id}")
    public Article findById(@PathVariable Long id) {
        return articleService.findById(id);
    }

    @PostMapping
    public Article save(@RequestBody Article article, Authentication authentication) {
        if (authentication.getAuthorities().stream().anyMatch(a -> a.getAuthority().equals("ROLE_FORMATEUR"))) {
            return articleService.save(article);
        }
        return null; // or throw an exception
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        articleService.delete(id);
    }
}
