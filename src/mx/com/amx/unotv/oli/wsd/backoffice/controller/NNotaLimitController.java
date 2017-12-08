/**
 * 
 */
package mx.com.amx.unotv.oli.wsd.backoffice.controller;

import java.util.Collections;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import mx.com.amx.unotv.oli.wsd.backoffice.controller.exception.ControllerException;
import mx.com.amx.unotv.oli.wsd.backoffice.dao.NNotaDAO;
import mx.com.amx.unotv.oli.wsd.backoffice.response.ItemResponse;
import mx.com.amx.unotv.oli.wsd.backoffice.response.ItemResponseList;

/**
 * @author Jesus A. Macias Benitez
 *
 */


@Controller
@RequestMapping("nNotaLimit")
public class NNotaLimitController {
	
	
	/** The logger. */
	private static Logger logger = Logger.getLogger(NNotaController.class);

	@Autowired
	NNotaDAO nNotaDAO;
	
	
	/* busca las notas mas recientes y recibe como parametro el total a devolver*/
	
	@RequestMapping(value = "/{limit}", method = RequestMethod.POST, headers = "Accept=application/json; charset=utf-8")
	@ResponseBody
	public ItemResponseList findAll(@PathVariable Integer limit) throws ControllerException {

		logger.info("--- findAll [ NNotaLimitController ]---- ");
		logger.info("---  limit : "+limit);

		List<ItemResponse> lista = null;
		ItemResponseList response = null;

		try {

			response = new ItemResponseList();
			lista = nNotaDAO.findAll(limit);

			if (lista != null && !lista.isEmpty()) {

				response.setLista(lista);
			} else {

				response.setLista(Collections.<ItemResponse>emptyList());
			}

		} catch (Exception e) {
			logger.error(" -- Error  findAll [ NNotaLimitController ]:", e);
			throw new ControllerException(e.getMessage());
		}

		return response;
	}
	
	
	/* busca las notas por idcategoria y recibe como parametro el total a devolver */
	
	@RequestMapping(value = "/categoria/{idCategoria}/{limit}", method = RequestMethod.POST, headers = "Accept=application/json; charset=utf-8")
	@ResponseBody
	public ItemResponseList findByIdCategoria(@PathVariable String idCategoria,@PathVariable Integer limit) throws ControllerException {

		logger.info("--- findByIdCategoria [ NNotaLimitController ]---- ");
		logger.info("---  idCategoria : "+idCategoria);
		logger.info("---  limit : "+limit);

		List<ItemResponse> lista = null;
		ItemResponseList response = null;

		try {

			response = new ItemResponseList();
			lista = nNotaDAO.findByIdCategoria(idCategoria,limit);

			if (lista != null && !lista.isEmpty()) {

				response.setLista(lista);
			} else {

				response.setLista(Collections.<ItemResponse>emptyList());
			}

		} catch (Exception e) {
			logger.error(" -- Error  findByIdCategoria [ NNotaLimitController ]:", e);
			throw new ControllerException(e.getMessage());
		}

		return response;
	}
	

	/* busca las notas por idClassVideo y  recibe como parametro el total a devolver */
	@RequestMapping(value = "/classVideo/{idClassVideo}/{limit}", method = RequestMethod.POST, headers = "Accept=application/json; charset=utf-8")
	@ResponseBody
	public ItemResponseList findByIdClassVideo(@PathVariable String idClassVideo,@PathVariable Integer limit) throws ControllerException {
		logger.info("--- findByIdClassVideo [ NNotaLimitController ]---- ");
		logger.info("---  idClassVideo : "+idClassVideo);
		logger.info("---  limit : "+limit);

		List<ItemResponse> lista = null;
		ItemResponseList response= null;

		try {
			response = new ItemResponseList();
			lista = nNotaDAO.findByIdClassVideo(idClassVideo,limit);

			if (lista != null && !lista.isEmpty()) {
				
				response.setLista(lista);
			} else {

			
				response.setLista(Collections.<ItemResponse>emptyList());
			}

		} catch (Exception e) {
			logger.error(" -- Error  findByIdClassVideo [ NNotaLimitController ]:", e);
			throw new ControllerException(e.getMessage());
		}

		return response;

	}

}
