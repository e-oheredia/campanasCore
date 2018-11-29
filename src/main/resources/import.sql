USE [db_campana_core]
GO
SET IDENTITY_INSERT [dbo].[tipo_destino] ON 
INSERT INTO [dbo].[tipo_destino]([tipo_destino_id],[nombre]) VALUES(1,'INTERNA')
INSERT INTO [dbo].[tipo_destino]([tipo_destino_id],[nombre]) VALUES(2,'EXTERNA')

SET IDENTITY_INSERT [dbo].[tipo_destino] OFF
