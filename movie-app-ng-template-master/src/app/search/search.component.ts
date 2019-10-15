import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router, ParamMap} from '@angular/router';
import { MovieService } from '../movie.service';

@Component({
  selector: 'app-search',
  templateUrl: './search.component.html',
  styleUrls: ['./search.component.css']
})
export class SearchComponent implements OnInit {
  public searchMovieName;
  public searchResult={};
  constructor(private route: ActivatedRoute, private router: Router, private _movieService: MovieService) { }

  ngOnInit() {
    this.route.paramMap.subscribe((params:ParamMap)=> {
      this.searchMovieName = params.get('name');
    });
    this._movieService.getSearchedMovies(this.searchMovieName)
                              .subscribe(data=>this.searchResult=data);
  }
  goToMovie(movieId){
    this.router.navigate(['./movie',{id:movieId}]);
  }

}
