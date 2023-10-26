package com.example.demo.restcontroller;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import java.util.ArrayList;
import java.util.List;

import com.example.demo.domain.dto.MovieDTO;
import com.example.demo.domain.dto.MovieImageDTO;
import com.example.demo.service.AdminService;
import com.example.demo.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
@RequestMapping(value="/admintest")
public class AdminRestController {
	
	@Autowired
	private MovieService movieService;

    @Autowired
    private AdminService adminService;
	
	@Value("${movie_apikey}")
	private String apiKey;

	@GetMapping(value="/addUpdate")
	public void movie_api() throws Exception {
		log.info("GET /admin/addUpdate...");
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Calendar cal = Calendar.getInstance();

		String today = sdf.format(cal.getTime());
		cal.add(Calendar.DATE, -30); //  일수 뺴기
		String yesterday = sdf.format(cal.getTime());
		
		//API URL
		String url = "https://api.themoviedb.org/3/discover/movie" + "?api_key=" + apiKey
				+ "&language=ko&region=kr&include_adult=false" + "&primary_release_date.gte=" + yesterday + "&primary_release_date.lte="
				+ today;
		
		RestTemplate rt = new RestTemplate();
		
        //Call
		MovieResponseDto response =  rt.getForObject(url, MovieResponseDto.class);
        
        List<MovieDTO> movies = new ArrayList<>();
        List<MovieImageDTO> movieimages = new ArrayList<>();
        
        for (MovieResultDto result : response.getResults()) {
            MovieDTO movie = new MovieDTO();
            MovieImageDTO movieImage = new MovieImageDTO();
            //영화 정보
            movie.setMovieId(result.getId());
            movie.setMovieName(result.getTitle());
            movie.setMovieRelease(result.getRelease_date());
            movie.setMovieRating(result.getVote_average()); // Assuming rating is a String
            movie.setMovieInfo(result.getOverview());
            //이미지
            movieImage.setImgId(result.getId());
            movieImage.setImgLink(result.getPoster_path());
            movies.add(movie);
            
            //장르 따로 받아야 함
            int col1 = movie.getMovieId();
            StringBuilder genresBuilder = new StringBuilder();
            String genresurl = "https://api.themoviedb.org/3/movie/" + col1 +"?api_key=" + apiKey + "&language=ko&region=kr&include_adult=false";
            MovieResponseDto2 genresresponse =  rt.getForObject(genresurl, MovieResponseDto2.class);
            
            for (MovieResultDto2 genresresult : genresresponse.getGenres()) {
            	if (genresBuilder.length() > 0) {
                    // 이미 다른 장르가 추가되었다면 쉼표와 공백을 추가
                    genresBuilder.append(", ");
                }
                genresBuilder.append(genresresult.getName());
            }
            movie.setMovieType(genresBuilder.toString());
            
            //영화 정보, 이미지 movies에 추가
            movies.add(movie);
            movieimages.add(movieImage);

        }
        //서비스 실행
        adminService.movie_insert(movies);
        adminService.movie_image_insert(movieimages);
	}
	
}

//영화 데이터
@Data
class MovieResponseDto {
    private int page;
    private int total_pages;
    private int total_results;
    private List<MovieResultDto> results;

}

@Data 
class MovieResultDto {
    private int id;
    private String title;
    private String release_date;
    private int vote_average;
    private String overview;
    private String poster_path;
}

//장르 데이터
@Data
class MovieResponseDto2 {
	private String title;
    private List<MovieResultDto2> genres;
}

@Data 
class MovieResultDto2 {
	private String id;
    private String name;
}
