package com.example.fsapi.repository;

import com.example.fsapi.domain.FsPic;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FsPicRepository extends JpaRepository<FsPic, String> {
}
