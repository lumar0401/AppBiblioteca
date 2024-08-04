package com.Biblioteca.App.Utils;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class utils {
	
	public static String calculoFecha(int tipousuario) {
		LocalDate date = LocalDate.now();
		
		int dias = 0;
		
		switch (tipousuario) {
		case 1:
			dias = 10;
			break;
		case 2:
			dias = 8;
			break;
		case 3:
			dias = 7;
			break;
		default:
			dias = 0;
			break;
		} 
		
		int diasAdicionales = 0;
		
		while(diasAdicionales < dias) {
			date = date.plusDays(1);
			
			if(!(date.getDayOfWeek() == DayOfWeek.SATURDAY || date.getDayOfWeek() == DayOfWeek.SUNDAY)) {
				diasAdicionales++;
			}
		}
		
		return formatearFecha(date);
	}
	
	private static String formatearFecha(LocalDate fecha) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        return fecha.format(formatter);
    }
}
