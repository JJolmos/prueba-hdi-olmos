import { Injectable, inject } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Reporte } from '../model/reporte-model'

@Injectable({
  providedIn: 'root'
})
export class ReporteService {
  private http = inject(HttpClient);
  private apiUrl = 'http://localhost:8080/api/reportes'; // Ajusta a tu URL de Spring Boot

  // Método para mandar el JSON al backend
  crearReporte(reporte: Reporte) {
    return this.http.post<Reporte>(this.apiUrl, reporte);
  }
}