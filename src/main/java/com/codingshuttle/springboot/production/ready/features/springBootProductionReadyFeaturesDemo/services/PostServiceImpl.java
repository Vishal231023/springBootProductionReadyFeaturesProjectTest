package com.codingshuttle.springboot.production.ready.features.springBootProductionReadyFeaturesDemo.services;

import com.codingshuttle.springboot.production.ready.features.springBootProductionReadyFeaturesDemo.dto.PostDto;
import com.codingshuttle.springboot.production.ready.features.springBootProductionReadyFeaturesDemo.entities.PostEntity;
import com.codingshuttle.springboot.production.ready.features.springBootProductionReadyFeaturesDemo.exceptions.ResourceNotFoundException;
import com.codingshuttle.springboot.production.ready.features.springBootProductionReadyFeaturesDemo.repositories.PostRepository;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostServiceImpl implements PostService {

    private final PostRepository postRepository;
    private  final ModelMapper modelMapper;

    public PostServiceImpl(PostRepository postRepository, ModelMapper modelMapper) {
        this.postRepository = postRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public PostDto createNewPost(PostDto postDto) {
        PostEntity post = modelMapper.map(postDto, PostEntity.class);

        return modelMapper.map(postRepository.save(post), PostDto.class) ;


    }

    @Override
    public List<PostDto> getAllPosts() {
        return postRepository
                .findAll()
                .stream()
                .map(postEntity -> modelMapper.map(postEntity, PostDto.class))
                .toList();
    }

    @Override
    public PostDto getPostById(Long id) {
       PostEntity post = postRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Post not found with this Id " +id));

       return modelMapper.map(post, PostDto.class);
    }
}
