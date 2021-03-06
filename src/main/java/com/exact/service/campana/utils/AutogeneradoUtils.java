package com.exact.service.campana.utils;

import org.springframework.stereotype.Component;

@Component
public class AutogeneradoUtils implements IAutogeneradoUtils {

	@Override
	public String generateMasivoAutogenerado(String autogeneradoAnterior) throws NumberFormatException {		
		if (autogeneradoAnterior == null) {
			return "MEX00000001";
		}
		String autogeneradoAnteriorSinEx = "9" + autogeneradoAnterior.substring(3);
		Long numeroAutogeneradoAnterior = Long.valueOf(autogeneradoAnteriorSinEx);
		Long numeroAutogenerado = numeroAutogeneradoAnterior + 1L;
		return "MEX" + numeroAutogenerado.toString().substring(1);
	}

	@Override
	public String generateDocumentoAutogenerado(String autogeneradoAnterior) throws NumberFormatException {
		if (autogeneradoAnterior == null) {
			return "EX00000001";
		}
		String autogeneradoAnteriorSinEx = "9" + autogeneradoAnterior.substring(2);
		Long numeroAutogeneradoAnterior = Long.valueOf(autogeneradoAnteriorSinEx);
		Long numeroAutogenerado = numeroAutogeneradoAnterior + 1L;
		return "EX" + numeroAutogenerado.toString().substring(1);
	}
	
}
