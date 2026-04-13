export class validatePolizaDates {
    
  static isVigente(fechaInicio: string | Date, fechaFin: string | Date, fecharegistro: string | Date ): boolean {
    const registro = new Date(fecharegistro);
    const inicio = new Date(fechaInicio);
    const fin = new Date(fechaFin);


    registro.setHours(0, 0, 0, 0);
    inicio.setHours(0, 0, 0, 0);
    fin.setHours(0, 0, 0, 0);

    return registro >= inicio && registro <= fin;
  }

  static esFechaValidaEnRango(fecharegistro: string | Date) {
    const hoy = new Date();
    const fechaRegistro = new Date(fecharegistro);
    const fechaLimite = new Date();
    fechaLimite.setMonth(hoy.getMonth() - 18);
    console.log(fechaLimite);
    return fechaRegistro < fechaLimite;
}

}