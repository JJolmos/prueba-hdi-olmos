import { Component, computed, effect, inject, OnInit, signal, TemplateRef, ViewChild, } from '@angular/core';
import { CommonModule } from '@angular/common'
import { FormControl, FormGroup, ReactiveFormsModule, Validators } from '@angular/forms';
import { MatTableDataSource, MatTableModule } from '@angular/material/table';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatInputModule } from '@angular/material/input';
import { MatSidenav, MatSidenavModule } from '@angular/material/sidenav';
import { MatButtonModule } from '@angular/material/button';
import { MatIconModule } from '@angular/material/icon';
import { MatPaginator, MatPaginatorModule } from '@angular/material/paginator';
import { MatDatepickerModule } from '@angular/material/datepicker';
import { MatSelectModule } from '@angular/material/select';
import { MatDialog, MatDialogModule } from '@angular/material/dialog';
import { MatNativeDateModule } from '@angular/material/core';
import { PolizaService } from '../../services/poliza-service';
import { ErrorStateMatcher } from '@angular/material/core';
import { MatSnackBar } from '@angular/material/snack-bar';
import { UsuarioService } from '../../services/usuario-service';
import { Poliza } from '../../model/poliza-model';
import { AuthService } from '../../services/auth-service';
import { ReporteService } from '../../services/reporte-service';
import { ValidationStateMatcher } from '../../util/validation-matcher';
import { validatePolizaDates } from '../../util/validate-date';



@Component({
  selector: 'app-dashboard-component',
  imports: [MatTableModule, MatFormFieldModule, MatInputModule, ReactiveFormsModule, MatSidenavModule, MatButtonModule, MatIconModule,
    ReactiveFormsModule, CommonModule, MatPaginatorModule, MatDatepickerModule, MatNativeDateModule, MatSelectModule, MatDialogModule],
  providers: [{ provide: ErrorStateMatcher, useClass: ValidationStateMatcher }],
  templateUrl: './dashboard-component.html',
  styleUrl: './dashboard-component.css',
})
export class DashboardComponent implements OnInit {

  @ViewChild(MatPaginator) paginator!: MatPaginator;
  @ViewChild('dialogTemplate') dialogTemplate!: TemplateRef<any>;
  @ViewChild('sidenav') sidenav!: MatSidenav;

  dataSource = new MatTableDataSource<Poliza>();
  searchNumero = new FormControl('');
  searchAsegurado = new FormControl('');
  reporteForm = new FormGroup({
    fechaOcurrencia: new FormControl(new Date(), { nonNullable: true, validators: [Validators.required] }),
    lugarSiniestro: new FormControl('', { nonNullable: true, validators: [Validators.required] }),
    nombreReporta: new FormControl('', { nonNullable: true, validators: [Validators.required] }),
    telefonoContacto: new FormControl('', { nonNullable: true, validators: [Validators.required, Validators.pattern('^[0-9]{10}$')] }),
    correoElectronico: new FormControl('', { nonNullable: true, validators: [Validators.required, Validators.email] }),
    descripcionSiniestro: new FormControl('', { nonNullable: true, validators: [Validators.required] }),
    placas: new FormControl('', { nonNullable: true, validators: [Validators.required] }),
    color: new FormControl('', { nonNullable: true, validators: [Validators.required] }),
    observaciones: new FormControl(''),
    nombreAjustador: new FormControl('', { nonNullable: true, validators: [Validators.required] })
  });

  usuario = computed(() => this.authService.usuario());
  idPoliza = signal<number>(0);
  vigenciaPoliza = signal({
    inicio: new Date(),
    fin: new Date()
  })
  maxDate: Date = new Date();
  private dialog = inject(MatDialog);
  private polizaService = inject(PolizaService);
  private reporteService = inject(ReporteService);
  private authService = inject(AuthService);
  private snackBar = inject(MatSnackBar);
  usuarioService = inject(UsuarioService);
  matcher = new ValidationStateMatcher();

  usuarios = computed(() => {
    if (!this.authService.isAuthenticated()) return [];
    const res = this.usuarioService.usuariosResource.value();
    return res ?? [];
  });

  polizas = computed(() => {
    if (!this.authService.isAuthenticated()) return [];
    const res = this.polizaService.polizasResource.value();
    return res ?? [];
  });
  isLoading = computed(() => this.polizaService.polizasResource.isLoading());


  displayedColumns: string[] = [
    'noPoliza',
    'asegurado',
    'liNeanegocio',
    'vigencia',
    'vehiculo',
    'acciones'
  ];

  constructor() {
    effect(() => {
      this.dataSource.data = this.polizas();
      if (this.paginator) {
        this.dataSource.paginator = this.paginator;
      }
    });
  }

  ngOnInit() {
  }

  setDatosPoliza(poliza: Poliza) {
    this.idPoliza.set(Number(poliza.idPoliza));
    this.vigenciaPoliza.set({
      inicio: poliza.inicioVigencia,
      fin: poliza.finVigencia
    });

  }

  guardarReporte() {
    if (this.reporteForm.valid) {
      //validaciones de fechas
      const _poliza = this.vigenciaPoliza();
      if (!validatePolizaDates.isVigente(_poliza.inicio, _poliza.fin, this.reporteForm.get('fechaOcurrencia')?.value ?? new Date())) {
        this.snackBar.open('Poliza fuera de vigencia', 'Cerrar', {
          duration: 3000,
          horizontalPosition: 'center',
          verticalPosition: 'bottom',
          panelClass: ['error-snackbar'] 
        });
        return;
      }
      if (validatePolizaDates.esFechaValidaEnRango(this.reporteForm.get('fechaOcurrencia')?.value ?? new Date())) {
        this.snackBar.open('No puede reportar un siniestro despues de 18 meses', 'Cerrar', {
          duration: 3000,
          horizontalPosition: 'center',
          verticalPosition: 'bottom',
          panelClass: ['error-snackbar'] 
        });
        return;
      }

      const selectedValue = this.reporteForm.get('nombreAjustador')?.value;
      const selectedOption = this.usuarios().find(opt => opt.correo === selectedValue);
      // console.log('Texto seleccionado:', selectedOption?.nombreUsuario);
      const datos = {
        ...this.reporteForm.getRawValue(),
        idPoliza: this.idPoliza(),
        correoAjustador: this.reporteForm.get('nombreAjustador')?.value,
        nombreAjustador: selectedOption?.nombreUsuario
      };
      console.log('Enviando reporte:', datos);
      this.reporteService.crearReporte(datos).subscribe({
        next: (response) => {
          console.log('Reporte guardado con éxito', response);
          // this.reporteForm.reset();
          this.sidenav.close();
          this.dialog.open(this.dialogTemplate, {
            data: response,
            width: '450px'
          });
        },
        error: (err) => {
          console.error('Error al guardar el reporte', err);
        }
      });
    }
  }

  buscarPoliza() {
    this.polizaService.buscar(this.searchAsegurado.value ?? '', this.searchNumero.value ?? '');
  }

  limpiar() {
    this.searchAsegurado.setValue('');
    this.searchNumero.setValue('');
    this.polizaService.buscar("", "");
  }

  resetForm() {
    console.log("POLIZA ::::: " + this.idPoliza)
    this.reporteForm.reset({
      fechaOcurrencia: new Date(),
    });

    const _usuario = this.usuario();
    if (_usuario) {
      const control = this.reporteForm.get('nombreAjustador');
      control?.setValue(_usuario.correo);
      if (_usuario.idRol !== 1) {
        control?.disable();
      }
    }
  }

}