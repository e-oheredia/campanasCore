USE [db_campana_core]

SET IDENTITY_INSERT [dbo].[accion_restos_campana] ON 

INSERT [dbo].[accion_restos_campana] ([accion_restos_campana_id]) VALUES (1)
INSERT [dbo].[accion_restos_campana] ([accion_restos_campana_id]) VALUES (2)
INSERT [dbo].[accion_restos_campana] ([accion_restos_campana_id]) VALUES (3)
INSERT [dbo].[accion_restos_campana] ([accion_restos_campana_id]) VALUES (4)
INSERT [dbo].[accion_restos_campana] ([accion_restos_campana_id]) VALUES (5)
INSERT [dbo].[accion_restos_campana] ([accion_restos_campana_id]) VALUES (6)
SET IDENTITY_INSERT [dbo].[accion_restos_campana] OFF
SET IDENTITY_INSERT [dbo].[accion_restos_rezagos_campana] ON 

INSERT [dbo].[accion_restos_rezagos_campana] ([accion_restos_rezagos_campana_id], [accion_restos_campana_id]) VALUES (1, 2)
INSERT [dbo].[accion_restos_rezagos_campana] ([accion_restos_rezagos_campana_id], [accion_restos_campana_id]) VALUES (2, 4)
INSERT [dbo].[accion_restos_rezagos_campana] ([accion_restos_rezagos_campana_id], [accion_restos_campana_id]) VALUES (3, 6)
SET IDENTITY_INSERT [dbo].[accion_restos_rezagos_campana] OFF
SET IDENTITY_INSERT [dbo].[auspiciador] ON 

INSERT [dbo].[auspiciador] ([auspiciador_id]) VALUES (1)
INSERT [dbo].[auspiciador] ([auspiciador_id]) VALUES (2)
INSERT [dbo].[auspiciador] ([auspiciador_id]) VALUES (3)
SET IDENTITY_INSERT [dbo].[auspiciador] OFF
SET IDENTITY_INSERT [dbo].[proveedor_impresion] ON 

INSERT [dbo].[proveedor_impresion] ([proveedor_impresion_id], [contacto], [direccion], [fecha_recojo], [nombre]) VALUES (1, N'asdasdsdasd', N'asdasd', CAST(N'2018-12-30T15:50:00.0000000' AS DateTime2), N'asdsad')
SET IDENTITY_INSERT [dbo].[proveedor_impresion] OFF
SET IDENTITY_INSERT [dbo].[tipo_agrupado] ON 

INSERT [dbo].[tipo_agrupado] ([tipo_agrupado_id], [nombre]) VALUES (1, N'POR AGENCIA')
INSERT [dbo].[tipo_agrupado] ([tipo_agrupado_id], [nombre]) VALUES (2, N'POR UNIDAD ORGANIZATIVA')
INSERT [dbo].[tipo_agrupado] ([tipo_agrupado_id], [nombre]) VALUES (3, N'POR SUCURSAL - SEDE')
SET IDENTITY_INSERT [dbo].[tipo_agrupado] OFF
SET IDENTITY_INSERT [dbo].[tipo_campana] ON 

INSERT [dbo].[tipo_campana] ([tipo_campana_id], [nombre]) VALUES (1, N'SENSIBLE')
INSERT [dbo].[tipo_campana] ([tipo_campana_id], [nombre]) VALUES (2, N'NO SENSIBLE')
SET IDENTITY_INSERT [dbo].[tipo_campana] OFF
SET IDENTITY_INSERT [dbo].[tipo_destino] ON 

INSERT [dbo].[tipo_destino] ([tipo_destino_id], [nombre]) VALUES (1, N'INTERNA')
INSERT [dbo].[tipo_destino] ([tipo_destino_id], [nombre]) VALUES (2, N'EXTERNA')
SET IDENTITY_INSERT [dbo].[tipo_destino] OFF
SET IDENTITY_INSERT [dbo].[accion_restos_cargos_campana] ON 

INSERT [dbo].[accion_restos_cargos_campana] ([accion_restos_cargos_campana_id], [accion_restos_campana_id]) VALUES (1, 1)
INSERT [dbo].[accion_restos_cargos_campana] ([accion_restos_cargos_campana_id], [accion_restos_campana_id]) VALUES (2, 3)
INSERT [dbo].[accion_restos_cargos_campana] ([accion_restos_cargos_campana_id], [accion_restos_campana_id]) VALUES (3, 5)
SET IDENTITY_INSERT [dbo].[accion_restos_cargos_campana] OFF
SET IDENTITY_INSERT [dbo].[campana] ON 

INSERT [dbo].[campana] ([campana_id], [autorizado], [buzon_id], [costo_campana], [nombre], [observacion], [paquete_habilitado_id], [plazo_id], [proveedor_id], [regulatorio], [requiere_georreferencia], [requiere_gps], [ruta_autorizacion], [tipo_documento_id], [accion_restos_cargos_campana_id], [accion_restos_rezagos_campana_id], [auspiciador_id], [proveedor_impresion_id], [tipo_campana], [tipo_destino_id]) VALUES (1, 0, 1, 540, N'CAMPAÑA 1', NULL, 5, 1, 2, 0, 1, 0, NULL, 1, 1, 1, 1,  NULL, 2, 1)
INSERT [dbo].[campana] ([campana_id], [autorizado], [buzon_id], [costo_campana], [nombre], [observacion], [paquete_habilitado_id], [plazo_id], [proveedor_id], [regulatorio], [requiere_georreferencia], [requiere_gps], [ruta_autorizacion], [tipo_documento_id], [accion_restos_cargos_campana_id], [accion_restos_rezagos_campana_id], [auspiciador_id], [proveedor_impresion_id], [tipo_campana], [tipo_destino_id]) VALUES (2, 0, 1, 4750, N'czvxcvcv', NULL, NULL, 1, 1, 0, 1, 0, NULL, 1, 2, 2, 2, NULL,  1, 1)
INSERT [dbo].[campana] ([campana_id], [autorizado], [buzon_id], [costo_campana], [nombre], [observacion], [paquete_habilitado_id], [plazo_id], [proveedor_id], [regulatorio], [requiere_georreferencia], [requiere_gps], [ruta_autorizacion], [tipo_documento_id], [accion_restos_cargos_campana_id], [accion_restos_rezagos_campana_id], [auspiciador_id], [proveedor_impresion_id], [tipo_campana], [tipo_destino_id]) VALUES (3, 0, 1, NULL, N'asdasdasdas', NULL, 1, 4, NULL, 0, 1, 0, NULL, 1, 3, 3, 3, 1, NULL, 1)
SET IDENTITY_INSERT [dbo].[campana] OFF
INSERT [dbo].[empresa_auspiciadora] ([contacto], [direccion], [razon_social], [ruc], [auspiciador_id]) VALUES (N'SDASDASD', N'DASDASDA', N'ASDASDASD', N'SADASDASDAS', 1)
INSERT [dbo].[empresa_auspiciadora] ([contacto], [direccion], [razon_social], [ruc], [auspiciador_id]) VALUES (N'xcvxcvxcv', N'xcvxcvcxv', N'xcvcxv', N'cxvcxv', 2)
INSERT [dbo].[grupo_centro_costos] ([auspiciador_id]) VALUES (3)
SET IDENTITY_INSERT [dbo].[item_campana] ON 

INSERT [dbo].[item_campana] ([item_campana_id], [apellido_materno], [apellido_paterno], [direccion], [distrito_id], [enviable], [nombres], [razon_social], [correlativo], [campana_id]) VALUES (1, N'ORLANDO MARIO', N'CARRASCO', N'Jr. Los Cafetales Los Olivos', 1275, 0, N'HEREDIA', N'', 0, 1)
INSERT [dbo].[item_campana] ([item_campana_id], [apellido_materno], [apellido_paterno], [direccion], [distrito_id], [enviable], [nombres], [razon_social], [correlativo], [campana_id]) VALUES (2, N'ORLANDO MARIO', N'CARRASCO', N'Jr. Los Cafetales Los Olivos', 1275, 1, N'HEREDIA', N'', 0, 2)
INSERT [dbo].[item_campana] ([item_campana_id], [apellido_materno], [apellido_paterno], [direccion], [distrito_id], [enviable], [nombres], [razon_social], [correlativo], [campana_id]) VALUES (3, N'ORLANDO MARIO', N'CARRASCO', N'Jr. Los Cafetales Los Olivos', 1275, 0, N'HEREDIA', N'', 0, 3)
SET IDENTITY_INSERT [dbo].[item_campana] OFF
SET IDENTITY_INSERT [dbo].[estado_campana] ON 

INSERT [dbo].[estado_campana] ([estado_campana_id], [nombre]) VALUES (1, N'CREADO')
INSERT [dbo].[estado_campana] ([estado_campana_id], [nombre]) VALUES (2, N'ASIGNADA')
INSERT [dbo].[estado_campana] ([estado_campana_id], [nombre]) VALUES (3, N'GEOREFERENCIADA')
INSERT [dbo].[estado_campana] ([estado_campana_id], [nombre]) VALUES (4, N'GEOREFERENCIADA Y MODIFICADA')
INSERT [dbo].[estado_campana] ([estado_campana_id], [nombre]) VALUES (5, N'GEOREFERENCIADA Y CONFIRMADA')
INSERT [dbo].[estado_campana] ([estado_campana_id], [nombre]) VALUES (6, N'COTIZADA')
INSERT [dbo].[estado_campana] ([estado_campana_id], [nombre]) VALUES (7, N'CONFORMIDAD ADJUNTADA')
INSERT [dbo].[estado_campana] ([estado_campana_id], [nombre]) VALUES (8, N'CONFORMIDAD VERIFICADA')
INSERT [dbo].[estado_campana] ([estado_campana_id], [nombre]) VALUES (9, N'CONFORMIDAD DENEGADA')
INSERT [dbo].[estado_campana] ([estado_campana_id], [nombre]) VALUES (10, N'MUESTRA SOLICITADA')
INSERT [dbo].[estado_campana] ([estado_campana_id], [nombre]) VALUES (11, N'MUESTRA ADJUNTADA')
INSERT [dbo].[estado_campana] ([estado_campana_id], [nombre]) VALUES (12, N'MUESTRA VERIFICADA')
INSERT [dbo].[estado_campana] ([estado_campana_id], [nombre]) VALUES (13, N'MUESTRA DENEGADA')
INSERT [dbo].[estado_campana] ([estado_campana_id], [nombre]) VALUES (14, N'IMPRESION INICIADA')
INSERT [dbo].[estado_campana] ([estado_campana_id], [nombre]) VALUES (15, N'IMPRESION POR RECOGER')
INSERT [dbo].[estado_campana] ([estado_campana_id], [nombre]) VALUES (16, N'GUIA ADJUNTADA')
INSERT [dbo].[estado_campana] ([estado_campana_id], [nombre]) VALUES (17, N'GUIA VERIFICADA')
INSERT [dbo].[estado_campana] ([estado_campana_id], [nombre]) VALUES (18, N'GUIA DENEGADA')
INSERT [dbo].[estado_campana] ([estado_campana_id], [nombre]) VALUES (19, N'INICIADA')
SET IDENTITY_INSERT [dbo].[estado_campana] OFF
SET IDENTITY_INSERT [dbo].[seguimiento_campana] ON 

INSERT [dbo].[seguimiento_campana] ([seguimiento_campana_id], [fecha], [observacion], [usuario_id], [campana_id], [estado_campana_id], [matricula]) VALUES (1, CAST(N'2018-12-12T10:48:53.4790000' AS DateTime2), N'', 1, 1, 1, 'OHEREDIA')
INSERT [dbo].[seguimiento_campana] ([seguimiento_campana_id], [fecha], [observacion], [usuario_id], [campana_id], [estado_campana_id], [matricula]) VALUES (2, CAST(N'2018-12-12T10:53:27.2770000' AS DateTime2), N'', 1, 2, 1, 'OHEREDIA')
INSERT [dbo].[seguimiento_campana] ([seguimiento_campana_id], [fecha], [observacion], [usuario_id], [campana_id], [estado_campana_id], [matricula]) VALUES (3, CAST(N'2018-12-12T10:56:32.0570000' AS DateTime2), N'', 1, 3, 1, 'OHEREDIA')
INSERT [dbo].[seguimiento_campana] ([seguimiento_campana_id], [fecha], [observacion], [usuario_id], [campana_id], [estado_campana_id], [matricula]) VALUES (4, CAST(N'2018-12-12T10:54:19.5450000' AS DateTime2), N'Proveedor: URBANO. Costo: 540.0', 1, 1, 2, 'OHEREDIA')
INSERT [dbo].[seguimiento_campana] ([seguimiento_campana_id], [fecha], [observacion], [usuario_id], [campana_id], [estado_campana_id], [matricula]) VALUES (5, CAST(N'2018-12-12T10:57:19.5450000' AS DateTime2), '', 1, 1, 3, 'OHEREDIA')
INSERT [dbo].[seguimiento_campana] ([seguimiento_campana_id], [fecha], [observacion], [usuario_id], [campana_id], [estado_campana_id], [matricula]) VALUES (6, CAST(N'2018-12-12T10:54:19.5450000' AS DateTime2), N'Proveedor: URBANO. Costo: 540.0', 1, 2, 2, 'OHEREDIA')
INSERT [dbo].[seguimiento_campana] ([seguimiento_campana_id], [fecha], [observacion], [usuario_id], [campana_id], [estado_campana_id], [matricula]) VALUES (7, CAST(N'2018-12-12T10:56:19.5450000' AS DateTime2), '', 1, 2, 3, 'OHEREDIA')
INSERT [dbo].[seguimiento_campana] ([seguimiento_campana_id], [fecha], [observacion], [usuario_id], [campana_id], [estado_campana_id], [matricula]) VALUES (8, CAST(N'2018-12-12T10:58:19.5450000' AS DateTime2), '', 1, 2, 5, 'OHEREDIA')
SET IDENTITY_INSERT [dbo].[seguimiento_campana] OFF
SET IDENTITY_INSERT [dbo].[centro_costos] ON 

INSERT [dbo].[centro_costos] ([centro_costos_id], [centro_costos_codigo], [cuenta_contable_codigo], [grupo_articulo], [orden_estadistica], [porcentaje], [auspiciador_id]) VALUES (1, N'asdas', N'sdasd', N'dasdas', N'dasdas', 100, 3)
SET IDENTITY_INSERT [dbo].[centro_costos] OFF
SET IDENTITY_INSERT [dbo].[accion_restos_proveedor] ON 

INSERT [dbo].[accion_restos_proveedor] ([accion_restos_proveedor_id], [nombre]) VALUES (1, N'Que el proveedor los destruya')
INSERT [dbo].[accion_restos_proveedor] ([accion_restos_proveedor_id], [nombre]) VALUES (2, N'Devolver a almacén')
SET IDENTITY_INSERT [dbo].[accion_restos_proveedor] OFF
INSERT [dbo].[accion_restos_campana_proveedor] ([accion_restos_campana_id], [accion_restos_proveedor_id]) VALUES (3, 2)
INSERT [dbo].[accion_restos_campana_proveedor] ([accion_restos_campana_id], [accion_restos_proveedor_id]) VALUES (4, 1)
INSERT [dbo].[accion_restos_campana_proveedor] ([accion_restos_campana_id], [accion_restos_proveedor_id]) VALUES (6, 1)
INSERT [dbo].[informacion_devolucion_restos] ([contacto], [direccion], [observacion], [accion_restos_campana_id]) VALUES (N'ZXCZXC', N'ZXCZXCZXC', N'ZXCZXCZ', 1)
INSERT [dbo].[informacion_devolucion_restos] ([contacto], [direccion], [observacion], [accion_restos_campana_id]) VALUES (N'XCZXCZXC', N'ZXCZXCZX', N'CXZCZXC', 2)
INSERT [dbo].[informacion_devolucion_restos] ([contacto], [direccion], [observacion], [accion_restos_campana_id]) VALUES (N'dasdasd', N'asdas', N'dasdasd', 5)


