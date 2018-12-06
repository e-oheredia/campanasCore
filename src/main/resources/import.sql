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

SET IDENTITY_INSERT [dbo].[accion_restos_campana] ON 
INSERT INTO [dbo].[accion_restos_campana] ([accion_restos_campana_id]) VALUES (1)
SET IDENTITY_INSERT [dbo].[accion_restos_campana] OFF 

SET IDENTITY_INSERT [dbo].[accion_restos_cargos_campana] ON 
INSERT INTO [dbo].[accion_restos_cargos_campana] ([accion_restos_cargos_campana_id],[accion_restos_campana_id]) VALUES (1,1)
SET IDENTITY_INSERT [dbo].[accion_restos_cargos_campana] OFF 

SET IDENTITY_INSERT [dbo].[accion_restos_rezagos_campana] ON 
INSERT INTO [dbo].[accion_restos_rezagos_campana] ([accion_restos_rezagos_campana_id],[accion_restos_campana_id]) VALUES (1,1)
SET IDENTITY_INSERT [dbo].[accion_restos_rezagos_campana] OFF

SET IDENTITY_INSERT [dbo].[accion_restos_proveedor] ON 
INSERT INTO [dbo].[accion_restos_proveedor] ([accion_restos_proveedor_id],[nombre]) VALUES (1,'Que el proveedor los destruya')
INSERT INTO [dbo].[accion_restos_proveedor] ([accion_restos_proveedor_id],[nombre]) VALUES (2,'Devolver a almacén')
SET IDENTITY_INSERT [dbo].[accion_restos_proveedor] OFF



SET IDENTITY_INSERT [dbo].[auspiciador] ON 
INSERT INTO [dbo].[auspiciador] ([auspiciador_id]) VALUES (1)
SET IDENTITY_INSERT [dbo].[auspiciador] OFF 


SET IDENTITY_INSERT [dbo].[campana] ON
INSERT [dbo].[campana] ([campana_id], [autorizado], [buzon_id], [cantidad_lima], [cantidad_provincia], [nombre], [observacion], [paquete_habilitado_id], [plazo_id], [proveedor_id], [regulatorio], [requiere_georreferencia], [requiere_gps], [ruta_autorizacion], [tipo_documento_id], [accion_restos_cargos_campana_id], [accion_restos_rezagos_campana_id], [auspiciador_id], [proveedor_impresion_id], [tipo_agrupado_id], [tipo_destino_id]) VALUES (1, 0, 1, 10, 10, N'Campaña nro 1', NULL, NULL, 1, 1, 0, 0, 0, NULL, 1, 1, 1, 1, NULL, 1, 1)
INSERT [dbo].[campana] ([campana_id], [autorizado], [buzon_id], [cantidad_lima], [cantidad_provincia], [nombre], [observacion], [paquete_habilitado_id], [plazo_id], [proveedor_id], [regulatorio], [requiere_georreferencia], [requiere_gps], [ruta_autorizacion], [tipo_documento_id], [accion_restos_cargos_campana_id], [accion_restos_rezagos_campana_id], [auspiciador_id], [proveedor_impresion_id], [tipo_agrupado_id], [tipo_destino_id]) VALUES (2, 0, 1, 10, 10, N'Campaña nro 2', NULL, NULL, 1, 1, 0, 0, 0, NULL, 1, 1, 1, 1, NULL, 1, 1)
INSERT [dbo].[campana] ([campana_id], [autorizado], [buzon_id], [cantidad_lima], [cantidad_provincia], [nombre], [observacion], [paquete_habilitado_id], [plazo_id], [proveedor_id], [regulatorio], [requiere_georreferencia], [requiere_gps], [ruta_autorizacion], [tipo_documento_id], [accion_restos_cargos_campana_id], [accion_restos_rezagos_campana_id], [auspiciador_id], [proveedor_impresion_id], [tipo_agrupado_id], [tipo_destino_id]) VALUES (3, 0, 1, 10, 10, N'Campaña nro 3', NULL, NULL, 1, 1, 0, 0, 0, NULL, 1, 1, 1, 1, NULL, 2, 2)
INSERT [dbo].[campana] ([campana_id], [autorizado], [buzon_id], [cantidad_lima], [cantidad_provincia], [nombre], [observacion], [paquete_habilitado_id], [plazo_id], [proveedor_id], [regulatorio], [requiere_georreferencia], [requiere_gps], [ruta_autorizacion], [tipo_documento_id], [accion_restos_cargos_campana_id], [accion_restos_rezagos_campana_id], [auspiciador_id], [proveedor_impresion_id], [tipo_agrupado_id], [tipo_destino_id]) VALUES (4, 0, 1, 10, 10, N'Campaña nro 4', NULL, NULL, 1, 1, 0, 0, 0, NULL, 1, 1, 1, 1, NULL, 3, 2)
INSERT [dbo].[campana] ([campana_id], [autorizado], [buzon_id], [cantidad_lima], [cantidad_provincia], [nombre], [observacion], [paquete_habilitado_id], [plazo_id], [proveedor_id], [regulatorio], [requiere_georreferencia], [requiere_gps], [ruta_autorizacion], [tipo_documento_id], [accion_restos_cargos_campana_id], [accion_restos_rezagos_campana_id], [auspiciador_id], [proveedor_impresion_id], [tipo_agrupado_id], [tipo_destino_id]) VALUES (5, 0, 1, 10, 10, N'Campaña nro 5', NULL, NULL, 1, 1, 0, 0, 0, NULL, 1, 1, 1, 1, NULL, 2, 1)
SET IDENTITY_INSERT [dbo].[campana] OFF

SET IDENTITY_INSERT [dbo].[seguimiento_campana] ON
INSERT [dbo].[seguimiento_campana] ([seguimiento_campana_id], [fecha], [observacion], [usuario_id], [campana_id], [estado_campana_id]) VALUES (1, GETDATE(), NULL,1,1,1)
INSERT [dbo].[seguimiento_campana] ([seguimiento_campana_id], [fecha], [observacion], [usuario_id], [campana_id], [estado_campana_id]) VALUES (2, GETDATE(), NULL,1,2,1)
INSERT [dbo].[seguimiento_campana] ([seguimiento_campana_id], [fecha], [observacion], [usuario_id], [campana_id], [estado_campana_id]) VALUES (3, GETDATE(), NULL,1,3,2)
INSERT [dbo].[seguimiento_campana] ([seguimiento_campana_id], [fecha], [observacion], [usuario_id], [campana_id], [estado_campana_id]) VALUES (4, GETDATE(), NULL,1,4,6)
INSERT [dbo].[seguimiento_campana] ([seguimiento_campana_id], [fecha], [observacion], [usuario_id], [campana_id], [estado_campana_id]) VALUES (5, GETDATE(), NULL,1,5,5)
SET IDENTITY_INSERT [dbo].[seguimiento_campana] OFF

