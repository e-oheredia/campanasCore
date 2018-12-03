SET IDENTITY_INSERT [dbo].[tipo_destino] ON 
INSERT INTO [dbo].[tipo_destino]([tipo_destino_id],[nombre]) VALUES(1,'INTERNA')
INSERT INTO [dbo].[tipo_destino]([tipo_destino_id],[nombre]) VALUES(2,'EXTERNA')
SET IDENTITY_INSERT [dbo].[tipo_destino] OFF

SET IDENTITY_INSERT [dbo].[tipo_agrupado] ON 
INSERT INTO [dbo].[tipo_agrupado]([tipo_agrupado_id],[nombre]) VALUES(1,'POR AGENCIA')
INSERT INTO [dbo].[tipo_agrupado]([tipo_agrupado_id],[nombre]) VALUES(2,'POR UNIDAD ORGANIZATIVA')
INSERT INTO [dbo].[tipo_agrupado]([tipo_agrupado_id],[nombre]) VALUES(3,'POR SUCURSAL - SEDE')
SET IDENTITY_INSERT [dbo].[tipo_agrupado] OFF