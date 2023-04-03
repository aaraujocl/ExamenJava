SELECT
    cli.idcliente as "Código de Cliente", 
	cli.nombre as "Nombre de Cliente", 
	prov.descripcion as "Nombre de Provincia", 
	p.descripcion as "Producto", 
	p.precio as "Importe", 
	c.fecha as "Fecha"
FROM
    compra c
inner join producto p 
    on c.idproducto=p.idproducto
inner join cliente cli 
    on c.idcliente = cli.idcliente    
inner join provincia prov
   on cli.idprovincia = prov.idprovincia  
   where ((cli.idprovincia=1) or (cli.idprovincia=2)) and (fecha between '2022-01-01' and '2022-03-31')