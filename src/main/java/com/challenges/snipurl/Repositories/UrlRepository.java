package com.challenges.snipurl.Repositories;

import com.challenges.snipurl.Models.Url;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UrlRepository extends  JpaRepository<Url,String> {
        Optional<Url> findById(String key);
      //  String save(Url url, String key);

}
