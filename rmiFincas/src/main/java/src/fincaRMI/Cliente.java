package src.fincaRMI;

import java.rmi.Naming;
import java.util.ArrayList;
import java.util.Scanner;


public class Cliente {
	
	
	 public static int menu() {
		 int opt;
		 Scanner sc = new Scanner(System.in);
		 System.out.println("<<<<MENU>>>>");
		 System.out.println("1.- Alta Finca"
				 		+ "\n2.- Listar Fincas"
				 		+ "\n3.- Baja Finca"
				 		+ "\n4.- Dar huerto de alta."
				 		+ "\n5.- Dar huerto de baja."
				 		+ "\n6.- Listar huertos."
				 		+ "\n7.- Dar trabajador de alta"
				 		+ "\n8.- Listar trabajadores"
				 		+ "\n9.- Dar de baja trabajador");
		 System.out.println("Opcion: ");
		 opt=sc.nextInt();
		 sc.nextLine();
		 return opt;
	 }
	
	   public static void main(String[] args) {
		   try {
			   Trabajador trabajador = (Trabajador) Naming.lookup("rmi://localhost:8080/FincaTrabService");
			   Huerto huerto = (Huerto) Naming.lookup("rmi://localhost:1099/FincaHuService");
			   Finca finca = (Finca) Naming.lookup("rmi://localhost:8081/FincaService");
			   Scanner sc = new Scanner(System.in);
			   int id=0; //trabajador
			   int idh=0; //huerto
			   int idFinca=0; //finca
			   
			   while(true) {
				   int opt=menu();
				   switch (opt) {
				   
				//Alta Finca
				   case 1:
					   System.out.println("Introduzca el nombre de la fina: ");
					   finca.altaFinca(idFinca, sc.nextLine());
					   idFinca ++;
					   break;
					   
				//Lista Ficas
				   case 2:
					   ArrayList<Finca> fincas = finca.getFincas();
					   for(Finca f: fincas) {
						   System.out.println("ID: " + f.getIdFinca() + "\tFinca " + f.getNombreFinca());
					   }
					   break;
					   
				//Baja Finca
				   case 3:
					   System.out.println("ID de la finca a eliminar: ");
					   finca.borrarFinca(sc.nextInt());
					   sc.nextLine();
				   break;
				   
			    //Alta huerto
				   case 4:
					   System.out.println("Id de la finca a la que pertenece: ");
					   int idfh = sc.nextInt(); //id  de finca para el huerto
					   sc.nextLine();
					   
					   System.out.println("Alimento plantado: ");
					   String plantado = sc.nextLine();
					   
					   System.out.println("Dimensiones: ");
					   double dim = sc.nextDouble();
					   sc.nextLine();
					   
					   System.out.println("Agua consumida: ");
					   double agua = sc.nextDouble();
					   sc.nextLine();
					   
					   System.out.println("Precio: ");
					   float precio = sc.nextFloat();
					   sc.nextLine();
					   
					   System.out.println("Cantidad ");
					   int cantidad = sc.nextInt();
					   sc.nextLine();
					   
					   huerto.altaHuerto(idh, plantado, agua, dim, idfh, precio, cantidad);
					   idh++;
					   break;
					   
				//Baja huerto
				   case 5:
					   System.out.println("Id de la finca a la que pertenece: ");
					   idfh = sc.nextInt();
					   sc.nextLine();
					   
					   System.out.println("Id del huerto que quiere eliminar: ");
					   huerto.borrarHuerto(idfh,sc.nextInt());
					   sc.nextLine();
					   break;
					   
			    //Listar huertos
				   case 6:
					   System.out.println("Id de la finca a la que pertenecen: ");
					   idfh = sc.nextInt();
					   sc.nextLine();
					   ArrayList<Huerto> huertos = huerto.getHuertos(idfh);
					   if(huertos!=null) {
						   if(huertos.size()>0) {
							   for(Huerto h: huertos) {
								   System.out.println(   "Id: "+h.getId()
													   + " Alimento plantado: " + h.getAlimentoPlantado()
													   + " Dimensiones: "+h.getDimensionesM2()
													   + " Agua necesaria: "+h.getAguaConsumida()
													   );
							   }
						   }else {
							   System.out.println("Actualmente no hay huertos para esta finca");
						   }
						  
					   }else {
						   System.out.println("La finca indicada no existe");
					   }
					 
					   break;
					
				// ALTA Trabajador
				   case 7:
					   System.out.println("Id de la finca a la que pertenece: ");
					   int idft = sc.nextInt();
					   sc.nextLine();
					   System.out.println("Nombre: ");
					   String nombre = sc.nextLine();
					   System.out.println("Apellidos: ");
					   String apellidos = sc.nextLine();
					   System.out.println("Puesto: ");
					   String puesto = sc.nextLine();
					   System.out.println("Sueldo: ");
					   double sueldo = sc.nextDouble();
					   sc.nextLine();
					   trabajador.altaTrabajador(idft,id, nombre, apellidos, puesto, sueldo);
					   id++;
					   
					   break;
					   
				//Lista Trabajador
				   case 8:
					   System.out.println("Id de la finca a la que pertenecen: ");
					   idft = sc.nextInt();
					   sc.nextLine();
					   ArrayList<Trabajador> trabajadores = trabajador.listarTrabajadores(idft);
					   if(trabajadores!=null) {
						   if(trabajadores.size()>0) {
							   for(Trabajador tr: trabajadores) {
								   System.out.println("Id: "+tr.getId()+" Nombre: "+tr.getNombre() + " Apellidos: " + tr.getApellidos()+" Puesto: "+tr.getPuesto()+" Sueldo: "+tr.getSueldo());
							   }
						   }else {
							   System.out.println("Esta finca no tiene trabajadores");
						   }
					   }else {
						   System.out.println("La finca indicada no existe");
					   }
					   					   
					   break;
					   
				 //Baja trabajador
				   case 9:
					   System.out.println("Id de la finca a la que pertenece: ");
					   idft = sc.nextInt();
					   sc.nextLine();
					   System.out.println("Introduzca el id del trabajador que desea dar de baja: ");
					   int idRemove = sc.nextInt();
					   trabajador.bajaTrabajador(idft,idRemove);
					   
					   
					   break;
					   
				   
				   }
				
			   }
			   
			   //c.listarTrabajadores();
			   //System.out.println(trabajadores.size());
			   
			  
			   
		   }catch (Exception e) {
			   System.out.println("ERROR");
			   main(args);
		   } 	
		}
	}
