package com.codingshuttle.springboot.production.ready.features.springBootProductionReadyFeaturesDemo.repositories;

import com.codingshuttle.springboot.production.ready.features.springBootProductionReadyFeaturesDemo.entities.PostEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends JpaRepository<PostEntity,Long> {
}
