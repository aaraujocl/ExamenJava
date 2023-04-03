INSERT INTO public.usuario(activo, actualizadoel, borrado, codigouser, creadoel, email, emailconfirmado, esadministrador, imagen, nombrecompleto, nombreusuario, ocupacion, password, telefono, telefonoconfirmado, valido, vencepassword)
VALUES 
(true, now(), false, 'c2d29867-3d0b-d497-9191-18a9d8ee7830', now(), 'a.araujo.cl@hotmail.com', true, true, '', 'Alfonso Araujo','aaraujo','Developer', '123456', '3213740026', true, true, now() + INTERVAL'1 year'),
(true, now(), false, 'f2f29867-3d0b-d497-1010-20a9d8ee2512', now(), 'luisa.alejandra@hotmail.com', true, true, '', 'Luisa Alejandra','lalejandra','Product Owner', '123456', '3708520147', true, true, now() + INTERVAL'1 year'),
(true, now(), false, 'c2d29956-3d0b-d497-9191-18a9d8ee2515', now(), 'maite0408@hotmail.com', true, false, '', 'Maria Angulo','mangulo','Developer', '123456', '3708523698', true, true, now() + INTERVAL'1 year') ON CONFLICT (email) DO NOTHING;
	
INSERT INTO public.rol(activo, creadoel, descripcion, nombre)
	VALUES 
	(true,now(), 'Administra todas las operaciones del sistema', 'Admin'),
	(true,now(), 'Verifica las operaciones', 'Consultor') ON CONFLICT (nombre) DO NOTHING;
	
	INSERT INTO public.usuario_roles(usuario_id, roles_id)
	VALUES 
	((SELECT id FROM public.usuario where codigouser='c2d29867-3d0b-d497-9191-18a9d8ee7830'), (SELECT id FROM public.rol where nombre='Admin')),
	((SELECT id FROM public.usuario where codigouser='f2f29867-3d0b-d497-1010-20a9d8ee2512'), (SELECT id FROM public.rol where nombre='Consultor')),
	((SELECT id FROM public.usuario where codigouser='c2d29956-3d0b-d497-9191-18a9d8ee2515'), (SELECT id FROM public.rol where nombre='Consultor'));
	
INSERT INTO public.cliente(
	nombre, importe)
	VALUES 
	('Wilfredo Moreno', 850000),
	('Pablo Marin', 170000),
	('Jose Urquiola', 225000) ON CONFLICT (nombre) DO NOTHING;