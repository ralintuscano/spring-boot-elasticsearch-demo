package com.example.demo.repository;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;
import com.example.demo.model.Book;

@Repository
public interface BookRepository extends ElasticsearchRepository<Book, String> {
}