import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { IsbnListComponent } from './isbn-list/isbn-list.component';

const routes: Routes = [
  { path: '', component: IsbnListComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
