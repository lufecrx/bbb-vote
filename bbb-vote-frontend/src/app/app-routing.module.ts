import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { VotingPageComponent } from './components/voting-page/voting-page.component';
import { RegisterVoteComponent } from './components/register-vote/register-vote.component';

const routes: Routes = [
  { path: 'vote', component: VotingPageComponent  },
  { path: 'register-vote', component: RegisterVoteComponent },
  { path: '', redirectTo: 'vote', pathMatch: 'full' }
];

@NgModule({
  imports: [RouterModule.forRoot(routes, { enableTracing: true })],
  exports: [RouterModule]
})
export class AppRoutingModule { }
