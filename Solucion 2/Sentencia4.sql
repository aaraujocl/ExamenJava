  SELECT
    cli.idcliente as "Código de Cliente", 
	cli.nombre as "Nombre de Cliente", 
	prov.descripcion as "Provincia", 
	p.descripcion as "Producto", 
	count(*) as "Número de Ventas", 
	SUM(p.precio) as "Importe Total"
FROM
    compra c
inner join producto p 
    on c.idproducto=p.idproducto
inner join cliente cli 
    on c.idcliente = cli.idcliente    
inner join provincia prov
   on cli.idprovincia = prov.idprovincia  group by  cli.idcliente, cli.nombre,prov.descripcion, p.descripcion