import { HttpInterceptorFn, HttpErrorResponse } from '@angular/common/http';
import { inject } from '@angular/core';
import { Router } from '@angular/router';
import { catchError, of, throwError } from 'rxjs';

export const authInterceptor: HttpInterceptorFn = (req, next) => {
  const router = inject(Router);
  const token = typeof localStorage !== 'undefined' ? localStorage.getItem('token') : null;
  
  const isLoginUrl = req.url.includes('/auth/login');
  if (token && !isLoginUrl){ 
    req = req.clone({
      setHeaders: { Authorization: `Bearer ${token}` }
    });
  }

  return next(req).pipe(
    catchError((error: HttpErrorResponse) => {
      if (error.status === 401 ) {
        if (typeof localStorage !== 'undefined') {
          localStorage.removeItem('token');
        }
        router.navigate(['/login'], { queryParams: { authError: 'unauthorized' }});
         return of([] as any); 
      }
      return throwError(() => error);
    })
  );
};