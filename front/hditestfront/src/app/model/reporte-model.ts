export interface Reporte{
  fechaOcurrencia: Date;
  lugarSiniestro: string;
  nombreReporta: string;
  telefonoContacto: string;
  correoElectronico: string;
  descripcionSiniestro: string;
  placas: string;
  color: string;
  observaciones: string | null;
  nombreAjustador: string | undefined;
}