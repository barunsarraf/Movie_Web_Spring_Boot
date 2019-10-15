import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, ParamMap, Router } from '@angular/router';
import { MovieService } from '../movie.service';
import { favourites } from '../favourites';
//import {Location} from '@angular/common';

@Component({
  selector: 'app-movie',
  templateUrl: './movie.component.html',
  styleUrls: ['./movie.component.css']
})
export class MovieComponent implements OnInit {
  public movieId;
  public movie=[];
  public isFav;
  public favObj = {};
  public commentVal;
  favourites: favourites[];
  public tobeEditedIndex;
  public styleObj = {};
  public tobeEdited = false;
  constructor(private route: ActivatedRoute, private _movieService: MovieService,private router:Router) { }

  ngOnInit() {
    this.route.paramMap.subscribe((params:ParamMap)=>{
      this.movieId = params.get('id');
    });
    this._movieService.getParticularMovie(this.movieId)
                                .subscribe(data => this.movie=data);
   
    //this.styleObj = {
    //  'background-image': 'url(`https://image.tmdb.org/t/p/w500"+${movie.backdrop_path} `)'
    //};
  }
 // goForward(){
  //  this.location.forward();}
  addToFavourites(id,poster,title){
    const newFav: favourites = new favourites();
    newFav.id = id;
    newFav.poster_path = poster;
    newFav.title = title;
    newFav.comments = [];
    this._movieService.addFavourites(newFav)
                    .subscribe(
                      ()=>{this.ngOnInit();}
                    );
  }
  removeFromFav(movieId){
    this._movieService.removeFromFavourites(movieId).subscribe(
      ()=>{this.ngOnInit();}
    );
  }
  addComment(favObj){
    console.log(this.commentVal);
    favObj.comments.push(this.commentVal);
    this._movieService.updateComments(favObj).subscribe(
      ()=>{this.commentVal='';
      this.ngOnInit();}
    );
    
  }
 deleteComment(favObj,i){
    delete(favObj.comments[i]);
    this._movieService.updateComments(favObj).subscribe(
      ()=>{this.ngOnInit();}
    );
  }
  editComment(i){
    this.tobeEdited = true;
    this.tobeEditedIndex = i;
  }
  editTheComment(favObj,i,commentValEdit){
    favObj.comments[i] = commentValEdit;
    this._movieService.updateComments(favObj).subscribe(
      ()=>{
        this.tobeEdited = false;
        this.ngOnInit();}
    );
  }
  updatemovie(name,cast,genre,budget,date)
  {
    var updatedmovie={"movieId":this.movieId,"movieName":name,"movieCast":cast,"movieGenre":genre,"movieReleaseDate":date};
    this._movieService.updatemovie(updatedmovie).subscribe();
    this.router.navigateByUrl(`/favourite`);
  }
}
