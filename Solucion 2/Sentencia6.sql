SELECT
    cli.idcliente as "Código de Cliente", 
	cli.nombre as "Nombre", 
	prov.descripcion as "Provincia",
	to_char(c.fecha,'Mon') as "Mes", 
	count(*) as "Número de Compras", 
	SUM(p.precio) as "Importe Total"
FROM
    compra c
inner join producto p 
    on c.idproducto=p.idproducto
inner join cliente cli 
    on c.idcliente = cli.idcliente    
inner join provincia prov
   on cli.idprovincia = prov.idprovincia group by cli.idcliente,cli.nombre,prov.descripcion,to_char(c.fecha,'Mon')