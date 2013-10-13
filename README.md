Curso de desarrollo en móviles (Android)
TADK
====

Curso / taller de desarrollo en la plataforma Android.

Contiene código con clases de ejemplo de: Activities, Listview, Asynchronous tasks, Services, consuming JSON / XML, Content providers, Fragments, Notifications, Sensors, Services.
  
Link de descarga de la presentación del tema de conceptos en Android.

https://db.tt/tMbcGGf7

Link a repositorio con la práctica final de cada participante en el curso.

https://github.com/angelofdeathv1/FinalCursoAndroid

---------------------------------------------
Crear Actividad - login (1)
	Boton para iniciar (1)
		Json(4)
		Abrir actividad Menu (1)

Crear Actividad menu de opciones (1) 
	Boton de usuarios (1)
		Abrir actividad listado de usuario (1)
	Boton de Hola Mundo (1)
		Abrir actividad hola mundo(1)

Crear actividad - hola mundo (1)

Crear Actividad - listado de usuarios (1)
	Crear adapter (2)
	Crear pojo (1)
	ListView (3)
		Json (4)
	Seleccionar elemento en listview (2)
		Abrir actividad de detalle de usuarios (1)
	Agregar Action bar (Agregar iconos) (1)
		Item para actualizar la lista (2)
		Item para agregar un usuario nuevo (2)
			Abrir actividad de forma de usaurio(1)

Crear Actividad - Detalles de usuarios (1)
	Cargar en pantalla la informacion (2)
	Agregar Action bar (Agregar iconos, paritido en 2) (2)
		Item para eliminar el usuario (1)
			Json(4)
			Mostrar Notificacion de aplicacion(2)
			Regresar a pantalla anterior(2)
		Item para abrir el mapa a partir de las coordenadas del usuario (3)

Crear actividad - Forma de usuarios (1)
	Leer elementos capturados (2)
	Cargar longitud y latidud, automaticas (2)
	Action bar (Agregar iconos) (1)
		Item para guardar (1)
			ajax(5)
			Regresar a pantalla anterior (2)

			
Manejar estilos (2)
Utilizar dialogo de procesos (2)
  
-----------------
Solicitudes para json
server - http://localhost/ANDROIDSERVICE_WEB/UK/PAGE_PracticaFinal.awp
login - http://localhost/ANDROIDSERVICE_WEB/UK/PAGE_PracticaFinal.awp?accion=login&usuario=android&contrasena=TADK
exito={"status":"ok"}
error={"status":"error","descripcion":"No se pudo hacer login :( usuario contrasena"}


lista de usuarios - http://localhost/ANDROIDSERVICE_WEB/UK/PAGE_PracticaFinal.awp?accion=usuarios
exito={"status":"ok","list":[{"UsuariosID":2,"Nombre":"Angel","Paterno":"Arambula","Materno":"Garcia","FechaIngreso":"20121011","Foto":"","Latitud":"32.5250","Longitud":"-117.0166700"},{"UsuariosID":5,"Nombre":"Jesus","Paterno":"Amador","Materno":"Figueroa","FechaIngreso":"20131011","Foto":"","Latitud":"-117","Longitud":"32"}}

agregar usuario -  http://192.168.1.81/ANDROIDSERVICE_WEB/UK/PAGE_PracticaFinal.awp?accion=agregar&nombre=Nombro&paterno=Paterno&materno=Materno&fecha&longitud=Longitud&latitud=Latitud
exito={"status":"ok","descripcion":"Usuario registrado :(","id":"id"}
error={"status":"error","descripcion":"No se encontro el nombre del usuario :("}

eliminar usuario - http://localhost/ANDROIDSERVICE_WEB/UK/PAGE_PracticaFinal.awp?accion=eliminar&id=id
exito={"status":"ok","descripcion":"Usuario eliminado :("}
error={"status":"error","descripcion":"No se encontro el usuario a eliminar :("}
