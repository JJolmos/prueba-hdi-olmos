import { Injectable, inject, signal } from '@angular/core';
import { httpResource } from '@angular/common/http';
import { Usuario } from '../model/usuario-model';

@Injectable({ providedIn: 'root' })
export class UsuarioService {
    private apiUrl = 'http://localhost:8080/api/usuarios';

    usuariosResource = httpResource<Usuario[]>(() => ({
        
        url: this.apiUrl,
        method: 'GET',
        defaultValue: []
    }), {

    });

    refresh() {
        this.usuariosResource.reload();
    }
}