import {NgModule} from '@angular/core';
import {Routes, RouterModule} from '@angular/router';
import {ReportComponent} from "./pages/report/report.component";
import {SurveyComponent} from "./pages/survey/survey.component";
import {Error404Component} from "./pages/error/error404/error404.component";


const routes: Routes = [
  {path: '', component: SurveyComponent},
  {path: 'report', component: ReportComponent},
  {path: '**', component: Error404Component},

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {
}
