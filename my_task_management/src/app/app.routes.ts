import { Routes } from '@angular/router';
import { HomeComponent } from './features/home/home';
import { AUTH_ROUTES } from './features/auth/auth.routes';


export const routes: Routes = [
  { 
    path: '', 
    component: HomeComponent,
    title: 'Home - Task Management'
  },
  {
    path: 'auth',
    loadChildren: () =>
      import('./features/auth/auth.routes').then(m => m.AUTH_ROUTES)
  }
];