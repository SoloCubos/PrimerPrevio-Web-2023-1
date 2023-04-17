package com.primer.previo.models;
import java.io.Serializable;
import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class Paciente implements Serializable {
	
	private Integer id;
	private String documento;
	private String nombre;
	private String apellido; 
	private String email;
	private String genero;
	private Date fechaNacimiento;
	private String telefono;
	private String direccion;
	private float peso;
	private float estatura;
	private String imc;
	
	public Paciente(String documento, String nombre, String apellido, String email, String genero, Date fechaNacimiento,
			String telefono, String direccion, float peso, float estatura) {
		super();
		this.documento = documento;
		this.nombre = nombre;
		this.apellido = apellido;
		this.email = email;
		this.genero = genero;
		this.fechaNacimiento = fechaNacimiento;
		this.telefono = telefono;
		this.direccion = direccion;
		this.peso = peso;
		this.estatura = estatura;
	}
	
	public void calcularIMC() {
		double Imc = 0;
        Imc = peso/(estatura * estatura);
        
        if(Imc < 18.5){
            this.imc = "Bajo Peso";
        }
        else if(Imc >= 18.5 && Imc <= 24.9){
        	this.imc =	"Normal";
        }
        else if(Imc >= 25.5 && Imc <= 29.9){
        	this.imc = "SobrePeso";
        }
        else {
        	this.imc = "Obesidad";
        }
	}

	public Paciente(Integer id, String documento, String nombre, String apellido, String email, String genero,
			Date fechaNacimiento, String telefono, String direccion, float peso, float estatura) {
		super();
		this.id = id;
		this.documento = documento;
		this.nombre = nombre;
		this.apellido = apellido;
		this.email = email;
		this.genero = genero;
		this.fechaNacimiento = fechaNacimiento;
		this.telefono = telefono;
		this.direccion = direccion;
		this.peso = peso;
		this.estatura = estatura;
	}
}
