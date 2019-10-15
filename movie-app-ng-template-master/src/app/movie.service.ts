import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { favourites } from './favourites';
const httpOptions = {
  headers: new HttpHeaders({'Content-Type':'application/json'})
};
@Injectable({
  providedIn: 'root'
})
export class MovieService {

  constructor(private http:HttpClient) { }
  private _url = 'https://api.themoviedb.org/3/movie/';
  private apiKey = 'b2edde3062978e00f939b23cc1cb99a0';
  getMovies(): any{
    let moviesUrl = `${this._url}popular?api_key=${this.apiKey}&language=${'en'}`;
    return this.http.get(moviesUrl);
  }
  getParticularMovie(movie_id): any{
    let movieUrl = `https://api.themoviedb.org/3/movie/${movie_id}?api_key=${this.apiKey}&language=en-US`;
    return this.http.get(movieUrl);
  }
  getSearchedMovies(search_query): any{
    let search_url = `https://api.themoviedb.org/3/search/movie?api_key=${this.apiKey}&language=en-US&page=1&include_adult=false&query=${search_query}`
    return this.http.get(search_url);
  }
  getFavourites():any{
    let search_url = `http://localhost:3000/posts`;
    return this.http.get(search_url);
  }
  addFavourites(newFav: favourites):any{
    let post_url = `http://localhost:3000/posts`;
    return this.http.post(post_url,newFav,httpOptions);
  }
  checkIfFav(id):any{
    let _url = `http://localhost:3000/posts/${id}`;
    return this.http.get(_url);
  }
  removeFromFavourites(id): any{
    let _url = `http://localhost:3000/posts/${id}`;
    return this.http.delete(_url,httpOptions);
  }
  updateComments(favObj):any{
    let _url = `http://localhost:3000/posts/${favObj.id}`;
    return this.http.put(_url,favObj,httpOptions);
  }
  
  savemovie(movieobj)
  {
    console.log(movieobj);
    let _url = `http://localhost:8777/movieservice`;
    return this.http.post(_url,movieobj,httpOptions);
  }


  
  
}
