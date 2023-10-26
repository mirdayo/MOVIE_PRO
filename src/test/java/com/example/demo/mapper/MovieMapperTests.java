package com.example.demo.mapper;

import com.example.demo.domain.dto.MovieDTO;
import com.example.demo.domain.paging.Criteria;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;


@SpringBootTest
@Slf4j
public class MovieMapperTests {

	@Autowired
	MovieMapper movieMapper;

	//영화조회
	@Test
	public void selectTest() {


		MovieDTO movieDTO = movieMapper.select(5);

		System.out.println("결과 값 : " + movieDTO);
	}

    //영화추가
//	@Test
//	public void insertTest() {
//
//		MovieDTO movie = new MovieDTO();
//
//		movie.setMovieName("테스트제목");
//		movie.setMovieInfo("테스트인포");
//		movie.setMovieRating("7");
//		movie.setMovieType("테스트타입");
//		movie.setMovieRelease("테스트릴리즈");
//
//		movieMapper.insert(movie);
//	}

//    @Test
//    public void selectTest() {
//
//        int movieId = 27;
//
//        MovieDTO result = movieMapper.select(movieId);
//        System.out.println("==============================");
//        System.out.println(result);
//        System.out.println("==============================");
//
//
//    }
//
//	@Test
//	public void deleteTest() {
//
//
//		movieMapper.delete(62);
//	}

//	@Test
//	public void getListPagingTest(){
//		Criteria criteria = new Criteria();
//
//		criteria.setPageNum(2);
//
//		List list = movieMapper.getListPaging(criteria, search);
//
//		list.forEach(movie -> log.info("" + movie));
//	}


	@Test
	public void searchMovieTest(){

		Criteria criteria = new Criteria();
		String keyword = "센과";

		criteria.setKeyword(keyword);


		List<MovieDTO> list = movieMapper.searchMovie(criteria);

		System.out.println("criteria : " + criteria);
		System.out.println("list : " + list);
	}

}

