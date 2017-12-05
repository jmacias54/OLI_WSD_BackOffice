/**
 * 
 */
package mx.com.amx.unotv.oli.wsd.backoffice.controller;

import java.util.Collections;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import mx.com.amx.unotv.oli.wsd.backoffice.controller.exception.ControllerException;
import mx.com.amx.unotv.oli.wsd.backoffice.dao.CategoriaDAO;
import mx.com.amx.unotv.oli.wsd.backoffice.model.Categoria;
import mx.com.amx.unotv.oli.wsd.backoffice.response.CategoriaListResponse;

/**
 * @author Jesus A. Macias Benitez
 *
 */

@Controller
@RequestMapping("categoria")
public class CategoriaController {
	
	
	/** The logger. */
	private static Logger logger = Logger.getLogger(CategoriaController.class);

	@Autowired
	CategoriaDAO categoriaDAO;
	
	@RequestMapping(value = "/", method = RequestMethod.POST, headers = "Accept=application/json; charset=utf-8")
	@ResponseBody
	public CategoriaListResponse findAll() throws ControllerException {
		CategoriaListResponse response = null;
		List<Categoria> lista = null;
		try {

			response = new CategoriaListResponse();
			lista = categoriaDAO.findAll();
			
			if(lista != null) {
				response.setLista(lista);
			}else {
				response.setLista(Collections.<Categoria>emptyList());
			}
			

		} catch (Exception e) {
			logger.error(" -- Error  findAll [ CategoriaController ]:", e);
			throw new ControllerException(e.getMessage());
		}
		
		return response;
	}

}
