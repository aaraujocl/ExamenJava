SELECT
     EXTRACT(DAY FROM c.fecha) || ' ' || to_char(c.fecha,'Mon') as "Día del mes", 
	 p.descripcion as "Producto", 
	 count(*) as "Número de Compras", 
	 SUM(p.precio) as "Importe Total"
FROM
    compra c
inner join producto p 
    on c.idproducto=p.idproducto
inner join cliente cli 
    on c.idcliente = cli.idcliente    
inner join provincia prov
   on cli.idprovincia = prov.idprovincia where EXTRACT(DAY FROM c.fecha)=1 group by p.descripcion,EXTRACT(DAY FROM c.fecha) || ' ' || to_char(c.fecha,'Mon') 