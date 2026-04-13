package com.hdi.prueba.util;

import java.util.Date;
import java.time.LocalDate;

public class ValidateDatePoliza {

    public static boolean isReporteValidDate( Date fechaReporte,  Date finVigencia, Date inicioVigencia)  {
        LocalDate fReporte = fechaReporte.toInstant().atZone(java.time.ZoneId.systemDefault()).toLocalDate();
        LocalDate fiVigencia = inicioVigencia.toInstant().atZone(java.time.ZoneId.systemDefault()).toLocalDate();
        LocalDate ffVigencia = finVigencia.toInstant().atZone(java.time.ZoneId.systemDefault()).toLocalDate();
        LocalDate hoy = LocalDate.now(); 
        LocalDate fechaLimite = hoy.minusMonths(18); 
        //primero validar si esta en vigencia
        if (fReporte.isBefore(fiVigencia) && fReporte.isAfter(ffVigencia) ) {
            return false;
        }
        // validar 18
        if(fReporte.isBefore(fechaLimite)){
            return false;
        }

        return true;
    }
}
