/**
 * 
 */
package mx.com.amx.unotv.oli.wsd.backoffice.controller;

import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import mx.com.amx.unotv.oli.wsd.backoffice.dao.SequenceImageDAO;

/**
 * @author Jesus A. Macias Benitez
 *
 */

@Controller
@RequestMapping("sequenceImage")
public class SequenceImageController {
	
	
	/** The logger. */
	private static Logger logger = Logger.getLogger(SequenceImageController.class);


	@Autowired
	private SequenceImageDAO sequenceImageDAO;
	
	@RequestMapping(value={"seq_NextVal"}, method={org.springframework.web.bind.annotation.RequestMethod.POST}, headers={"Accept=application/json; charset=utf-8"})
	@ResponseBody
	public Integer seq_NextVal( HttpServletResponse response)
	{
		logger.info("Inicia seq_NextVal [ SequenceImageController ]");
		String msj="OK";
		String codigo="0";
		String causa_error="";
		int status_peticion=HttpServletResponse.SC_OK;
		int res = 0;
		try {
			res = sequenceImageDAO.seq_NextVal();
		} catch (Exception e) {
			logger.error("Error getParameters [ SequenceImageController ]: ",e);
			codigo="-1";
			msj=e.getMessage();
			causa_error=e.toString();
			status_peticion=HttpServletResponse.SC_INTERNAL_SERVER_ERROR;
		}
		response.setHeader("codigo", codigo);
		response.setHeader("mensaje", msj);
		response.setHeader("causa_error", causa_error);
		response.setStatus(status_peticion);
		
		
		return res;
	}
}
