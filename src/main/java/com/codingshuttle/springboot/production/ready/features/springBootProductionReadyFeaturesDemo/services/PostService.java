package com.codingshuttle.springboot.production.ready.features.springBootProductionReadyFeaturesDemo.services;

import com.codingshuttle.springboot.production.ready.features.springBootProductionReadyFeaturesDemo.dto.PostDto;

import java.util.List;


public interface PostService {

    PostDto createNewPost(PostDto postDto);

    List<PostDto> getAllPosts();

    PostDto getPostById(Long id);
}
