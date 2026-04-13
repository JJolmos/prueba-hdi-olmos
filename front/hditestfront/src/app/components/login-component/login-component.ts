import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { MatCardModule } from '@angular/material/card';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatInputModule } from '@angular/material/input';
import { MatButtonModule } from '@angular/material/button';
import { MatSnackBar } from '@angular/material/snack-bar';
import { MatIconModule } from '@angular/material/icon';
import { AuthService } from '../../services/auth-service';

@Component({
  selector: 'app-login-component',
  imports: [
    CommonModule,
    FormsModule,
    MatCardModule,
    MatFormFieldModule,
    MatInputModule,
    MatButtonModule,
    MatIconModule],
  templateUrl: './login-component.html',
  styleUrl: './login-component.css',
})
export class LoginComponent implements OnInit {

  loginData = { correo: '', contrasena: '' };

  constructor(private authService: AuthService,
    private router: Router,
    private route: ActivatedRoute,
    private snackBar: MatSnackBar) { }

  ngOnInit() {
    this.authService.logout();
    console.log('Sesión previa limpiada para nuevo inicio.');
    this.route.queryParams.subscribe(params => {
      if (params['authError'] === 'unauthorized') {
        this.snackBar.open('Hubo un problema con tu Autenticacion', 'Cerrar', {
          duration: 3000,
          horizontalPosition: 'center',
          verticalPosition: 'bottom',
          panelClass: ['error-snackbar'] 
        });
      }
    });
  }

  onLogin() {
    this.authService.login(this.loginData).subscribe({
      next: (response) => {
        console.log('Login exitoso', response);
        this.router.navigate(['/dashboard']);
      },
      error: (err) => {

      }
    });


  }
}



