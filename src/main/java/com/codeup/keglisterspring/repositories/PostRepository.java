package com.codeup.keglisterspring.repositories;

import com.codeup.keglisterspring.models.Ad;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Ad, Long> {
}
