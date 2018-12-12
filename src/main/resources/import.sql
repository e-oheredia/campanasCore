SET IDENTITY_INSERT [dbo].[tipo_destino] ON 
INSERT INTO [dbo].[tipo_destino]([tipo_destino_id],[nombre]) VALUES(1,'INTERNA')
INSERT INTO [dbo].[tipo_destino]([tipo_destino_id],[nombre]) VALUES(2,'EXTERNA')
SET IDENTITY_INSERT [dbo].[tipo_destino] OFF

SET IDENTITY_INSERT [dbo].[tipo_agrupado] ON 
INSERT INTO [dbo].[tipo_agrupado]([tipo_agrupado_id],[nombre]) VALUES(1,'POR AGENCIA')
INSERT INTO [dbo].[tipo_agrupado]([tipo_agrupado_id],[nombre]) VALUES(2,'POR UNIDAD ORGANIZATIVA')
INSERT INTO [dbo].[tipo_agrupado]([tipo_agrupado_id],[nombre]) VALUES(3,'POR SUCURSAL - SEDE')
SET IDENTITY_INSERT [dbo].[tipo_agrupado] OFF


insert into tipo_campana(nombre) values('SENSIBLE')
insert into tipo_campana(nombre) values('NO SENSIBLE')

INSERT INTO estado_campana(nombre) VALUES ('CREADO')
INSERT INTO estado_campana(nombre) VALUES ('ASIGNADA')
INSERT INTO estado_campana(nombre) VALUES ('GEOREFERENCIADA')
INSERT INTO estado_campana(nombre) VALUES ('GEOREFERENCIADA Y MODIFICADA')
INSERT INTO estado_campana(nombre) VALUES ('GEOREFERENCIADA Y CONFIRMADA')
INSERT INTO estado_campana(nombre) VALUES ('COTIZADA')


SET IDENTITY_INSERT [dbo].[accion_restos_proveedor] ON 
INSERT INTO [dbo].[accion_restos_proveedor] ([accion_restos_proveedor_id],[nombre]) VALUES (1,'Que el proveedor los destruya')
INSERT INTO [dbo].[accion_restos_proveedor] ([accion_restos_proveedor_id],[nombre]) VALUES (2,'Devolver a almacén')
SET IDENTITY_INSERT [dbo].[accion_restos_proveedor] OFF


