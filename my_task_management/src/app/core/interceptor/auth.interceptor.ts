import { Injectable } from '@angular/core';
import {
  HttpInterceptor,
  HttpRequest,
  HttpHandler,
  HttpEvent,
} from '@angular/common/http';
import { Observable } from 'rxjs';
import { environment } from '../../../enviroment/environment';

@Injectable()
export class AuthInterceptor implements HttpInterceptor {
  private readonly API_BASE_URL = 'http://localhost:2001/api'; // 👈 đặt base URL của bạn

  intercept(
    req: HttpRequest<any>,
    next: HttpHandler
  ): Observable<HttpEvent<any>> {
    const isApiUrl = req.url.startsWith(this.API_BASE_URL);

    if (!isApiUrl || req.url.includes('/auth/login')) {
      return next.handle(req);
    }

    const token = localStorage.getItem('access_token');

    if (token) {
      const cloned = req.clone({
        setHeaders: { Authorization: `Bearer ${token}` },
      });
      return next.handle(cloned);
    }

    return next.handle(req);
  }
}
