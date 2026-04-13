import { Injectable, inject, signal } from '@angular/core';
import { httpResource } from '@angular/common/http';
import { Poliza } from '../model/poliza-model';

@Injectable({ providedIn: 'root' })
export class PolizaService {

    private apiUrl = 'http://localhost:8080/api/polizas';
    private filtros = signal<{ asegurado?: string, noPoliza?: string }>({});

    polizasResource = httpResource<Poliza[]>(() => {
        const f = this.filtros();

        const isFiltered = f.asegurado || f.noPoliza;
        const url = isFiltered ? `${this.apiUrl}/getPolizaByAseguradoOrNoPoliza` : this.apiUrl;

        return {
            url: url,
            method: 'GET',
            params: {
                asegurado: f.asegurado ?? '',
                noPoliza: f.noPoliza ?? ''
            }
        };
    }, {
        defaultValue: []
    });


    buscar(asegurado: string, noPoliza: string) {
        this.filtros.set({ asegurado, noPoliza });
    }

    refresh() {
        this.polizasResource.reload();
    }
}