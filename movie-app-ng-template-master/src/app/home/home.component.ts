import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { MovieService } from '../movie.service';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {
  public movies =  [];
  constructor(private _movieService : MovieService,private router: Router) { }

  ngOnInit() {
    this._movieService.getMovies().subscribe(data => this.movies = data);
  }
  toSearch(movieName){
    this.router.navigate(['./search',{name:movieName}]);
  }
  goToMovie(movieId){
    this.router.navigate(['./movie',{id:movieId}]);
  }
  savemovie(id,moviename,moviecast)
  {
    console.log(id,moviename,moviecast);
    var movie={"movieId":id,"movieName":moviename,"movieCast":moviecast};
    this._movieService.savemovie(movie).subscribe();
  }
  deleteMovie(id)
  {
    console.log("delete id: ",id);

    this._movieService.deleteMovieById(id).subscribe();
  }

  registernewuser(userid,userfname,userlname,userage)
  {
    var user=  {
      "id": userid,
      "firstName": userfname,
      "lastName": userlname,
      "age": userage
  }
    this._movieService.registernewuser(user).subscribe();
    this.router.navigateByUrl(`favourites`);
  }


}
