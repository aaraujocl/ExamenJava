SELECT
    count(*) as "Número de Peonzas", 
	SUM(p.precio) as "Importe Total"
FROM
    compra c
inner join producto p 
    on c.idproducto=p.idproducto
inner join cliente cli 
    on c.idcliente = cli.idcliente    
inner join provincia prov
   on cli.idprovincia = prov.idprovincia 
where (cli.idprovincia=1) and (p.idproducto='C') and (fecha between '2022-03-01' and '2022-03-31')
