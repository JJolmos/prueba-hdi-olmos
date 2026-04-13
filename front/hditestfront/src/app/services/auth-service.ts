import { HttpClient } from '@angular/common/http';
import { computed, inject, Injectable, PLATFORM_ID, signal } from '@angular/core';
import { Observable, tap } from 'rxjs';
import { JwtHelperService } from '@auth0/angular-jwt';
import { isPlatformBrowser } from '@angular/common';
import { Usuario } from '../model/usuario-model';

@Injectable({ providedIn: 'root' })
export class AuthService {

  private platformId = inject(PLATFORM_ID);
  private apiUrl = 'http://localhost:8080/auth/login';
  private jwtHelper = new JwtHelperService();
  private _usuario = signal<Usuario | null>(null);
  usuario = computed(() => this._usuario());

  constructor(private http: HttpClient) {
    if (isPlatformBrowser(this.platformId)) {
      const sesionGuardada = localStorage.getItem('usuario_sesion');
      if (sesionGuardada) {
        this._usuario.set(JSON.parse(sesionGuardada));
      }
    }
  }

  public isAuthenticated(): boolean {
    if (isPlatformBrowser(this.platformId)) {
      const token = localStorage.getItem('token');
      return token ? !this.jwtHelper.isTokenExpired(token) : false;
    }
    return false;
  }

  setSesion(datos: Usuario) {
    if (isPlatformBrowser(this.platformId)) {
      localStorage.setItem('usuario_sesion', JSON.stringify(datos));
      this._usuario.set(datos);
    }
  }

  logout() {
    if (isPlatformBrowser(this.platformId)) {
      localStorage.removeItem('token');
      localStorage.removeItem('usuario_sesion');
      this._usuario.set(null);
    }
  }

  login(credentials: any): Observable<any> {
    return this.http.post<any>(this.apiUrl, credentials).pipe(
      tap(res => {
        if (res.token) {
          localStorage.setItem('token', res.token);
          this.setSesion(res.usuario);
        }
      })
    );
  }

}