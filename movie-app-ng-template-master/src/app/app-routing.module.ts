import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { HomeComponent } from './home/home.component';
import { MovieComponent } from './movie/movie.component';
import { SearchComponent } from './search/search.component';
import { FavouritesComponent } from './favourites/favourites.component';
import { PageNotFoundComponent } from './page-not-found/page-not-found.component';


const routes: Routes = [
  {path: '', redirectTo:'/home',pathMatch : 'full'},
  {path: 'home', component: HomeComponent},
  {path: 'movie', component: MovieComponent},
  {path: 'search', component: SearchComponent},
  {path: 'favourites', component: FavouritesComponent},
  {path: '**', component:PageNotFoundComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
export const routingComponents = [HomeComponent,MovieComponent,SearchComponent
                                    ,FavouritesComponent];