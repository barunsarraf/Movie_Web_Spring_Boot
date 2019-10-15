import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { MovieService } from '../movie.service';
import { favourites} from '../favourites';

@Component({
  selector: 'app-favourites',
  templateUrl: './favourites.component.html',
  styleUrls: ['./favourites.component.css']
})
export class FavouritesComponent implements OnInit {
  favList : favourites[];
  constructor(private router: Router, private _movieService: MovieService) { }

  ngOnInit() {
    this._movieService.getFavourites().subscribe(data => this.favList = data as favourites[]);
  }
  goToMovie(movieId){
    this.router.navigate(['./movie',{id:movieId}]);
  }

}
